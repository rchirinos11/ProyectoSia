package pe.edu.pucp.sia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.LevelDetail;
import pe.edu.pucp.sia.model.MeasurementLevel;
import pe.edu.pucp.sia.repository.LevelDetailRepository;
import pe.edu.pucp.sia.repository.MeasurementLevelRepository;
import pe.edu.pucp.sia.requests.MPlanLineSpecialtySemesterRequest;
import pe.edu.pucp.sia.response.ApiResponse;
import pe.edu.pucp.sia.service.MeasurementLevelService;
@Service
public class MeasurementLevelServiceImpl implements MeasurementLevelService {
	@Autowired
	private MeasurementLevelRepository measurementLevelRepository;

	@Autowired
	private LevelDetailRepository levelDetailRepository;

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
			List<LevelDetail> list = levelDetailRepository.findByMeasurementLevelId(id);
			for (LevelDetail ld : list) {
				levelDetailRepository.deleteLevelDetail(ld.getId());
			}
			measurementLevelRepository.deleteMeasurementLevel(id);
			response = new ApiResponse(list,200);
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
			response = new ApiResponse(id,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

}
