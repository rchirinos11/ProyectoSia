package pe.edu.pucp.sia.repository;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import pe.edu.pucp.sia.model.ImprovementProposal;

public interface ImprovementProposalRepository extends CrudRepository<ImprovementProposal, Integer>{
	@Procedure("sp_delete_improvement_proposal")
	public void deleteImprovementProposal(Integer id);
}