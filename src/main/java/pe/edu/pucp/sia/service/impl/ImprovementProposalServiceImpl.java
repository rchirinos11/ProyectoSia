package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.ImprovementProposal;
import pe.edu.pucp.sia.repository.ImprovementProposalRepository;
import pe.edu.pucp.sia.response.ApiResponse;
import pe.edu.pucp.sia.service.ImprovementProposalService;

@Service
public class ImprovementProposalServiceImpl implements ImprovementProposalService{
	@Autowired
	private ImprovementProposalRepository improvementProposalRepository;
	
	@Override
	public ApiResponse listAll() {
		ApiResponse response = null;
		try {
			Iterable<ImprovementProposal> list = improvementProposalRepository.findAll();
			response = new ApiResponse(list,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse createImprovementProposal(ImprovementProposal i) {
		ApiResponse response = null;
		try {
			Integer id = improvementProposalRepository.save(i).getId();
			response = new ApiResponse(id,201);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse updateImprovementProposal(ImprovementProposal i) {
		ApiResponse response = null;
		try {
			Integer id = improvementProposalRepository.save(i).getId();
			response = new ApiResponse(id,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse deleteImprovementProposal(Integer id) {
		ApiResponse response = null;
		try {
			improvementProposalRepository.deleteImprovementProposal(id);
			response = new ApiResponse("Success",200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse listByImprovementPlan(Integer id) {
		ApiResponse response = null;
		try {
			Iterable<ImprovementProposal> list = improvementProposalRepository.findByImprovementPlanId(id);
			response = new ApiResponse(list,200);
			for (ImprovementProposal improvementProposal : list)
				improvementProposal.setImprovementPlan(null);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}
}
