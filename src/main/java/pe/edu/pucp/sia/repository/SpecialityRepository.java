package pe.edu.pucp.sia.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import pe.edu.pucp.sia.model.Faculty;
import pe.edu.pucp.sia.model.Speciality;

public interface SpecialityRepository extends CrudRepository<Speciality,Integer>{
	public List<Speciality> findByFacultyId(Integer id);
}
