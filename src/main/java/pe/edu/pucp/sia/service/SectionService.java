package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.Section;

public interface SectionService {
    public Iterable<Section> listAll();
    public Iterable<Section> listByMeasurementPlanLine(Integer idMeasurementPlanLine);
	public int createSection(Section s);
	public int deleteSection(Integer id);
	public int updateSection(Section s);    
}