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

import pe.edu.pucp.sia.model.Specialty;
import pe.edu.pucp.sia.model.Person;
import pe.edu.pucp.sia.requests.SpecialtyUpdateAssistantRequest;
import pe.edu.pucp.sia.requests.SpecialtyUpdateCoordinatorRequest;
import pe.edu.pucp.sia.requests.SpecialtyUpdatePercentageRequest;
import pe.edu.pucp.sia.response.ApiResponse;
import pe.edu.pucp.sia.service.SpecialtyService;
import pe.edu.pucp.sia.service.impl.SpecialtyServiceImpl;

@RestController
@RequestMapping("/specialty")
public class SpecialtyController {

	Logger logger = LoggerFactory.getLogger(SpecialtyController.class);
	
	@Autowired
	private SpecialtyService specialtyService = new SpecialtyServiceImpl();
	
	@GetMapping("/list")
	public ResponseEntity<ApiResponse> listSpecialty(){
		logger.info("Entered method listSpecialty()");
		ApiResponse response = specialtyService.listAll();
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@GetMapping("/listbyfaculty/{id}")
	public ResponseEntity<ApiResponse> listByFaculty(@PathVariable Integer id){
		logger.info("Entered method listByFaculty()");
		ApiResponse response = specialtyService.listByFaculty(id);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@GetMapping("/listbycoordinator/{id}")
	public ResponseEntity<ApiResponse> listByCoordinator(@PathVariable Integer id){
		logger.info("Entered method listByCoordinator()");
		ApiResponse response = specialtyService.listByCoordinator(id);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@GetMapping("/listbyassistant/{id}")
	public ResponseEntity<ApiResponse> listByAssistant(@PathVariable Integer id){
		logger.info("Entered method listByAssistant()");
		ApiResponse response = specialtyService.listByAssistant(id);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	@PostMapping("/create")
	public ResponseEntity<ApiResponse> createSpecialty(@RequestBody Specialty s){
		logger.info("Entered method createSpecialty()");
		ApiResponse response = specialtyService.createSpecialty(s);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/update")
	public ResponseEntity<ApiResponse> updateSpecialty(@RequestBody Specialty s){
		logger.info("Entered method updateSpecialty()");
		ApiResponse response = specialtyService.updateSpecialty(s);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> deleteSpecialty(@PathVariable Integer id){
		logger.info("Entered method deleteSpecialty()");
		ApiResponse response = specialtyService.deleteSpecialty(id);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("setCoordinator")
	public ResponseEntity<ApiResponse> updateSpecialtyCoordinator(@RequestBody SpecialtyUpdateCoordinatorRequest s){
		logger.info("Entered method updateSpecialtyCoordinator()");
		ApiResponse response = specialtyService.updateCoordinator(s.getIdSpecialty(),s.getIdCoordinator());
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("setAssistant")
	public ResponseEntity<ApiResponse> updateSpecialtyAssistant(@RequestBody SpecialtyUpdateAssistantRequest s){
		logger.info("Entered method updateSpecialtyAssistant()");
		ApiResponse response = specialtyService.updateAssitant(s.getIdSpecialty(),s.getIdAssistant());
		return ResponseEntity.status(response.getStatus()).body(response);
	}

	@PostMapping("setPercentage")
	public ResponseEntity<ApiResponse> updateSuccessPercentage(@RequestBody SpecialtyUpdatePercentageRequest s){
		logger.info("Entered method updateSuccessPercentage()");
		ApiResponse response = specialtyService.updatePercentage(s.getIdSpecialty(),s.getSuccessPercentage());
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("archive/{id}")
	public ResponseEntity<ApiResponse> archiveSpecialty(@PathVariable Integer id){
		logger.info("Entered method archiveSpecialty()");
		ApiResponse response = specialtyService.archiveSpecialty(id,true);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("disarchive/{id}")
	public ResponseEntity<ApiResponse> disarchiveSpecialty(@PathVariable Integer id){
		logger.info("Entered method disarchiveSpecialty()");
		ApiResponse response = specialtyService.archiveSpecialty(id,false);
		return ResponseEntity.status(response.getStatus()).body(response);
	}

	@GetMapping("/listTeachersBySpecialty/{id}")
	public ResponseEntity<ApiResponse> listTeachersBySpecialty(@PathVariable Integer id){
		logger.info("Entered method listTeachersBySpecialty()");
		ApiResponse response = specialtyService.listTeachersBySpecialty(id);
		return ResponseEntity.status(response.getStatus()).body(response);
	}

}
