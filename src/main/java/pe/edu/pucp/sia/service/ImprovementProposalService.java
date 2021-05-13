package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.ImprovementProposal;

public interface ImprovementProposalService {
	public Iterable<ImprovementProposal>  listAll();
	public Integer createImprovementProposal(ImprovementProposal i);
	public Integer updateImprovementProposal(ImprovementProposal i);
	public String deleteImprovementProposal(Integer id);
}