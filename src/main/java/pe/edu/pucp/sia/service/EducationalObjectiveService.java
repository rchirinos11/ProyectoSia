package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.EducationalObjective;

public interface EducationalObjectiveService {
	public Iterable<EducationalObjective> listAll();
	public Integer createEducationalObjective(EducationalObjective eo);
	public Integer updateEducationalObjective(EducationalObjective eo);
	public String deleteEducationalObjective(Integer id);
}
