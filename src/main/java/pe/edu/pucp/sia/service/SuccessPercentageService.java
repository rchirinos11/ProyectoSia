package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.SuccessPercentage;
import pe.edu.pucp.sia.response.ApiResponse;

public interface SuccessPercentageService {
	public ApiResponse listAll();
	public ApiResponse listBySpecialtySemester(Integer idSpecialty, Integer idSemester);
	public ApiResponse createSuccessPercentage(SuccessPercentage sp);
	public ApiResponse updateSuccessPercentage(SuccessPercentage sp);
	public ApiResponse deleteSuccessPercentage(Integer id);
}
