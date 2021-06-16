package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.Specialty;

public interface SpecialtyService {
	public Iterable<Specialty> listAll();
	public Iterable<Specialty> listByFaculty(Integer id);
	public Iterable<Specialty> listByCoordinator(Integer id);
	public Iterable<Specialty> listByAssistant(Integer id);
	public Integer createSpecialty(Specialty s);
	public Integer updateSpecialty(Specialty s);
	public String deleteSpecialty(Integer id);
	public String updateCoordinator(Integer idSpecialty, Integer idCoordinator);
	public String updateAssitant(Integer idSpecialty, Integer idAssistant);
	public String updatePercentage(Integer idSpecialty, Integer successPercentage);
}
