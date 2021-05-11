package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import pe.edu.pucp.sia.model.Measurement;
import pe.edu.pucp.sia.repository.MeasurementRepository;
import pe.edu.pucp.sia.service.MeasurementService;

public class MeasurementServiceImpl implements MeasurementService {
	@Autowired
	private MeasurementRepository measurementRepository;

	@Override
	public Iterable<Measurement> listAll() {
		return measurementRepository.findAll();
	}

	@Override
	public String createMeasurement(Measurement m) {
		String response = "";
		try {
			measurementRepository.save(m);
			response = "Created"; 
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public String updateMeasurement(Measurement m) {
		String response = "";
		try {
			measurementRepository.save(m);
			response = "Updated"; 
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public String deleteMeasurement(Integer id) {
		String response = "";
		try {
			measurementRepository.deleteById(id);
			response = "Deleted"; 
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

}
