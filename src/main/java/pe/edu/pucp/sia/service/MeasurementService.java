package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.Measurement;

public interface MeasurementService {
	public Iterable<Measurement>  listAll();
	public String createMeasurement(Measurement m);
	public String updateMeasurement(Measurement m);
	public String deleteMeasurement(Integer id);

}
