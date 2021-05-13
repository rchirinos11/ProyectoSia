package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.MeasurementType;
import pe.edu.pucp.sia.repository.MeasurementTypeRepository;
import pe.edu.pucp.sia.service.MeasurementTypeService;

@Service
public class MeasurementTypeServiceImpl implements MeasurementTypeService{
	
	@Autowired
	private MeasurementTypeRepository measurementTypeRepository;
	
	@Override
	public Iterable<MeasurementType> listAll() {
		return measurementTypeRepository.findAll();
	}

	@Override
	public int createMeasurementType(MeasurementType m) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMeasurementType(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateMeasurementType(MeasurementType m) {
		// TODO Auto-generated method stub
		return 0;
	}

}
