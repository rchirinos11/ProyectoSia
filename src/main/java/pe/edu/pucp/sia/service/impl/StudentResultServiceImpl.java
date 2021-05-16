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
	public Integer createStudentResult(StudentResult sr) {
		Integer response = 0;
		try {
			response = studentResultRepository.save(sr).getId();
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public Integer updateStudentResult(StudentResult sr) {
		Integer response = 0;
		try {
			response = studentResultRepository.save(sr).getId();
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

	@Override
	public Iterable<StudentResult> listBySpecialty(Integer id) {
		Iterable<StudentResult> lista = studentResultRepository.findBySpecialtyId(id);
		for (StudentResult studentResult : lista) {
			studentResult.setSpecialty(null);
		}
		return lista;
	}

}
