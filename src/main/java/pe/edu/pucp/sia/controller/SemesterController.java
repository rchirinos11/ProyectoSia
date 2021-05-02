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

import pe.edu.pucp.sia.model.Semester;
import pe.edu.pucp.sia.service.SemesterService;
import pe.edu.pucp.sia.service.impl.SemesterServiceImpl;

@RestController
@RequestMapping("/semester")
public class SemesterController {
	@Autowired
	private SemesterService semesterService = new SemesterServiceImpl(); 
	
	@GetMapping("/list")
	public ResponseEntity<Object> listPerson(){
		return ResponseEntity.status(HttpStatus.OK).body(semesterService.listAll());
	}
	
	@PostMapping("/create")
	public ResponseEntity<Object> createPerson(@RequestBody Semester s){
		return ResponseEntity.status(HttpStatus.CREATED).body(semesterService.createSemester(s));
	}
	
	@PostMapping("/update")
	public ResponseEntity<Object> updatePerson(@RequestBody Semester s){
		return ResponseEntity.status(HttpStatus.CREATED).body(semesterService.updateSemester(s));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deletePerson(@PathVariable Integer id){
		return ResponseEntity.status(HttpStatus.CREATED).body(semesterService.deleteSemester(id));
	}
}
