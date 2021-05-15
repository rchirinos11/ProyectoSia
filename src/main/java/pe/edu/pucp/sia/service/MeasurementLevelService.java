package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.MeasurementLevel;

public interface MeasurementLevelService {
	public Iterable<MeasurementLevel> listAll();
	public Iterable<MeasurementLevel> listBySpecialty(Integer id);
	public Integer createMeasurementLevel(MeasurementLevel ml);
	public Integer updateMeasurementLevel(MeasurementLevel ml);
	public String deleteMeasurementLevel(Integer id);
}
