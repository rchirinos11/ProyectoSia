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
import pe.edu.pucp.sia.model.Speciality;
import pe.edu.pucp.sia.service.SpecialityService;
import pe.edu.pucp.sia.service.impl.SpecialityServiceImp;

@RestController
@RequestMapping("/speciality")
public class SpecialityController {

	Logger logger = LoggerFactory.getLogger(SpecialityController.class);
	
	@Autowired
	private SpecialityService specialityService = new SpecialityServiceImp();
	
	@GetMapping("/list")
	public ResponseEntity<Object> listSpeciality(){
		logger.info("Entered method listSpeciality()");
		return ResponseEntity.status(HttpStatus.OK).body(specialityService.listAll());
	}
	
	@GetMapping("/listbyfaculty/{id}")
	public ResponseEntity<Object> listByFaculty(@PathVariable Integer id){
		logger.info("Entered method listByFaculty()");
		return ResponseEntity.status(HttpStatus.OK).body(specialityService.listByFaculty(id));
	}
	
	@PostMapping("/create")
	public ResponseEntity<Object> createSpeciality(@RequestBody Speciality s){
		logger.info("Entered method createSpeciality()");
		return ResponseEntity.status(HttpStatus.CREATED).body(specialityService.createSpeciality(s));
	}
	
	@PostMapping("/update")
	public ResponseEntity<Object> updateSpeciality(@RequestBody Speciality s){
		logger.info("Entered method updateSpeciality()");
		return ResponseEntity.status(HttpStatus.CREATED).body(specialityService.updateSpeciality(s));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteSpeciality(@PathVariable Integer id){
		logger.info("Entered method deleteSpeciality()");
		return ResponseEntity.status(HttpStatus.CREATED).body(specialityService.deleteSpeciality(id));
	}
}
