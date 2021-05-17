package pe.edu.pucp.sia.repository;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import pe.edu.pucp.sia.model.Activity;

public interface ActivityRepository extends CrudRepository<Activity, Integer>{
	@Procedure("sp_delete_activity")
	public void deleteActivity(Integer id);
}