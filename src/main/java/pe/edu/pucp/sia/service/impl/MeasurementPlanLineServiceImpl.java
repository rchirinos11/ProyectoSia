package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.MeasurementPlanLine;
import pe.edu.pucp.sia.repository.MeasurementPlanLineRepository;
import pe.edu.pucp.sia.service.MeasurementPlanLineService;

@Service
public class MeasurementPlanLineServiceImpl implements MeasurementPlanLineService{
	@Autowired
	private MeasurementPlanLineRepository mPlanLineRepository;

	@Override
	public Iterable<MeasurementPlanLine> listAll() {
		return mPlanLineRepository.findAll();
	}

	@Override
	public String createMeasurementPlanLine(MeasurementPlanLine m) {
		String response = "";
		try {
			mPlanLineRepository.save(m);
			response = "Created";
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public String updateMeasurementPlanLine(MeasurementPlanLine m) {
		String response = "";
		try {
			mPlanLineRepository.save(m);
			response = "Updated";
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public String deleteMeasurementPlanLine(Integer id) {
		String response = "";
		try {
			mPlanLineRepository.deleteById(id);
			response = "Deleted";
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}
	
	
}
