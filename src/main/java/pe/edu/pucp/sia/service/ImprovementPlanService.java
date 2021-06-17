package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.Activity;
import pe.edu.pucp.sia.model.ImprovementPlan;
import pe.edu.pucp.sia.requests.CreateImprovementPlanRequest;
import pe.edu.pucp.sia.requests.ImprovementPlanActivityRequest;
import pe.edu.pucp.sia.response.ImprovementPlanDataResponse;
import pe.edu.pucp.sia.response.ImprovementPlanDataResponseList;

public interface ImprovementPlanService {
	public Iterable<ImprovementPlan>  listAll();
	public Iterable<ImprovementPlanDataResponse> listBySpecialty(Integer id);
	public Iterable<ImprovementPlanDataResponseList> listByActivityStatesAndSemesters(ImprovementPlanActivityRequest i);
	public Integer createImprovementPlan(CreateImprovementPlanRequest c);
	public Integer updateImprovementPlan(CreateImprovementPlanRequest i);
	public String deleteImprovementPlan(Integer id);
}