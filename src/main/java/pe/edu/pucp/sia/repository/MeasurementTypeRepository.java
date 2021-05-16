package pe.edu.pucp.sia.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.pucp.sia.model.MeasurementType;
import pe.edu.pucp.sia.model.EducationalObjective;

public interface MeasurementTypeRepository extends CrudRepository<MeasurementType,Integer>{

}