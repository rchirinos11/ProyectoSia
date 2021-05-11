package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.MeasurementCard;

public interface MeasurementCardService {
	public Iterable<MeasurementCard> listAll();
	public String createMeasurementCard(MeasurementCard mc);
	public String updateMeasurementCard(MeasurementCard mc);
	public String deleteMeasurementCard(Integer id);
}
