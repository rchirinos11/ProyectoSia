package pe.edu.pucp.sia.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.pucp.sia.model.ResultsPerCard;
import pe.edu.pucp.sia.requests.CreateImprovementPlanRequest;
import pe.edu.pucp.sia.response.ApiResponse;
import pe.edu.pucp.sia.service.ResultsPerCardService;
import pe.edu.pucp.sia.service.impl.ResultsPerCardServiceImpl;

@RequestMapping("/resultspercard")
@RestController
public class ResultsPerCardController {
	Logger logger = LoggerFactory.getLogger(ResultsPerCardController.class);
	
	@Autowired
	ResultsPerCardService resultsPerCardService= new ResultsPerCardServiceImpl();
	
	@GetMapping("/list")
	public ResponseEntity<ApiResponse> listAll(){
		logger.info("Entered method listResultsPerCard()");
		ApiResponse response = resultsPerCardService.listAll();
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@GetMapping("/listbymeasurementplanline/{id}")
	public ResponseEntity<ApiResponse> listByFaculty(@PathVariable Integer id){
		logger.info("Entered method listByMeasurementPlanLine()");
		ApiResponse response = resultsPerCardService.listByMeasurementPlanLine(id);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/create")
	public ResponseEntity<ApiResponse> createResultsPerCard(@RequestBody ResultsPerCard r){
		logger.info("Entered method createResultsPerCard()");
		ApiResponse response = resultsPerCardService.createResultsPerCard(r);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/update")
	public ResponseEntity<ApiResponse> updateResultsPerCard(@RequestBody ResultsPerCard r){
		logger.info("Entered method updateResultsPerCard()");
		ApiResponse response = resultsPerCardService.updateResultsPerCard(r);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> deleteResultsPerCard(@PathVariable Integer id){
		logger.info("Entered method deleteResultsPerCard()");
		ApiResponse response = resultsPerCardService.deleteResultsPerCard(id);
		return ResponseEntity.status(response.getStatus()).body(response);
	}

	@PostMapping("/registerstudentmeditions")
	public ResponseEntity<ApiResponse> registerStudentMeditions(@RequestBody ResultsPerCard r){
		logger.info("Entered method registerStudentMeditions()");
		ApiResponse response = resultsPerCardService.registerStudentMeditions(r);
		return ResponseEntity.status(response.getStatus()).body(response);
	}

	@GetMapping("/prompercentagebystudentresult/{id}")
	public ResponseEntity<ApiResponse> promPercentageByStudentResult(@PathVariable Integer id){
		logger.info("Entered method promPercentageByStudentResult()");
		ApiResponse response = resultsPerCardService.promPercentageByStudentResult(id);
		return ResponseEntity.status(response.getStatus()).body(response);
	}

}
