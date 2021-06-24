package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.requests.CreateImprovementPlanRequest;
import pe.edu.pucp.sia.response.ApiResponse;
import pe.edu.pucp.sia.requests.ImprovementPlanActivityRequest;

public interface ImprovementPlanService {
	public ApiResponse listAll();
	public ApiResponse listBySpecialty(Integer id);
	public ApiResponse createImprovementPlan(CreateImprovementPlanRequest c);
	public ApiResponse listByActivityStatesAndSemesters(ImprovementPlanActivityRequest i);
	public ApiResponse updateImprovementPlan(CreateImprovementPlanRequest i);
	public ApiResponse deleteImprovementPlan(Integer id);
}

