package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.Evidence;
import pe.edu.pucp.sia.repository.EvidenceRepository;
import pe.edu.pucp.sia.response.ApiResponse;
import pe.edu.pucp.sia.service.EvidenceService;

@Service
public class EvidenceServiceImpl implements EvidenceService{
	
	@Autowired
	private EvidenceRepository evidenceRepository;
	
	@Override
	public ApiResponse listAll() {
		ApiResponse response = null;
		try {
			Iterable<Evidence> list = evidenceRepository.findAll();
			response = new ApiResponse(list,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse createEvidence(Evidence e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApiResponse deleteEvidence(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApiResponse updateEvidence(Evidence e) {
		// TODO Auto-generated method stub
		return null;
	}

}
