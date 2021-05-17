package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.Person;
import pe.edu.pucp.sia.response.PersonDataResponse;

public interface PersonService {
	public Iterable<Person> listAll();
	public String createPerson(Person p);
	public String deletePerson(Integer id);
	public String updatePerson(Person p);
	public Person loginPerson(String email);	
	public PersonDataResponse listFacultiesSpecialties(String email);
}
