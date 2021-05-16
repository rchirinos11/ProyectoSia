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

import pe.edu.pucp.sia.model.State;
import pe.edu.pucp.sia.service.StateService;
import pe.edu.pucp.sia.service.impl.StateServiceImpl;

@RestController
@RequestMapping("/state")
public class StateController {

	Logger logger = LoggerFactory.getLogger(StateController.class);
	
	@Autowired
	private StateService stateService = new StateServiceImpl(); 
	
	@GetMapping("/list")
	public ResponseEntity<Object> listState(){
		logger.info("Entered method listState()");
		return ResponseEntity.status(HttpStatus.OK).body(stateService.listAll());
	}
	
	@PostMapping("/create")
	public ResponseEntity<Object> createState(@RequestBody State s){
		logger.info("Entered method createState()");
		return ResponseEntity.status(HttpStatus.CREATED).body(stateService.createState(s));
	}
	
	@PostMapping("/update")
	public ResponseEntity<Object> updateState(@RequestBody State s){
		logger.info("Entered method updateState()");
		return ResponseEntity.status(HttpStatus.CREATED).body(stateService.updateState(s));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteState(@PathVariable Integer id){
		logger.info("Entered method deleteState()");
		return ResponseEntity.status(HttpStatus.CREATED).body(stateService.deleteState(id));
	}
}