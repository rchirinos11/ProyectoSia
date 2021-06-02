package pe.edu.pucp.sia.service;

import java.util.List;

import org.springframework.boot.context.properties.source.ConfigurationPropertyName.Form;

import pe.edu.pucp.sia.model.MeasurementCard;
import pe.edu.pucp.sia.model.MeasurementLevel;
import pe.edu.pucp.sia.model.ResultsPerCard;

public interface MeasurementCardService {
	public Iterable<MeasurementCard> listAll();
	public Iterable<MeasurementCard> listByTeacher(Integer id);
	public Iterable<MeasurementCard> listByCourse(Integer id);
	public Iterable<Form> listdByTeacherCourse(Integer idTeacher,Integer idCourse);
	public Iterable<MeasurementCard> listdByTeacherCourse2(Integer idTeacher,Integer idCourse);
	public Iterable<ResultsPerCard> listdByTeacherCourse3(Integer idTeacher,Integer idCourse);
	public Integer createMeasurementCard(MeasurementCard mc);
	public Integer updateMeasurementCard(MeasurementCard mc);
	public String deleteMeasurementCard(Integer id);
}
