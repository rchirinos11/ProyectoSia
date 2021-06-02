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

import pe.edu.pucp.sia.model.ImprovementProposal;
import pe.edu.pucp.sia.service.ImprovementProposalService;
import pe.edu.pucp.sia.service.impl.ImprovementProposalServiceImpl;

@RestController
@RequestMapping("/improvementproposal")
public class ImprovementProposalController {

	Logger logger = LoggerFactory.getLogger(ImprovementProposalController.class);
	
	@Autowired
	private ImprovementProposalService improvementProposalService = new ImprovementProposalServiceImpl(); 
	
	@GetMapping("/listbyimprovementplan/{id}")
	public ResponseEntity<Object> listByImprovementPlan(@PathVariable Integer id){
		logger.info("Entered method listByImprovementPlan()");
		return ResponseEntity.status(HttpStatus.OK).body(improvementProposalService.listByImprovementPlan(id));
	}
	
	@GetMapping("/list")
	public ResponseEntity<Object> listImprovementProposal(){
		logger.info("Entered method listImprovementProposal()");
		return ResponseEntity.status(HttpStatus.OK).body(improvementProposalService.listAll());
	}
	
	@PostMapping("/create")
	public ResponseEntity<Object> createImprovementProposal(@RequestBody ImprovementProposal i){
		logger.info("Entered method createImprovementProposal()");
		return ResponseEntity.status(HttpStatus.CREATED).body(improvementProposalService.createImprovementProposal(i));
	}
	
	@PostMapping("/update")
	public ResponseEntity<Object> updateImprovementProposal(@RequestBody ImprovementProposal i){
		logger.info("Entered method updateImprovementProposal()");
		return ResponseEntity.status(HttpStatus.CREATED).body(improvementProposalService.updateImprovementProposal(i));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteImprovementProposal(@PathVariable Integer id){
		logger.info("Entered method deleteImprovementProposal()");
		return ResponseEntity.status(HttpStatus.CREATED).body(improvementProposalService.deleteImprovementProposal(id));
	}
}
