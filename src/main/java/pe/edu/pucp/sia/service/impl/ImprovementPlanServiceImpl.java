package pe.edu.pucp.sia.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.Activity;
import pe.edu.pucp.sia.model.ImprovementPlan;
import pe.edu.pucp.sia.model.ImprovementProposal;
import pe.edu.pucp.sia.repository.ActivityRepository;
import pe.edu.pucp.sia.repository.ImprovementPlanRepository;
import pe.edu.pucp.sia.repository.ImprovementProposalRepository;
import pe.edu.pucp.sia.requests.CreateImprovementPlanRequest;
import pe.edu.pucp.sia.requests.CreateImprovementProposalRequest;
import pe.edu.pucp.sia.response.ImprovementPlanDataResponse;
import pe.edu.pucp.sia.service.ImprovementPlanService;

@Service
public class ImprovementPlanServiceImpl implements ImprovementPlanService{
	@Autowired
	private ImprovementPlanRepository improvementPlanRepository;
	@Autowired
	private ImprovementProposalRepository improvementProposalRepository;
	@Autowired
	private ActivityRepository activityRepository;
	
	@Override
	public Iterable<ImprovementPlan> listAll() {
		 return improvementPlanRepository.findAll();
	}

	@Override
	public Integer createImprovementPlan(CreateImprovementPlanRequest c) {
		Integer improvementPlanId = 0;
		ImprovementPlan i = new ImprovementPlan();
		ImprovementProposal ip = new ImprovementProposal();
		try {
			i.setSpecialty(c.getSpecialty());
			i.setTitle(c.getTitle());
			i.setOpportunity(c.getOpportunity());
			improvementPlanId = improvementPlanRepository.save(i).getId();
			for(CreateImprovementProposalRequest cip : c.getImprovementProposals()) {
				ip = new ImprovementProposal();
				ip.setDescription(cip.getDescription());
				ip.setImprovementPlan(i);
				cip.setId(improvementProposalRepository.save(ip).getId());
				for(Activity a : cip.getActivities()) {
					a.setImprovementProposal(ip);
					activityRepository.save(a);
				}
			}
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return improvementPlanId;
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
			response = new ImprovementPlanDataResponse();
			response.setId(improvementPlan.getId());
			response.setSpecialty(null);
			response.setTitle(improvementPlan.getTitle());
			response.setOpportunity(improvementPlan.getOpportunity());
			improvementProposalList = improvementProposalRepository.findByImprovementPlanId(improvementPlan.getId());
			for (ImprovementProposal improvementProposal : improvementProposalList) {
				improvementProposal.setImprovementPlan(null);
			}
			response.setImprovementProposals(improvementProposalList);
			listaResponse.add(response);
		}
		return listaResponse;
	}
}
