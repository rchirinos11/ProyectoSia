package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.MeasurementLevel;
import pe.edu.pucp.sia.repository.MeasurementLevelRepository;
import pe.edu.pucp.sia.service.MeasurementLevelService;
@Service
public class MeasurementLevelServiceImpl implements MeasurementLevelService {
	@Autowired
	private MeasurementLevelRepository measurementLevelRepository;

	@Override
	public Iterable<MeasurementLevel> listAll() {
		return measurementLevelRepository.findAll();
	}

	@Override
	public String createMeasurementLevel(MeasurementLevel ml) {
		String response = "";
		try {
			measurementLevelRepository.save(ml);
			response = "Created"; 
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public String updateMeasurementLevel(MeasurementLevel ml) {
		String response = "";
		try {
			measurementLevelRepository.save(ml);
			response = "Updated"; 
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public String deleteMeasurementLevel(Integer id) {
		String response = "";
		try {
			measurementLevelRepository.deleteById(id);
			response = "Deleted"; 
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

}
