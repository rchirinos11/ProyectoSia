package pe.edu.pucp.sia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.pucp.sia.model.MeasurementType;
import pe.edu.pucp.sia.response.ApiResponse;
import pe.edu.pucp.sia.service.MeasurementTypeService;
import pe.edu.pucp.sia.service.impl.MeasurementTypeServiceImpl;

@RestController
@RequestMapping("/measurementType")
public class MeasurementTypeController {
	@Autowired
	private MeasurementTypeService measurementTypeService = new MeasurementTypeServiceImpl(); 
	
	@GetMapping("/list")
	public ResponseEntity<ApiResponse> listMeasurementType(){
		ApiResponse response = measurementTypeService.listAll();
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/create")
	public ResponseEntity<ApiResponse> createMeasurementType(@RequestBody MeasurementType m){
		ApiResponse response = measurementTypeService.createMeasurementType(m);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/update")
	public ResponseEntity<ApiResponse> updateMeasurementType(@RequestBody MeasurementType m){
		ApiResponse response = measurementTypeService.updateMeasurementType(m);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> deleteMeasurementType(@PathVariable Integer id){
		ApiResponse response = measurementTypeService.deleteMeasurementType(id);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
}