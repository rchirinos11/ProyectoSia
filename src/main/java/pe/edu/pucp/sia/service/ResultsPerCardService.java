package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.ResultsPerCard;

public interface ResultsPerCardService {
	public Iterable<ResultsPerCard> listAll();
	public Integer createResultsPerCard(ResultsPerCard r);
	public Integer updateResultsPerCard(ResultsPerCard r);
	public String deleteResultsPerCard(Integer id);

}