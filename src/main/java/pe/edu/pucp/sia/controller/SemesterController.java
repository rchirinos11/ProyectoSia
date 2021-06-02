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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.pucp.sia.model.Semester;
import pe.edu.pucp.sia.service.SemesterService;
import pe.edu.pucp.sia.service.impl.SemesterServiceImpl;

@RestController
@RequestMapping("/semester")
public class SemesterController {

	Logger logger = LoggerFactory.getLogger(SemesterController.class);
	
	@Autowired
	private SemesterService semesterService = new SemesterServiceImpl(); 
	
	@GetMapping("/list")
	public ResponseEntity<Object> listSemester(){
		logger.info("Entered method listSemester()");
		return ResponseEntity.status(HttpStatus.OK).body(semesterService.listAll());
	}
	
	@PostMapping("/create")
	public ResponseEntity<Object> createSemester(@RequestBody Semester s){
		logger.info("Entered method createSemester()");
		return ResponseEntity.status(HttpStatus.CREATED).body(semesterService.createSemester(s));
	}
	
	@PostMapping("/update")
	public ResponseEntity<Object> updateSemester(@RequestBody Semester s){
		logger.info("Entered method updateSemester()");
		return ResponseEntity.status(HttpStatus.OK).body(semesterService.updateSemester(s));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteSemester(@PathVariable Integer id){
		logger.info("Entered method deleteSemester()");
		return ResponseEntity.status(HttpStatus.OK).body(semesterService.deleteSemester(id));
	}
	
	@GetMapping("updateCurrent/{id}")
	public ResponseEntity<Object> updateCurrentSemester(@PathVariable Integer id){
		logger.info("Entered method updateCurrentSemester()");
		return ResponseEntity.status(HttpStatus.OK).body(semesterService.updateCurrent(id));
	}
	
	@GetMapping("/current")
	public ResponseEntity<Object> findCurrent(){
		logger.info("Entered method findCurrent()");
		return ResponseEntity.status(HttpStatus.OK).body(semesterService.findCurrent());
	}
}
