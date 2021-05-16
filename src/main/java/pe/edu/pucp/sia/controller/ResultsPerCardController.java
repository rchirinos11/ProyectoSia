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

import pe.edu.pucp.sia.model.ResultsPerCard;
import pe.edu.pucp.sia.service.ResultsPerCardService;
import pe.edu.pucp.sia.service.impl.ResultsPerCardServiceImpl;

@RequestMapping("/resultspercard")
@RestController
public class ResultsPerCardController {
	Logger logger = LoggerFactory.getLogger(ResultsPerCardController.class);
	
	@Autowired
	ResultsPerCardService resultsPerCardService= new ResultsPerCardServiceImpl();
	
	@GetMapping("/list")
	public ResponseEntity<Object> listAll(){
		logger.info("Entered method listResultsPerCard()");
		return ResponseEntity.status(HttpStatus.OK).body(resultsPerCardService.listAll());
	}
	
	@PostMapping("/create")
	public ResponseEntity<Object> createResultsPerCard(@RequestBody ResultsPerCard r){
		logger.info("Entered method createResultsPerCard()");
		return ResponseEntity.status(HttpStatus.CREATED).body(resultsPerCardService.createResultsPerCard(r));
	}
	
	@PostMapping("/update")
	public ResponseEntity<Object> updateResultsPerCard(@RequestBody ResultsPerCard r){
		logger.info("Entered method updateResultsPerCard()");
		return ResponseEntity.status(HttpStatus.CREATED).body(resultsPerCardService.updateResultsPerCard(r));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteResultsPerCard(@PathVariable Integer id){
		logger.info("Entered method deleteResultsPerCard()");
		return ResponseEntity.status(HttpStatus.CREATED).body(resultsPerCardService.deleteResultsPerCard(id));
	}

}
