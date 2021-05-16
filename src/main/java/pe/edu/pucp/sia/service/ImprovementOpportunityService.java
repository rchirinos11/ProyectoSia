package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.ImprovementOpportunity;

public interface ImprovementOpportunityService {
	public Iterable<ImprovementOpportunity>  listAll();
	public Integer createImprovementOpportunity(ImprovementOpportunity i);
	public Integer updateImprovementOpportunity(ImprovementOpportunity i);
	public String deleteImprovementOpportunity(Integer id);
}