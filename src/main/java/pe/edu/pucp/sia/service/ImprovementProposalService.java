package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.ImprovementProposal;
import pe.edu.pucp.sia.response.ApiResponse;

public interface ImprovementProposalService {
	public ApiResponse listAll();
	public ApiResponse listByImprovementPlan(Integer id);
	public ApiResponse createImprovementProposal(ImprovementProposal i);
	public ApiResponse updateImprovementProposal(ImprovementProposal i);
	public ApiResponse deleteImprovementProposal(Integer id);
}