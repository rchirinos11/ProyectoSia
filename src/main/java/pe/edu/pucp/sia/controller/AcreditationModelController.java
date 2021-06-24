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

import pe.edu.pucp.sia.model.AcreditationModel;
import pe.edu.pucp.sia.response.ApiResponse;
import pe.edu.pucp.sia.service.AcreditationModelService;
import pe.edu.pucp.sia.service.impl.AcreditationModelServiceImpl;

@RestController
@RequestMapping("/acreditationmodel")
public class AcreditationModelController {

	Logger logger = LoggerFactory.getLogger(AcreditationModelController.class);

    @Autowired
    private AcreditationModelService acreditationModelService = new AcreditationModelServiceImpl();
    
    @GetMapping("/list")
	public ResponseEntity<ApiResponse> listAcreditationModel(){
		logger.info("Entered method listAcreditationModel()");
		ApiResponse response = acreditationModelService.listAll();
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/create")
	public ResponseEntity<ApiResponse> createAcreditationModel(@RequestBody AcreditationModel a){
		logger.info("Entered method createAcreditationModel()");
		ApiResponse response = acreditationModelService.createAcreditationModel(a);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/update")
	public ResponseEntity<ApiResponse> updateAcreditationModel(@RequestBody AcreditationModel a){
		logger.info("Entered method updateAcreditationModel()");
		ApiResponse response = acreditationModelService.updateAcreditationModel(a);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> deleteAcreditationModel(@PathVariable Integer id){
		logger.info("Entered method deleteAcreditationModel()");
		ApiResponse response = acreditationModelService.deleteAcreditationModel(id);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
}
