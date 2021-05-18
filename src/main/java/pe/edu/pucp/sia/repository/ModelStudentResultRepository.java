package pe.edu.pucp.sia.repository;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import pe.edu.pucp.sia.model.ModelStudentResult;

public interface ModelStudentResultRepository extends CrudRepository<ModelStudentResult,Integer> {
    @Procedure("sp_delete_model_student_result")
	public void deleteModelStudentResult(Integer id); 
}
