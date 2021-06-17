package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.MeasurementPlanLine;
import pe.edu.pucp.sia.response.MeasurementPlanResponse;

public interface MeasurementPlanLineService {
	public Iterable<MeasurementPlanLine> listAll();
	public Integer createMeasurementPlanLine(MeasurementPlanLine m);
	public Integer updateMeasurementPlanLine(MeasurementPlanLine m);
	public String deleteMeasurementPlanLine(Integer id);
	public Iterable<MeasurementPlanLine> listByCourse(Integer idFaculty);
	public Iterable<MeasurementPlanLine> listBySpecialtyAndSemester(Integer idSpecialty, Integer idSemester);
	public Iterable<MeasurementPlanLine> listByCourseSemesterTeacher(Integer idCourse, Integer idSemester,Integer idPerson);
	//public Iterable<MeasurementPlanResponse> listByCourseSemesterTeacher(Integer idCourse, Integer idSemester,Integer idPerson);
	public Iterable<MeasurementPlanLine> listByCourseAndSemester(Integer idCourse, Integer idSemester);
	public Iterable<MeasurementPlanLine> listBySemesterAndTeachers(Integer idSemester, Integer idPerson);
	public Iterable<MeasurementPlanLine> listByCourseAndSemesterAndSchedule(Integer idCourse, Integer idSemester,Integer code);
}
