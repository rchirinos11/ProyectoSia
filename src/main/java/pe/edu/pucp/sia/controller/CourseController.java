package pe.edu.pucp.sia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.pucp.sia.model.Course;
import pe.edu.pucp.sia.response.ApiResponse;
import pe.edu.pucp.sia.service.CourseService;
import pe.edu.pucp.sia.service.impl.CourseServiceImpl;

@RestController
@RequestMapping("/course")
public class CourseController {
	@Autowired
	private CourseService courseService = new CourseServiceImpl(); 
	
	@GetMapping("/list")
	public ResponseEntity<ApiResponse> listCourse(){
		ApiResponse response = courseService.listAll();
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@GetMapping("/listbyPersonSpeciality/{idP}/{idS}")
	public ResponseEntity<ApiResponse> listbyPersonSpeciality(@PathVariable Integer idP, @PathVariable Integer idS){
		ApiResponse response = courseService.listCoursesByTeacherSpecialty(idP,idS);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	
	@GetMapping("/listbyspecialty/{id}")
	public ResponseEntity<ApiResponse> listBySpecialty(@PathVariable Integer id){
		ApiResponse response = courseService.listBySpecialty(id);
		return ResponseEntity.status(response.getStatus()).body(response);
	}

	@PostMapping("/create")
	public ResponseEntity<ApiResponse> createCourse(@RequestBody Course c){
		ApiResponse response = courseService.createCourse(c);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/update")
	public ResponseEntity<ApiResponse> updateCourse(@RequestBody Course c){
		ApiResponse response = courseService.updateCourse(c);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> deleteCourse(@PathVariable Integer id){
		ApiResponse response = courseService.deleteCourse(id);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
}