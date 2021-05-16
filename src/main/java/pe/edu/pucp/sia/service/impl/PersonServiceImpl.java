package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.Faculty;
import pe.edu.pucp.sia.model.Person;
import pe.edu.pucp.sia.model.Specialty;
import pe.edu.pucp.sia.repository.FacultyRepository;
import pe.edu.pucp.sia.repository.PersonRepository;
import pe.edu.pucp.sia.repository.SpecialtyRepository;
import pe.edu.pucp.sia.response.PersonDataResponse;
import pe.edu.pucp.sia.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService{
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private FacultyRepository facultyRepository;
	
	@Autowired
	private SpecialtyRepository specialtyRepository;
	
	@Override
	public Iterable<Person> listAll() {
		return personRepository.findAll();
	}

	@Override
	public String createPerson(Person p) {
		String response = "";
		try {
			personRepository.save(p);
			response = "Created"; 
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public String deletePerson(Integer id) {
		String response = "";
		try {
			personRepository.deleteById(id);
			response = "Deleted"; 
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public String updatePerson(Person p) {
		String response = "";
		try {
			personRepository.save(p);
			response = "Updated"; 
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}
	
	@Override
	public PersonDataResponse listFacultiesSpecialties(String email) {
		PersonDataResponse response = null;
		Iterable<Faculty> facultyList;
		Iterable<Specialty> cSpecialtyList;
		Iterable<Specialty> aSpecialtyList;
		try {
			facultyList = facultyRepository.findByCoordinatorEmail(email);
			cSpecialtyList = specialtyRepository.findByCoordinatorEmail(email);
			aSpecialtyList = specialtyRepository.findByAssistantEmail(email);
			
			for(Faculty f : facultyList)
				f.setCoordinator(null);
			for(Specialty s : cSpecialtyList) {
				s.setAssistant(null);
				s.setCoordinator(null);
				s.getFaculty().setCoordinator(null);
			}
			for(Specialty s : aSpecialtyList) {
				s.setAssistant(null);
				s.setCoordinator(null);
				s.getFaculty().setCoordinator(null);
			}
			
			response = new PersonDataResponse();
			response.setCoordinatingSpecialtyList(cSpecialtyList);
			response.setAssistingSpecialtyList(aSpecialtyList);
			response.setCoordinatingFacultyList(facultyList);
			
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;		
	}

}
