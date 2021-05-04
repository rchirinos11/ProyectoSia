package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.Person;
import pe.edu.pucp.sia.repository.PersonRepository;
import pe.edu.pucp.sia.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService{
	
	@Autowired
	private PersonRepository personRepository;
	
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
			response = "Created"; 
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

}
