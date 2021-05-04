package pe.edu.pucp.sia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.pucp.sia.model.Course;
import pe.edu.pucp.sia.service.CourseService;
import pe.edu.pucp.sia.service.impl.CourseServiceImpl;

@RequestMapping("/course")
@RestController
public class CourseController {
	@Autowired
	CourseService courseService = new CourseServiceImpl();
	
	@GetMapping("/list")
	public ResponseEntity<Object> listCourse(){
		return ResponseEntity.status(HttpStatus.OK).body(courseService.listAll());
	}
	
	@PostMapping("/create")
	public ResponseEntity<Object> createPerson(@RequestBody Course c){
		return ResponseEntity.status(HttpStatus.CREATED).body(courseService.createCourse(c));
	}
	
	@PostMapping("/update")
	public ResponseEntity<Object> updatePerson(@RequestBody Course c){
		return ResponseEntity.status(HttpStatus.CREATED).body(courseService.updateCourse(c));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deletePerson(@PathVariable Integer id){
		return ResponseEntity.status(HttpStatus.CREATED).body(courseService.deleteCourse(id));
	}
}
