package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.Specialty;
import pe.edu.pucp.sia.repository.SpecialtyRepository;
import pe.edu.pucp.sia.response.ApiResponse;
import pe.edu.pucp.sia.service.SpecialtyService;

@Service
public class SpecialtyServiceImpl implements SpecialtyService{
	@Autowired
	private SpecialtyRepository specialtyRepository;
	
	@Override
	public ApiResponse listAll(){
		ApiResponse response = null;
		 try {
			Iterable<Specialty> list = specialtyRepository.findAll();
		 	response = new ApiResponse(list,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse createSpecialty(Specialty s) {
		ApiResponse response = null;
		try {
			Integer id = specialtyRepository.save(s).getId();
			response = new ApiResponse(id,201);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse updateSpecialty(Specialty s) {
		ApiResponse response = null;
		try {
			Integer id = specialtyRepository.save(s).getId();
			response = new ApiResponse(id,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse deleteSpecialty(Integer id) {
		ApiResponse response = null;
		try {
			specialtyRepository.deleteSpecialty(id);
			response = new ApiResponse("Success",200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse listByFaculty(Integer id) {
		ApiResponse response = null;
		 try {
			Iterable<Specialty> list = specialtyRepository.findByFacultyId(id);
			for (Specialty specialty : list) {
				specialty.setFaculty(null);
			}
		 	response = new ApiResponse(list,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse listByCoordinator(Integer id) {
		ApiResponse response = null;
		 try {
			Iterable<Specialty> list = specialtyRepository.findByCoordinatorId(id);
			for (Specialty specialty : list) {
				specialty.setCoordinator(null);
			}
		 	response = new ApiResponse(list,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse listByAssistant(Integer id) {
		ApiResponse response = null;
		 try {
			Iterable<Specialty> list = specialtyRepository.findByAssistantId(id);
			for (Specialty specialty : list) {
				specialty.setAssistant(null);
			}
		 	response = new ApiResponse(list,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse updateCoordinator(Integer idSpecialty, Integer idCoordinator) {
		ApiResponse response = null;
		try {
			specialtyRepository.setCoordinator(idSpecialty,idCoordinator);
			response = new ApiResponse("Success",200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse updateAssitant(Integer idSpecialty, Integer idAssistant) {
		ApiResponse response = null;
		try {
			specialtyRepository.setAssistant(idSpecialty,idAssistant);
			response = new ApiResponse("Success",200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse updatePercentage(Integer idSpecialty, Integer percentage){
		ApiResponse response = null;
		try {
			specialtyRepository.setPercentage(idSpecialty,percentage);
			response = new ApiResponse("Success",200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}
}
