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

import pe.edu.pucp.sia.model.AcreditationModel;
import pe.edu.pucp.sia.service.AcreditationModelService;
import pe.edu.pucp.sia.service.impl.AcreditationModelServiceImpl;

@RestController
@RequestMapping("/acreditationmodel")
public class AcreditationModelController {
    @Autowired
    private AcreditationModelService acreditationModelService = new AcreditationModelServiceImpl();
    
    @GetMapping("/list")
	public ResponseEntity<Object> listAcreditationModel(){
		return ResponseEntity.status(HttpStatus.OK).body(acreditationModelService.listAll());
	}
	
	@PostMapping("/create")
	public ResponseEntity<Object> createAcreditationModel(@RequestBody AcreditationModel a){
		return ResponseEntity.status(HttpStatus.CREATED).body(acreditationModelService.createAcreditationModel(a));
	}
	
	@PostMapping("/update")
	public ResponseEntity<Object> updateAcreditationModel(@RequestBody AcreditationModel a){
		return ResponseEntity.status(HttpStatus.CREATED).body(acreditationModelService.updateAcreditationModel(a));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteAcreditationModel(@PathVariable Integer id){
		return ResponseEntity.status(HttpStatus.CREATED).body(acreditationModelService.deleteAcreditationModel(id));
	}
}
