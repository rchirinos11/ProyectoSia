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

import pe.edu.pucp.sia.model.Indicator;
import pe.edu.pucp.sia.requests.IndicatorListRequest;
import pe.edu.pucp.sia.response.ApiResponse;
import pe.edu.pucp.sia.service.IndicatorService;
import pe.edu.pucp.sia.service.impl.IndicatorServiceImpl;

@RestController
@RequestMapping("/indicator")
public class IndicatorController {
	Logger logger = LoggerFactory.getLogger(IndicatorController.class);

    @Autowired
    private IndicatorService indicatorService = new IndicatorServiceImpl();
    
    @GetMapping("/list")
	public ResponseEntity<ApiResponse> listIndicator(){
		logger.info("Entered method listIndicator()");
		ApiResponse response = indicatorService.listAll();
		return ResponseEntity.status(response.getStatus()).body(response);
	}

    @PostMapping("/listbyspecialtysemester")
	public ResponseEntity<ApiResponse> listBySpecialtySemester(@RequestBody IndicatorListRequest r){
		logger.info("Entered method listbyspecialtysemester()");
		ApiResponse response = indicatorService.listBySpecialtySemester(r.getIdSpecialty(),r.getIdSemester());
		return ResponseEntity.status(response.getStatus()).body(response);
	}

	@PostMapping("/create")
	public ResponseEntity<ApiResponse> createIndicator(@RequestBody Indicator i){
		logger.info("Entered method createIndicator()");
		ApiResponse response = indicatorService.createIndicator(i);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/update")
	public ResponseEntity<ApiResponse> updateIndicator(@RequestBody Indicator i){
		logger.info("Entered method updateIndicator()");
		ApiResponse response = indicatorService.updateIndicator(i);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> deleteIndicator(@PathVariable Integer id){
		logger.info("Entered method deleteIndicator()");
		ApiResponse response = indicatorService.deleteIndicator(id);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
}