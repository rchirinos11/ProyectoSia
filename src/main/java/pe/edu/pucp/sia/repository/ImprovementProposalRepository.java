package pe.edu.pucp.sia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import pe.edu.pucp.sia.model.ImprovementProposal;

public interface ImprovementProposalRepository extends CrudRepository<ImprovementProposal, Integer>{
	public List<ImprovementProposal> findByImprovementPlanId(Integer id);
	@Procedure("sp_delete_improvement_proposal")
	public void deleteImprovementProposal(Integer id);
}