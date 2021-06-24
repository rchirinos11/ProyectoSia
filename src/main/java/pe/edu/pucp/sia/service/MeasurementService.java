package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.Measurement;
import pe.edu.pucp.sia.response.ApiResponse;

public interface MeasurementService {
	public ApiResponse  listAll();
	public ApiResponse createMeasurement(Measurement m);
	public ApiResponse updateMeasurement(Measurement m);
	public ApiResponse deleteMeasurement(Integer id);
	public ApiResponse deleteByResultsPerCard(Integer idResultsPerCard);

}
