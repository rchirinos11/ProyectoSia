package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.Measurement;
import pe.edu.pucp.sia.model.ResultsPerCard;
import pe.edu.pucp.sia.repository.MeasurementRepository;
import pe.edu.pucp.sia.repository.ResultsPerCardRepository;
import pe.edu.pucp.sia.service.MeasurementService;
@Service
public class MeasurementServiceImpl implements MeasurementService {
	@Autowired
	private MeasurementRepository measurementRepository;
	@Autowired
	private ResultsPerCardRepository resultsPerCardRepository;

	@Override
	public Iterable<Measurement> listAll() {
		return measurementRepository.findAll();
	}

	@Override
	public Integer createMeasurement(Measurement m) {
		Integer response =0;
		try {			
			response=measurementRepository.save(m).getId();
					} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public Integer updateMeasurement(Measurement m) {
		Integer response =0;
		try {
			response=measurementRepository.save(m).getId();
					} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public String deleteMeasurement(Integer id) {
		String response = "";
		try {
			measurementRepository.deleteMeasurement(id);
			response = "Deleted"; 
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public String deleteByResultsPerCard(Integer idResultsPerCard) {
		 String response = "";
		try {
			if(measurementRepository.deleteByResultsPerCardId(idResultsPerCard) > 0)
				response = "Deleted";
			else 
				response = "Error occurred while deleting";
			
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

}
