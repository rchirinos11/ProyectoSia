package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.Activity;
import pe.edu.pucp.sia.model.ImprovementProposal;
import pe.edu.pucp.sia.repository.ActivityRepository;
import pe.edu.pucp.sia.response.ApiResponse;
import pe.edu.pucp.sia.service.ActivityService;

@Service
public class ActivityServiceImpl implements ActivityService{
	@Autowired
	private ActivityRepository activityRepository;
	
	@Override
	public ApiResponse listAll() {
		ApiResponse response = null;
		try{
			Iterable<Activity> list = activityRepository.findAll();
			response = new ApiResponse(list, 200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		 return response;
	}

	@Override
	public ApiResponse createActivity(Activity a) {
		ApiResponse response = null;
		try{
			Integer id = activityRepository.save(a).getId();			
			response = new ApiResponse(id,201);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse updateActivity(Activity a) {
		ApiResponse response = null;
		try {
			Integer id = activityRepository.save(a).getId();
			response = new ApiResponse(id,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse deleteActivity(Integer id) {
		ApiResponse response = null;
		try {
			activityRepository.deleteActivity(id);
			response = new ApiResponse("Success",200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse listByImprovementProposal(Integer id) {
		ApiResponse response = null;
		try {
			Iterable<Activity> list = activityRepository.findByImprovementProposalId(id);
			for (Activity activity : list)
				activity.setImprovementProposal(null);
			response = new ApiResponse(list, 200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}	
}