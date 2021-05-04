package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.Course;

public interface CourseService {
	public Iterable<Course> listAll();
	public String updateCourse(Course c);
	public String createCourse(Course c);
	public String deleteCourse(Integer id);
}
