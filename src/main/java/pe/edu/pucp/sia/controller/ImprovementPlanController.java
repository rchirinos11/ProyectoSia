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

import pe.edu.pucp.sia.requests.CreateImprovementPlanRequest;
import pe.edu.pucp.sia.requests.ImprovementPlanActivityRequest;
import pe.edu.pucp.sia.response.ApiResponse;
import pe.edu.pucp.sia.service.ImprovementPlanService;
import pe.edu.pucp.sia.service.impl.ImprovementPlanServiceImpl;

@RestController
@RequestMapping("/improvementplan")
public class ImprovementPlanController {

	Logger logger = LoggerFactory.getLogger(ImprovementPlanController.class);
	
	@Autowired
	private ImprovementPlanService improvementPlanService = new ImprovementPlanServiceImpl(); 
	
	@GetMapping("/listbyspecialty/{id}")
	public ResponseEntity<ApiResponse> listBySpecialty(@PathVariable Integer id){
		logger.info("Entered method listBySpecialty()");
		ApiResponse response = improvementPlanService.listBySpecialty(id);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/listbyactivitystatesandsemesters")
	public ResponseEntity<Object> listByActivityStatesAndSemesters(@RequestBody ImprovementPlanActivityRequest i){
		logger.info("Entered method listByActivityStatesAndSemesters()");
		ApiResponse response = improvementPlanService.listByActivityStatesAndSemesters(i);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@GetMapping("/list")
	public ResponseEntity<ApiResponse> listImprovementPlan(){
		logger.info("Entered method listImprovementPlan()");
		ApiResponse response = improvementPlanService.listAll();
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/create")
	public ResponseEntity<ApiResponse> createImprovementPlan(@RequestBody CreateImprovementPlanRequest i){
		logger.info("Entered method createImprovementPlan()");
		ApiResponse response = improvementPlanService.createImprovementPlan(i);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/update")
	public ResponseEntity<ApiResponse> updateImprovementPlan(@RequestBody CreateImprovementPlanRequest i){
		logger.info("Entered method updateImprovementPlan()");
		ApiResponse response = improvementPlanService.updateImprovementPlan(i);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> deleteImprovementPlan(@PathVariable Integer id){
		logger.info("Entered method deleteImprovementPlan()");
		ApiResponse response = improvementPlanService.deleteImprovementPlan(id);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
}
