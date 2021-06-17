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

import pe.edu.pucp.sia.model.MeasurementCard;
import pe.edu.pucp.sia.response.ApiResponse;
import pe.edu.pucp.sia.service.MeasurementCardService;
import pe.edu.pucp.sia.service.impl.MeasurementCardServiceImpl;

@RequestMapping("/measurementcard")
@RestController
public class MeasurementCardController {
	Logger logger = LoggerFactory.getLogger(MeasurementCardController.class);
	
	@Autowired
	MeasurementCardService measurementCardService= new MeasurementCardServiceImpl();
	
	@GetMapping("/list")
	public ResponseEntity<ApiResponse> listAll(){
		logger.info("Entered method listMeasurementCard()");
		ApiResponse response = measurementCardService.listAll();
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@GetMapping("/listbyteacher/{id}")
	public ResponseEntity<ApiResponse> listByTeacher(@PathVariable Integer id){
		logger.info("Entered method listByTeacher()");
		ApiResponse response = measurementCardService.listByTeacher(id);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@GetMapping("/listbycourse/{id}")
	public ResponseEntity<ApiResponse> listByCourse(@PathVariable Integer id){
		logger.info("Entered method listByCourse()");
		ApiResponse response = measurementCardService.listByCourse(id);
		return ResponseEntity.status(response.getStatus()).body(response);
	}

	@GetMapping("/listbyteachercourse/{idTeacher}/{idCourse}")
	public ResponseEntity<ApiResponse> listByTeacherCourse(@PathVariable Integer idTeacher,@PathVariable Integer idCourse){
		logger.info("Entered method listByTeacherCourse()");
		ApiResponse response = measurementCardService.listdByTeacherCourse(idTeacher,idCourse);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@GetMapping("/listbyteachercourse2/{idTeacher}/{idCourse}")
	public ResponseEntity<ApiResponse> listByTeacherCourse2(@PathVariable Integer idTeacher,@PathVariable Integer idCourse){
		logger.info("Entered method listByTeacherCourse2()");
		ApiResponse response = measurementCardService.listdByTeacherCourse2(idTeacher,idCourse);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@GetMapping("/listbyteachercourse3/{idTeacher}/{idCourse}")
	public ResponseEntity<ApiResponse> listByTeacherCourse3(@PathVariable Integer idTeacher,@PathVariable Integer idCourse){
		logger.info("Entered method listByTeacherCourse3()");
		ApiResponse response = measurementCardService.listdByTeacherCourse3(idTeacher,idCourse);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/create")
	public ResponseEntity<ApiResponse> createMeasurementCard(@RequestBody MeasurementCard mc){
		logger.info("Entered method createMeasurementCard()");
		ApiResponse response = measurementCardService.createMeasurementCard(mc);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/update")
	public ResponseEntity<ApiResponse> updateMeasurementCard(@RequestBody MeasurementCard mc){
		logger.info("Entered method updateMeasurementCard()");
		ApiResponse response = measurementCardService.updateMeasurementCard(mc);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> deleteMeasurementCard(@PathVariable Integer id){
		logger.info("Entered method deleteMeasurementCard()");
		ApiResponse response = measurementCardService.deleteMeasurementCard(id);
		return ResponseEntity.status(response.getStatus()).body(response);
	}

}
