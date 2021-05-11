package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.Course;

public class CourseService {
    public Iterable<Course> listAll();
	public int createCourse(Course c);
	public int deleteCourse(Integer id);
	public int updateCourse(Course c);    
}
