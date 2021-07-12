package pe.edu.pucp.sia.service;

import java.util.List;

import pe.edu.pucp.sia.model.ResultsPerCard;
import pe.edu.pucp.sia.response.ApiResponse;

public interface ResultsPerCardService {
	public ApiResponse listAll();
	public ApiResponse listByMeasurementPlanLine(Integer id);
	public ApiResponse createResultsPerCard(ResultsPerCard r);
	public ApiResponse updateResultsPerCard(ResultsPerCard r);
	public ApiResponse deleteResultsPerCard(Integer id);
	public ApiResponse registerStudentMeditions(ResultsPerCard r);
	public ApiResponse promPercentageByStudentResult(Integer id);
	public ApiResponse updateEvidences(Integer id, List<String> evidences);
}
