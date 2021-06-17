package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.EducationalObjective;
import pe.edu.pucp.sia.repository.EducationalObjectiveRepository;
import pe.edu.pucp.sia.response.ApiResponse;
import pe.edu.pucp.sia.service.EducationalObjectiveService;

@Service
public class EducationalObjectiveServiceImpl implements EducationalObjectiveService{
	@Autowired
	private EducationalObjectiveRepository educationalObjectiveRepository;
	
	@Override
	public ApiResponse listAll() {
		ApiResponse response = null;
		try {
			Iterable<EducationalObjective> list = educationalObjectiveRepository.findAll();
			response = new ApiResponse(list, 200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse createEducationalObjective(EducationalObjective eo) {
		ApiResponse response = null;
		try {
			Integer id = educationalObjectiveRepository.save(eo).getId();
			response = new ApiResponse(id, 201);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse updateEducationalObjective(EducationalObjective eo) {
		ApiResponse response = null;
		try {
			Integer id = educationalObjectiveRepository.save(eo).getId();
			response = new ApiResponse(id, 200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse deleteEducationalObjective(Integer id) {
		ApiResponse response = null;
		try {
			educationalObjectiveRepository.deleteById(id);
			response = new ApiResponse("Success",200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

}
