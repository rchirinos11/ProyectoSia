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

import pe.edu.pucp.sia.model.Faculty;
import pe.edu.pucp.sia.requests.FacultyUpdateCoordinatorRequest;
import pe.edu.pucp.sia.response.ApiResponse;
import pe.edu.pucp.sia.service.FacultyService;
import pe.edu.pucp.sia.service.impl.FacultyServiceImpl;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
	Logger logger = LoggerFactory.getLogger(FacultyController.class);
	
	@Autowired
	private FacultyService facultyService = new FacultyServiceImpl();
	
	@GetMapping("/list")
	public ResponseEntity<ApiResponse> listFaculty(){
		logger.info("Entered method listFaculty()");
		ApiResponse response = facultyService.listAll();
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@GetMapping("/listbycoordinator/{id}")
	public ResponseEntity<ApiResponse> listByCoordinator(@PathVariable Integer id){
		logger.info("Entered method listByCoordinator()");
		ApiResponse response = facultyService.listByCoordinator(id);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/create")
	public ResponseEntity<ApiResponse> createFaculty(@RequestBody Faculty f){
		logger.info("Entered method createFaculty()");
		ApiResponse response = facultyService.createFaculty(f);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/update")
	public ResponseEntity<ApiResponse> updateFaculty(@RequestBody Faculty f){
		logger.info("Entered method updateFaculty()");
		ApiResponse response = facultyService.updateFaculty(f);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> deleteFaculty(@PathVariable Integer id){
		logger.info("Entered method deleteFaculty()");
		ApiResponse response = facultyService.deleteFaculty(id);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/setCoordinator")
	public ResponseEntity<ApiResponse> updateFacultyCoordinator(@RequestBody FacultyUpdateCoordinatorRequest f){
		logger.info("Entered method updateFacultyCoordinator()");
		ApiResponse response = facultyService.updateCoordinator(f.getIdFaculty(),f.getIdCoordinator());
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/archive/{id}")
	public ResponseEntity<ApiResponse> archiveFaculty(@PathVariable Integer id){
		logger.info("Entered method archiveFaculty()");
		ApiResponse response = facultyService.archiveFaculty(id,true);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/disarchive/{id}")
	public ResponseEntity<ApiResponse> disarchiveFaculty(@PathVariable Integer id){
		logger.info("Entered method disarchiveFaculty()");
		ApiResponse response = facultyService.archiveFaculty(id,false);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
}
