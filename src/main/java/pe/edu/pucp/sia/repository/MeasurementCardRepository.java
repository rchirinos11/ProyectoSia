package pe.edu.pucp.sia.repository;

import java.util.List;

import org.springframework.boot.context.properties.source.ConfigurationPropertyName.Form;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import pe.edu.pucp.sia.model.Course;
import pe.edu.pucp.sia.model.MeasurementCard;
import pe.edu.pucp.sia.model.MeasurementLevel;
import pe.edu.pucp.sia.model.ResultsPerCard;

public interface MeasurementCardRepository extends CrudRepository<MeasurementCard,Integer>{
	public List<MeasurementCard> findByPersonId(Integer id); // BY TEACHER
	public List<MeasurementCard> findByCourseId(Integer id);
	
	@Query(value = "call sp_list_measurement_card_by_teacher_course(:in_id_teacher,:in_id_course)", nativeQuery = true)
	public Iterable<Form> listMeasurementCardByTeacherCourse(@Param("in_id_teacher") Integer idTeacher, @Param("in_id_course")Integer idCourse);
	
	@Query(value = "call sp_list_measurement_card_by_teacher_course_2(:in_id_teacher,:in_id_course)", nativeQuery = true)
	public List<MeasurementCard> listMeasurementCardByTeacherCourse_2(@Param("in_id_teacher") Integer idTeacher, @Param("in_id_course")Integer idCourse);
	
	@Query(value = "call sp_list_measurement_card_by_teacher_course_3(:in_id_teacher,:in_id_course)", nativeQuery = true)
	public List<ResultsPerCard> listMeasurementCardByTeacherCourse_3(@Param("in_id_teacher") Integer idTeacher, @Param("in_id_course")Integer idCourse);
	
	
	
	@Procedure("sp_delete_measurement_card")
	public void deleteMeasurementCard(Integer id);
}
