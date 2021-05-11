package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.EducationalObjective;

public interface EducationalObjectiveService {
	public Iterable<EducationalObjective> listAll();
	public String createEducationalObjective(EducationalObjective eo);
	public String updateEducationalObjective(EducationalObjective eo);
	public String deleteEducationalObjective(Integer id);
}
