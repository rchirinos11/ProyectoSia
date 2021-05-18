package pe.edu.pucp.sia.repository;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import pe.edu.pucp.sia.model.Program;

public interface ProgramRepository extends CrudRepository<Program,Integer> {
    @Procedure("sp_delete_program")
	public void deleteProgram(Integer id);  
}
