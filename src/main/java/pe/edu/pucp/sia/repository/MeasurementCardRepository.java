package pe.edu.pucp.sia.repository;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import pe.edu.pucp.sia.model.MeasurementCard;

public interface MeasurementCardRepository extends CrudRepository<MeasurementCard,Integer>{
	@Procedure("sp_delete_measurement_card")
	public void deleteMeasurementCard(Integer id);
}
