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
import pe.edu.pucp.sia.service.ActivityService;
import pe.edu.pucp.sia.service.impl.ActivityServiceImpl;

@RestController
@RequestMapping("/activity")
public class ActivityController {

	Logger logger = LoggerFactory.getLogger(ActivityController.class);
	
	@Autowired
	private ActivityService activityService = new ActivityServiceImpl(); 
	
	@GetMapping("/listbyimprovementproposal/{id}")
	public ResponseEntity<Object> listByImprovementProposal(@PathVariable Integer id){
		logger.info("Entered method listByImprovementProposal()");
		return ResponseEntity.status(HttpStatus.OK).body(activityService.listByImprovementProposal(id));
	}
	
	@GetMapping("/list")
	public ResponseEntity<Object> listActivity(){
		logger.info("Entered method listActivity()");
		return ResponseEntity.status(HttpStatus.OK).body(activityService.listAll());
	}
	
	@PostMapping("/create")
	public ResponseEntity<Object> createActivity(@RequestBody Activity a){
		logger.info("Entered method createActivity()");
		return ResponseEntity.status(HttpStatus.CREATED).body(activityService.createActivity(a));
	}
	
	@PostMapping("/update")
	public ResponseEntity<Object> updateActivity(@RequestBody Activity a){
		logger.info("Entered method updateActivity()");
		return ResponseEntity.status(HttpStatus.CREATED).body(activityService.updateActivity(a));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteActivity(@PathVariable Integer id){
		logger.info("Entered method deleteActivity()");
		return ResponseEntity.status(HttpStatus.CREATED).body(activityService.deleteActivity(id));
	}
}