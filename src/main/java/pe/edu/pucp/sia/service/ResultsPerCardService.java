package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.ResultsPerCard;

public interface ResultsPerCardService {
	public Iterable<ResultsPerCard> listAll();
	public String createResultsPerCard(ResultsPerCard r);
	public String updateResultsPerCard(ResultsPerCard r);
	public String deleteResultsPerCard(Integer id);

}
