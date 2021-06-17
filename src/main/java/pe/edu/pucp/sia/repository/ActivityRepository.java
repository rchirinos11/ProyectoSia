package pe.edu.pucp.sia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import pe.edu.pucp.sia.model.Activity;
import pe.edu.pucp.sia.model.ImprovementPlan;
import pe.edu.pucp.sia.model.ImprovementProposal;
import pe.edu.pucp.sia.model.State;

public interface ActivityRepository extends CrudRepository<Activity, Integer>{
	public List<Activity> findByImprovementProposalId(Integer id);
	public List<Activity> findBySemesterStartIdAndSemesterEndIdAndImprovementProposalInAndStateInOrderByImprovementProposalImprovementPlanIdDescImprovementProposalDesc(Integer id,Integer id2,Iterable<ImprovementProposal> i,Iterable<State> states);
	public List<Activity> findBySemesterStartIdAndImprovementProposalInAndStateInOrderByImprovementProposalImprovementPlanIdDescImprovementProposalDesc(Integer id,Iterable<ImprovementProposal> i,Iterable<State> states);
	public List<Activity> findBySemesterEndIdAndImprovementProposalInAndStateInOrderByImprovementProposalImprovementPlanIdDescImprovementProposalDesc(Integer id,Iterable<ImprovementProposal> i,Iterable<State> states);
	public List<Activity> findByImprovementProposalInAndStateInOrderByImprovementProposalImprovementPlanIdDescImprovementProposalDesc(Iterable<ImprovementProposal> i,Iterable<State> states);
	@Procedure("sp_delete_activity")
	public void deleteActivity(Integer id);
	@Procedure("sp_reactivate_activity")
	public void reactivateActivity(Integer id);
}