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

import pe.edu.pucp.sia.model.StudentResult;
import pe.edu.pucp.sia.requests.MPlanLineCourseSemesterRequest;
import pe.edu.pucp.sia.requests.MPlanLineSpecialtySemesterRequest;
import pe.edu.pucp.sia.requests.StudentResultCopyRequest;
import pe.edu.pucp.sia.response.ApiResponse;
import pe.edu.pucp.sia.service.StudentResultService;
import pe.edu.pucp.sia.service.impl.StudentResultServiceImpl;

import pe.edu.pucp.sia.requests.StudentResultSemestersRequest;
import pe.edu.pucp.sia.requests.StudentResultSpecialtySemestersRequest;

@RestController
@RequestMapping("/studentresult")
public class StudentResultController {
	Logger logger = LoggerFactory.getLogger(StudentResultController.class);
	
	@Autowired
	private StudentResultService studentResultService = new StudentResultServiceImpl();
	
	@GetMapping("/list")
	public ResponseEntity<ApiResponse> listStudentResult(){
		logger.info("Entered method listStudentResult()");
		ApiResponse response = studentResultService.listAll();
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@GetMapping("/listbysemester/{idSemester}")
	public ResponseEntity<ApiResponse> listSBySemester(@PathVariable Integer idSemester){
		logger.info("Entered method listBySemester()");
		ApiResponse response = studentResultService.listBySemester(idSemester);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/listbyspecialtysemester")
	public ResponseEntity<ApiResponse> listBySpecialtySemester(@RequestBody MPlanLineSpecialtySemesterRequest lss){
		logger.info("Entered method listBySpecialtySemester()");
		ApiResponse response = studentResultService.listBySpecialtySemester(lss);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/listbyspecialtysemesterpluspercentage")
	public ResponseEntity<ApiResponse> listBySpecialtySemesterPlusAchievementPercentage(@RequestBody MPlanLineSpecialtySemesterRequest lss){
		logger.info("Entered method listBySpecialtyPlusAchievementPercentage()");
		ApiResponse response = studentResultService.listBySpecialtySemesterPlusAchievementPercentage(lss);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/listbyspecialtysemesterplusindicatorscoursespercentages")
	public ResponseEntity<ApiResponse> listBySpecialtySemesterPlusIndicatorsCoursesPercentage(@RequestBody MPlanLineSpecialtySemesterRequest lss){
		logger.info("Entered method listBySpecialtySemesterPlusIndicatorsCoursesPercentage()");
		ApiResponse response = studentResultService.listBySpecialtySemesterPlusIndicatorsCoursesPercentage(lss);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/listbyspecialtysemesterstartsemesterendplusindicatorscoursespercentages")
	public ResponseEntity<ApiResponse> listBySpecialtySemestersPlusIndicatorsCoursesPercentage(@RequestBody StudentResultSpecialtySemestersRequest lss){
		logger.info("Entered method listBySpecialtySemestersPlusIndicatorsCoursesPercentage()");
		ApiResponse response = studentResultService.listBySpecialtySemestersPlusIndicatorsCoursesPercentage(lss);
		return ResponseEntity.status(response.getStatus()).body(response);
	}

	@PostMapping("/listbycoursesemesterplussuccess")
	public ResponseEntity<ApiResponse> listByCourseSemesterPlusSuccess(@RequestBody MPlanLineCourseSemesterRequest lss){
		logger.info("Entered method listByCourseSemesterPlusSuccess()");
		ApiResponse response = studentResultService.listByCourseSemesterPlusSuccess(lss);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/listbyspecialtysemesterplusindicator")
	public ResponseEntity<ApiResponse> listBySpecialtySemesterPlusIndicator(@RequestBody MPlanLineSpecialtySemesterRequest lss){
		logger.info("Entered method listBySpecialtyPlusIndicator()");
		ApiResponse response = studentResultService.listBySpecialtySemesterPlusIndicator(lss);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/create")
	public ResponseEntity<ApiResponse> createStudentResult(@RequestBody StudentResult sr){
		logger.info("Entered method createStudentResult()");
		ApiResponse response = studentResultService.createStudentResult(sr);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/update")
	public ResponseEntity<ApiResponse> updateStudentResult(@RequestBody StudentResult sr){
		logger.info("Entered method updateStudentResult()");
		ApiResponse response = studentResultService.updateStudentResult(sr);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> deleteStudentResult(@PathVariable Integer id){
		logger.info("Entered method deleteStudentResult()");
		ApiResponse response = studentResultService.deleteStudentResult(id);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/copyBySpecialtySemester")
	public ResponseEntity<ApiResponse> copyBySpecialtySemester(@RequestBody StudentResultCopyRequest srRequest){
		logger.info("Entered method copyBySpecialtySemester()");
		ApiResponse response = studentResultService.copyBySpecialtySemester(srRequest.getIdSpecialtyFrom(),srRequest.getIdSemesterFrom(),srRequest.getIdSpecialtyTo(),srRequest.getIdSemesterTo());
		return ResponseEntity.status(response.getStatus()).body(response);
	}

	//Method inserted. If fails, delete this
	@PostMapping("/listbysemesterspluspercentage")
	public ResponseEntity<ApiResponse> listBySemestersPlusAchievementPercentage(@RequestBody StudentResultSemestersRequest srRequest){
		logger.info("Entered method listBySemestersPlusAchievementPercentage()");
		ApiResponse response = studentResultService.listBySemestersPlusAchievementPercentage(srRequest.getIdSemesterStart(),srRequest.getIdSemesterEnd());
		return ResponseEntity.status(response.getStatus()).body(response);
	}
}
