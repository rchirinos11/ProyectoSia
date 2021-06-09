package pe.edu.pucp.sia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import pe.edu.pucp.sia.model.Course;

public interface CourseRepository extends CrudRepository<Course, Integer>{
	//@Procedure("sp_list_courses_by_teacher_specialty")
	@Query(value = "call sp_list_courses_by_teacher_specialty(:in_id_teacher,:in_id_specialty)", nativeQuery = true)
	public List<Course> listCoursesByTeacherSpecialty(@Param("in_id_teacher") Integer idPerson, @Param("in_id_specialty")Integer idSpeciality);

	public List<Course> findBySpecialtyId(Integer id);

	
}
