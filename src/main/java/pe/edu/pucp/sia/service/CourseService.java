package pe.edu.pucp.sia.service;

import java.util.List;

import pe.edu.pucp.sia.model.Course;

public interface CourseService {
  public Iterable<Course> listAll();
	public int createCourse(Course c);
	public String deleteCourse(Integer id);
	public int updateCourse(Course c);   
	public List<Course> listCoursesByTeacherSpecialty(Integer idPerson,Integer idSpeciality);
}
