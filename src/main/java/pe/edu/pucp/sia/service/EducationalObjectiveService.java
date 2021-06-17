package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.EducationalObjective;
import pe.edu.pucp.sia.response.ApiResponse;

public interface EducationalObjectiveService {
	public ApiResponse listAll();
	public ApiResponse createEducationalObjective(EducationalObjective eo);
	public ApiResponse updateEducationalObjective(EducationalObjective eo);
	public ApiResponse deleteEducationalObjective(Integer id);
}
