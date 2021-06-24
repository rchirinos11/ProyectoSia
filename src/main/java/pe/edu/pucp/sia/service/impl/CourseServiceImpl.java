package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.Course;
import pe.edu.pucp.sia.repository.CourseRepository;
import pe.edu.pucp.sia.response.ApiResponse;
import pe.edu.pucp.sia.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	private CourseRepository courseRepository;
  
	@Override
	public ApiResponse listAll() {
		ApiResponse response = null;
		try {
			Iterable<Course> list = courseRepository.findAll();
			response = new ApiResponse(list, 200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse updateCourse(Course c) {
		ApiResponse response = null;
		try {
			Integer id = courseRepository.save(c).getId();
			response = new ApiResponse(id, 201);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse createCourse(Course c) {
		ApiResponse response = null;
		try {
			Integer id = courseRepository.save(c).getId();
			response = new ApiResponse(id, 200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse deleteCourse(Integer id) {
		ApiResponse response = null;
		try {
			courseRepository.deleteById(id);
			response = new ApiResponse("Success",200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse listCoursesByTeacherSpecialty(Integer idPerson, Integer idSpeciality) {
		ApiResponse response = null;
		try{
			Iterable<Course> list = courseRepository.listCoursesByTeacherSpecialty(idPerson, idSpeciality);
			response = new ApiResponse(list, 200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse listBySpecialty(Integer id) {
		ApiResponse response = null;
		try {
			Iterable<Course> list = courseRepository.findBySpecialtyId(id);
			for (Course course: list) 
				course.setSpecialty(null);
			response = new ApiResponse(list, 200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
		

	}

}
