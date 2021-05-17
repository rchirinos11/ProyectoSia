package pe.edu.pucp.sia.repository;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import pe.edu.pucp.sia.model.State;

public interface StateRepository extends CrudRepository<State, Integer>{
	@Procedure("sp_delete_state")
	public void deleteState(Integer id);
}