package pe.edu.pucp.sia.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import pe.edu.pucp.sia.model.Faculty;
import pe.edu.pucp.sia.model.Specialty;

public interface SpecialtyRepository extends CrudRepository<Specialty,Integer>{
	public List<Specialty> findByFacultyId(Integer id);
	public List<Specialty> findByCoordinatorId(Integer id);
	public List<Specialty> findByAssistantId(Integer id);
}
