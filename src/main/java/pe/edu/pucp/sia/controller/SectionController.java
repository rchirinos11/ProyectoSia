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

import pe.edu.pucp.sia.model.Section;
import pe.edu.pucp.sia.service.SectionService;
import pe.edu.pucp.sia.service.impl.SectionServiceImpl;

@RestController
@RequestMapping("/section")
public class SectionController {
	@Autowired
	private SectionService sectionService = new SectionServiceImpl(); 
	
	@GetMapping("/list")
	public ResponseEntity<Object> listSection(){
		logger.info("Entered method listSection()");
		return ResponseEntity.status(HttpStatus.OK).body(sectionService.listAll());
	}
	
	@PostMapping("/create")
	public ResponseEntity<Object> createSection(@RequestBody Section s){
		logger.info("Entered method createSection()");
		return ResponseEntity.status(HttpStatus.CREATED).body(sectionService.createSection(s));
	}
	
	@PostMapping("/update")
	public ResponseEntity<Object> updateSection(@RequestBody Section s){
		logger.info("Entered method updateSection()");
		return ResponseEntity.status(HttpStatus.CREATED).body(sectionService.updateSection(s));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteSection(@PathVariable Integer id){
		return ResponseEntity.status(HttpStatus.CREATED).body(sectionService.deleteSection(id));
	}
	
	@GetMapping("/listbymeasurementplanline/{id}")
	public ResponseEntity<Object> listByMeasurementPlanLine(@PathVariable Integer id){
		return ResponseEntity.status(HttpStatus.OK).body(sectionService.listByMeasurementPlanLine(id));
	}
	
}