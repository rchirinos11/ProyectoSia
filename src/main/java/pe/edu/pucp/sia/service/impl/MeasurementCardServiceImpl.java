package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.ConfigurationPropertyName.Form;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.MeasurementCard;
import pe.edu.pucp.sia.model.ResultsPerCard;
import pe.edu.pucp.sia.repository.MeasurementCardRepository;
import pe.edu.pucp.sia.response.ApiResponse;
import pe.edu.pucp.sia.service.MeasurementCardService;
@Service
public class MeasurementCardServiceImpl implements MeasurementCardService{
	@Autowired
	private MeasurementCardRepository measurementCardRepository;
	
	@Override
	public ApiResponse listAll() {
		ApiResponse response = null;
		try {
			Iterable<MeasurementCard> list = measurementCardRepository.findAll();
			response = new ApiResponse(list,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse createMeasurementCard(MeasurementCard mc) {
		ApiResponse response = null;
		try {
			Integer id = measurementCardRepository.save(mc).getId();				
			response = new ApiResponse(id,201);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse updateMeasurementCard(MeasurementCard mc) {
		ApiResponse response = null;
		try {
			Integer id = measurementCardRepository.save(mc).getId();
			response = new ApiResponse(id,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse deleteMeasurementCard(Integer id) {
		ApiResponse response = null;
		try {
			measurementCardRepository.deleteMeasurementCard(id);
			response = new ApiResponse("Success",200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse listByTeacher(Integer id) {
		ApiResponse response = null;
		try {
			Iterable<MeasurementCard> list = measurementCardRepository.findByPersonId(id);
			for (MeasurementCard mc : list) {
				mc.setPerson(null);
			}
			response = new ApiResponse(list,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse listByCourse(Integer id) {
		ApiResponse response = null;
		try {
			Iterable<MeasurementCard> list = measurementCardRepository.findByCourseId(id);
			for (MeasurementCard mc : list) {
				mc.setCourse(null);
			}
			response = new ApiResponse(list,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse listdByTeacherCourse(Integer idTeacher, Integer idCourse) {
		ApiResponse response = null;
		try {
			Iterable<Form> list = measurementCardRepository.listMeasurementCardByTeacherCourse(idTeacher,idCourse);
			response = new ApiResponse(list,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse listdByTeacherCourse2(Integer idTeacher, Integer idCourse) {
		ApiResponse response = null;
		try {
			Iterable<MeasurementCard> list = measurementCardRepository.listMeasurementCardByTeacherCourse_2(idTeacher,idCourse);
			response = new ApiResponse(list,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse listdByTeacherCourse3(Integer idTeacher, Integer idCourse) {
		ApiResponse response = null;
		try {
			Iterable<ResultsPerCard> list = measurementCardRepository.listMeasurementCardByTeacherCourse_3(idTeacher,idCourse);
			response = new ApiResponse(list,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}



}
