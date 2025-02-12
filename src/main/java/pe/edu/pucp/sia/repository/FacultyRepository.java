package pe.edu.pucp.sia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import pe.edu.pucp.sia.model.Faculty;

public interface FacultyRepository extends CrudRepository<Faculty,Integer>{
	public List<Faculty> findByCoordinatorId(Integer id);
	public Iterable<Faculty> findByCoordinatorEmail(String email);
	
	@Procedure("sp_delete_faculty")
	public int deleteFaculty(Integer id);
	@Procedure("sp_set_faculty_coordinator")
	public void setCoordinator(Integer idFaculty,Integer idCoordinator);
	@Procedure("sp_archive_faculty")
	public void archiveFaculty(Integer idFaculty,boolean state);
}
