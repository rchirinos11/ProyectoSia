package pe.edu.pucp.sia.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import pe.edu.pucp.sia.model.MeasurementLevel;

public interface MeasurementLevelRepository extends CrudRepository <MeasurementLevel,Integer>{
	public List<MeasurementLevel> findBySpecialtyId(Integer id);
}