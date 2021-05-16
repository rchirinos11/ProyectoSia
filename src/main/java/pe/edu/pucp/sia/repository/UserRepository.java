package pe.edu.pucp.sia.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.pucp.sia.model.User;

public interface UserRepository extends CrudRepository<User,Integer>{

}