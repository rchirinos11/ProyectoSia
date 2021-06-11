package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.ImprovementPlan;
import pe.edu.pucp.sia.requests.CreateImprovementPlanRequest;
import pe.edu.pucp.sia.response.ImprovementPlanDataResponse;

public interface ImprovementPlanService {
	public Iterable<ImprovementPlan>  listAll();
	public Iterable<ImprovementPlanDataResponse> listBySpecialty(Integer id);
	public Integer createImprovementPlan(CreateImprovementPlanRequest c);
	public Integer updateImprovementPlan(CreateImprovementPlanRequest i);
	public String deleteImprovementPlan(Integer id);
}