package pe.edu.pucp.sia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import pe.edu.pucp.sia.model.ImprovementPlan;
import pe.edu.pucp.sia.model.ImprovementProposal;

public interface ImprovementProposalRepository extends CrudRepository<ImprovementProposal, Integer>{
	public List<ImprovementProposal> findByImprovementPlanId(Integer id);
	public List<ImprovementProposal> findByImprovementPlanIn(Iterable<ImprovementPlan> i);
	@Procedure("sp_delete_improvement_proposal")
	public void deleteImprovementProposal(Integer id);
	@Procedure("sp_reactivate_improvement_proposal")
	public void reactivateImprovementProposal(Integer id);
}