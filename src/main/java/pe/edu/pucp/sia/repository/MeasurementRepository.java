package pe.edu.pucp.sia.repository;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import pe.edu.pucp.sia.model.Measurement;

public interface MeasurementRepository extends CrudRepository<Measurement,Integer> {
	@Procedure("sp_delete_measurement")
	public void deleteMeasurement(Integer id);
	public Measurement findByPersonIdAndResultsPerCardId(Integer idPerson, Integer idResultPerCard);
}
