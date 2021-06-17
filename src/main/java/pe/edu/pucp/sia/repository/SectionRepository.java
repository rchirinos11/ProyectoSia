package pe.edu.pucp.sia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import pe.edu.pucp.sia.model.Section;
import pe.edu.pucp.sia.model.Semester;


public interface SectionRepository extends CrudRepository<Section,Integer>{
	@Query(value = "call sp_list_section_by_measurement_plan_line(:in_id_measurement_plan_line)", nativeQuery = true)
	public Iterable<Section> listSectionByMeasurementPlanLine(@Param("in_id_measurement_plan_line") Integer idMeasurementPlanLine);
	
	public List<Section> findByCode(Integer code);
}