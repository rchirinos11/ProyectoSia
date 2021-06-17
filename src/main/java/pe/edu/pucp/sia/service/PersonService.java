package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.Person;
import pe.edu.pucp.sia.model.Role;
import pe.edu.pucp.sia.response.PersonDataResponse;

public interface PersonService {
	public Iterable<Person> listAll();
	public Iterable<Person> listWorkers();
	public Iterable<Role> listRoleByPerson(Integer id);
	public Integer createPerson(Person p);
	public String deletePerson(Integer id);
	public String updatePerson(Person p);
	public Person loginPerson(String email);	
	public PersonDataResponse listFacultiesSpecialties(String email);
}
