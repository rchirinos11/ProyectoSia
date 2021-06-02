package pe.edu.pucp.sia.repository;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import pe.edu.pucp.sia.model.Section_X_Measurement_Plan_Line;

public interface Section_X_Measurement_Plan_Line_Repository extends CrudRepository <Section_X_Measurement_Plan_Line,Integer> {
	@Procedure("sp_delete_section_x_measurement_plan_line")
	public void deleteSxM(Integer id);
}
