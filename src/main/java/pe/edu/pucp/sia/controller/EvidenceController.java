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
import pe.edu.pucp.sia.service.EvidenceService;
import pe.edu.pucp.sia.service.impl.EvidenceServiceImpl;

@RestController
@RequestMapping("/evidence")
public class CourseController {

	Logger logger = LoggerFactory.getLogger(EducationalObjectiveController.class);
	
	@Autowired
	private EvidenceService evidenceService = new EvidenceServiceImpl(); 
	
	@GetMapping("/list")
	public ResponseEntity<Object> listEvidence(){
		logger.info("Entered method listEvidence()");
		return ResponseEntity.status(HttpStatus.OK).body(evidenceService.listAll());
	}
	
	@PostMapping("/create")
	public ResponseEntity<Object> createEvidence(@RequestBody Evidence e){
		logger.info("Entered method createEvidence()");
		return ResponseEntity.status(HttpStatus.CREATED).body(evidenceService.createEvidence(e));
	}
	
	@PostMapping("/update")
	public ResponseEntity<Object> updateEvidence(@RequestBody Evidence e){
		logger.info("Entered method updateEvidence()");
		return ResponseEntity.status(HttpStatus.CREATED).body(evidenceService.updateEvidence(e));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteEvidence(@PathVariable Integer id){
		logger.info("Entered method deleteEvidence()");
		return ResponseEntity.status(HttpStatus.CREATED).body(evidenceService.deleteEvidence(id));
	}
}