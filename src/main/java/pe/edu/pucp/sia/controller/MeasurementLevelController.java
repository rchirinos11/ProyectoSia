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

import pe.edu.pucp.sia.model.MeasurementLevel;
import pe.edu.pucp.sia.service.MeasurementLevelService;
import pe.edu.pucp.sia.service.impl.MeasurementLevelServiceImpl;

@RequestMapping("/measurementlevel")
@RestController
public class MeasurementLevelController {
	Logger logger = LoggerFactory.getLogger(MeasurementLevelController.class);
	
	@Autowired
	MeasurementLevelService measurementLevelService= new MeasurementLevelServiceImpl();
	
	@GetMapping("/list")
	public ResponseEntity<Object> listAll(){
		logger.info("Entered method listMeasurementLevel()");
		return ResponseEntity.status(HttpStatus.OK).body(measurementLevelService.listAll());
	}
	
	@GetMapping("/listbyspecialty/{id}")
	public ResponseEntity<Object> listByFaculty(@PathVariable Integer id){
		logger.info("Entered method listBySpecialty()");
		return ResponseEntity.status(HttpStatus.OK).body(measurementLevelService.listBySpecialty(id));
	}
	
	
	@PostMapping("/create")
	public ResponseEntity<Object> createMeasurementLevel(@RequestBody MeasurementLevel ml){
		logger.info("Entered method createMeasurementLevel()");
		return ResponseEntity.status(HttpStatus.CREATED).body(measurementLevelService.createMeasurementLevel(ml));
	}
	
	@PostMapping("/update")
	public ResponseEntity<Object> updateMeasurementLevel(@RequestBody MeasurementLevel ml){
		logger.info("Entered method updateMeasurementLevel()");
		return ResponseEntity.status(HttpStatus.CREATED).body(measurementLevelService.updateMeasurementLevel(ml));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteMeasurementLevel(@PathVariable Integer id){
		logger.info("Entered method deleteMeasurementLevel()");
		return ResponseEntity.status(HttpStatus.CREATED).body(measurementLevelService.deleteMeasurementLevel(id));
	}
}
