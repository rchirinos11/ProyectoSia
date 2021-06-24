package pe.edu.pucp.sia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.pucp.sia.model.Evidence;
import pe.edu.pucp.sia.response.ApiResponse;
import pe.edu.pucp.sia.service.EvidenceService;
import pe.edu.pucp.sia.service.impl.EvidenceServiceImpl;

@RestController
@RequestMapping("/evidence")
public class EvidenceController {
	@Autowired
	private EvidenceService evidenceService = new EvidenceServiceImpl(); 
	
	@GetMapping("/list")
	public ResponseEntity<ApiResponse> listEvidence(){
		ApiResponse response = evidenceService.listAll();
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/create")
	public ResponseEntity<ApiResponse> createEvidence(@RequestBody Evidence e){
		ApiResponse response = evidenceService.createEvidence(e);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/update")
	public ResponseEntity<ApiResponse> updateEvidence(@RequestBody Evidence e){
		ApiResponse response = evidenceService.updateEvidence(e);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> deleteEvidence(@PathVariable Integer id){
		ApiResponse response = evidenceService.deleteEvidence(id);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
}