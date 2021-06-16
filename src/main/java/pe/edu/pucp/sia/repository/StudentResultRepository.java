package pe.edu.pucp.sia.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import pe.edu.pucp.sia.model.StudentResult;

public interface StudentResultRepository extends CrudRepository<StudentResult,Integer>{
	public List<StudentResult> findBySpecialtyIdOrderById(Integer id);
}
