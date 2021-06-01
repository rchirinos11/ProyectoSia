package pe.edu.pucp.sia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import pe.edu.pucp.sia.model.ImprovementPlan;

public interface ImprovementPlanRepository extends CrudRepository<ImprovementPlan, Integer>{
	public List<ImprovementPlan> findBySpecialtyId(Integer id);
	@Procedure("sp_delete_improvement_plan")
	public void deleteImprovementPlan(Integer id);
}