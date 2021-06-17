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

import pe.edu.pucp.sia.model.Section;
import pe.edu.pucp.sia.response.ApiResponse;
import pe.edu.pucp.sia.service.SectionService;
import pe.edu.pucp.sia.service.impl.SectionServiceImpl;

@RestController
@RequestMapping("/section")
public class SectionController {
	@Autowired
	private SectionService sectionService = new SectionServiceImpl(); 
	
	@GetMapping("/list")
	public ResponseEntity<ApiResponse> listSection(){
		ApiResponse response = sectionService.listAll();
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/create")
	public ResponseEntity<ApiResponse> createSection(@RequestBody Section s){
		ApiResponse response = sectionService.createSection(s);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/update")
	public ResponseEntity<ApiResponse> updateSection(@RequestBody Section s){
		ApiResponse response = sectionService.updateSection(s);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> deleteSection(@PathVariable Integer id){
		ApiResponse response = sectionService.deleteSection(id);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@GetMapping("/listbymeasurementplanline/{id}")
	public ResponseEntity<ApiResponse> listByMeasurementPlanLine(@PathVariable Integer id){
		ApiResponse response = sectionService.listByMeasurementPlanLine(id);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
}