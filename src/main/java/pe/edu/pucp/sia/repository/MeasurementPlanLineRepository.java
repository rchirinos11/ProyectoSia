package pe.edu.pucp.sia.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import pe.edu.pucp.sia.model.MeasurementPlanLine;
import pe.edu.pucp.sia.model.Person;

public interface MeasurementPlanLineRepository extends CrudRepository<MeasurementPlanLine, Integer>{
	@Query(value = "call sp_list_measurement_plan_line_by_course_semester_teacher(:in_id_course,:in_id_semester,:in_id_teacher)", nativeQuery = true)
	public Iterable<MeasurementPlanLine> listMeasurementPlanLineByCourseSemesterTeacher(@Param("in_id_course") Integer idCourse, @Param("in_id_semester")Integer idSemester,@Param("in_id_teacher")Integer idPerson);

	@Query(value = "call sp_list_measurement_plan_line_by_specialty_semester(:in_id_specialty,:in_id_semester)", nativeQuery = true)
	public Iterable<MeasurementPlanLine> listMeasurementPlanLineBySpecialtySemester(@Param("in_id_specialty") Integer idSpecialty, @Param("in_id_semester")Integer idSemester);
	
	
	public Iterable<MeasurementPlanLine> findByCourseId(Integer id);
	public Iterable<MeasurementPlanLine> findByIndicatorStudentResultSpecialtyIdAndSemesterId(Integer idSpecialty, Integer idSemester);
	public Iterable<MeasurementPlanLine> findByCourseIdAndSemesterId(Integer idCourse, Integer idSemester);
	public Iterable<MeasurementPlanLine> findByIndicatorId(Integer id);
	public Iterable<MeasurementPlanLine> findBySemesterIdAndPersonsIn(Integer idSemester, Iterable<Person> persons); 
}
