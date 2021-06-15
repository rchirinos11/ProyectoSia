package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.MeasurementPlanLine;
import pe.edu.pucp.sia.model.Section;
import pe.edu.pucp.sia.repository.SectionRepository;
import pe.edu.pucp.sia.service.SectionService;

@Service
public class SectionServiceImpl implements SectionService{
	
	@Autowired
	private SectionRepository sectionRepository;
	
	@Override
	public Iterable<Section> listAll() {
		Iterable<Section> response = null;
		try {
			response = sectionRepository.findAll(); 
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public Integer createSection(Section s) {
		Integer response = null;
		try {
			response = sectionRepository.save(s).getId();
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public String deleteSection(Integer id) {
		String response = null;
		try {
			sectionRepository.deleteById(id);;
			response = "Deleted";
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public Integer updateSection(Section s) {
		Integer response = null;
		try {
			response = sectionRepository.save(s).getId();
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public Iterable<Section> listByMeasurementPlanLine(Integer idMeasurementPlanLine) {
		Iterable<Section> response = null;
		try {
			response = sectionRepository.listSectionByMeasurementPlanLine(idMeasurementPlanLine); 
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}		
		return response;
	}

}
