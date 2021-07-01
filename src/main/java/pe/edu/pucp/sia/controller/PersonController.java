package pe.edu.pucp.sia.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.pucp.sia.model.Person;
import pe.edu.pucp.sia.requests.MultiplePersonRequest;
import pe.edu.pucp.sia.requests.UnfinishedTeachersRequest;
import pe.edu.pucp.sia.response.ApiResponse;
import pe.edu.pucp.sia.service.PersonService;
import pe.edu.pucp.sia.service.impl.PersonServiceImpl;

@RequestMapping("/person")
@RestController
public class PersonController {
	
	Logger logger = LoggerFactory.getLogger(PersonController.class);
	
	@Autowired
	private PersonService personService = new PersonServiceImpl();
	
	@GetMapping("/list")
	public ResponseEntity<ApiResponse> listPerson(){
		logger.info("Entered method listPerson()");
		ApiResponse response = personService.listAll();
		return ResponseEntity.status(response.getStatus()).body(response);
	}

	@GetMapping("/listRolesByPerson/{id}")
	public ResponseEntity<ApiResponse> listRolesByPerson(@PathVariable Integer id){
		logger.info("Entered method listRolesByPerson()");
		ApiResponse response = personService.listRoleByPerson(id);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@GetMapping("/listWorkers")
	public ResponseEntity<ApiResponse> listWorkers(){
		logger.info("Entered method listWorkers()");
		ApiResponse response = personService.listWorkers();
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/create")
	public ResponseEntity<ApiResponse> createPerson(@RequestBody Person p){
		logger.info("Entered method createPerson()");
		ApiResponse response = personService.createPerson(p);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/createmultiple")
	public ResponseEntity<ApiResponse> createMultiplePerson(@RequestBody MultiplePersonRequest m){
		logger.info("Entered method createMultiplePerson()");
		ApiResponse response = personService.createMultiplePerson(m);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/update")
	public ResponseEntity<ApiResponse> updatePerson(@RequestBody Person p){
		logger.info("Entered method updatePerson()");
		ApiResponse response = personService.updatePerson(p);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> deletePerson(@PathVariable Integer id){
		logger.info("Entered method deletePerson()");
		ApiResponse response = personService.deletePerson(id);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@GetMapping("/login/{email}")
	public ResponseEntity<ApiResponse> loginPerson(@PathVariable String email){
		logger.info("Entered method loginPerson()");
		ApiResponse response = personService.loginPerson(email);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
		
	@PostMapping("/getPersonData")
	public ResponseEntity<ApiResponse> getPersonData(@RequestBody Person p){
		logger.info("Entered method getPersonData()");
		ApiResponse response = personService.listFacultiesSpecialties(p.getEmail());
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/listunfinishedteachers")
	public ResponseEntity<ApiResponse> listunfinishedteachers(@RequestBody UnfinishedTeachersRequest u){
		logger.info("Entered method listUnfinishedTeachers()");
		ApiResponse response = personService.listUnfinishedTeachers(u);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/listassignedteachers")
	public ResponseEntity<ApiResponse> listassignedteachers(@RequestBody UnfinishedTeachersRequest u){
		logger.info("Entered method listAssignedTeachers()");
		ApiResponse response = personService.listAssignedTeachers(u);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
}
