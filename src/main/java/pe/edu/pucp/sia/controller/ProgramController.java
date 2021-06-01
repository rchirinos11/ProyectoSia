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
import org.springframework.web.bind.annotation.RestController;

import pe.edu.pucp.sia.model.Program;
import pe.edu.pucp.sia.service.ProgramService;
import pe.edu.pucp.sia.service.impl.ProgramServiceImpl;

@RestController
@RequestMapping("/program")
public class ProgramController {
    @Autowired
    private ProgramService programService = new ProgramServiceImpl();
    
    @GetMapping("/list")
	public ResponseEntity<Object> listProgram(){
		return ResponseEntity.status(HttpStatus.OK).body(programService.listAll());
	}
	
	@PostMapping("/create")
	public ResponseEntity<Object> createProgram(@RequestBody Program p){
		return ResponseEntity.status(HttpStatus.CREATED).body(programService.createProgram(p));
	}
	
	@PostMapping("/update")
	public ResponseEntity<Object> updateProgram(@RequestBody Program p){
		return ResponseEntity.status(HttpStatus.CREATED).body(programService.updateProgram(p));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteProgram(@PathVariable Integer id){
		return ResponseEntity.status(HttpStatus.CREATED).body(programService.deleteProgram(id));
	}
}
