package pe.edu.pucp.sia.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.pucp.sia.model.Course;
import pe.edu.pucp.sia.model.EducationalObjective;

public interface CourseRepository extends CrudRepository<Course,Integer>{

}