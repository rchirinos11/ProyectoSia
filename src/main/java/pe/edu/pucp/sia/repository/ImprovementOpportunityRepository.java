package pe.edu.pucp.sia.repository;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import pe.edu.pucp.sia.model.ImprovementOpportunity;

public interface ImprovementOpportunityRepository extends CrudRepository<ImprovementOpportunity, Integer>{
	@Procedure("sp_delete_improvement_opportunity")
	public void deleteImprovementOpportunity(Integer id);
}