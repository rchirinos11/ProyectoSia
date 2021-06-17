package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.MeasurementCard;
import pe.edu.pucp.sia.response.ApiResponse;

public interface MeasurementCardService {
	public ApiResponse listAll();
	public ApiResponse listByTeacher(Integer id);
	public ApiResponse listByCourse(Integer id);
	public ApiResponse listdByTeacherCourse(Integer idTeacher,Integer idCourse);
	public ApiResponse listdByTeacherCourse2(Integer idTeacher,Integer idCourse);
	public ApiResponse listdByTeacherCourse3(Integer idTeacher,Integer idCourse);
	public ApiResponse createMeasurementCard(MeasurementCard mc);
	public ApiResponse updateMeasurementCard(MeasurementCard mc);
	public ApiResponse deleteMeasurementCard(Integer id);
}
