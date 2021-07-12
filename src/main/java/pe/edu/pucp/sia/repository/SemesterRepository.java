package pe.edu.pucp.sia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import pe.edu.pucp.sia.model.Semester;
import pe.edu.pucp.sia.model.StudentResult;

public interface SemesterRepository extends CrudRepository<Semester, Integer>{
	@Procedure("sp_change_current_semester")
	public Integer changeCurrentSemester(Integer id);
	
	@Procedure("sp_delete_semester")
	public void deleteSemester(Integer id);
	
	public Semester findByCurrent(Boolean current);
	
	@Query(value = "call sp_list_semesters_range(:in_id_semester_start,:in_id_semester_end)", nativeQuery = true)
	public List<Semester> listSemestersRange(@Param("in_id_semester_start") Integer idSemesterStart,@Param("in_id_semester_end") Integer idSemesterEnd);
	
}