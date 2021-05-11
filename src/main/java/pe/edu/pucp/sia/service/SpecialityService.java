package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.Speciality;

public interface SpecialityService {
	public Iterable<Speciality> listAll();
	public String createSpeciality(Speciality s);
	public String updateSpeciality(Speciality s);
	public String deleteSpeciality(Integer id);
}
