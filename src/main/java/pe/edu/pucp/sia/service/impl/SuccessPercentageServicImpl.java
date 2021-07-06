package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.Activity;
import pe.edu.pucp.sia.model.SuccessPercentage;
import pe.edu.pucp.sia.repository.ActivityRepository;
import pe.edu.pucp.sia.repository.SuccessPercentageRepository;
import pe.edu.pucp.sia.response.ApiResponse;
import pe.edu.pucp.sia.service.SuccessPercentageService;

@Service
public class SuccessPercentageServicImpl implements SuccessPercentageService {
	@Autowired
	private SuccessPercentageRepository successPercentageRepository;

	@Override
	public ApiResponse listAll() {
		ApiResponse response = null;
		try{
			Iterable<SuccessPercentage> list = successPercentageRepository.findAll();
			response = new ApiResponse(list, 200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		 return response;
	}

	@Override
	public ApiResponse createSuccessPercentage(SuccessPercentage sp) {
		ApiResponse response = null;
		try{
			Integer id = successPercentageRepository.save(sp).getId();			
			response = new ApiResponse(id,201);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse updateSuccessPercentage(SuccessPercentage sp) {
		ApiResponse response = null;
		try {
			Integer id = successPercentageRepository.save(sp).getId();
			response = new ApiResponse(id,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse deleteSuccessPercentage(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApiResponse listBySpecialtySemester(Integer idSpecialty, Integer idSemester) {
		ApiResponse response = null;
		try{
			Iterable<SuccessPercentage> list = successPercentageRepository.findBySpecialtyIdAndSemesterId(idSpecialty,idSemester);
			response = new ApiResponse(list, 200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		 return response;
	}

}
