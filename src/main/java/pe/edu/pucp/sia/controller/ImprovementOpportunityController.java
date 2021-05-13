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

import pe.edu.pucp.sia.model.ImprovementOpportunity;
import pe.edu.pucp.sia.service.ImprovementOpportunityService;
import pe.edu.pucp.sia.service.impl.ImprovementOpportunityServiceImpl;

@RestController
@RequestMapping("/improvementopportunity")
public class ImprovementOpportunityController {

	Logger logger = LoggerFactory.getLogger(ImprovementOpportunityController.class);
	
	@Autowired
	private ImprovementOpportunityService improvementOpportunityService = new ImprovementOpportunityServiceImpl(); 
	
	@GetMapping("/list")
	public ResponseEntity<Object> listImprovementOpportunity(){
		logger.info("Entered method listImprovementOpportunity()");
		return ResponseEntity.status(HttpStatus.OK).body(improvementOpportunityService.listAll());
	}
	
	@PostMapping("/create")
	public ResponseEntity<Object> createImprovementOpportunity(@RequestBody ImprovementOpportunity i){
		logger.info("Entered method createImprovementOpportunity()");
		return ResponseEntity.status(HttpStatus.CREATED).body(improvementOpportunityService.createImprovementOpportunity(i));
	}
	
	@PostMapping("/update")
	public ResponseEntity<Object> updateImprovementOpportunity(@RequestBody ImprovementOpportunity i){
		logger.info("Entered method updateImprovementOpportunity()");
		return ResponseEntity.status(HttpStatus.CREATED).body(improvementOpportunityService.updateImprovementOpportunity(i));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteImprovementOpportunity(@PathVariable Integer id){
		logger.info("Entered method deleteImprovementOpportunity()");
		return ResponseEntity.status(HttpStatus.CREATED).body(improvementOpportunityService.deleteImprovementOpportunity(id));
	}
}
