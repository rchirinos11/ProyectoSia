package pe.edu.pucp.sia.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.Indicator;
import pe.edu.pucp.sia.model.LevelDetail;
import pe.edu.pucp.sia.model.Measurement;
import pe.edu.pucp.sia.model.MeasurementLevel;
import pe.edu.pucp.sia.model.MeasurementPlanLine;
import pe.edu.pucp.sia.model.ResultsPerCard;
import pe.edu.pucp.sia.model.Semester;
import pe.edu.pucp.sia.model.Specialty;
import pe.edu.pucp.sia.model.comparators.LevelDetailComparator;
import pe.edu.pucp.sia.repository.IndicatorRepository;
import pe.edu.pucp.sia.repository.LevelDetailRepository;
import pe.edu.pucp.sia.repository.MeasurementLevelRepository;
import pe.edu.pucp.sia.repository.MeasurementPlanLineRepository;
import pe.edu.pucp.sia.repository.ResultsPerCardRepository;
import pe.edu.pucp.sia.repository.SemesterRepository;
import pe.edu.pucp.sia.requests.MPlanLineSpecialtySemesterRequest;
import pe.edu.pucp.sia.response.ApiResponse;
import pe.edu.pucp.sia.service.MeasurementLevelService;
@Service
public class MeasurementLevelServiceImpl implements MeasurementLevelService {
	@Autowired
	private MeasurementLevelRepository measurementLevelRepository;

	@Autowired
	private LevelDetailRepository levelDetailRepository;
	
	@Autowired
	private ResultsPerCardRepository resultsPerCardRepository;
	
	@Autowired
	private IndicatorRepository indicatorRepository;
	
	@Autowired
    private MeasurementPlanLineRepository mplRepository;
	
	@Override
	public ApiResponse listAll() {
		ApiResponse response = null;
		try {
			Iterable<MeasurementLevel> list = measurementLevelRepository.findAllByOrderByOrdenAsc();
			response = new ApiResponse(list,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}
	
	@Override
	public ApiResponse listBySemester(Integer idSemester) {
		ApiResponse response = null;
		try {
			Iterable<MeasurementLevel> list = measurementLevelRepository.findBySemesterIdOrderByOrdenAsc(idSemester);
			response = new ApiResponse(list,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse createMeasurementLevel(MeasurementLevel ml) {
		ApiResponse response = null;
		try {
			Integer id = measurementLevelRepository.save(ml).getId();
			//Crea niveles de medición a cada indicador existente
			Iterable<Indicator> list = indicatorRepository.findBystudentResultSpecialtyIdAndStudentResultSemesterIdOrderByCodeAsc(ml.getSpecialty().getId(),ml.getSemester().getId());
			if (list!=null) {
				ml.setId(id);
				for (Indicator indicator: list) {
					LevelDetail ld = new LevelDetail();
					ld.setIndicator(indicator);
					ld.setMeasurementLevel(ml);
					levelDetailRepository.save(ld);
				}
			}
			response = new ApiResponse(id,201);
			
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse updateMeasurementLevel(MeasurementLevel ml) {
		ApiResponse response = null;
		try {
			Integer id = measurementLevelRepository.save(ml).getId();
			response = new ApiResponse(id,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse deleteMeasurementLevel(Integer id) {
		ApiResponse response = null;
		try {
			//Verifica si hay planes de medición, que indica que el proceso ya empezo
			MeasurementLevel ml = measurementLevelRepository.findById(id).get();
			Iterator<MeasurementPlanLine> i = mplRepository.findByIndicatorStudentResultSpecialtyIdAndSemesterId(ml.getSpecialty().getId(),ml.getSemester().getId()).iterator();
			if(!i.hasNext()) { //Si no hay
									
				List<LevelDetail> list = levelDetailRepository.findByMeasurementLevelId(id);
				for (LevelDetail ld : list) {
					levelDetailRepository.deleteLevelDetail(ld.getId());
				}
				measurementLevelRepository.deleteMeasurementLevel(id);
				response = new ApiResponse(list,200);
				
			} else { //Si ya se empezó el proceso de medición
				response = new ApiResponse(409,"No se puede eliminar niveles porque existen Planes de Medición");
			}		
			
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse listBySpecialtySemester(MPlanLineSpecialtySemesterRequest lss) {
		ApiResponse response = null;
		try {
			Iterable<MeasurementLevel> list = measurementLevelRepository.findBySpecialtyIdAndSemesterIdOrderByOrdenAsc(lss.getIdSpecialty(),lss.getIdSemester());
			for (MeasurementLevel ml : list) {
				ml.setSpecialty(null);
			}
			response = new ApiResponse(list,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse updateCurrentMeasurementLevel(Integer idMeasurement) {
		ApiResponse response = null;
		List<ResultsPerCard> listaRPC = new ArrayList<ResultsPerCard>();
		Integer notaMin;
		try {
			Integer specialtyId = 0;
			MeasurementLevel ml = measurementLevelRepository.findById(idMeasurement).get();
			ml.setIsMinimum(1);		
			Integer id = measurementLevelRepository.save(ml).getId();
			
			specialtyId=ml.getSpecialty().getId();			
			Iterable<MeasurementLevel> lista = measurementLevelRepository.findAll();
			for(MeasurementLevel m : lista) {
				if(m.getSpecialty()!=null)				
					if (m.getSpecialty().getId()==specialtyId && (m.getId())!=id) {
							m.setIsMinimum(0);
							measurementLevelRepository.save(m);
					}
			}
			//Actualiza ResultsPerCard por el nuevo mínimo
			notaMin = ml.getOrden();
			listaRPC = resultsPerCardRepository.findByMeasurementPlanLineIndicatorStudentResultSpecialtyIdAndMeasurementPlanLineSemesterId(ml.getSpecialty().getId(),ml.getSemester().getId());
			for (ResultsPerCard rpc : listaRPC) {
				List <Measurement> listaM = rpc.getMeasurements();
				Integer total34=0,nota,evaluados=0;
				float porcentaje;
				//Lista los measurements de cada resultPerCard
				if (listaM!=null) {
					for (Measurement me : listaM) {
						MeasurementLevel mlevel;
						mlevel = me.getMeasurementLevel();
						if (mlevel==null)
							nota=0;
						else {
							nota=mlevel.getOrden();
							if (nota>=notaMin)
								total34++;
							evaluados++;
						}
					}
					//Actualiza los aprobados y el porcentaje
					if (evaluados==0)
						porcentaje = 0;
					else
						porcentaje = (float)total34/evaluados;
					rpc.setTotalSuccessful(total34);
					rpc.setPercentage(porcentaje);
					resultsPerCardRepository.registerResultsPerCard(rpc.getId(),rpc.getTotalStudents(),total34,rpc.getAverage(),porcentaje);
				}
			}//end for
			
			response = new ApiResponse(id,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse copyBySpecialtySemester(Integer idSpecialtyFrom, Integer idSemesterFrom, Integer idSpecialtyTo,
			Integer idSemesterTo) {
		ApiResponse response = null;
		List<MeasurementLevel> lista;
		try {
			lista = measurementLevelRepository.findBySpecialtyIdAndSemesterIdOrderByOrdenAsc(idSpecialtyFrom, idSemesterFrom);
			if(!lista.isEmpty()) {
				//Recorre lista y copia los datos
				for (MeasurementLevel mlf : lista) {
					MeasurementLevel mlt = new MeasurementLevel();
					Specialty specialty = new Specialty();
					Semester semester = new Semester();
					specialty.setId(idSpecialtyTo);
					semester.setId(idSemesterTo);
					mlt.setSpecialty(specialty);
					mlt.setSemester(semester);
					mlt.setName(mlf.getName());
					mlt.setOrden(mlf.getOrden());
					mlt.setIsMinimum(mlf.getIsMinimum());
					measurementLevelRepository.save(mlt);
				}
				response = new ApiResponse(lista.size(), 200);
			}
			else
				response = new ApiResponse(400,"Nothing was updated");
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse deleteMeasurementLevelByStudentAndIdResultPerCard(Integer idResultPerCard) {
		ApiResponse response = null;
		try {
			measurementLevelRepository.deleteByRolAndIdResultPerCard(6,idResultPerCard);
			response = new ApiResponse(idResultPerCard,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

}
