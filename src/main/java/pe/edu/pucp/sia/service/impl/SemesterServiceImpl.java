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
	public Integer createSemester(Semester s) {
		Integer response = 0;
		try {
			response = semesterRepository.save(s).getId(); 
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public Integer updateSemester(Semester s) {
		Integer response = 0;
		try {
			response = semesterRepository.save(s).getId();
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public String deleteSemester(Integer id) {
		String response = "";
		try {
			semesterRepository.deleteSemester(id);
			response = "Deleted";
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}
	
	@Override
	public Integer updateCurrent(Integer id) {
		Integer response = 0;
		try {
			response = semesterRepository.changeCurrentSemester(id);
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public Semester findCurrent() {
		Semester semester = null;
		try {
			semester = semesterRepository.findByCurrent(true);
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return semester;
	}

}
