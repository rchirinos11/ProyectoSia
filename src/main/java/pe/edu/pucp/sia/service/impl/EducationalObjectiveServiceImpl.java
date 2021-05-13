package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.EducationalObjective;
import pe.edu.pucp.sia.repository.EducationalObjectiveRepository;
import pe.edu.pucp.sia.service.EducationalObjectiveService;

@Service
public class EducationalObjectiveServiceImpl implements EducationalObjectiveService{
	@Autowired
	private EducationalObjectiveRepository educationalObjectiveRepository;
	
	@Override
	public Iterable<EducationalObjective> listAll() {
		return educationalObjectiveRepository.findAll();
	}

	@Override
	public Integer createEducationalObjective(EducationalObjective eo) {
		Integer response = 0;
		try {
			response = educationalObjectiveRepository.save(eo).getId();
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public Integer updateEducationalObjective(EducationalObjective eo) {
		Integer response = 0;
		try {
			educationalObjectiveRepository.save(eo).getId();
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public String deleteEducationalObjective(Integer id) {
		String response = "";
		try {
			educationalObjectiveRepository.deleteById(id);
			response = "Deleted"; 
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

}
