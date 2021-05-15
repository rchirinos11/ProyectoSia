package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.Indicator;

public interface IndicatorService {
    public Iterable<Indicator>  listAll();
	public Integer createIndicator(Indicator i);
	public Integer updateIndicator(Indicator i);
	public String deleteIndicator(Integer id);
}
