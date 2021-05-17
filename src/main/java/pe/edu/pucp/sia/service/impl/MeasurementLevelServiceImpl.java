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
	public Integer createMeasurementLevel(MeasurementLevel ml) {
		Integer response =0;
		try {
			response=measurementLevelRepository.save(ml).getId();
			
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public Integer updateMeasurementLevel(MeasurementLevel ml) {
		Integer response =0;
		try {
			response=measurementLevelRepository.save(ml).getId();
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public String deleteMeasurementLevel(Integer id) {
		String response = "";
		try {
			measurementLevelRepository.deleteMeasurementLevel(id);
			response = "Deleted"; 
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public Iterable<MeasurementLevel> listBySpecialty(Integer id) {
		Iterable<MeasurementLevel> lista = measurementLevelRepository.findBySpecialtyId(id);
		for (MeasurementLevel ml : lista) {
			ml.setSpecialty(null);
		}
		return lista;
	}

}
