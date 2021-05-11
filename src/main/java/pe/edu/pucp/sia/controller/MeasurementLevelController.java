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

import pe.edu.pucp.sia.model.MeasurementLevel;
import pe.edu.pucp.sia.service.MeasurementLevelService;
import pe.edu.pucp.sia.service.impl.MeasurementLevelServiceImpl;

@RestController
@RequestMapping("/measurementLevel")
public class CourseController {
	@Autowired
	private MeasurementLevelService measurementLevelService = new MeasurementLevelServiceImpl(); 
	
	@GetMapping("/list")
	public ResponseEntity<Object> listMeasurementLevel(){
		return ResponseEntity.status(HttpStatus.OK).body(measurementLevelService.listAll());
	}
	
	@PostMapping("/create")
	public ResponseEntity<Object> createMeasurementLevel(@RequestBody MeasurementLevel m){
		return ResponseEntity.status(HttpStatus.CREATED).body(measurementLevelService.createMeasurementLevel(m));
	}
	
	@PostMapping("/update")
	public ResponseEntity<Object> updateMeasurementLevel(@RequestBody MeasurementLevel m){
		return ResponseEntity.status(HttpStatus.CREATED).body(measurementLevelService.updateMeasurementLevel(m));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteEvidence(@PathVariable Integer id){
		return ResponseEntity.status(HttpStatus.CREATED).body(measurementLevelService.deleteMeasurementLevel(id));
	}
}