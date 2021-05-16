package pe.edu.pucp.sia.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import pe.edu.pucp.sia.model.Faculty;
import pe.edu.pucp.sia.service.FacultyService;
import pe.edu.pucp.sia.service.impl.FacultyServiceImpl;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
	Logger logger = LoggerFactory.getLogger(FacultyController.class);
	
	@Autowired
	private FacultyService facultyService = new FacultyServiceImpl();
	
	@GetMapping("/list")
	public ResponseEntity<Object> listFaculty(){
		logger.info("Entered method listFaculty()");
		return ResponseEntity.status(HttpStatus.OK).body(facultyService.listAll());
	}
	
	@GetMapping("/listbycoordinator/{id}")
	public ResponseEntity<Object> listByCoordinator(@PathVariable Integer id){
		logger.info("Entered method listByCoordinator()");
		return ResponseEntity.status(HttpStatus.OK).body(facultyService.listByCoordinator(id));
	}
	
	@PostMapping("/create")
	public ResponseEntity<Object> createFaculty(@RequestBody Faculty f){
		logger.info("Entered method createFaculty()");
		return ResponseEntity.status(HttpStatus.CREATED).body(facultyService.createFaculty(f));
	}
	
	@PostMapping("/update")
	public ResponseEntity<Object> updateFaculty(@RequestBody Faculty f){
		logger.info("Entered method updateFaculty()");
		return ResponseEntity.status(HttpStatus.CREATED).body(facultyService.updateFaculty(f));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteFaculty(@PathVariable Integer id){
		logger.info("Entered method deleteFaculty()");
		return ResponseEntity.status(HttpStatus.OK).body(facultyService.deleteFaculty(id));
	}
}
