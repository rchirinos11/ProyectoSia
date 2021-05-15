package pe.edu.pucp.sia.repository;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import pe.edu.pucp.sia.model.Semester;

public interface SemesterRepository extends CrudRepository<Semester, Integer>{
	@Procedure("sp_change_current_semester")
	public int changeCurrentSemester(Integer id);
	
	@Procedure("sp_delete_semester")
	public void deleteSemester(Integer id);
}