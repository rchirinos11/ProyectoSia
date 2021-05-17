package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.Section;
import pe.edu.pucp.sia.repository.SectionRepository;
import pe.edu.pucp.sia.service.SectionService;

@Service
public class SectionServiceImpl implements SectionService{
	
	@Autowired
	private SectionRepository sectionRepository;
	
	@Override
	public Iterable<Section> listAll() {
		return sectionRepository.findAll();
	}

	@Override
	public int createSection(Section s) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteSection(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateSection(Section s) {
		// TODO Auto-generated method stub
		return 0;
	}

}
