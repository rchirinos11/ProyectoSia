package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.Semester;

public interface SemesterService {
	public Iterable<Semester>  listAll();
	public Integer createSemester(Semester s);
	public Integer updateSemester(Semester s);
	public String deleteSemester(Integer id);
	public Integer updateCurrent(Integer id);
	
}
