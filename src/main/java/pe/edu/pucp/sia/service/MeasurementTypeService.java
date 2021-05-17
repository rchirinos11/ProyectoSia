package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.MeasurementType;

public interface MeasurementTypeService {
    public Iterable<MeasurementType> listAll();
	public int createMeasurementType(MeasurementType m);
	public int deleteMeasurementType(Integer id);
	public int updateMeasurementType(MeasurementType m);    
}