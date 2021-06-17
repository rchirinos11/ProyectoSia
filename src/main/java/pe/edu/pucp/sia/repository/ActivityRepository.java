package pe.edu.pucp.sia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import pe.edu.pucp.sia.model.Activity;
import pe.edu.pucp.sia.model.ImprovementProposal;
import pe.edu.pucp.sia.model.State;

public interface ActivityRepository extends CrudRepository<Activity, Integer>{
	public List<Activity> findByImprovementProposalId(Integer id);
	@Query("select a from Activity a where (a.semesterStart.year*10 + a.semesterStart.number) >= ?1 and (a.semesterEnd.year*10 + a.semesterEnd.number) <= ?2 and a.improvementProposal in ?3 and a.state in ?4 order by a.improvementProposal.improvementPlan.id desc, a.improvementProposal.id desc")
	public List<Activity> listByActivityStatesAndSemesters(Integer id1,Integer id2,Iterable<ImprovementProposal> i,Iterable<State> states);
	@Procedure("sp_delete_activity")
	public void deleteActivity(Integer id);
	@Procedure("sp_reactivate_activity")
	public void reactivateActivity(Integer id);
}