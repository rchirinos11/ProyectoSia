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

import pe.edu.pucp.sia.model.MeasurementType;
import pe.edu.pucp.sia.service.MeasurementTypeService;
import pe.edu.pucp.sia.service.impl.MeasurementTypeServiceImpl;

@RestController
@RequestMapping("/measurementType")
public class MeasurementTypeController {
	@Autowired
	private MeasurementTypeService measurementTypeService = new MeasurementTypeServiceImpl(); 
	
	@GetMapping("/list")
	public ResponseEntity<Object> listMeasurementType(){
		logger.info("Entered method listMeasurementType()");
		return ResponseEntity.status(HttpStatus.OK).body(measurementTypeService.listAll());
	}
	
	@PostMapping("/create")
	public ResponseEntity<Object> createMeasurementType(@RequestBody MeasurementType m){
		logger.info("Entered method createMeasurementType()");
		return ResponseEntity.status(HttpStatus.CREATED).body(measurementTypeService.createMeasurementType(m));
	}
	
	@PostMapping("/update")
	public ResponseEntity<Object> updateMeasurementType(@RequestBody MeasurementType m){
		logger.info("Entered method updateMeasurementType()");
		return ResponseEntity.status(HttpStatus.CREATED).body(measurementTypeService.updateMeasurementType(m));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteMeasurementType(@PathVariable Integer id){
		logger.info("Entered method deleteMeasurementType()");
		return ResponseEntity.status(HttpStatus.CREATED).body(measurementTypeService.deleteMeasurementType(id));
	}
}