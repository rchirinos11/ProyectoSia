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
import pe.edu.pucp.sia.requests.UpdateImprovementPlanRequest;
import pe.edu.pucp.sia.response.ImprovementPlanDataResponse;
import pe.edu.pucp.sia.response.ImprovementProposalResponse;
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
	public Integer updateImprovementPlan(UpdateImprovementPlanRequest uipr) {
		ImprovementPlan i = new ImprovementPlan();
		Integer response = 0;
		Iterable<ImprovementProposal> improvementProposals = uipr.getImprovementProposals();
		try {
			i.setId(uipr.getId());
			i.setSpecialty(uipr.getSpecialty());
			i.setTitle(uipr.getTitle());
			i.setOpportunity(uipr.getOpportunity());
			response = improvementPlanRepository.save(i).getId();
			
			for(ImprovementProposal ip : improvementProposals) {
				if(ip.getId() == 0) {
					ip.setImprovementPlan(i);
					improvementProposalRepository.save(ip);
				}
			}
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
		Iterable<Activity> activityList = null;
		List<ImprovementProposalResponse> improvementProposalResponseList = null;
		ImprovementPlanDataResponse response = new ImprovementPlanDataResponse();
		ImprovementProposalResponse ipr = null;
		List<ImprovementPlanDataResponse> listaResponse = new ArrayList<ImprovementPlanDataResponse>();
		for (ImprovementPlan improvementPlan : lista) {
			response = new ImprovementPlanDataResponse();
			response.setId(improvementPlan.getId());
			response.setSpecialty(null);
			response.setTitle(improvementPlan.getTitle());
			response.setOpportunity(improvementPlan.getOpportunity());
			improvementProposalResponseList = new ArrayList<ImprovementProposalResponse>();
			improvementProposalList = improvementProposalRepository.findByImprovementPlanId(improvementPlan.getId());
			for (ImprovementProposal improvementProposal : improvementProposalList) {
				ipr = new ImprovementProposalResponse();
				ipr.setId(improvementProposal.getId());
				ipr.setDescription(improvementProposal.getDescription());
				activityList = activityRepository.findByImprovementProposalId(improvementProposal.getId()); 
				for(Activity activity : activityList) {
					activity.setImprovementProposal(null);
				}
				ipr.setActivities(activityList);
				improvementProposalResponseList.add(ipr);
			}
			response.setImprovementProposals(improvementProposalResponseList);
			listaResponse.add(response);
		}
		return listaResponse;
	}
}
