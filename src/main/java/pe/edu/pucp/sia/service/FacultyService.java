package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.Faculty;

public interface FacultyService {
	public Iterable<Faculty> listAll();
	public Integer createFaculty(Faculty f);
	public String updateFaculty(Faculty f);
	public String deleteFaculty(Integer id);
}
