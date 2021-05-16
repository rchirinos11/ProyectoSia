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

import pe.edu.pucp.sia.model.Person;
import pe.edu.pucp.sia.service.PersonService;
import pe.edu.pucp.sia.service.impl.PersonServiceImpl;

@RequestMapping("/person")
@RestController
public class PersonController {
	
	Logger logger = LoggerFactory.getLogger(PersonController.class);
	
	@Autowired
	private PersonService personService = new PersonServiceImpl();
	
	@GetMapping("/list")
	public ResponseEntity<Object> listPerson(){
		logger.info("Entered method listPerson()");
		return ResponseEntity.status(HttpStatus.OK).body(personService.listAll());
	}
	
	@PostMapping("/create")
	public ResponseEntity<Object> createPerson(@RequestBody Person p){
		logger.info("Entered method createPerson()");
		return ResponseEntity.status(HttpStatus.CREATED).body(personService.createPerson(p));
	}
	
	@PostMapping("/update")
	public ResponseEntity<Object> updatePerson(@RequestBody Person p){
		logger.info("Entered method updatePerson()");
		return ResponseEntity.status(HttpStatus.OK).body(personService.updatePerson(p));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deletePerson(@PathVariable Integer id){
		logger.info("Entered method deletePerson()");
		return ResponseEntity.status(HttpStatus.OK).body(personService.deletePerson(id));
	}
	
	@GetMapping("/login/{email}")
	public ResponseEntity<Object> loginPerson(@PathVariable String email){
		logger.info("Entered method loginPerson()");
		return ResponseEntity.status(HttpStatus.OK).body(personService.loginPerson(email));
	}
}
