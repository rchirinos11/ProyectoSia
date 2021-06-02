package pe.edu.pucp.sia.service;


import pe.edu.pucp.sia.model.Section_X_Measurement_Plan_Line;

public interface Section_X_Measurement_Plan_Line_Service {
	public Iterable<Section_X_Measurement_Plan_Line>  listAll();
	public Integer createSxM(Section_X_Measurement_Plan_Line ld);
	public Integer updateSxM(Section_X_Measurement_Plan_Line ld);
	public String deleteSxM(Integer id);
}
