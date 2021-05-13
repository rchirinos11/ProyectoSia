package pe.edu.pucp.sia.repository;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import pe.edu.pucp.sia.model.Semester;

public interface SemesterRepository extends CrudRepository<Semester, Integer>{
	@Procedure("change_current_semester")
	public int changeCurrentSemester(Integer id);
}