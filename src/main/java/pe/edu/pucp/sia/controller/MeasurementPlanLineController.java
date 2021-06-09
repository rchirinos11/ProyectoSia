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

import pe.edu.pucp.sia.model.MeasurementPlanLine;
import pe.edu.pucp.sia.requests.MPlanLineCourseSemesterRequest;
import pe.edu.pucp.sia.requests.MPlanLineSpecialtySemesterRequest;
import pe.edu.pucp.sia.requests.MPlanLineTeacherSemesterRequest;
import pe.edu.pucp.sia.service.MeasurementPlanLineService;
import pe.edu.pucp.sia.service.impl.MeasurementPlanLineServiceImpl;

@RequestMapping("/measurementplanline")
@RestController
public class MeasurementPlanLineController {
	@Autowired
	MeasurementPlanLineService mPlanLineService = new MeasurementPlanLineServiceImpl();
	
	@GetMapping("/list")
	public ResponseEntity<Object> listAll(){
		return ResponseEntity.status(HttpStatus.OK).body(mPlanLineService.listAll());
	}
	
	@PostMapping("/create")
	public ResponseEntity<Object> createMeasurementPlanLine(@RequestBody MeasurementPlanLine m){
		return ResponseEntity.status(HttpStatus.CREATED).body(mPlanLineService.createMeasurementPlanLine(m));
	}
	
	@PostMapping("/update")
	public ResponseEntity<Object> updateMeasurementPlanLine(@RequestBody MeasurementPlanLine m){
		return ResponseEntity.status(HttpStatus.OK).body(mPlanLineService.updateMeasurementPlanLine(m));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteMeasurementPlanLine(@PathVariable Integer id){
		return ResponseEntity.status(HttpStatus.OK).body(mPlanLineService.deleteMeasurementPlanLine(id));
	}
	
	@GetMapping("/listByCourse/{id}")
	public ResponseEntity<Object> listByCourse(@PathVariable Integer id){
		return ResponseEntity.status(HttpStatus.OK).body(mPlanLineService.listByCourse(id));
	}
	
	@PostMapping("/listBySpecialtySemester")
	public ResponseEntity<Object> listBySpecialtySemester(@RequestBody MPlanLineSpecialtySemesterRequest mplRequest){
		return ResponseEntity.status(HttpStatus.OK).body(mPlanLineService.listBySpecialtyAndSemester(mplRequest.getIdSpecialty(),mplRequest.getIdSemester()));
	}
	
	@GetMapping("/listByCourseSemesterTeacherOld/{idCourse}/{idSemester}/{idPerson}")
	public ResponseEntity<Object> listByCourseSemesterTeacherOld(@PathVariable Integer idCourse,@PathVariable Integer idSemester,@PathVariable Integer idPerson){
		return ResponseEntity.status(HttpStatus.OK).body(mPlanLineService.listByCourseSemesterTeacherOld(idCourse,idSemester,idPerson));
	}
	
	@GetMapping("/listByCourseSemesterTeacher/{idCourse}/{idSemester}/{idPerson}")
	public ResponseEntity<Object> listByCourseSemesterTeacher(@PathVariable Integer idCourse,@PathVariable Integer idSemester,@PathVariable Integer idPerson){
		return ResponseEntity.status(HttpStatus.OK).body(mPlanLineService.listByCourseSemesterTeacher(idCourse,idSemester,idPerson));
	}
	
	@PostMapping("/listByCourseSemester")
	public ResponseEntity<Object> listByCourseSemester(@RequestBody MPlanLineCourseSemesterRequest mplRequest){
		return ResponseEntity.status(HttpStatus.OK).body(mPlanLineService.listByCourseAndSemester(mplRequest.getIdCourse(), mplRequest.getIdSemester()));
	}
	
	@PostMapping("/listByTeacherSemester")
	public ResponseEntity<Object> listByTeacherSemester(@RequestBody MPlanLineTeacherSemesterRequest mplRequest){
		return ResponseEntity.status(HttpStatus.OK).body(mPlanLineService.listBySemesterAndTeachers(mplRequest.getIdSemester(), mplRequest.getIdTeacher()));
	}
	
}
