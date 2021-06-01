package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.Indicator;

public interface IndicatorService {
    public Iterable<Indicator>  listAll();
	public Iterable<Indicator> listBySpecialty(Integer id);
	public Integer createIndicator(Indicator i);
	public Integer updateIndicator(Indicator i);
	public String deleteIndicator(Integer id);
}
