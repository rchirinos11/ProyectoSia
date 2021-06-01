package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.Faculty;

public interface FacultyService {
	public Iterable<Faculty> listAll();
	public Iterable<Faculty> listByCoordinator(Integer id);
	public Integer createFaculty(Faculty f);
	public Integer updateFaculty(Faculty f);
	public String deleteFaculty(Integer id);
	public String updateCoordinator(Integer idFaculty, Integer idCoordinator);
}
