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

import pe.edu.pucp.sia.model.Measurement;
import pe.edu.pucp.sia.service.MeasurementService;
import pe.edu.pucp.sia.service.impl.MeasurementServiceImpl;

@RequestMapping("/measurement")
@RestController
public class MeasurementController {
	Logger logger = LoggerFactory.getLogger(MeasurementController.class);
	
	@Autowired
	MeasurementService measurementService= new MeasurementServiceImpl();
	
	@GetMapping("/list")
	public ResponseEntity<Object> listAll(){
		logger.info("Entered method listMeasurement()");
		return ResponseEntity.status(HttpStatus.OK).body(measurementService.listAll());
	}
	
	@PostMapping("/create")
	public ResponseEntity<Object> createMeasurement(@RequestBody Measurement m){
		logger.info("Entered method createMeasurement()");
		return ResponseEntity.status(HttpStatus.CREATED).body(measurementService.createMeasurement(m));
	}
	
	@PostMapping("/update")
	public ResponseEntity<Object> updateMeasurement(@RequestBody Measurement m){
		logger.info("Entered method updateMeasurement()");
		return ResponseEntity.status(HttpStatus.CREATED).body(measurementService.updateMeasurement(m));
	}
	
	@PostMapping("/delete/{id}")
	public ResponseEntity<Object> deleteMeasurement(@PathVariable Integer id){
		logger.info("Entered method deleteMeasurement()");
		return ResponseEntity.status(HttpStatus.CREATED).body(measurementService.deleteMeasurement(id));
	}

}
