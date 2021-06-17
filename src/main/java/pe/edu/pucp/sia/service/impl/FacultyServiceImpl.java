package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.Faculty;
import pe.edu.pucp.sia.model.Specialty;
import pe.edu.pucp.sia.repository.FacultyRepository;
import pe.edu.pucp.sia.response.ApiResponse;
import pe.edu.pucp.sia.service.FacultyService;

@Service
public class FacultyServiceImpl implements FacultyService{

	@Autowired
	private FacultyRepository facultyRepository;
	
	@Override
	public ApiResponse listAll() {
		ApiResponse response = null;
		try {
			Iterable<Faculty> list = facultyRepository.findAll();
			response = new ApiResponse(list, 200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse createFaculty(Faculty f) {
		ApiResponse response = null;
		try {
			Integer id = facultyRepository.save(f).getId();
			response = new ApiResponse(id, 201);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse updateFaculty(Faculty f) {
		ApiResponse response = null;
		try {
			Integer id = facultyRepository.save(f).getId();
			response = new ApiResponse(id, 200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse deleteFaculty(Integer id) {
		ApiResponse response = null;
		try {
			int x = facultyRepository.deleteFaculty(id);
			if(x==0)
				response = new ApiResponse("Success", 200);
			else
				response = new ApiResponse(409,"Cannot delete due to dependency");
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse listByCoordinator(Integer id) {
		ApiResponse response = null;
		try {
			Iterable<Faculty> list = facultyRepository.findByCoordinatorId(id);
			for (Faculty faculty : list)
				faculty.setCoordinator(null);
			response = new ApiResponse(list, 200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse updateCoordinator(Integer idFaculty, Integer idCoordinator) {
		ApiResponse response = null;
		try {
			facultyRepository.setCoordinator(idFaculty,idCoordinator);
			response = new ApiResponse("Success", 200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}
}
