package pe.edu.pucp.sia.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.pucp.sia.model.Person_X_Measurement_Plan_Line;
import pe.edu.pucp.sia.service.Person_X_Measurement_Plan_Line_Service;
import pe.edu.pucp.sia.service.impl.Person_X_Measurement_Plan_Line_ServiceImpl;


@RequestMapping("/person_x_measurement_plan_line")
@RestController
public class Person_X_Measurement_Plan_Line_Controller {
	Logger logger = LoggerFactory.getLogger(Person_X_Measurement_Plan_Line_Controller.class);
	
	@Autowired
	Person_X_Measurement_Plan_Line_Service person_X_Measurement_Plan_Line_Service= new Person_X_Measurement_Plan_Line_ServiceImpl();
	
	@GetMapping("/list")
	public ResponseEntity<Object> listAll(){
		logger.info("Entered method list()");
		return ResponseEntity.status(HttpStatus.OK).body(person_X_Measurement_Plan_Line_Service.listAll());
	}
	
	@PostMapping("/create")
	public ResponseEntity<Object> createPxM(@RequestBody Person_X_Measurement_Plan_Line l){
		logger.info("Entered method createPxM()");
		return ResponseEntity.status(HttpStatus.CREATED).body(person_X_Measurement_Plan_Line_Service.createPxM(l));
	}
	
	@PostMapping("/update")
	public ResponseEntity<Object> updatePxM(@RequestBody Person_X_Measurement_Plan_Line l){
		logger.info("Entered method updatePxM()");
		return ResponseEntity.status(HttpStatus.CREATED).body(person_X_Measurement_Plan_Line_Service.updatePxM(l));
	}
	
	@PostMapping("/delete/{id}")
	public ResponseEntity<Object> deletePxM(@PathVariable Integer id){
		logger.info("Entered method deletePxM()");
		return ResponseEntity.status(HttpStatus.CREATED).body(person_X_Measurement_Plan_Line_Service.deletePxM(id));
	}
	
	
}
