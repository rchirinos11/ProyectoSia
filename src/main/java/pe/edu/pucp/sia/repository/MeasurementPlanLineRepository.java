package pe.edu.pucp.sia.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import pe.edu.pucp.sia.model.MeasurementPlanLine;
import pe.edu.pucp.sia.model.Person;

public interface MeasurementPlanLineRepository extends CrudRepository<MeasurementPlanLine, Integer>{
	public Iterable<MeasurementPlanLine> findByCourseId(Integer id);
	public Iterable<MeasurementPlanLine> findByIndicatorStudentResultSpecialtyIdAndSemesterId(Integer idSpecialty, Integer idSemester);
	public Iterable<MeasurementPlanLine> findByCourseIdAndSemesterId(Integer idCourse, Integer idSemester);
	public Iterable<MeasurementPlanLine> findByIndicatorId(Integer id);
	public Iterable<MeasurementPlanLine> findDistinctBySemesterIdAndSectionsTeachersIn(Integer idSemester, Iterable<Person> persons);
	public Iterable<MeasurementPlanLine> findByCourseIdAndSemesterIdAndSectionsTeachersInOrderByIndicatorCodeAsc(Integer idCourse, Integer idSemester, Iterable<Person> persons);
	@Query(value = "call sp_find_by_code_teacher_course_semester(:in_code,:in_id_teacher,:in_id_course,:in_id_semester)", nativeQuery = true)
	public Iterable<MeasurementPlanLine> findByCodeTeacherCourseSemester(@Param("in_code") Integer code, @Param("in_id_teacher") Integer idTeacher, @Param("in_id_course") Integer idCourse, @Param("in_id_semester") Integer idSemester);
}
