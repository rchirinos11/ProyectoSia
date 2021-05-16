package pe.edu.pucp.sia.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import pe.edu.pucp.sia.model.Faculty;

public interface FacultyRepository extends CrudRepository<Faculty,Integer>{
	public List<Faculty> findByCoordinatorId(Integer id);
	public Iterable<Faculty> findByCoordinatorEmail(String email);
}
