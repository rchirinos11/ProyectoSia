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
	public Iterable<ResultsPerCard> listAll() {
		return resultsPerCardRepository.findAll();
	}

	@Override
	public Integer createResultsPerCard(ResultsPerCard r) {
		Integer response =0;
		try {
			response=resultsPerCardRepository.save(r).getId();
			
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public Integer updateResultsPerCard(ResultsPerCard r) {
		Integer response =0;
		try {
			response=resultsPerCardRepository.save(r).getId();
					} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public String deleteResultsPerCard(Integer id) {
		String response = "";
		try {
			resultsPerCardRepository.deleteResultsPerCard(id);
			response = "Deleted"; 
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public Iterable<ResultsPerCard> listByMeasurementPlanLine(Integer id) {
		Iterable<ResultsPerCard> lista = resultsPerCardRepository.findByMeasurementPlanLineId(id);
		for (ResultsPerCard rc : lista) {
			rc.setMeasurementPlanLine(null);
		}
		return lista;
	}

	@Override
	public Integer registerStudentMeditions(ResultsPerCard r) {
		Integer response = 0;
		Integer d1,d2;
		try {
			Integer idResult = r.getId();
			Integer idStudent,idProfesor;
			Measurement meFound;
			ResultsPerCard result = new ResultsPerCard();
			Person student,found;
			List<Role> listaRoles = new ArrayList<>();
			Role rol = new Role();
			idProfesor = roleRepository.findByDescription("Profesor").getId();
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
					d1=measurementRepository.save(meFound).getId();
					d2=measurementRepository.save(me).getId();
				}
			}
			response = 1;
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

}
