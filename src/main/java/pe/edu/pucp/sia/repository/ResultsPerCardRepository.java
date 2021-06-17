package pe.edu.pucp.sia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import pe.edu.pucp.sia.model.ResultsPerCard;

public interface ResultsPerCardRepository extends CrudRepository <ResultsPerCard,Integer>{
	public List<ResultsPerCard> findByMeasurementPlanLineId(Integer id);
	public List<ResultsPerCard> findBySectionIdAndMeasurementPlanLineId(Integer idSection,Integer idMeasurementPlanLine);
	
	@Procedure("sp_delete_results_per_card")
	public void deleteResultsPerCard(Integer id);
	
	@Procedure("sp_register_results_per_card")
	public void registerResultsPerCard(Integer id, Integer total, float average, float percentage);
	
}
