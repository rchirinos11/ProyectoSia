package pe.edu.pucp.sia.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.Measurement;
import pe.edu.pucp.sia.model.Person;
import pe.edu.pucp.sia.model.ResultsPerCard;
import pe.edu.pucp.sia.model.Role;
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
			Integer nota,total=0,total34=0,cantidad=0;
			float media, porcentaje;
			Integer idResult = r.getId();
			Integer idStudent,idProfesor;
			Measurement meFound;
			ResultsPerCard result = new ResultsPerCard();
			Person student,found;
			List<Role> listaRoles = new ArrayList<>();
			Role rol = new Role();
			idProfesor = roleRepository.findByDescription("Alumno").getId();
			rol.setId(idProfesor);
			listaRoles.add(rol);
			result.setId(idResult);
			for (Measurement me : r.getMeasurements()) {
				me.setResultsPerCard(result); //Le coloca el FK del resultPerCard
				
				//Añade alumno, verificando existencia
				student = me.getPerson();
				found = personRepository.findByCode(student.getCode());
				if (found==null) {  //si no existe
					student.setRoleList(listaRoles); 
					idStudent = personRepository.save(student).getId();
				}else
					idStudent = found.getId();
				me.getPerson().setId(idStudent);	//Le coloca el idStudent a su student
				
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
				nota=me.getMeasurementLevel().getOrden();
				if (nota==3 || nota==4)
					total34++;
				total+=nota;
				cantidad++;
			}
			//Calcula resultados totales
			media = (float)total/cantidad;
			porcentaje = (float)total34/total;
			resultsPerCardRepository.registerResultsPerCard(idResult,cantidad,media,porcentaje);
			response = new ApiResponse("Success",200);
		}catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

}
