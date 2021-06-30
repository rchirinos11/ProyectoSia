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
	public ApiResponse copyBySpecialtySemester(Integer idSpecialtyFrom, Integer idSemesterFrom, Integer idSpecialtyTo, Integer idSemesterTo);
	public ApiResponse listBySemestersPlusAchievementPercentage(Integer id_semester_start, Integer id_semester_end);
}
