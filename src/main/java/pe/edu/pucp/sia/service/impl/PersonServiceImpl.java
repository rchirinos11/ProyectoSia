package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import pe.edu.pucp.sia.model.Person;
import pe.edu.pucp.sia.repository.PersonRepository;
import pe.edu.pucp.sia.service.PersonService;

public class PersonServiceImpl implements PersonService{
	
	@Autowired
	private PersonRepository personRepository;
	
	@Override
	public Iterable<Person> listAll() {
		return personRepository.findAll();
	}

	@Override
	public int createPerson(Person p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deletePerson(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updatePerson(Person p) {
		// TODO Auto-generated method stub
		return 0;
	}

}
