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

import pe.edu.pucp.sia.model.Activity;
import pe.edu.pucp.sia.response.ApiResponse;
import pe.edu.pucp.sia.service.ActivityService;
import pe.edu.pucp.sia.service.impl.ActivityServiceImpl;

@RestController
@RequestMapping("/activity")
public class ActivityController {

	Logger logger = LoggerFactory.getLogger(ActivityController.class);
	
	@Autowired
	private ActivityService activityService = new ActivityServiceImpl(); 
	
	@GetMapping("/listbyimprovementproposal/{id}")
	public ResponseEntity<ApiResponse> listByImprovementProposal(@PathVariable Integer id){
		logger.info("Entered method listByImprovementProposal()");
		ApiResponse response = activityService.listByImprovementProposal(id);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@GetMapping("/list")
	public ResponseEntity<ApiResponse> listActivity(){
		logger.info("Entered method listActivity()");
		ApiResponse response = activityService.listAll();
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/create")
	public ResponseEntity<ApiResponse> createActivity(@RequestBody Activity a){
		logger.info("Entered method createActivity()");
		ApiResponse response = activityService.createActivity(a);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/update")
	public ResponseEntity<ApiResponse> updateActivity(@RequestBody Activity a){
		logger.info("Entered method updateActivity()");
		ApiResponse response = activityService.updateActivity(a);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> deleteActivity(@PathVariable Integer id){
		logger.info("Entered method deleteActivity()");
		ApiResponse response = activityService.deleteActivity(id);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
}