package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.ImprovementProposal;

public interface ImprovementProposalService {
	public Iterable<ImprovementProposal>  listAll();
	public String createImprovementProposal(ImprovementProposal i);
	public String updateImprovementProposal(ImprovementProposal i);
	public String deleteImprovementProposal(Integer id);
}