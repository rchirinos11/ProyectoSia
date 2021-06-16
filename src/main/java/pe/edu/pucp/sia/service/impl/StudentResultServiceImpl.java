package pe.edu.pucp.sia.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.StudentResult;
import pe.edu.pucp.sia.model.dozers.StudentResultDozer;
import pe.edu.pucp.sia.repository.StudentResultRepository;
import pe.edu.pucp.sia.service.StudentResultService;

@Service
public class StudentResultServiceImpl implements StudentResultService{

	
	private Mapper mapper = new DozerBeanMapper();

	@Autowired
	private IndicatorServiceImpl indicatorServiceImpl;

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
		Iterable<StudentResult> lista = studentResultRepository.findBySpecialtyIdOrderById(id);
		for (StudentResult studentResult : lista) {
			studentResult.setSpecialty(null);
		}
		return lista;
	}

	@Override
	public Iterable<StudentResultDozer> listBySpecialtyPlusIndicator(Integer id) {
		List<StudentResult> lista = studentResultRepository.findBySpecialtyIdOrderById(id);
		for (StudentResult studentResult : lista) {
			studentResult.setSpecialty(null);
		}
		return mapListDTO(lista);
	}

	private List<StudentResultDozer> mapListDTO(List<StudentResult> studentResults){
        List<StudentResultDozer> studentResultDozers = new ArrayList<>();
        for(StudentResult s: studentResults){
            StudentResultDozer studentResultDozer = new StudentResultDozer();
			mapper.map(s,studentResultDozer);
			studentResultDozer.setIndicators(indicatorServiceImpl.listByStudentResult(studentResultDozer.getId()));
            studentResultDozers.add(studentResultDozer);
        }
        return studentResultDozers;
    }
}
