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

@RestController
@RequestMapping("/course")
public class CourseController {
	@Autowired
	private CourseService courseService = new CourseServiceImpl(); 
	
	@GetMapping("/list")
	public ResponseEntity<Object> listCourse(){
		return ResponseEntity.status(HttpStatus.OK).body(courseService.listAll());
	}
	
	@GetMapping("/listbyPersonSpeciality/{idP}/{idS}")
	public ResponseEntity<Object> listbyPersonSpeciality(@PathVariable Integer idP, @PathVariable Integer idS){
		return ResponseEntity.status(HttpStatus.OK).body(courseService.listCoursesByTeacherSpecialty(idP,idS));
	}
	
	@PostMapping("/create")
	public ResponseEntity<Object> createCourse(@RequestBody Course c){
		return ResponseEntity.status(HttpStatus.CREATED).body(courseService.createCourse(c));
	}
	
	@PostMapping("/update")
	public ResponseEntity<Object> updateCourse(@RequestBody Course c){
		return ResponseEntity.status(HttpStatus.CREATED).body(courseService.updateCourse(c));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteCourse(@PathVariable Integer id){
		return ResponseEntity.status(HttpStatus.CREATED).body(courseService.deleteCourse(id));
	}
}