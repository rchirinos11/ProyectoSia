package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.Measurement;

public interface MeasurementService {
	public Iterable<Measurement>  listAll();
	public Integer createMeasurement(Measurement m);
	public Integer updateMeasurement(Measurement m);
	public String deleteMeasurement(Integer id);

}
