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

import pe.edu.pucp.sia.model.ImprovementPlan;
import pe.edu.pucp.sia.requests.CreateImprovementPlanRequest;
import pe.edu.pucp.sia.requests.ImprovementPlanActivityRequest;
import pe.edu.pucp.sia.service.ImprovementPlanService;
import pe.edu.pucp.sia.service.impl.ImprovementPlanServiceImpl;

@RestController
@RequestMapping("/improvementplan")
public class ImprovementPlanController {

	Logger logger = LoggerFactory.getLogger(ImprovementPlanController.class);
	
	@Autowired
	private ImprovementPlanService improvementPlanService = new ImprovementPlanServiceImpl(); 
	
	@GetMapping("/listbyspecialty/{id}")
	public ResponseEntity<Object> listBySpecialty(@PathVariable Integer id){
		logger.info("Entered method listBySpecialty()");
		return ResponseEntity.status(HttpStatus.OK).body(improvementPlanService.listBySpecialty(id));
	}
	
	@PostMapping("/listbyactivitystatesandsemesters")
	public ResponseEntity<Object> listByActivityStatesAndSemesters(@RequestBody ImprovementPlanActivityRequest i){
		logger.info("Entered method listByActivityStatesAndSemesters()");
		return ResponseEntity.status(HttpStatus.OK).body(improvementPlanService.listByActivityStatesAndSemesters(i));
	}
	
	@GetMapping("/list")
	public ResponseEntity<Object> listImprovementPlan(){
		logger.info("Entered method listImprovementPlan()");
		return ResponseEntity.status(HttpStatus.OK).body(improvementPlanService.listAll());
	}
	
	@PostMapping("/create")
	public ResponseEntity<Object> createImprovementPlan(@RequestBody CreateImprovementPlanRequest i){
		logger.info("Entered method createImprovementPlan()");
		return ResponseEntity.status(HttpStatus.CREATED).body(improvementPlanService.createImprovementPlan(i));
	}
	
	@PostMapping("/update")
	public ResponseEntity<Object> updateImprovementPlan(@RequestBody CreateImprovementPlanRequest i){
		logger.info("Entered method updateImprovementPlan()");
		return ResponseEntity.status(HttpStatus.CREATED).body(improvementPlanService.updateImprovementPlan(i));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteImprovementPlan(@PathVariable Integer id){
		logger.info("Entered method deleteImprovementPlan()");
		return ResponseEntity.status(HttpStatus.CREATED).body(improvementPlanService.deleteImprovementPlan(id));
	}
}
