package pe.edu.pucp.sia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import pe.edu.pucp.sia.model.StudentResult;

public interface StudentResultRepository extends CrudRepository<StudentResult,Integer>{
	public List<StudentResult> findBySpecialtyIdAndSemesterIdOrderByOrderNumber(Integer idSpecialty, Integer idSemester);
	public Iterable<StudentResult> findBySemesterId(Integer idSemester);
	
	@Procedure("sp_clone_student_results")
	public Integer cloneStudentResults(Integer idSpecialtyFrom, Integer idSemesterFrom, Integer idSpecialtyTo, Integer idSemesterTo);


	//Change to the proper procedure
	@Procedure("sp_clone_student_results")
	public Integer findBySemesters(Integer id_semester_start,Integer id_semester_end);
}
