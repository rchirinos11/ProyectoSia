package pe.edu.pucp.sia.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.pucp.sia.model.Course;

public interface CourseRepository extends CrudRepository<Course, Integer>{
}
