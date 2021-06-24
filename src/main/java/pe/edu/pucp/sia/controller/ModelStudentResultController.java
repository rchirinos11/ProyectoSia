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

import pe.edu.pucp.sia.model.ModelStudentResult;
import pe.edu.pucp.sia.response.ApiResponse;
import pe.edu.pucp.sia.service.ModelStudentResultService;
import pe.edu.pucp.sia.service.impl.ModelStudentResultServiceImpl;

@RestController
@RequestMapping("/modelstudentresult")
public class ModelStudentResultController {

	Logger logger = LoggerFactory.getLogger(ModelStudentResultController.class);

    @Autowired
    private ModelStudentResultService modelStudentResultService = new ModelStudentResultServiceImpl();
    
    @GetMapping("/list")
	public ResponseEntity<ApiResponse> listModelStudentResult(){
		logger.info("Entered method listModelStudentResult()");
		ApiResponse response = modelStudentResultService.listAll();
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/create")
	public ResponseEntity<ApiResponse> createModelStudentResult(@RequestBody ModelStudentResult m){
		logger.info("Entered method createModelStudentResult()");
		ApiResponse response = modelStudentResultService.createModelStudentResult(m);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/update")
	public ResponseEntity<ApiResponse> updateModelStudentResult(@RequestBody ModelStudentResult m){
		logger.info("Entered method updateModelStudentResult()");
		ApiResponse response = modelStudentResultService.updateModelStudentResult(m);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> deleteModelStudentResult(@PathVariable Integer id){
		logger.info("Entered method deleteModelStudentResult()");
		ApiResponse response = modelStudentResultService.deleteModelStudentResult(id);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
}
