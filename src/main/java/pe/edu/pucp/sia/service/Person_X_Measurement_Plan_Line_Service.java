package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.Person_X_Measurement_Plan_Line;

public interface Person_X_Measurement_Plan_Line_Service {
	public Iterable<Person_X_Measurement_Plan_Line>  listAll();
	public Integer createPxM(Person_X_Measurement_Plan_Line ld);
	public Integer updatePxM(Person_X_Measurement_Plan_Line ld);
	public String deletePxM(Integer id);

}
