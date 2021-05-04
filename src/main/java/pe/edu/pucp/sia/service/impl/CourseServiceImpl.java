package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.Course;
import pe.edu.pucp.sia.repository.CourseRepository;
import pe.edu.pucp.sia.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService{
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public Iterable<Course> listAll() {
		return courseRepository.findAll();
	}

	@Override
	public String updateCourse(Course c) {
		String response = "";
		try {
			courseRepository.save(c);
			response = "Created"; 
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public String createCourse(Course c) {
		String response = "";
		try {
			courseRepository.save(c);
			response = "Created"; 
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public String deleteCourse(Integer id) {
		String response = "";
		try {
			courseRepository.deleteById(id);
			response = "Deleted";
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}
	
}
