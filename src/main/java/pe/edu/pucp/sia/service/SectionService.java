package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.Section;
import pe.edu.pucp.sia.response.ApiResponse;

public interface SectionService {
    public ApiResponse listAll();
    public ApiResponse listByMeasurementPlanLine(Integer idMeasurementPlanLine);
	public ApiResponse createSection(Section s);
	public ApiResponse deleteSection(Integer id);
	public ApiResponse updateSection(Section s);    
}