package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.ImprovementPlan;
import pe.edu.pucp.sia.repository.ImprovementPlanRepository;
import pe.edu.pucp.sia.service.ImprovementPlanService;

@Service
public class ImprovementPlanServiceImpl implements ImprovementPlanService{
	@Autowired
	private ImprovementPlanRepository improvementPlanRepository;
	
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

}
