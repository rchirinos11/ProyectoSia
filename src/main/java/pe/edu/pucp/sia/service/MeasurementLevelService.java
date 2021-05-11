package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.Evidence;

public class MeasurementLevelService {
    public Iterable<MeasurementLevel> listAll();
	public int createMeasurementLevel(MeasurementLevel m);
	public int deleteMeasurementLevel(Integer id);
	public int updateMeasurementLevel(MeasurementLevel m);    
}