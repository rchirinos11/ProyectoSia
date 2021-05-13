package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.Measurement;
import pe.edu.pucp.sia.repository.MeasurementRepository;
import pe.edu.pucp.sia.service.MeasurementService;
@Service
public class MeasurementServiceImpl implements MeasurementService {
	@Autowired
	private MeasurementRepository measurementRepository;

	@Override
	public Iterable<Measurement> listAll() {
		return measurementRepository.findAll();
	}

	@Override
	public Integer createMeasurement(Measurement m) {
		Integer response =0;
		try {
			response=measurementRepository.save(m).getIdMeasurement();
					} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public Integer updateMeasurement(Measurement m) {
		Integer response =0;
		try {
			response=measurementRepository.save(m).getIdMeasurement();
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
