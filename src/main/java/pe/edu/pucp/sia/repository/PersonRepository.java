package pe.edu.pucp.sia.repository;

import org.springframework.data.repository.CrudRepository;

import pe.edu.pucp.sia.model.Person;

public interface PersonRepository extends CrudRepository<Person,Integer>{
	public Person findByEmail(String email);
	public Iterable<Person> findByEmailIsNotNull();
	public Person findByCode(String code);
}
