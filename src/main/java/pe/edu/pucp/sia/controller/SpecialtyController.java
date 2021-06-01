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

import pe.edu.pucp.sia.model.Faculty;
import pe.edu.pucp.sia.model.Specialty;
import pe.edu.pucp.sia.requests.SpecialtyUpdateAssistantRequest;
import pe.edu.pucp.sia.requests.SpecialtyUpdateCoordinatorRequest;
import pe.edu.pucp.sia.service.SpecialtyService;
import pe.edu.pucp.sia.service.impl.SpecialtyServiceImpl;

@RestController
@RequestMapping("/specialty")
public class SpecialtyController {

	Logger logger = LoggerFactory.getLogger(SpecialtyController.class);
	
	@Autowired
	private SpecialtyService specialtyService = new SpecialtyServiceImpl();
	
	@GetMapping("/list")
	public ResponseEntity<Object> listSpecialty(){
		logger.info("Entered method listSpecialty()");
		return ResponseEntity.status(HttpStatus.OK).body(specialtyService.listAll());
	}
	
	@GetMapping("/listbyfaculty/{id}")
	public ResponseEntity<Object> listByFaculty(@PathVariable Integer id){
		logger.info("Entered method listByFaculty()");
		return ResponseEntity.status(HttpStatus.OK).body(specialtyService.listByFaculty(id));
	}
	
	@GetMapping("/listbycoordinator/{id}")
	public ResponseEntity<Object> listByCoordinator(@PathVariable Integer id){
		logger.info("Entered method listByCoordinator()");
		return ResponseEntity.status(HttpStatus.OK).body(specialtyService.listByCoordinator(id));
	}
	
	@GetMapping("/listbyassistant/{id}")
	public ResponseEntity<Object> listByAssistant(@PathVariable Integer id){
		logger.info("Entered method listByAssistant()");
		return ResponseEntity.status(HttpStatus.OK).body(specialtyService.listByAssistant(id));
	}
	@PostMapping("/create")
	public ResponseEntity<Object> createSpecialty(@RequestBody Specialty s){
		logger.info("Entered method createSpecialty()");
		return ResponseEntity.status(HttpStatus.CREATED).body(specialtyService.createSpecialty(s));
	}
	
	@PostMapping("/update")
	public ResponseEntity<Object> updateSpecialty(@RequestBody Specialty s){
		logger.info("Entered method updateSpecialty()");
		return ResponseEntity.status(HttpStatus.CREATED).body(specialtyService.updateSpecialty(s));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteSpecialty(@PathVariable Integer id){
		logger.info("Entered method deleteSpecialty()");
		return ResponseEntity.status(HttpStatus.CREATED).body(specialtyService.deleteSpecialty(id));
	}
	
	@PostMapping("setCoordinator")
	public ResponseEntity<Object> updateSpecialtyCoordinator(@RequestBody SpecialtyUpdateCoordinatorRequest s){
		logger.info("Entered method updateSpecialtyCoordinator()");
		return ResponseEntity.status(HttpStatus.CREATED).body(specialtyService.updateCoordinator(s.getIdSpecialty(),s.getIdCoordinator()));
	}
	
	@PostMapping("setAssistant")
	public ResponseEntity<Object> updateSpecialtyAssistant(@RequestBody SpecialtyUpdateAssistantRequest s){
		logger.info("Entered method updateSpecialtyAssistant()");
		return ResponseEntity.status(HttpStatus.CREATED).body(specialtyService.updateAssitant(s.getIdSpecialty(),s.getIdAssistant()));
	}
}
