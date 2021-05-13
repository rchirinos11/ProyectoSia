package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.Faculty;
import pe.edu.pucp.sia.repository.FacultyRepository;
import pe.edu.pucp.sia.service.FacultyService;

@Service
public class FacultyServiceImpl implements FacultyService{

	@Autowired
	private FacultyRepository facultyRepository;
	
	@Override
	public Iterable<Faculty> listAll() {
		return facultyRepository.findAll();
	}

	@Override
	public Integer createFaculty(Faculty f) {
		Integer response = 0;
		try {
			response = facultyRepository.save(f).getId();
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public Integer updateFaculty(Faculty f) {
		Integer response = 0;
		try {
			response = facultyRepository.save(f).getId();
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public String deleteFaculty(Integer id) {
		String response = "";
		try {
			facultyRepository.deleteById(id);
			response = "Deleted"; 
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}
}
