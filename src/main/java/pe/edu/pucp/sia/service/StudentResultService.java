package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.StudentResult;
import pe.edu.pucp.sia.requests.MPlanLineSpecialtySemesterRequest;
import pe.edu.pucp.sia.response.ApiResponse;

public interface StudentResultService {
	public ApiResponse listAll();
	public ApiResponse listBySemester(Integer idSemester);
	public ApiResponse listBySpecialtySemester(MPlanLineSpecialtySemesterRequest lss);
	public ApiResponse listBySpecialtySemesterPlusIndicator(MPlanLineSpecialtySemesterRequest lss);
	public ApiResponse listBySpecialtySemesterPlusAchievementPercentage(MPlanLineSpecialtySemesterRequest lss);
	public ApiResponse createStudentResult(StudentResult sr);
	public ApiResponse updateStudentResult(StudentResult sr);
	public ApiResponse deleteStudentResult(Integer id);
}
