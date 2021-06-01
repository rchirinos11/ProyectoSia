package pe.edu.pucp.sia.repository;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import pe.edu.pucp.sia.model.ImprovementPlan;

public interface ImprovementPlanRepository extends CrudRepository<ImprovementPlan, Integer>{
	@Procedure("sp_delete_improvement_plan")
	public void deleteImprovementPlan(Integer id);
}