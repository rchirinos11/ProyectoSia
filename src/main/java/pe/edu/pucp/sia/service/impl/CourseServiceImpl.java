package pe.edu.pucp.sia.service.impl;

import java.util.List;

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
	public int updateCourse(Course c) {
		int response = 0;
		try {
			response = courseRepository.save(c).getId();
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public int createCourse(Course c) {
		int response = 0;
		try {
			response = courseRepository.save(c).getId(); 
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

	@Override
	public List<Course> listCoursesByTeacherSpecialty(Integer idPerson, Integer idSpeciality) {
		List<Course> lista=null;
		try{
			lista = courseRepository.listCoursesByTeacherSpecialty(idPerson, idSpeciality);
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return lista;
	}
}
