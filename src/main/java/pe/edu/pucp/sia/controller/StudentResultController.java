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

import pe.edu.pucp.sia.model.StudentResult;
import pe.edu.pucp.sia.service.StudentResultService;
import pe.edu.pucp.sia.service.impl.StudentResultServiceImpl;

@RestController
@RequestMapping("/studentresult")
public class StudentResultController {
	Logger logger = LoggerFactory.getLogger(StudentResultController.class);
	
	@Autowired
	private StudentResultService studentResultService = new StudentResultServiceImpl();
	
	@GetMapping("/list")
	public ResponseEntity<Object> listStudentResult(){
		logger.info("Entered method listStudentResult()");
		return ResponseEntity.status(HttpStatus.OK).body(studentResultService.listAll());
	}
	
	@GetMapping("/listbyspeciality/{id}")
	public ResponseEntity<Object> listBySpeciality(@PathVariable Integer id){
		logger.info("Entered method listBySpeciality()");
		return ResponseEntity.status(HttpStatus.OK).body(studentResultService.listBySpeciality(id));
	}
	
	@PostMapping("/create")
	public ResponseEntity<Object> createStudentResult(@RequestBody StudentResult sr){
		logger.info("Entered method createStudentResult()");
		return ResponseEntity.status(HttpStatus.CREATED).body(studentResultService.createStudentResult(sr));
	}
	
	@PostMapping("/update")
	public ResponseEntity<Object> updateStudentResult(@RequestBody StudentResult sr){
		logger.info("Entered method updateStudentResult()");
		return ResponseEntity.status(HttpStatus.CREATED).body(studentResultService.updateStudentResult(sr));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteStudentResult(@PathVariable Integer id){
		logger.info("Entered method deleteStudentResult()");
		return ResponseEntity.status(HttpStatus.CREATED).body(studentResultService.deleteStudentResult(id));
	}
}
