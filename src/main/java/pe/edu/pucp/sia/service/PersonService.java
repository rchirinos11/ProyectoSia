package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.Person;

public interface PersonService {
	public Iterable<Person> listAll();
	public int createPerson(Person p);
	public int deletePerson(Integer id);
	public int updatePerson(Person p);
}
