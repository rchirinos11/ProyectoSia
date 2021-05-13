package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.MeasurementCard;
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
			response=measurementCardRepository.save(mc).getIdMeasurementCard();
					} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public Integer updateMeasurementCard(MeasurementCard mc) {
		Integer response =0;
		try {
			response=measurementCardRepository.save(mc).getIdMeasurementCard();
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
