package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.MeasurementPlanLine;
import pe.edu.pucp.sia.response.ApiResponse;

public interface MeasurementPlanLineService {
	public ApiResponse listAll();
	public ApiResponse createMeasurementPlanLine(MeasurementPlanLine m);
	public ApiResponse updateMeasurementPlanLine(MeasurementPlanLine m);
	public ApiResponse deleteMeasurementPlanLine(Integer id);
	public ApiResponse listByCourse(Integer idFaculty);
	public ApiResponse listBySpecialtyAndSemester(Integer idSpecialty, Integer idSemester);
	public ApiResponse listByCourseSemesterTeacher(Integer idCourse, Integer idSemester,Integer idPerson);
	public ApiResponse listByCourseAndSemester(Integer idCourse, Integer idSemester);
	public ApiResponse listByCourseAndSemesterPlusCode(Integer idCourse, Integer idSemester);
	public ApiResponse listBySemesterAndTeachers(Integer idSemester, Integer idPerson);
	public ApiResponse listByCourseAndSemesterAndSchedule(Integer idCourse, Integer idSemester,Integer idSection);
}
