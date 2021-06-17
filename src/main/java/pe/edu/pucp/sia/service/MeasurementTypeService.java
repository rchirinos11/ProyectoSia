package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.MeasurementType;
import pe.edu.pucp.sia.response.ApiResponse;

public interface MeasurementTypeService {
    public ApiResponse listAll();
	public ApiResponse createMeasurementType(MeasurementType m);
	public ApiResponse deleteMeasurementType(Integer id);
	public ApiResponse updateMeasurementType(MeasurementType m);    
}