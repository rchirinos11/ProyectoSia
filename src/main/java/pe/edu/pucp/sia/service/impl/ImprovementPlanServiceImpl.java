package pe.edu.pucp.sia.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.ImprovementPlan;
import pe.edu.pucp.sia.model.ImprovementProposal;
import pe.edu.pucp.sia.repository.ImprovementPlanRepository;
import pe.edu.pucp.sia.repository.ImprovementProposalRepository;
import pe.edu.pucp.sia.response.ImprovementPlanDataResponse;
import pe.edu.pucp.sia.service.ImprovementPlanService;

@Service
public class ImprovementPlanServiceImpl implements ImprovementPlanService{
	@Autowired
	private ImprovementPlanRepository improvementPlanRepository;
	@Autowired
	private ImprovementProposalRepository improvementProposalRepository;
	
	@Override
	public Iterable<ImprovementPlan> listAll() {
		 return improvementPlanRepository.findAll();
	}

	@Override
	public Integer createImprovementPlan(ImprovementPlan i) {
		Integer response = 0;
		try {
			response = improvementPlanRepository.save(i).getId();
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public Integer updateImprovementPlan(ImprovementPlan i) {
		Integer response = 0;
		try {
			response = improvementPlanRepository.save(i).getId();
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public String deleteImprovementPlan(Integer id) {
		String response = "";
		try {
			improvementPlanRepository.deleteImprovementPlan(id);
			response = "Deleted";
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public Iterable<ImprovementPlanDataResponse> listBySpecialty(Integer id) {
		Iterable<ImprovementPlan> lista = improvementPlanRepository.findBySpecialtyId(id);
		Iterable<ImprovementProposal> improvementProposalList = null;
		ImprovementPlanDataResponse response = new ImprovementPlanDataResponse();
		List<ImprovementPlanDataResponse> listaResponse = new ArrayList<ImprovementPlanDataResponse>();
		for (ImprovementPlan improvementPlan : lista) {
			improvementPlan.setSpecialty(null);
			response = new ImprovementPlanDataResponse();
			response.setImprovementPlan(improvementPlan);
			improvementProposalList = improvementProposalRepository.findByImprovementPlanId(improvementPlan.getId());
			for (ImprovementProposal improvementProposal : improvementProposalList) {
				improvementProposal.setImprovementPlan(null);
			}
			response.setImprovementProposalList(improvementProposalList);
			listaResponse.add(response);
		}
		return listaResponse;
	}
}
