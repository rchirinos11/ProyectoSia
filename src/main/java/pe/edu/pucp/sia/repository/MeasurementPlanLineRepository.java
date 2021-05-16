package pe.edu.pucp.sia.repository;

import org.springframework.data.repository.CrudRepository;

import pe.edu.pucp.sia.model.MeasurementPlanLine;

public interface MeasurementPlanLineRepository extends CrudRepository<MeasurementPlanLine, Integer>{
	public Iterable<MeasurementPlanLine> findByCourseId(Integer id);
}
