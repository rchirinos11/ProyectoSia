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

import pe.edu.pucp.sia.model.State;
import pe.edu.pucp.sia.response.ApiResponse;
import pe.edu.pucp.sia.service.StateService;
import pe.edu.pucp.sia.service.impl.StateServiceImpl;

@RestController
@RequestMapping("/state")
public class StateController {

	Logger logger = LoggerFactory.getLogger(StateController.class);
	
	@Autowired
	private StateService stateService = new StateServiceImpl(); 
	
	@GetMapping("/list")
	public ResponseEntity<ApiResponse> listState(){
		logger.info("Entered method listState()");
		ApiResponse response = stateService.listAll();
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/create")
	public ResponseEntity<ApiResponse> createState(@RequestBody State s){
		logger.info("Entered method createState()");
		ApiResponse response = stateService.createState(s);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/update")
	public ResponseEntity<ApiResponse> updateState(@RequestBody State s){
		logger.info("Entered method updateState()");
		ApiResponse response = stateService.updateState(s);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> deleteState(@PathVariable Integer id){
		logger.info("Entered method deleteState()");
		ApiResponse response = stateService.deleteState(id);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
}