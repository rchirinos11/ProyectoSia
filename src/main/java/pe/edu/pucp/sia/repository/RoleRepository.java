package pe.edu.pucp.sia.repository;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import pe.edu.pucp.sia.model.Role;
public interface RoleRepository extends CrudRepository<Role, Integer>{
	public Iterable<Role> findByPersonListEmail(String email);
	public Role findByDescription(String description);
	
	@Procedure("sp_assign_role")
	public void assignRole(Integer idRole,Integer idPerson);
	@Procedure("sp_unassign_teacher")
	public void unassignTeacher(Integer idTeacher);
}
