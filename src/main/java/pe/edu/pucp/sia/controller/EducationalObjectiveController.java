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

import pe.edu.pucp.sia.model.EducationalObjective;
import pe.edu.pucp.sia.response.ApiResponse;
import pe.edu.pucp.sia.service.EducationalObjectiveService;
import pe.edu.pucp.sia.service.impl.EducationalObjectiveServiceImpl;

@RestController
@RequestMapping("/educationalobjective")
public class EducationalObjectiveController {
	Logger logger = LoggerFactory.getLogger(EducationalObjectiveController.class);
	
	@Autowired
	private EducationalObjectiveService educationalObjectiveService = new EducationalObjectiveServiceImpl();
	
	@GetMapping("/list")
	public ResponseEntity<ApiResponse> listEducationalObjective(){
		logger.info("Entered method listEducationalObjective()");
		ApiResponse response = educationalObjectiveService.listAll();
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/create")
	public ResponseEntity<ApiResponse> createEducationalObjective(@RequestBody EducationalObjective eo){
		logger.info("Entered method createEducationalObjective()");
		ApiResponse response = educationalObjectiveService.createEducationalObjective(eo);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/update")
	public ResponseEntity<ApiResponse> updateEducationalObjective(@RequestBody EducationalObjective eo){
		logger.info("Entered method updateEducationalObjective()");
		ApiResponse response = educationalObjectiveService.updateEducationalObjective(eo);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> deleteEducationalObjective(@PathVariable Integer id){
		logger.info("Entered method deleteEducationalObjective()");
		ApiResponse response = educationalObjectiveService.deleteEducationalObjective(id);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
}
