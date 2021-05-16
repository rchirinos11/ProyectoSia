package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.Person;

public interface PersonService {
	public Iterable<Person> listAll();
	public String createPerson(Person p);
	public String deletePerson(Integer id);
	public String updatePerson(Person p);
	public Person loginPerson(String email);
}
