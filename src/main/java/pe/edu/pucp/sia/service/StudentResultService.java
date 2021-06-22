package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.StudentResult;
import pe.edu.pucp.sia.response.ApiResponse;

public interface StudentResultService {
	public ApiResponse listAll();
	public ApiResponse listBySpecialty(Integer id);
	public ApiResponse listBySpecialtyPlusIndicator(Integer id);
	public ApiResponse listBySpecialtyPlusAchievementPercentage(Integer id);
	public ApiResponse createStudentResult(StudentResult sr);
	public ApiResponse updateStudentResult(StudentResult sr);
	public ApiResponse deleteStudentResult(Integer id);
}
