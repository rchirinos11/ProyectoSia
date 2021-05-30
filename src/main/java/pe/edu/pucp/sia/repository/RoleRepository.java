package pe.edu.pucp.sia.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.pucp.sia.model.Role;
public interface RoleRepository extends CrudRepository<Role, Integer>{
	public Iterable<Role> findByPersonListEmail(String email);
}
