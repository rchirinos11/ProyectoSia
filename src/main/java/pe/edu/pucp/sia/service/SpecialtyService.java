package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.Specialty;
import pe.edu.pucp.sia.response.ApiResponse;

public interface SpecialtyService {
	public ApiResponse listAll();
	public ApiResponse listByFaculty(Integer id);
	public ApiResponse listByCoordinator(Integer id);
	public ApiResponse listByAssistant(Integer id);
	public ApiResponse createSpecialty(Specialty s);
	public ApiResponse updateSpecialty(Specialty s);
	public ApiResponse deleteSpecialty(Integer id);
	public ApiResponse updateCoordinator(Integer idSpecialty, Integer idCoordinator);
	public ApiResponse updateAssitant(Integer idSpecialty, Integer idAssistant);
	public ApiResponse updatePercentage(Integer idSpecialty, Integer successPercentage);
	public ApiResponse archiveSpecialty(Integer idSpecialty, boolean state);
	
}
