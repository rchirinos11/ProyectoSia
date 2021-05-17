package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.ImprovementOpportunity;
import pe.edu.pucp.sia.repository.ImprovementOpportunityRepository;
import pe.edu.pucp.sia.service.ImprovementOpportunityService;

@Service
public class ImprovementOpportunityServiceImpl implements ImprovementOpportunityService{
	@Autowired
	private ImprovementOpportunityRepository improvementOpportunityRepository;
	
	@Override
	public Iterable<ImprovementOpportunity> listAll() {
		 return improvementOpportunityRepository.findAll();
	}

	@Override
	public Integer createImprovementOpportunity(ImprovementOpportunity i) {
		Integer response = 0;
		try {
			response = improvementOpportunityRepository.save(i).getId();
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public Integer updateImprovementOpportunity(ImprovementOpportunity i) {
		Integer response = 0;
		try {
			response = improvementOpportunityRepository.save(i).getId();
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public String deleteImprovementOpportunity(Integer id) {
		String response = "";
		try {
			improvementOpportunityRepository.deleteImprovementOpportunity(id);
			response = "Deleted";
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

}
