package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.Semester;
import pe.edu.pucp.sia.response.ApiResponse;

public interface SemesterService {
	public ApiResponse listAll();
	public ApiResponse createSemester(Semester s);
	public ApiResponse updateSemester(Semester s);
	public ApiResponse deleteSemester(Integer id);
	public ApiResponse updateCurrent(Integer id);
	public ApiResponse findCurrent();
}
