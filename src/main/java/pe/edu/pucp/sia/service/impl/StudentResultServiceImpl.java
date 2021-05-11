package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.StudentResult;
import pe.edu.pucp.sia.repository.StudentResultRepository;
import pe.edu.pucp.sia.service.StudentResultService;

@Service
public class StudentResultServiceImpl implements StudentResultService{
	@Autowired
	private StudentResultRepository studentResultRepository;
	
	@Override
	public Iterable<StudentResult> listAll() {
		return studentResultRepository.findAll();
	}

	@Override
	public String createStudentResult(StudentResult sr) {
		String response = "";
		try {
			studentResultRepository.save(sr);
			response = "Created"; 
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public String updateStudentResult(StudentResult sr) {
		String response = "";
		try {
			studentResultRepository.save(sr);
			response = "Updated"; 
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public String deleteStudentResult(Integer id) {
		String response = "";
		try {
			studentResultRepository.deleteById(id);
			response = "Deleted"; 
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

}
