package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.ResultsPerCard;
import pe.edu.pucp.sia.requests.RegisterStudentMeditionsRequest;

public interface ResultsPerCardService {
	public Iterable<ResultsPerCard> listAll();
	public Iterable<ResultsPerCard> listByMeasurementPlanLine(Integer id);
	public Integer createResultsPerCard(ResultsPerCard r);
	public Integer updateResultsPerCard(ResultsPerCard r);
	public String deleteResultsPerCard(Integer id);
	public Integer registerStudentMeditions(RegisterStudentMeditionsRequest rq);
}
