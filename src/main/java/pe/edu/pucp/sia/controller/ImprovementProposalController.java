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
import pe.edu.pucp.sia.response.ApiResponse;
import pe.edu.pucp.sia.service.ImprovementProposalService;
import pe.edu.pucp.sia.service.impl.ImprovementProposalServiceImpl;

@RestController
@RequestMapping("/improvementproposal")
public class ImprovementProposalController {

	Logger logger = LoggerFactory.getLogger(ImprovementProposalController.class);
	
	@Autowired
	private ImprovementProposalService improvementProposalService = new ImprovementProposalServiceImpl(); 
	
	@GetMapping("/listbyimprovementplan/{id}")
	public ResponseEntity<ApiResponse> listByImprovementPlan(@PathVariable Integer id){
		logger.info("Entered method listByImprovementPlan()");
		ApiResponse response = improvementProposalService.listByImprovementPlan(id);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@GetMapping("/list")
	public ResponseEntity<ApiResponse> listImprovementProposal(){
		logger.info("Entered method listImprovementProposal()");
		ApiResponse response = improvementProposalService.listAll();
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/create")
	public ResponseEntity<ApiResponse> createImprovementProposal(@RequestBody ImprovementProposal i){
		logger.info("Entered method createImprovementProposal()");
		ApiResponse response = improvementProposalService.createImprovementProposal(i);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/update")
	public ResponseEntity<ApiResponse> updateImprovementProposal(@RequestBody ImprovementProposal i){
		logger.info("Entered method updateImprovementProposal()");
		ApiResponse response = improvementProposalService.updateImprovementProposal(i);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> deleteImprovementProposal(@PathVariable Integer id){
		logger.info("Entered method deleteImprovementProposal()");
		ApiResponse response = improvementProposalService.deleteImprovementProposal(id);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
}
