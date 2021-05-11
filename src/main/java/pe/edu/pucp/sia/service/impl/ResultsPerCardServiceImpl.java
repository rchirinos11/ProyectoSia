package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public String createResultsPerCard(ResultsPerCard r) {
		String response = "";
		try {
			resultsPerCardRepository.save(r);
			response = "Created"; 
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public String updateResultsPerCard(ResultsPerCard r) {
		String response = "";
		try {
			resultsPerCardRepository.save(r);
			response = "Updated"; 
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public String deleteResultsPerCard(Integer id) {
		String response = "";
		try {
			resultsPerCardRepository.deleteById(id);
			response = "Deleted"; 
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

}
