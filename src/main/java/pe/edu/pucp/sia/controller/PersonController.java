package pe.edu.pucp.sia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	private PersonService personService = new PersonServiceImpl();
	
	@GetMapping("/list")
	public ResponseEntity<Object> listPerson(){
		return ResponseEntity.status(HttpStatus.OK).body(personService.listAll());
	}
	
	@PostMapping("/create")
	public ResponseEntity<Object> createPerson(@RequestBody Person p){
		return ResponseEntity.status(HttpStatus.OK).body(personService.createPerson(p));
	}
}
