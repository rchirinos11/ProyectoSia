package pe.edu.pucp.sia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import pe.edu.pucp.sia.model.Measurement;

public interface MeasurementRepository extends CrudRepository<Measurement,Integer> {
	public Measurement findByPersonIdAndResultsPerCardId(Integer idPerson, Integer idResultPerCard);
	@Query(value = "call sp_find_delete_multiple_measurement(:in_id_results_per_card)", nativeQuery = true)
	public List<Measurement> findDeleteMultipleMeasurement(@Param("in_id_results_per_card") Integer idResultsPerCard);
	
	@Procedure("sp_delete_measurement")
	public void deleteMeasurement(Integer id);
	@Procedure("sp_delete_measurement_by_result")
	public Integer deleteByResultsPerCardId(Integer idResultsPerCard);
	@Procedure("sp_remove_relation_measurement_with_id_result_per_card")
	public void removeByResultsPerCardId(Integer idResultsPerCard);
	

}
