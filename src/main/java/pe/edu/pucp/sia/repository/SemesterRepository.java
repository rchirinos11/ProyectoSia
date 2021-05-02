package pe.edu.pucp.sia.repository;

import org.springframework.data.repository.CrudRepository;

import pe.edu.pucp.sia.model.Semester;

public interface SemesterRepository extends CrudRepository<Semester, Integer>{
}