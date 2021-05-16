package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.Section;

public class SectionService {
    public Iterable<Section> listAll();
	public int createSection(Section s);
	public int deleteSection(Integer id);
	public int updateSection(Section s);    
}