package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.Activity;
import pe.edu.pucp.sia.repository.ActivityRepository;
import pe.edu.pucp.sia.service.ActivityService;

@Service
public class ActivityServiceImpl implements ActivityService{
	@Autowired
	private ActivityRepository activityRepository;
	
	@Override
	public Iterable<Activity> listAll() {
		 return activityRepository.findAll();
	}

	@Override
	public Integer createActivity(Activity a) {
		Integer response = 0;
		try {
			response = activityRepository.save(a).getId();
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public Integer updateActivity(Activity a) {
		Integer response = 0;
		try {
			response = activityRepository.save(a).getId();
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public String deleteActivity(Integer id) {
		String response = "";
		try {
			activityRepository.deleteActivity(id);
			response = "Deleted";
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

}