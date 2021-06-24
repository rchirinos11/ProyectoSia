package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.Person;
import pe.edu.pucp.sia.requests.UnfinishedTeachersRequest;
import pe.edu.pucp.sia.response.ApiResponse;

public interface PersonService {
	public ApiResponse listAll();
	public ApiResponse listWorkers();
	public ApiResponse listRoleByPerson(Integer id);
	public ApiResponse createPerson(Person p);
	public ApiResponse deletePerson(Integer id);
	public ApiResponse updatePerson(Person p);
	public ApiResponse loginPerson(String email);	
	public ApiResponse listFacultiesSpecialties(String email);
	public ApiResponse listUnfinishedTeachers(UnfinishedTeachersRequest u);
	public ApiResponse listTeachersBySpecialty(Integer idSpecialty);
}
