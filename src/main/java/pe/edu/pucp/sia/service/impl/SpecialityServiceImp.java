package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.Speciality;
import pe.edu.pucp.sia.repository.SpecialityRepository;
import pe.edu.pucp.sia.service.SpecialityService;

@Service
public class SpecialityServiceImp implements SpecialityService{
	@Autowired
	private SpecialityRepository specialityRepository;
	
	@Override
	public Iterable<Speciality> listAll(){
		return specialityRepository.findAll();
	}

	@Override
	public String createSpeciality(Speciality s) {
		String response = "";
		try {
			specialityRepository.save(s);
			response = "Created"; 
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public String updateSpeciality(Speciality s) {
		String response = "";
		try {
			specialityRepository.save(s);
			response = "Updated"; 
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public String deleteSpeciality(Integer id) {
		String response = "";
		try {
			specialityRepository.deleteById(id);
			response = "Deleted"; 
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}
}
