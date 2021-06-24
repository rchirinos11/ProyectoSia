package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.MeasurementType;
import pe.edu.pucp.sia.repository.MeasurementTypeRepository;
import pe.edu.pucp.sia.response.ApiResponse;
import pe.edu.pucp.sia.service.MeasurementTypeService;

@Service
public class MeasurementTypeServiceImpl implements MeasurementTypeService{
	
	@Autowired
	private MeasurementTypeRepository measurementTypeRepository;
	
	@Override
	public ApiResponse listAll() {
		ApiResponse response = null;
		try {
			Iterable<MeasurementType> list = measurementTypeRepository.findAll();
			response = new ApiResponse(list,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse createMeasurementType(MeasurementType m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApiResponse deleteMeasurementType(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApiResponse updateMeasurementType(MeasurementType m) {
		// TODO Auto-generated method stub
		return null;
	}

}
