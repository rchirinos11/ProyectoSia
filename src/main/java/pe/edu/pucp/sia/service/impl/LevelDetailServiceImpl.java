package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.LevelDetail;
import pe.edu.pucp.sia.repository.LevelDetailRepository;
import pe.edu.pucp.sia.response.ApiResponse;
import pe.edu.pucp.sia.service.LevelDetailService;

@Service
public class LevelDetailServiceImpl implements LevelDetailService{
	@Autowired
	private LevelDetailRepository levelDetailRepository;
	
	@Override
	public ApiResponse listAll() {
		ApiResponse response = null;
		try {
			Iterable<LevelDetail> list = levelDetailRepository.findAll();
			response = new ApiResponse(list,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse createLevelDetail(LevelDetail ld) {
		ApiResponse response = null;
		try {
			Integer id = levelDetailRepository.save(ld).getId();
			response = new ApiResponse(id,201);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse updateLevelDetail(LevelDetail ld) {
		ApiResponse response = null;
		try {
			Integer id = levelDetailRepository.save(ld).getId();
			response = new ApiResponse(id,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse deleteLevelDetail(Integer id) {
	ApiResponse response = null;
		try {
			levelDetailRepository.deleteLevelDetail(id);
			response = new ApiResponse("Success",200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse listBySpecialty(Integer idSpecialty) {
		ApiResponse response = null;
		try {
			Iterable<LevelDetail> list =levelDetailRepository.listLevelDetailBySpecialty(idSpecialty);
			for(LevelDetail l : list) {	
				l.setMeasurementLevel(null);
				l.setIndicator(null);
			}
			response = new ApiResponse(list,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

}
