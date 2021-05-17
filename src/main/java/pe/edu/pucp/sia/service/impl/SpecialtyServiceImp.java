package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.Faculty;
import pe.edu.pucp.sia.model.Specialty;
import pe.edu.pucp.sia.repository.SpecialtyRepository;
import pe.edu.pucp.sia.service.SpecialtyService;

@Service
public class SpecialtyServiceImp implements SpecialtyService{
	@Autowired
	private SpecialtyRepository specialtyRepository;
	
	@Override
	public Iterable<Specialty> listAll(){
		return specialtyRepository.findAll();
	}

	@Override
	public Integer createSpecialty(Specialty s) {
		Integer response = 0;
		try {
			response = specialtyRepository.save(s).getId();
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public Integer updateSpecialty(Specialty s) {
		Integer response = 0;
		try {
			response = specialtyRepository.save(s).getId();
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public String deleteSpecialty(Integer id) {
		String response = "";
		try {
			specialtyRepository.deleteSpecialty(id);
			response = "Deleted"; 
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public Iterable<Specialty> listByFaculty(Integer id) {
		Iterable<Specialty> lista = specialtyRepository.findByFacultyId(id);
		for (Specialty specialty : lista) {
			specialty.setFaculty(null);
		}
		return lista;
	}

	@Override
	public Iterable<Specialty> listByCoordinator(Integer id) {
		Iterable<Specialty> lista = specialtyRepository.findByFacultyId(id);
		for (Specialty specialty : lista) {
			specialty.setCoordinator(null);
		}
		return lista;
	}

	@Override
	public Iterable<Specialty> listByAssistant(Integer id) {
		Iterable<Specialty> lista = specialtyRepository.findByFacultyId(id);
		for (Specialty specialty : lista) {
			specialty.setAssistant(null);
		}
		return lista;
	}
}
