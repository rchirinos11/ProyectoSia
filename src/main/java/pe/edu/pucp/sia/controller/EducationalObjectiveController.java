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
import pe.edu.pucp.sia.service.EducationalObjectiveService;
import pe.edu.pucp.sia.service.impl.EducationalObjectiveServiceImpl;

@RestController
@RequestMapping("/educationalobjective")
public class EducationalObjectiveController {
	Logger logger = LoggerFactory.getLogger(EducationalObjectiveController.class);
	
	@Autowired
	private EducationalObjectiveService educationalObjectiveService = new EducationalObjectiveServiceImpl();
	
	@GetMapping("/list")
	public ResponseEntity<Object> listEducationalObjective(){
		logger.info("Entered method listEducationalObjective()");
		return ResponseEntity.status(HttpStatus.OK).body(educationalObjectiveService.listAll());
	}
	
	@PostMapping("/create")
	public ResponseEntity<Object> createEducationalObjective(@RequestBody EducationalObjective eo){
		logger.info("Entered method createEducationalObjective()");
		return ResponseEntity.status(HttpStatus.CREATED).body(educationalObjectiveService.createEducationalObjective(eo));
	}
	
	@PostMapping("/update")
	public ResponseEntity<Object> updateEducationalObjective(@RequestBody EducationalObjective eo){
		logger.info("Entered method updateEducationalObjective()");
		return ResponseEntity.status(HttpStatus.CREATED).body(educationalObjectiveService.updateEducationalObjective(eo));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteEducationalObjective(@PathVariable Integer id){
		logger.info("Entered method deleteEducationalObjective()");
		return ResponseEntity.status(HttpStatus.CREATED).body(educationalObjectiveService.deleteEducationalObjective(id));
	}
}
