package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.MeasurementLevel;
import pe.edu.pucp.sia.repository.MeasurementLevelRepository;
import pe.edu.pucp.sia.service.MeasurementLevelService;

@Service
public class MeasurementLevelServiceImpl implements MeasurementLevelService{
	
	@Autowired
	private MeasurementLevelRepository measurementLevelRepository;
	
	@Override
	public Iterable<MeasurementLevel> listAll() {
		return measurementLevelRepository.findAll();
	}

	@Override
	public int createMeasurementLevel(MeasurementLevel m) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMeasurementLevel(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateMeasurementLevel(MeasurementLevel m) {
		// TODO Auto-generated method stub
		return 0;
	}

}
