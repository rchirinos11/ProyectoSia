package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.Faculty;
import pe.edu.pucp.sia.model.Specialty;
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
			int x = facultyRepository.deleteFaculty(id);
			if(x==0)
				response = "Deleted";
			else
				response = "Cannot delete due to dependency";
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public Iterable<Faculty> listByCoordinator(Integer id) {
		Iterable<Faculty> lista = facultyRepository.findByCoordinatorId(id);
		for (Faculty faculty : lista) {
			faculty.setCoordinator(null);
		}
		return lista;
	}
}
