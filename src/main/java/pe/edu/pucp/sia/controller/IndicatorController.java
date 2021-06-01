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

import pe.edu.pucp.sia.model.Indicator;
import pe.edu.pucp.sia.service.IndicatorService;
import pe.edu.pucp.sia.service.impl.IndicatorServiceImpl;

@RestController
@RequestMapping("/indicator")
public class IndicatorController {
    @Autowired
    private IndicatorService indicatorService = new IndicatorServiceImpl();
    
    @GetMapping("/list")
	public ResponseEntity<Object> listIndicator(){
		return ResponseEntity.status(HttpStatus.OK).body(indicatorService.listAll());
	}
	
	@PostMapping("/create")
	public ResponseEntity<Object> createIndicator(@RequestBody Indicator i){
		return ResponseEntity.status(HttpStatus.CREATED).body(indicatorService.createIndicator(i));
	}
	
	@PostMapping("/update")
	public ResponseEntity<Object> updateIndicator(@RequestBody Indicator i){
		return ResponseEntity.status(HttpStatus.CREATED).body(indicatorService.updateIndicator(i));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteIndicator(@PathVariable Integer id){
		return ResponseEntity.status(HttpStatus.CREATED).body(indicatorService.deleteIndicator(id));
	}
}
