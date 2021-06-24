package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.Faculty;
import pe.edu.pucp.sia.response.ApiResponse;

public interface FacultyService {
	public ApiResponse listAll();
	public ApiResponse listByCoordinator(Integer id);
	public ApiResponse createFaculty(Faculty f);
	public ApiResponse updateFaculty(Faculty f);
	public ApiResponse deleteFaculty(Integer id);
	public ApiResponse updateCoordinator(Integer idFaculty, Integer idCoordinator);
	public ApiResponse archiveFaculty(Integer idFaculty, boolean state);
}
