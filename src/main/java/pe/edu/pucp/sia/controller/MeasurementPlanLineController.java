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

import pe.edu.pucp.sia.model.MeasurementPlanLine;
import pe.edu.pucp.sia.requests.MPlanLineCourseSemesterRequest;
import pe.edu.pucp.sia.requests.MPlanLineCourseSemesterTeacherRequest;
import pe.edu.pucp.sia.requests.MPlanLineSpecialtySemesterRequest;
import pe.edu.pucp.sia.requests.MPlanLineTeacherSemesterRequest;
import pe.edu.pucp.sia.response.ApiResponse;
import pe.edu.pucp.sia.service.MeasurementPlanLineService;
import pe.edu.pucp.sia.service.impl.MeasurementPlanLineServiceImpl;

@RequestMapping("/measurementplanline")
@RestController
public class MeasurementPlanLineController {
	Logger logger = LoggerFactory.getLogger(IndicatorController.class);
	
	@Autowired
	MeasurementPlanLineService mPlanLineService = new MeasurementPlanLineServiceImpl();
	
	@GetMapping("/list")
	public ResponseEntity<ApiResponse> listMeasurementPlanLine(){
		logger.info("Entered method listMeasurementPlanLine()");
		ApiResponse response = mPlanLineService.listAll();
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/create")
	public ResponseEntity<ApiResponse> createMeasurementPlanLine(@RequestBody MeasurementPlanLine m){
		logger.info("Entered method createMeasurementPlanLine()");
		ApiResponse response = mPlanLineService.createMeasurementPlanLine(m);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/update")
	public ResponseEntity<ApiResponse> updateMeasurementPlanLine(@RequestBody MeasurementPlanLine m){
		logger.info("Entered method updateMeasurementPlanLine()");
		ApiResponse response = mPlanLineService.updateMeasurementPlanLine(m);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> deleteMeasurementPlanLine(@PathVariable Integer id){
		logger.info("Entered method deleteMeasurementPlanLine()");
		ApiResponse response = mPlanLineService.deleteMeasurementPlanLine(id);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@GetMapping("/listByCourse/{id}")
	public ResponseEntity<ApiResponse> listByCourse(@PathVariable Integer id){
		logger.info("Entered method listByCourse()");
		ApiResponse response = mPlanLineService.listByCourse(id);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/listBySpecialtySemester")
	public ResponseEntity<ApiResponse> listBySpecialtySemester(@RequestBody MPlanLineSpecialtySemesterRequest mplRequest){
		logger.info("Entered method listBySpecialtySemester()");
		ApiResponse response = mPlanLineService.listBySpecialtyAndSemester(mplRequest.getIdSpecialty(),mplRequest.getIdSemester());
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/listByCourseSemesterTeacher")
	public ResponseEntity<ApiResponse> listByCourseSemesterTeacher(@RequestBody MPlanLineCourseSemesterTeacherRequest mplRequest){
		logger.info("Entered method listByCourseSemesterTeacher()");
		ApiResponse response = mPlanLineService.listByCourseSemesterTeacher(mplRequest.getIdCourse(),mplRequest.getIdSemester(),mplRequest.getIdTeacher());
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/listByCourseSemester")
	public ResponseEntity<ApiResponse> listByCourseSemester(@RequestBody MPlanLineCourseSemesterRequest mplRequest){
		logger.info("Entered method listByCourseSemester()");
		ApiResponse response = mPlanLineService.listByCourseAndSemester(mplRequest.getIdCourse(), mplRequest.getIdSemester());
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/listByTeacherSemester")
	public ResponseEntity<ApiResponse> listByTeacherSemester(@RequestBody MPlanLineTeacherSemesterRequest mplRequest){
		logger.info("Entered method listByTeacherSemester()");
		ApiResponse response = mPlanLineService.listBySemesterAndTeachers(mplRequest.getIdSemester(), mplRequest.getIdTeacher());
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@GetMapping("/listByCourseSemesterSection/{idC}/{idSem}/{idSec}")
	public ResponseEntity<ApiResponse> listByCourseSemesterSection(@PathVariable Integer idC,@PathVariable Integer idSem,@PathVariable Integer idSec){
		logger.info("Entered method listByCourseSemesterSection()");
		ApiResponse response = mPlanLineService.listByCourseAndSemesterAndSchedule(idC, idSem, idSec);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
}
