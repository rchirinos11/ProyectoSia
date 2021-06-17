package pe.edu.pucp.sia.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.var;
import pe.edu.pucp.sia.model.Measurement;
import pe.edu.pucp.sia.model.MeasurementLevel;
import pe.edu.pucp.sia.model.Person;
import pe.edu.pucp.sia.model.ResultsPerCard;
import pe.edu.pucp.sia.model.Role;
import pe.edu.pucp.sia.repository.MeasurementLevelRepository;
import pe.edu.pucp.sia.repository.MeasurementRepository;
import pe.edu.pucp.sia.repository.PersonRepository;
import pe.edu.pucp.sia.repository.ResultsPerCardRepository;
import pe.edu.pucp.sia.repository.RoleRepository;
import pe.edu.pucp.sia.response.ApiResponse;
import pe.edu.pucp.sia.service.ResultsPerCardService;

@Service
public class ResultsPerCardServiceImpl implements ResultsPerCardService{
	@Autowired
	private ResultsPerCardRepository resultsPerCardRepository;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private MeasurementRepository measurementRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private MeasurementLevelRepository measurementLevelRepository;
	
	@Override
	public ApiResponse listAll() {
		ApiResponse response = null;
		try {
			Iterable<ResultsPerCard> list = resultsPerCardRepository.findAll();
			response = new ApiResponse(list,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse createResultsPerCard(ResultsPerCard r) {
		ApiResponse response = null;
		try {
			Integer id = resultsPerCardRepository.save(r).getId();
			response = new ApiResponse(id,201);
			
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse updateResultsPerCard(ResultsPerCard r) {
		ApiResponse response = null;
		try {
			Integer id = resultsPerCardRepository.save(r).getId();
			response = new ApiResponse(id,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse deleteResultsPerCard(Integer id) {
		ApiResponse response = null;
		try {
			resultsPerCardRepository.deleteResultsPerCard(id);
			response = new ApiResponse("Success",200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse listByMeasurementPlanLine(Integer id) {
		ApiResponse response = null;
		try {
			Iterable<ResultsPerCard> list = resultsPerCardRepository.findByMeasurementPlanLineId(id);
			for (ResultsPerCard rc : list) {
				rc.setMeasurementPlanLine(null);
			}
			response = new ApiResponse(list,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse registerStudentMeditions(ResultsPerCard r) {
		ApiResponse response = null;
		try {
			Integer nota,notaMin=0,idSpecialty=0;
			Integer total=0,total34=0,cantidad=0;
			MeasurementLevel ml=null;
			float media, porcentaje;
			Integer idResult = r.getId();
			Integer idStudent,idProfesor;
			Measurement meFound;
			ResultsPerCard result = new ResultsPerCard();
			Person student,found;
			//Rol de alumno
			List<Role> listaRoles = new ArrayList<>();
			Role rol = new Role();
			idProfesor = roleRepository.findByDescription("Alumno").getId();
			rol.setId(idProfesor);
			listaRoles.add(rol);
			result.setId(idResult);
			//Busca especialidad para sacar minimo successul
			//idSpecialty = r.get
			for (Measurement me : r.getMeasurements()) {
				me.setResultsPerCard(result); //Le coloca el FK del resultPerCard
				
				//Añade alumno, verificando existencia
				student = me.getPerson();
				found = personRepository.findByCode(student.getCode());
				if (found==null) {  //si no existe
					student.setRoleList(listaRoles); 
					idStudent = personRepository.save(student).getId();
					me.getPerson().setId(idStudent);	//Le coloca el idStudent a su student
				}else
					idStudent = found.getId();
				
				//Guarda en BD
				meFound = measurementRepository.findByPersonIdAndResultsPerCardId(idStudent, idResult);
				if (meFound==null)
					measurementRepository.save(me);
				else {
					meFound.setActive(false);
					measurementRepository.save(meFound);
					measurementRepository.save(me);
				}
				
				//Suma las notas necesarias
				ml = me.getMeasurementLevel();
				if (ml==null)
					nota=0;
				else {
					nota=ml.getOrden();
					//Halla la nota minima una vez
					if (notaMin==0) {
						var val = measurementLevelRepository.findById(ml.getId());	//Para obtener el dato completo con especialidad
						if (val.isPresent())
							idSpecialty = val.get().getSpecialty().getId(); 
						ml = measurementLevelRepository.findBySpecialtyIdAndIsMinimum(idSpecialty, 1);
						if (ml!=null)
							notaMin = ml.getOrden();
					}
					if (nota>=notaMin && notaMin>0)
						total34++;
				}
				total+=nota;
				cantidad++;
			}
			//Calcula resultados totales
			if (cantidad == 0)
				media = 0;
			else
				media = (float)total/cantidad;
			
			if (total==0)
				porcentaje = 0;
			else
				porcentaje = (float)total34/total;
			resultsPerCardRepository.registerResultsPerCard(idResult,cantidad,total34,media,porcentaje);
			response = new ApiResponse("Success",200);
		}catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

}
