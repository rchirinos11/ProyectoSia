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
	public int createCourse(Course c) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCourse(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateCourse(Course c) {
		// TODO Auto-generated method stub
		return 0;
	}

}
