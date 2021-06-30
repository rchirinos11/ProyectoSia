package pe.edu.pucp.sia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.edu.pucp.sia.model.StudentResult;

public interface StudentResultRepository extends CrudRepository<StudentResult,Integer>{
	public List<StudentResult> findBySpecialtyIdAndSemesterIdOrderByOrderNumber(Integer idSpecialty, Integer idSemester);
	public Iterable<StudentResult> findBySemesterId(Integer idSemester);
	
	@Procedure("sp_clone_student_results")
	public Integer cloneStudentResults(Integer idSpecialtyFrom, Integer idSemesterFrom, Integer idSpecialtyTo, Integer idSemesterTo);


	//sp not implemented yet
	@Query(value = "call sp_list_student_result_by_semesters(:in_id_semester_start,:in_id_semester_end)", nativeQuery = true)
	public List<StudentResult> findBySemesters(@Param("in_id_semester_start")Integer id_semester_start,@Param("in_id_semester_end")Integer id_semester_end);
}
