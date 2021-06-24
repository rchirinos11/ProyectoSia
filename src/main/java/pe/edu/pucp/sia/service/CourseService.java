package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.Course;
import pe.edu.pucp.sia.response.ApiResponse;

public interface CourseService {
	public ApiResponse listAll();
    public ApiResponse createCourse(Course c);
	public ApiResponse deleteCourse(Integer id);
	public ApiResponse updateCourse(Course c);   
	public ApiResponse listCoursesByTeacherSpecialty(Integer idPerson,Integer idSpeciality);
	public ApiResponse listBySpecialty(Integer id);
	
}
