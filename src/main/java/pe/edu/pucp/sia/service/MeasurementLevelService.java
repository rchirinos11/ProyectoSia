package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.MeasurementLevel;
import pe.edu.pucp.sia.requests.MPlanLineSpecialtySemesterRequest;
import pe.edu.pucp.sia.response.ApiResponse;

public interface MeasurementLevelService {
	public ApiResponse listAll();
	public ApiResponse listBySemester(Integer idSemester);
	public ApiResponse listBySpecialtySemester(MPlanLineSpecialtySemesterRequest lss);
	public ApiResponse createMeasurementLevel(MeasurementLevel ml);
	public ApiResponse updateMeasurementLevel(MeasurementLevel ml);
	public ApiResponse updateCurrentMeasurementLevel(Integer id);
	public ApiResponse deleteMeasurementLevel(Integer id);
	public ApiResponse copyBySpecialtySemester(Integer idSpecialtyFrom, Integer idSemesterFrom, Integer idSpecialtyTo, Integer idSemesterTo);
}
