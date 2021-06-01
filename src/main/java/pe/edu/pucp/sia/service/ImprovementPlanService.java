package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.ImprovementPlan;

public interface ImprovementPlanService {
	public Iterable<ImprovementPlan>  listAll();
	public Integer createImprovementPlan(ImprovementPlan i);
	public Integer updateImprovementPlan(ImprovementPlan i);
	public String deleteImprovementPlan(Integer id);
}