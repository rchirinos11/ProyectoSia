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

import pe.edu.pucp.sia.model.Program;
import pe.edu.pucp.sia.response.ApiResponse;
import pe.edu.pucp.sia.service.ProgramService;
import pe.edu.pucp.sia.service.impl.ProgramServiceImpl;

@RestController
@RequestMapping("/program")
public class ProgramController {

	Logger logger = LoggerFactory.getLogger(ProgramController.class);
	
    @Autowired
    private ProgramService programService = new ProgramServiceImpl();
    
    @GetMapping("/list")
	public ResponseEntity<ApiResponse> listProgram(){
		logger.info("Entered method listProgram()");
		ApiResponse response = programService.listAll();
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/create")
	public ResponseEntity<ApiResponse> createProgram(@RequestBody Program p){
		logger.info("Entered method createProgram()");
		ApiResponse response = programService.createProgram(p);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/update")
	public ResponseEntity<ApiResponse> updateProgram(@RequestBody Program p){
		logger.info("Entered method updateProgram()");
		ApiResponse response = programService.updateProgram(p);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> deleteProgram(@PathVariable Integer id){
		logger.info("Entered method deleteProgram()");
		ApiResponse response = programService.deleteProgram(id);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
}
