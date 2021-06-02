package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.MeasurementLevel;
import pe.edu.pucp.sia.model.ResultsPerCard;
import pe.edu.pucp.sia.repository.ResultsPerCardRepository;
import pe.edu.pucp.sia.service.ResultsPerCardService;

@Service
public class ResultsPerCardServiceImpl implements ResultsPerCardService{
	@Autowired
	private ResultsPerCardRepository resultsPerCardRepository;
	
	@Override
	public Iterable<ResultsPerCard> listAll() {
		return resultsPerCardRepository.findAll();
	}

	@Override
	public Integer createResultsPerCard(ResultsPerCard r) {
		Integer response =0;
		try {
			response=resultsPerCardRepository.save(r).getId();
			
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public Integer updateResultsPerCard(ResultsPerCard r) {
		Integer response =0;
		try {
			response=resultsPerCardRepository.save(r).getId();
					} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public String deleteResultsPerCard(Integer id) {
		String response = "";
		try {
			resultsPerCardRepository.deleteResultsPerCard(id);
			response = "Deleted"; 
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public Iterable<ResultsPerCard> listByMeasurementPlanLine(Integer id) {
		Iterable<ResultsPerCard> lista = resultsPerCardRepository.findByMeasurementPlanLineId(id);
		for (ResultsPerCard rc : lista) {
			rc.setMeasurementPlanLine(null);
		}
		return lista;
	}

}
