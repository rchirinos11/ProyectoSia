package pe.edu.pucp.sia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import pe.edu.pucp.sia.model.Activity;

public interface ActivityRepository extends CrudRepository<Activity, Integer>{
	public List<Activity> findByImprovementProposalId(Integer id);
	@Procedure("sp_delete_activity")
	public void deleteActivity(Integer id);
	@Procedure("sp_reactivate_activity")
	public void reactivateActivity(Integer id);
}