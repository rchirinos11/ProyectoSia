package pe.edu.pucp.sia.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.Activity;
import pe.edu.pucp.sia.model.ImprovementPlan;
import pe.edu.pucp.sia.model.ImprovementProposal;
import pe.edu.pucp.sia.model.Semester;
import pe.edu.pucp.sia.repository.ActivityRepository;
import pe.edu.pucp.sia.repository.ImprovementPlanRepository;
import pe.edu.pucp.sia.repository.ImprovementProposalRepository;
import pe.edu.pucp.sia.repository.SemesterRepository;
import pe.edu.pucp.sia.requests.CreateImprovementPlanRequest;
import pe.edu.pucp.sia.requests.CreateImprovementProposalRequest;
import pe.edu.pucp.sia.requests.ImprovementPlanActivityRequest;
import pe.edu.pucp.sia.response.ApiResponse;
import pe.edu.pucp.sia.response.ImprovementPlanDataResponse;
import pe.edu.pucp.sia.response.ImprovementPlanDataResponseList;
import pe.edu.pucp.sia.response.ImprovementProposalDataResponse;
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
	@Autowired
	private SemesterRepository semesterRepository;
	
	@Override
	public ApiResponse listAll() {
		ApiResponse response = null;
		try {
			Iterable<ImprovementPlan> list = improvementPlanRepository.findAll();
			response = new ApiResponse(list,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse createImprovementPlan(CreateImprovementPlanRequest c) {
		ApiResponse response = null;
		try {
			ImprovementPlan i = new ImprovementPlan();
			ImprovementProposal ip = new ImprovementProposal();
			i.setSpecialty(c.getSpecialty());
			i.setTitle(c.getTitle());
			i.setOpportunity(c.getOpportunity());
			Integer improvementPlanId = improvementPlanRepository.save(i).getId();
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

			response = new ApiResponse(improvementPlanId,201);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse updateImprovementPlan(CreateImprovementPlanRequest ipr) {
		ApiResponse response = null;
		try {
			Iterable<ImprovementProposal> improvementProposals = improvementProposalRepository.findByImprovementPlanId(ipr.getId());
			Iterable<Activity> activities = null;
			for(ImprovementProposal i : improvementProposals) {
				activities = activityRepository.findByImprovementProposalId(i.getId());
				for(Activity a : activities) {
					activityRepository.deleteActivity(a.getId());
				}
				improvementProposalRepository.deleteImprovementProposal(i.getId());
			}
			
			ImprovementPlan improvementPlan = new ImprovementPlan();
			improvementPlan.setId(ipr.getId());
			improvementPlan.setSpecialty(ipr.getSpecialty());
			improvementPlan.setTitle(ipr.getTitle());
			improvementPlan.setOpportunity(ipr.getOpportunity());
			Integer id = improvementPlanRepository.save(improvementPlan).getId();
			
			ImprovementProposal improvementProposal = null;
			for(CreateImprovementProposalRequest iprr : ipr.getImprovementProposals()) {
				improvementProposal = new ImprovementProposal();
				improvementProposal.setId(iprr.getId());
				improvementProposal.setImprovementPlan(improvementPlan);
				improvementProposal.setDescription(iprr.getDescription());
				if(improvementProposal.getId() != null) {
					improvementProposalRepository.reactivateImprovementProposal(improvementProposal.getId());
				}
				improvementProposalRepository.save(improvementProposal);
				
				for(Activity activity : iprr.getActivities()) {
					activity.setImprovementProposal(improvementProposal);
					if(activity.getId() != null) {
						activityRepository.reactivateActivity(activity.getId());
					}
					activityRepository.save(activity);
				}
			}
			response = new ApiResponse(id,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse deleteImprovementPlan(Integer id) {
		ApiResponse response = null;
		try {
			improvementPlanRepository.deleteImprovementPlan(id);
			response = new ApiResponse("Success", 200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse listBySpecialty(Integer id) {
		ApiResponse response = null;
		try{
			Iterable<ImprovementPlan> lista = improvementPlanRepository.findBySpecialtyId(id);
			Iterable<ImprovementProposal> improvementProposalList = null;
			Iterable<Activity> activityList = null;
			List<ImprovementProposalResponse> improvementProposalResponseList = null;
			ImprovementPlanDataResponse iPResponse = new ImprovementPlanDataResponse();
			ImprovementProposalResponse ipr = null;
			List<ImprovementPlanDataResponse> listaResponse = new ArrayList<ImprovementPlanDataResponse>();
			for (ImprovementPlan improvementPlan : lista) {
				iPResponse = new ImprovementPlanDataResponse();
				iPResponse.setId(improvementPlan.getId());
				iPResponse.setSpecialty(null);
				iPResponse.setTitle(improvementPlan.getTitle());
				iPResponse.setOpportunity(improvementPlan.getOpportunity());
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
				iPResponse.setImprovementProposals(improvementProposalResponseList);
				listaResponse.add(iPResponse);
			}
			response = new ApiResponse(listaResponse,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse listByActivityStatesAndSemesters(ImprovementPlanActivityRequest i) {
		ApiResponse response = null;
		try {
			Iterable<Activity> activities = null;
			Integer idIni = i.getIdSemesterStart();
			Integer idFin = i.getIdSemesterEnd();

			Semester semesterIni = semesterRepository.findById(idIni).get();
			Semester semesterFin = semesterRepository.findById(idFin).get();

			activities = activityRepository.listByActivityStatesAndSemesters(semesterIni.getYear()*10+semesterIni.getNumber(),semesterFin.getYear()*10+semesterFin.getNumber(),improvementProposalRepository.findByImprovementPlanIn(improvementPlanRepository.findBySpecialtyId(i.getIdSpecialty())),i.getStates());
			
			Integer idProAnt = 0;
			Integer idPlanAnt = 0;
			Integer idProCur;
			Integer idPlanCur;
			ImprovementPlanDataResponseList ipldr = null;
			ImprovementProposalDataResponse iprdr = null;
			List<ImprovementPlanDataResponseList> ipldrs = new ArrayList<ImprovementPlanDataResponseList>();
			List<ImprovementProposalDataResponse> iprdrs = null;
			List<Activity> adrs = null;
			ImprovementPlan ipl = null;
			ImprovementProposal ipr = null;
			Activity act = null;
			for(Activity a : activities) {
				ipl = a.getImprovementProposal().getImprovementPlan();
				ipr = a.getImprovementProposal();
				idProCur = ipr.getId();
				idPlanCur = ipl.getId();
				if(idPlanCur != idPlanAnt) {
					ipldr = new ImprovementPlanDataResponseList();
					ipldr.setId(ipl.getId());
					ipldr.setSpecialty(ipl.getSpecialty());
					ipldr.setTitle(ipl.getTitle());
					ipldr.setOpportunity(ipl.getOpportunity());
					iprdrs = new ArrayList<ImprovementProposalDataResponse>();
					ipldr.setImprovementProposals(iprdrs);
					
					ipldrs.add(ipldr);
				}
				if(idProCur != idProAnt) {
					iprdr = new ImprovementProposalDataResponse();
					iprdr.setId(ipr.getId());
					iprdr.setDescription(ipr.getDescription());
					adrs = new ArrayList<Activity>();
					iprdr.setActivities(adrs);
					
					iprdrs.add(iprdr);
				}
				act = new Activity();
				act.setId(a.getId());
				act.setState(a.getState());
				act.setDescription(a.getDescription());
				act.setEvidence(a.getEvidence());
				act.setSemesterStart(a.getSemesterStart());
				act.setSemesterEnd(a.getSemesterEnd());
				act.setResponsible(a.getResponsible());
				
				adrs.add(act);
				
				idPlanAnt = idPlanCur;
				idProAnt = idProCur;
			}
			response = new ApiResponse(ipldrs, 200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		
		return response;		
	}
}
