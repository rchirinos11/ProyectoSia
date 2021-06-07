package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.ImprovementProposal;
import pe.edu.pucp.sia.requests.CreateImprovementProposalRequest;

public interface ImprovementProposalService {
	public Iterable<ImprovementProposal>  listAll();
	public Iterable<ImprovementProposal> listByImprovementPlan(Integer id);
	public Integer createImprovementProposal(ImprovementProposal i);
	public Integer updateImprovementProposal(CreateImprovementProposalRequest i);
	public String deleteImprovementProposal(Integer id);
}