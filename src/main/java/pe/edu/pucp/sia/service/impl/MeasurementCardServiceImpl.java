package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import pe.edu.pucp.sia.model.MeasurementCard;
import pe.edu.pucp.sia.repository.MeasurementCardRepository;
import pe.edu.pucp.sia.service.MeasurementCardService;

public class MeasurementCardServiceImpl implements MeasurementCardService{
	@Autowired
	private MeasurementCardRepository measurementCardRepository;
	
	@Override
	public Iterable<MeasurementCard> listAll() {
		return measurementCardRepository.findAll();
	}

	@Override
	public String createMeasurementCard(MeasurementCard mc) {
		String response = "";
		try {
			measurementCardRepository.save(mc);
			response = "Created"; 
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public String updateMeasurementCard(MeasurementCard mc) {
		String response = "";
		try {
			measurementCardRepository.save(mc);
			response = "Updated"; 
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public String deleteMeasurementCard(Integer id) {
		String response = "";
		try {
			measurementCardRepository.deleteById(id);
			response = "Deleted"; 
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}
	

}
