package pe.edu.pucp.sia.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.pucp.sia.model.LevelDetail;
import pe.edu.pucp.sia.response.ApiResponse;
import pe.edu.pucp.sia.service.LevelDetailService;
import pe.edu.pucp.sia.service.impl.LevelDetailServiceImpl;

@RequestMapping("/leveldetail")
@RestController
public class LevelDetailController {
	Logger logger = LoggerFactory.getLogger(LevelDetailController.class);
	
	@Autowired
	LevelDetailService levelDetailService= new LevelDetailServiceImpl();
	
	@GetMapping("/list")
	public ResponseEntity<ApiResponse> listAll(){
		logger.info("Entered method listLevelDetail()");
		ApiResponse response = levelDetailService.listAll();
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/create")
	public ResponseEntity<ApiResponse> createLevelDetail(@RequestBody LevelDetail l){
		logger.info("Entered method createLevelDetail()");
		ApiResponse response = levelDetailService.createLevelDetail(l);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/update")
	public ResponseEntity<ApiResponse> updateLevelDetail(@RequestBody LevelDetail l){
		logger.info("Entered method updateLevelDetail()");
		ApiResponse response = levelDetailService.updateLevelDetail(l);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> deleteLevelDetail(@PathVariable Integer id){
		logger.info("Entered method deleteLevelDetail()");
		ApiResponse response = levelDetailService.deleteLevelDetail(id);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@GetMapping("/listbyspecialty/{id}")
	public ResponseEntity<ApiResponse> listBySpecialty(@PathVariable Integer id){
		ApiResponse response = levelDetailService.listBySpecialty(id);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
}
