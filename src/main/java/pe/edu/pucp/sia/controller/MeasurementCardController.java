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
import pe.edu.pucp.sia.service.MeasurementCardService;
import pe.edu.pucp.sia.service.impl.MeasurementCardServiceImpl;

@RequestMapping("/measurementcard")
@RestController
public class MeasurementCardController {
	Logger logger = LoggerFactory.getLogger(MeasurementCardController.class);
	
	@Autowired
	MeasurementCardService measurementCardService= new MeasurementCardServiceImpl();
	
	@GetMapping("/list")
	public ResponseEntity<Object> listAll(){
		logger.info("Entered method listMeasurementCard()");
		return ResponseEntity.status(HttpStatus.OK).body(measurementCardService.listAll());
	}
	
	@GetMapping("/listbyteacher/{id}")
	public ResponseEntity<Object> listByTeacher(@PathVariable Integer id){
		logger.info("Entered method listByTeacher()");
		return ResponseEntity.status(HttpStatus.OK).body(measurementCardService.listByTeacher(id));
	}
	
	@GetMapping("/listbycourse/{id}")
	public ResponseEntity<Object> listByCourse(@PathVariable Integer id){
		logger.info("Entered method listByCourse()");
		return ResponseEntity.status(HttpStatus.OK).body(measurementCardService.listByCourse(id));
	}

	@GetMapping("/listbyteachercourse/{idTeacher}/{idCourse}")
	public ResponseEntity<Object> listByTeacherCourse(@PathVariable Integer idTeacher,@PathVariable Integer idCourse){
		logger.info("Entered method listByTeacherCourse()");
		return ResponseEntity.status(HttpStatus.OK).body(measurementCardService.listdByTeacherCourse(idTeacher,idCourse));
	}
	
	@GetMapping("/listbyteachercourse2/{idTeacher}/{idCourse}")
	public ResponseEntity<Object> listByTeacherCourse2(@PathVariable Integer idTeacher,@PathVariable Integer idCourse){
		logger.info("Entered method listByTeacherCourse2()");
		return ResponseEntity.status(HttpStatus.OK).body(measurementCardService.listdByTeacherCourse2(idTeacher,idCourse));
	}
	
	@GetMapping("/listbyteachercourse3/{idTeacher}/{idCourse}")
	public ResponseEntity<Object> listByTeacherCourse3(@PathVariable Integer idTeacher,@PathVariable Integer idCourse){
		logger.info("Entered method listByTeacherCourse3()");
		return ResponseEntity.status(HttpStatus.OK).body(measurementCardService.listdByTeacherCourse3(idTeacher,idCourse));
	}
	
	
	@PostMapping("/create")
	public ResponseEntity<Object> createMeasurementCard(@RequestBody MeasurementCard mc){
		logger.info("Entered method createMeasurementCard()");
		return ResponseEntity.status(HttpStatus.CREATED).body(measurementCardService.createMeasurementCard(mc));
	}
	
	@PostMapping("/update")
	public ResponseEntity<Object> updateMeasurementCard(@RequestBody MeasurementCard mc){
		logger.info("Entered method updateMeasurementCard()");
		return ResponseEntity.status(HttpStatus.CREATED).body(measurementCardService.updateMeasurementCard(mc));
	}
	
	@PostMapping("/delete/{id}")
	public ResponseEntity<Object> deleteMeasurementCard(@PathVariable Integer id){
		logger.info("Entered method deleteMeasurementCard()");
		return ResponseEntity.status(HttpStatus.CREATED).body(measurementCardService.deleteMeasurementCard(id));
	}

}
