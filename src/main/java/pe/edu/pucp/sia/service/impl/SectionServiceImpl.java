package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.MeasurementPlanLine;
import pe.edu.pucp.sia.model.Section;
import pe.edu.pucp.sia.repository.SectionRepository;
import pe.edu.pucp.sia.response.ApiResponse;
import pe.edu.pucp.sia.service.SectionService;

@Service
public class SectionServiceImpl implements SectionService{
	
	@Autowired
	private SectionRepository sectionRepository;
	
	@Override
	public ApiResponse listAll() {
		ApiResponse response = null;
		try {
			Iterable<Section> list = sectionRepository.findAll(); 
			response = new ApiResponse(list,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse createSection(Section s) {
		ApiResponse response = null;
		try {
			Integer id = sectionRepository.save(s).getId();
			response = new ApiResponse(id,201);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse deleteSection(Integer id) {
		ApiResponse response = null;
		try {
			sectionRepository.deleteById(id);;
			response = new ApiResponse("Success",200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse updateSection(Section s) {
		ApiResponse response = null;
		try {
			Integer id = sectionRepository.save(s).getId();
			response = new ApiResponse(id,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse listByMeasurementPlanLine(Integer idMeasurementPlanLine) {
		ApiResponse response = null;
		try {
			Iterable<Section> list = sectionRepository.listSectionByMeasurementPlanLine(idMeasurementPlanLine); 
			response = new ApiResponse(list,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}		
		return response;
	}

}
