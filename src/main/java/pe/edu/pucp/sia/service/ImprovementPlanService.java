package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.ImprovementPlan;
import pe.edu.pucp.sia.response.ImprovementPlanDataResponse;

public interface ImprovementPlanService {
	public Iterable<ImprovementPlan>  listAll();
	public Iterable<ImprovementPlanDataResponse> listBySpecialty(Integer id);
	public Integer createImprovementPlan(ImprovementPlan i);
	public Integer updateImprovementPlan(ImprovementPlan i);
	public String deleteImprovementPlan(Integer id);
}