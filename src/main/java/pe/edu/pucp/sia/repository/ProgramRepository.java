package pe.edu.pucp.sia.repository;

import org.springframework.data.repository.CrudRepository;

import pe.edu.pucp.sia.model.Program;

public interface ProgramRepository extends CrudRepository<Program,Integer> {
    
}
