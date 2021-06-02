package pe.edu.pucp.sia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import pe.edu.pucp.sia.model.ResultsPerCard;

public interface ResultsPerCardRepository extends CrudRepository <ResultsPerCard,Integer>{
	public List<ResultsPerCard> findByMeasurementPlanLineId(Integer id);
	
	@Procedure("sp_delete_results_per_card")
	public void deleteResultsPerCard(Integer id);
}
