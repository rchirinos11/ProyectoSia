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

import pe.edu.pucp.sia.model.Measurement;
import pe.edu.pucp.sia.requests.DeleteMultipleMeasurementRequest;
import pe.edu.pucp.sia.requests.MultipleMeasurementRequest;
import pe.edu.pucp.sia.response.ApiResponse;
import pe.edu.pucp.sia.service.MeasurementService;
import pe.edu.pucp.sia.service.impl.MeasurementServiceImpl;

@RequestMapping("/measurement")
@RestController
public class MeasurementController {
	Logger logger = LoggerFactory.getLogger(MeasurementController.class);
	
	@Autowired
	MeasurementService measurementService= new MeasurementServiceImpl();
	
	@GetMapping("/list")
	public ResponseEntity<ApiResponse> listAll(){
		logger.info("Entered method listMeasurement()");
		ApiResponse response = measurementService.listAll();
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/create")
	public ResponseEntity<ApiResponse> createMeasurement(@RequestBody Measurement m){
		logger.info("Entered method createMeasurement()");
		ApiResponse response = measurementService.createMeasurement(m);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/createmultiple")
	public ResponseEntity<ApiResponse> createMultipleMeasurement(@RequestBody MultipleMeasurementRequest m){
		logger.info("Entered method createMultipleMeasurement()");
		ApiResponse response = measurementService.createMultipleMeasurement(m);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/update")
	public ResponseEntity<ApiResponse> updateMeasurement(@RequestBody Measurement m){
		logger.info("Entered method updateMeasurement()");
		ApiResponse response = measurementService.updateMeasurement(m);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> deleteMeasurement(@PathVariable Integer id){
		logger.info("Entered method deleteMeasurement()");
		ApiResponse response = measurementService.deleteMeasurement(id);
		return ResponseEntity.status(response.getStatus()).body(response);
	}

	@DeleteMapping("deleteByResultsPerCard/{id}")
	public ResponseEntity<ApiResponse> deleteByResultsPerCard(@PathVariable Integer id){
		logger.info("Entered method deleteByResultsPerCard()");
		ApiResponse response = measurementService.deleteByResultsPerCard(id);
		return ResponseEntity.status(response.getStatus()).body(response);
	}

	@DeleteMapping("deleteByAlumnosAndResultsPerCard/{id}")
	public ResponseEntity<ApiResponse> deleteByAlumnosAndResultsPerCard(@PathVariable Integer id){
		logger.info("Entered method deleteByAlumnosAndResultsPerCard()");
		ApiResponse response = measurementService.deleteByAlumnosAndResultsPerCard(id);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("deletemultiple")
	public ResponseEntity<ApiResponse> deleteMultipleMeasurement(@RequestBody DeleteMultipleMeasurementRequest m){
		logger.info("Entered method deleteMultipleMeasurement()");
		ApiResponse response = measurementService.deleteMultipleMeasurement(m);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
}
