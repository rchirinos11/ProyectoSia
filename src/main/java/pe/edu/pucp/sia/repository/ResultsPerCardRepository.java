package pe.edu.pucp.sia.repository;

import java.util.List;

import org.springframework.boot.context.properties.source.ConfigurationPropertyName.Form;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import pe.edu.pucp.sia.model.ResultsPerCard;

public interface ResultsPerCardRepository extends CrudRepository <ResultsPerCard,Integer>{
	public List<ResultsPerCard> findByMeasurementPlanLineId(Integer id);
	public List<ResultsPerCard> findBySectionIdAndMeasurementPlanLineId(Integer idSection,Integer idMeasurementPlanLine);
	public List<ResultsPerCard> findBySectionCodeAndMeasurementPlanLineId(Integer code,Integer idMeasurementPlanLine);
	public List<ResultsPerCard> findByMeasurementPlanLineIndicatorStudentResultId(Integer id);
	public List<ResultsPerCard> findByMeasurementPlanLineIndicatorStudentResultSpecialtyIdAndMeasurementPlanLineSemesterId(
			Integer idSpecialty, Integer idSemester);

	@Procedure("sp_delete_results_per_card")
	public void deleteResultsPerCard(Integer id);
	
	@Procedure("sp_register_results_per_card")
	public void registerResultsPerCard(Integer id, Integer cantidad, Integer total34, float average, float percentage);
	
	@Query(value = "call sp_list_results_per_card_by_indicator(:in_id_indicator)", nativeQuery = true)
	public Float listResultsPerCardByIndicator(@Param("in_id_indicator") Integer idIndicator);
	
	@Query(value = "call sp_update_percentage_results_per_card(:in_id_semester,:in_id_specialty,:in_id_results_per_card)", nativeQuery = true)
	public void updatePercentageResutlsPerCard(@Param("in_id_semester") Integer idSemester,@Param("in_id_specialty") Integer idSpecialty,@Param("in_id_results_per_card") Integer idResultsPerCard);
	
	@Query(value = "call sp_list_results_per_card_by_indicator_all(:in_id_indicator)", nativeQuery = true)
	public List<ResultsPerCard> listResultsPerCardByIndicatorAll(@Param("in_id_indicator") Integer idIndicator);
	
	@Query(value = "call sp_evalute_student_result_total_measured(:in_id_results_per_card)", nativeQuery = true)
	public Float evaluaStudentResultTotalMeasured(@Param("in_id_results_per_card") Integer idResultsPerCard);
	
	
}
