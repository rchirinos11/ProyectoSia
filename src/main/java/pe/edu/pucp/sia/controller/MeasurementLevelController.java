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

import pe.edu.pucp.sia.model.MeasurementLevel;
import pe.edu.pucp.sia.requests.MPlanLineSpecialtySemesterRequest;
import pe.edu.pucp.sia.response.ApiResponse;
import pe.edu.pucp.sia.service.MeasurementLevelService;
import pe.edu.pucp.sia.service.impl.MeasurementLevelServiceImpl;

@RequestMapping("/measurementlevel")
@RestController
public class MeasurementLevelController {
	Logger logger = LoggerFactory.getLogger(MeasurementLevelController.class);
	
	@Autowired
	MeasurementLevelService measurementLevelService= new MeasurementLevelServiceImpl();
	
	@GetMapping("/list")
	public ResponseEntity<ApiResponse> listAll(){
		logger.info("Entered method listMeasurementLevel()");
		ApiResponse response = measurementLevelService.listAll();
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@GetMapping("/listbysemester/{idSemester}")
	public ResponseEntity<ApiResponse> listBySemester(@PathVariable Integer idSemester){
		logger.info("Entered method listBySemester()");
		ApiResponse response = measurementLevelService.listBySemester(idSemester);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/listbyspecialtysemester")
	public ResponseEntity<ApiResponse> listBySpecialtySemester(@RequestBody MPlanLineSpecialtySemesterRequest lss){
		logger.info("Entered method listBySpecialtySemester()");
		ApiResponse response = measurementLevelService.listBySpecialtySemester(lss);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	
	@PostMapping("/create")
	public ResponseEntity<ApiResponse> createMeasurementLevel(@RequestBody MeasurementLevel ml){
		logger.info("Entered method createMeasurementLevel()");
		ApiResponse response = measurementLevelService.createMeasurementLevel(ml);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/update")
	public ResponseEntity<ApiResponse> updateMeasurementLevel(@RequestBody MeasurementLevel ml){
		logger.info("Entered method updateMeasurementLevel()");
		ApiResponse response = measurementLevelService.updateMeasurementLevel(ml);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> deleteMeasurementLevel(@PathVariable Integer id){
		logger.info("Entered method deleteMeasurementLevel()");
		ApiResponse response = measurementLevelService.deleteMeasurementLevel(id);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/updateCurrent/{id}")
	public ResponseEntity<ApiResponse> updateCurrentMeasurementLevel(@PathVariable Integer id){
		logger.info("Entered method updateCurrentMeasurementLevel()");
		ApiResponse response = measurementLevelService.updateCurrentMeasurementLevel(id);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
}
