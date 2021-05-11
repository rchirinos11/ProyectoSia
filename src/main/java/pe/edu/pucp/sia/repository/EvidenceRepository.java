package pe.edu.pucp.sia.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.pucp.sia.model.Evidence;

import pe.edu.pucp.sia.model.EducationalObjective;

public interface EvidenceRepository extends CrudRepository<Evidence,Integer>{

}