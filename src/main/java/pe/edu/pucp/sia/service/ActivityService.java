package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.Activity;
import pe.edu.pucp.sia.response.ApiResponse;

public interface ActivityService {
	public ApiResponse listAll();
	public ApiResponse listByImprovementProposal(Integer id);
	public ApiResponse createActivity(Activity a);
	public ApiResponse updateActivity(Activity a);
	public ApiResponse deleteActivity(Integer id);
}