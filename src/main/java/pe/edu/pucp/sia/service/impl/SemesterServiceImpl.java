package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.Semester;
import pe.edu.pucp.sia.repository.SemesterRepository;
import pe.edu.pucp.sia.service.SemesterService;

@Service
public class SemesterServiceImpl implements SemesterService{
	@Autowired
	private SemesterRepository semesterRepository;
	
	@Override
	public Iterable<Semester> listAll() {
		 return semesterRepository.findAll();
	}

	@Override
	public String createSemester(Semester s) {
		String response = "";
		try {
			semesterRepository.save(s);
			response = "Created"; 
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public String updateSemester(Semester s) {
		String response = "";
		try {
			semesterRepository.save(s);
			response = "Updated";
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public String deleteSemester(Integer id) {
		String response = "";
		try {
			semesterRepository.deleteById(id);
			response = "Deleted";
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

}
