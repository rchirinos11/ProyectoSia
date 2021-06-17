package pe.edu.pucp.sia.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.pucp.sia.model.Semester;
import pe.edu.pucp.sia.response.ApiResponse;
import pe.edu.pucp.sia.service.SemesterService;
import pe.edu.pucp.sia.service.impl.SemesterServiceImpl;

@RestController
@RequestMapping("/semester")
public class SemesterController {

	Logger logger = LoggerFactory.getLogger(SemesterController.class);
	
	@Autowired
	private SemesterService semesterService = new SemesterServiceImpl(); 
	
	@GetMapping("/list")
	public ResponseEntity<ApiResponse> listSemester(){
		logger.info("Entered method listSemester()");
		ApiResponse response = semesterService.listAll();
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/create")
	public ResponseEntity<ApiResponse> createSemester(@RequestBody Semester s){
		logger.info("Entered method createSemester()");
		ApiResponse response = semesterService.createSemester(s);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/update")
	public ResponseEntity<ApiResponse> updateSemester(@RequestBody Semester s){
		logger.info("Entered method updateSemester()");
		ApiResponse response = semesterService.updateSemester(s);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> deleteSemester(@PathVariable Integer id){
		logger.info("Entered method deleteSemester()");
		ApiResponse response = semesterService.deleteSemester(id);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@GetMapping("updateCurrent/{id}")
	public ResponseEntity<ApiResponse> updateCurrentSemester(@PathVariable Integer id){
		logger.info("Entered method updateCurrentSemester()");
		ApiResponse response = semesterService.updateCurrent(id);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@GetMapping("/current")
	public ResponseEntity<ApiResponse> findCurrent(){
		logger.info("Entered method findCurrent()");
		ApiResponse response = semesterService.findCurrent();
		return ResponseEntity.status(response.getStatus()).body(response);
	}
}
