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

import pe.edu.pucp.sia.model.LevelDetail;
import pe.edu.pucp.sia.service.LevelDetailService;
import pe.edu.pucp.sia.service.impl.LevelDetailServiceImpl;

@RequestMapping("/leveldetail")
@RestController
public class LevelDetailController {
	Logger logger = LoggerFactory.getLogger(LevelDetailController.class);
	
	@Autowired
	LevelDetailService levelDetailService= new LevelDetailServiceImpl();
	
	@GetMapping("/list")
	public ResponseEntity<Object> listAll(){
		logger.info("Entered method listLevelDetail()");
		return ResponseEntity.status(HttpStatus.OK).body(levelDetailService.listAll());
	}
	
	@PostMapping("/create")
	public ResponseEntity<Object> createLevelDetail(@RequestBody LevelDetail l){
		logger.info("Entered method createLevelDetail()");
		return ResponseEntity.status(HttpStatus.CREATED).body(levelDetailService.createLevelDetail(l));
	}
	
	@PostMapping("/update")
	public ResponseEntity<Object> updateLevelDetail(@RequestBody LevelDetail l){
		logger.info("Entered method updateLevelDetail()");
		return ResponseEntity.status(HttpStatus.CREATED).body(levelDetailService.updateLevelDetail(l));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteLevelDetail(@PathVariable Integer id){
		logger.info("Entered method deleteLevelDetail()");
		return ResponseEntity.status(HttpStatus.CREATED).body(levelDetailService.deleteLevelDetail(id));
	}
}
