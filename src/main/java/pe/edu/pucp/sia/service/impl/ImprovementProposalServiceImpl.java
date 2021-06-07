package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.Activity;
import pe.edu.pucp.sia.model.ImprovementPlan;
import pe.edu.pucp.sia.model.ImprovementProposal;
import pe.edu.pucp.sia.repository.ActivityRepository;
import pe.edu.pucp.sia.repository.ImprovementProposalRepository;
import pe.edu.pucp.sia.requests.CreateImprovementProposalRequest;
import pe.edu.pucp.sia.service.ImprovementProposalService;

@Service
public class ImprovementProposalServiceImpl implements ImprovementProposalService{
	@Autowired
	private ImprovementProposalRepository improvementProposalRepository;
	@Autowired
	private ActivityRepository activityRepository;
	
	@Override
	public Iterable<ImprovementProposal> listAll() {
		 return improvementProposalRepository.findAll();
	}

	@Override
	public Integer createImprovementProposal(ImprovementProposal i) {
		Integer response = 0;
		try {
			response = improvementProposalRepository.save(i).getId();
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public Integer updateImprovementProposal(CreateImprovementProposalRequest ipr) {
		ImprovementProposal i = new ImprovementProposal();
		Integer response = 0;
		try {
			i.setId(ipr.getId());
			i.setDescription(ipr.getDescription());
			response = improvementProposalRepository.save(i).getId();
			for(Activity a : ipr.getActivities()) {
				if(a.getId() == 0) {
					a.setImprovementProposal(i);
					activityRepository.save(a);
				}
			}
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public String deleteImprovementProposal(Integer id) {
		String response = "";
		try {
			improvementProposalRepository.deleteImprovementProposal(id);
			response = "Deleted";
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public Iterable<ImprovementProposal> listByImprovementPlan(Integer id) {
		Iterable<ImprovementProposal> lista = improvementProposalRepository.findByImprovementPlanId(id);
		for (ImprovementProposal improvementProposal : lista) {
			improvementProposal.setImprovementPlan(null);
		}
		return lista;
	}
}
