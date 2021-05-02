package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.Semester;

public interface SemesterService {
	public Iterable<Semester>  listAll();
	public String createSemester(Semester s);
	public String updateSemester(Semester s);
	public String deleteSemester(Integer id);
	
}
