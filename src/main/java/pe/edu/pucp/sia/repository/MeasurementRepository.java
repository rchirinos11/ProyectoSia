package pe.edu.pucp.sia.repository;

import org.springframework.data.repository.CrudRepository;

import pe.edu.pucp.sia.model.Measurement;

public interface MeasurementRepository extends CrudRepository<Measurement,Integer> {

}
