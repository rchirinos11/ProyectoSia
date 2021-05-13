package pe.edu.pucp.sia.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.pucp.sia.model.User;
import pe.edu.pucp.sia.model.EducationalObjective;

public interface UserRepository extends CrudRepository<User,Integer>{

}