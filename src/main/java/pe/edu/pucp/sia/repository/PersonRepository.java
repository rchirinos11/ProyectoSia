package pe.edu.pucp.sia.repository;

import org.springframework.data.repository.CrudRepository;

import pe.edu.pucp.sia.model.Person;

public interface PersonRepository extends CrudRepository<Person,Integer>{
	
}
