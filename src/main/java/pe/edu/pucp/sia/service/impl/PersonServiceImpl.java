package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.Faculty;
import pe.edu.pucp.sia.model.Person;
import pe.edu.pucp.sia.model.Role;
import pe.edu.pucp.sia.model.Specialty;
import pe.edu.pucp.sia.repository.FacultyRepository;
import pe.edu.pucp.sia.repository.PersonRepository;
import pe.edu.pucp.sia.repository.SpecialtyRepository;
import pe.edu.pucp.sia.requests.UnfinishedTeachersRequest;
import pe.edu.pucp.sia.response.ApiResponse;
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
	public ApiResponse listAll() {
		ApiResponse response = null;
		try {
			Iterable<Person> list = personRepository.findAll();
			response = new ApiResponse(list,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse createPerson(Person p) {
		ApiResponse response = null;
		try {
			Integer id = personRepository.save(p).getId();
			response = new ApiResponse(id,201);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse deletePerson(Integer id) {
		ApiResponse response = null;
		try {
			personRepository.deleteById(id);
			response = new ApiResponse("Success",200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse updatePerson(Person p) {
		ApiResponse response = null;
		try {
			Integer id = personRepository.save(p).getId();
			response = new ApiResponse(id,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}
	
	@Override
	public ApiResponse listFacultiesSpecialties(String email) {
		ApiResponse response = null;
		try {
			Iterable<Faculty> facultyList = facultyRepository.findByCoordinatorEmail(email);
			Iterable<Specialty> cSpecialtyList = specialtyRepository.findByCoordinatorEmail(email);
			Iterable<Specialty> aSpecialtyList = specialtyRepository.findByAssistantEmail(email);
			Person person = personRepository.findByEmail(email);
			
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
			
			PersonDataResponse pDataResponse = new PersonDataResponse();
			pDataResponse.setCoordinatingSpecialtyList(cSpecialtyList);
			pDataResponse.setAssistingSpecialtyList(aSpecialtyList);
			pDataResponse.setCoordinatingFacultyList(facultyList);
			pDataResponse.setPerson(person);
			pDataResponse.setAdmin(false);
			
			for(Role r : person.getRoleList())
				if(r.getId()==1)
					pDataResponse.setAdmin(true);
			
			response = new ApiResponse(pDataResponse,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;		
	}

	@Override
	public ApiResponse loginPerson(String email) {
		ApiResponse response = null;
		try {
			Person p = personRepository.findByEmail(email);
			response = new ApiResponse(p,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse listWorkers() {
		ApiResponse response = null;
		try {
			Iterable<Person> list=personRepository.findByEmailIsNotNull();
			response = new ApiResponse(list,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;		
	}

	@Override
	public ApiResponse listRoleByPerson(Integer id) {
		ApiResponse response = null;
		try {
			Person p=personRepository.findById(id).get();
			Iterable<Role> list = p.getRoleList();
			response = new ApiResponse(list,200);			
		}catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}	
		return response;		
	}

	@Override
	public ApiResponse listUnfinishedTeachers(UnfinishedTeachersRequest u) {
		ApiResponse response = null;
		try {
			Iterable<Person> teachers = personRepository.listUnfinishedTeachers(u.getIdSemester(),u.getIdSpecialty());
			response = new ApiResponse(teachers,200);			
		}catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}	
		return response;
	}

	@Override
	public ApiResponse listTeachersBySpecialty(Integer idSpecialty){
		ApiResponse response=null;
		try{
			Iterable <Person> list = personRepository.listTeachersBySpecialty(idSpecialty);
			for (Person p : list)
				p.setRoleList(null);
			response = new ApiResponse(list,200);
		}
		catch(Exception ex){
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}
}
