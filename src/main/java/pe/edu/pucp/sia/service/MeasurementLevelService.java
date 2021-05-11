package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.MeasurementLevel;

public interface MeasurementLevelService {
	public Iterable<MeasurementLevel> listAll();
	public String createMeasurementLevel(MeasurementLevel ml);
	public String updateMeasurementLevel(MeasurementLevel ml);
	public String deleteMeasurementLevel(Integer id);
}
