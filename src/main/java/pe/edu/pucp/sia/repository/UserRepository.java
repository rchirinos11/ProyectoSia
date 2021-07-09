package pe.edu.pucp.sia.repository;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import pe.edu.pucp.sia.model.User;

public interface UserRepository extends CrudRepository<User,Integer>{
	@Procedure("sp_register_user")
	public int registerUser(Integer idPerson, String username, String password, Integer idFaculty);
	
	@Procedure("sp_delete_user")
	public void deleteUser(Integer idUser);
	
	@Procedure("sp_update_user")
	public int updateUser(Integer idPerson, String username, String password, Integer idFaculty);
	
	@Procedure("sp_login")
	public int authenticate(String username, String password);

}