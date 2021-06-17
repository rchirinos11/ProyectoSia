package pe.edu.pucp.sia.service;

import java.util.List;

import pe.edu.pucp.sia.model.Indicator;
import pe.edu.pucp.sia.response.ApiResponse;

public interface IndicatorService {
    public ApiResponse listAll();
	public ApiResponse listBySpecialty(Integer id);
	public ApiResponse listByStudentResult(Integer id);
	public ApiResponse createIndicator(Indicator i);
	public ApiResponse updateIndicator(Indicator i);
	public ApiResponse deleteIndicator(Integer id);
}
