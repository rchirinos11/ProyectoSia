package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.Specialty;

public interface SpecialtyService {
	public Iterable<Specialty> listAll();
	public Iterable<Specialty> listByFaculty(Integer id);
	public Integer createSpecialty(Specialty s);
	public Integer updateSpecialty(Specialty s);
	public String deleteSpecialty(Integer id);
}
