package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.Section;

public interface SectionService {
    public Iterable<Section> listAll();
    public Iterable<Section> listByMeasurementPlanLine(Integer idMeasurementPlanLine);
	public Integer createSection(Section s);
	public String deleteSection(Integer id);
	public Integer updateSection(Section s);    
}