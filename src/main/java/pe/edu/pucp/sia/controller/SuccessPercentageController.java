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

import pe.edu.pucp.sia.model.SuccessPercentage;
import pe.edu.pucp.sia.requests.MPlanLineSpecialtySemesterRequest;
import pe.edu.pucp.sia.response.ApiResponse;
import pe.edu.pucp.sia.service.SuccessPercentageService;
import pe.edu.pucp.sia.service.impl.SuccessPercentageServicImpl;

@RestController
@RequestMapping("/successpercentage")
public class SuccessPercentageController {
	Logger logger = LoggerFactory.getLogger(SuccessPercentageController.class);
	
	@Autowired
	private SuccessPercentageService successPercentageService = new SuccessPercentageServicImpl(); 
	@GetMapping("/list")
	public ResponseEntity<ApiResponse> listSuccessPercentage(){
		logger.info("Entered method listSuccessPercentage()");
		ApiResponse response = successPercentageService.listAll();
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/listbyspecialtysemester")
	public ResponseEntity<ApiResponse> listBySpecialtySemester(@RequestBody MPlanLineSpecialtySemesterRequest lss){
		logger.info("Entered method listBySpecialtySemester()");
		ApiResponse response = successPercentageService.listBySpecialtySemester(lss.getIdSpecialty(),lss.getIdSemester());
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/create")
	public ResponseEntity<ApiResponse> createSuccessPercentage(@RequestBody SuccessPercentage sp){
		logger.info("Entered method createSuccessPercentage()");
		ApiResponse response = successPercentageService.createSuccessPercentage(sp);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/update")
	public ResponseEntity<ApiResponse> updateSuccessPercentage(@RequestBody SuccessPercentage sp){
		logger.info("Entered method updateSuccessPercentage()");
		ApiResponse response = successPercentageService.updateSuccessPercentage(sp);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> deleteSuccessPercentage(@PathVariable Integer id){
		logger.info("Entered method deleteSuccessPercentage()");
		ApiResponse response = successPercentageService.deleteSuccessPercentage(id);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	
}
