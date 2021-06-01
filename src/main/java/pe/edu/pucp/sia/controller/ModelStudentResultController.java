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

import pe.edu.pucp.sia.model.ModelStudentResult;
import pe.edu.pucp.sia.service.ModelStudentResultService;
import pe.edu.pucp.sia.service.impl.ModelStudentResultServiceImpl;

@RestController
@RequestMapping("/modelstudentresult")
public class ModelStudentResultController {

	Logger logger = LoggerFactory.getLogger(ModelStudentResultController.class);

    @Autowired
    private ModelStudentResultService modelStudentResultService = new ModelStudentResultServiceImpl();
    
    @GetMapping("/list")
	public ResponseEntity<Object> listModelStudentResult(){
		logger.info("Entered method listModelStudentResult()");
		return ResponseEntity.status(HttpStatus.OK).body(modelStudentResultService.listAll());
	}
	
	@PostMapping("/create")
	public ResponseEntity<Object> createModelStudentResult(@RequestBody ModelStudentResult m){
		logger.info("Entered method createModelStudentResult()");
		return ResponseEntity.status(HttpStatus.CREATED).body(modelStudentResultService.createModelStudentResult(m));
	}
	
	@PostMapping("/update")
	public ResponseEntity<Object> updateModelStudentResult(@RequestBody ModelStudentResult m){
		logger.info("Entered method updateModelStudentResult()");
		return ResponseEntity.status(HttpStatus.CREATED).body(modelStudentResultService.updateModelStudentResult(m));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteModelStudentResult(@PathVariable Integer id){
		logger.info("Entered method deleteModelStudentResult()");
		return ResponseEntity.status(HttpStatus.CREATED).body(modelStudentResultService.deleteModelStudentResult(id));
	}
}
