package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.Activity;

public interface ActivityService {
	public Iterable<Activity>  listAll();
	public Integer createActivity(Activity a);
	public Integer updateActivity(Activity a);
	public String deleteActivity(Integer id);
}