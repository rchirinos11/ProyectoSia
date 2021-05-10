package pe.edu.pucp.sia.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.pucp.sia.model.Activity;

public interface ActivityRepository extends CrudRepository<Activity, Integer>{
}