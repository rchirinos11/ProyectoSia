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

import pe.edu.pucp.sia.model.StudentResult;
import pe.edu.pucp.sia.response.ApiResponse;
import pe.edu.pucp.sia.service.StudentResultService;
import pe.edu.pucp.sia.service.impl.StudentResultServiceImpl;

@RestController
@RequestMapping("/studentresult")
public class StudentResultController {
	Logger logger = LoggerFactory.getLogger(StudentResultController.class);
	
	@Autowired
	private StudentResultService studentResultService = new StudentResultServiceImpl();
	
	@GetMapping("/list")
	public ResponseEntity<ApiResponse> listStudentResult(){
		logger.info("Entered method listStudentResult()");
		ApiResponse response = studentResultService.listAll();
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@GetMapping("/listbyspecialty/{id}")
	public ResponseEntity<ApiResponse> listBySpecialty(@PathVariable Integer id){
		logger.info("Entered method listBySpecialty()");
		ApiResponse response = studentResultService.listBySpecialty(id);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@GetMapping("/listbyspecialtypluspercentage/{id}")
	public ResponseEntity<ApiResponse> listBySpecialtyPlusAchievementPercentage(@PathVariable Integer id){
		logger.info("Entered method listBySpecialtyPlusAchievementPercentage()");
		ApiResponse response = studentResultService.listBySpecialtyPlusAchievementPercentage(id);
		return ResponseEntity.status(response.getStatus()).body(response);
	}

	@GetMapping("/listbyspecialtyplusindicator/{id}")
	public ResponseEntity<ApiResponse> listBySpecialtyPlusIndicator(@PathVariable Integer id){
		logger.info("Entered method listBySpecialtyPlusIndicator()");
		ApiResponse response = studentResultService.listBySpecialtyPlusIndicator(id);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/create")
	public ResponseEntity<ApiResponse> createStudentResult(@RequestBody StudentResult sr){
		logger.info("Entered method createStudentResult()");
		ApiResponse response = studentResultService.createStudentResult(sr);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/update")
	public ResponseEntity<ApiResponse> updateStudentResult(@RequestBody StudentResult sr){
		logger.info("Entered method updateStudentResult()");
		ApiResponse response = studentResultService.updateStudentResult(sr);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> deleteStudentResult(@PathVariable Integer id){
		logger.info("Entered method deleteStudentResult()");
		ApiResponse response = studentResultService.deleteStudentResult(id);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
}
