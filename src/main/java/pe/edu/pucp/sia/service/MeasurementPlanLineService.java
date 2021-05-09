package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.MeasurementPlanLine;

public interface MeasurementPlanLineService {
	public Iterable<MeasurementPlanLine> listAll();
	public String createMeasurementPlanLine(MeasurementPlanLine m);
	public String updateMeasurementPlanLine(MeasurementPlanLine m);
	public String deleteMeasurementPlanLine(Integer id);
}
