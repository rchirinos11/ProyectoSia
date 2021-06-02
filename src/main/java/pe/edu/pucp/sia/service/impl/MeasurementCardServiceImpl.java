package pe.edu.pucp.sia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.ConfigurationPropertyName.Form;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.MeasurementCard;
import pe.edu.pucp.sia.model.MeasurementLevel;
import pe.edu.pucp.sia.model.ResultsPerCard;
import pe.edu.pucp.sia.repository.MeasurementCardRepository;
import pe.edu.pucp.sia.service.MeasurementCardService;
@Service
public class MeasurementCardServiceImpl implements MeasurementCardService{
	@Autowired
	private MeasurementCardRepository measurementCardRepository;
	
	@Override
	public Iterable<MeasurementCard> listAll() {
		return measurementCardRepository.findAll();
	}

	@Override
	public Integer createMeasurementCard(MeasurementCard mc) {
		Integer response =0;
		try {
			response=measurementCardRepository.save(mc).getId();				
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public Integer updateMeasurementCard(MeasurementCard mc) {
		Integer response =0;
		try {
			response=measurementCardRepository.save(mc).getId();
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public String deleteMeasurementCard(Integer id) {
		String response = "";
		try {
			measurementCardRepository.deleteMeasurementCard(id);
			response = "Deleted"; 
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public Iterable<MeasurementCard> listByTeacher(Integer id) {
		Iterable<MeasurementCard> lista = measurementCardRepository.findByPersonId(id);
		for (MeasurementCard mc : lista) {
			mc.setPerson(null);
		}
		return lista;
	}

	@Override
	public Iterable<MeasurementCard> listByCourse(Integer id) {
		Iterable<MeasurementCard> lista = measurementCardRepository.findByCourseId(id);
		for (MeasurementCard mc : lista) {
			mc.setCourse(null);
		}
		return lista;
	}

	@Override
	public Iterable<Form> listdByTeacherCourse(Integer idTeacher, Integer idCourse) {
		Iterable <Form> lista = measurementCardRepository.listMeasurementCardByTeacherCourse(idTeacher,idCourse);
		return lista;
	}

	@Override
	public Iterable<MeasurementCard> listdByTeacherCourse2(Integer idTeacher, Integer idCourse) {
		Iterable <MeasurementCard> lista = measurementCardRepository.listMeasurementCardByTeacherCourse_2(idTeacher,idCourse);
		return lista;
	}

	@Override
	public Iterable<ResultsPerCard> listdByTeacherCourse3(Integer idTeacher, Integer idCourse) {
		Iterable <ResultsPerCard> lista = measurementCardRepository.listMeasurementCardByTeacherCourse_3(idTeacher,idCourse);
		return lista;
	}



}
