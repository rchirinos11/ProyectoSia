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

import pe.edu.pucp.sia.model.Section_X_Measurement_Plan_Line;
import pe.edu.pucp.sia.service.Section_X_Measurement_Plan_Line_Service;
import pe.edu.pucp.sia.service.impl.Section_X_Measurement_Plan_Line_ServiceImpl;

@RequestMapping("/section_x_measurement_plan_line")
@RestController
public class Section_X_Measurement_Plan_Line_Controller {
	Logger logger = LoggerFactory.getLogger(Section_X_Measurement_Plan_Line_Controller.class);
	
	@Autowired
	Section_X_Measurement_Plan_Line_Service section_X_Measurement_Plan_Line_Service= new Section_X_Measurement_Plan_Line_ServiceImpl();
	
	@GetMapping("/list")
	public ResponseEntity<Object> listAll(){
		logger.info("Entered method list()");
		return ResponseEntity.status(HttpStatus.OK).body(section_X_Measurement_Plan_Line_Service.listAll());
	}
	
	@PostMapping("/create")
	public ResponseEntity<Object> createSxM(@RequestBody Section_X_Measurement_Plan_Line l){
		logger.info("Entered method createSxM()");
		return ResponseEntity.status(HttpStatus.CREATED).body(section_X_Measurement_Plan_Line_Service.createSxM(l));
	}
	
	@PostMapping("/update")
	public ResponseEntity<Object> updateSxM(@RequestBody Section_X_Measurement_Plan_Line l){
		logger.info("Entered method updateSxM()");
		return ResponseEntity.status(HttpStatus.CREATED).body(section_X_Measurement_Plan_Line_Service.updateSxM(l));
	}
	
	@PostMapping("/delete/{id}")
	public ResponseEntity<Object> deleteSxM(@PathVariable Integer id){
		logger.info("Entered method deleteSxM()");
		return ResponseEntity.status(HttpStatus.CREATED).body(section_X_Measurement_Plan_Line_Service.deleteSxM(id));
	}
	
}
