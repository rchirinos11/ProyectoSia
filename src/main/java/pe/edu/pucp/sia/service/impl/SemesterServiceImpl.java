package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.Semester;
import pe.edu.pucp.sia.model.Specialty;
import pe.edu.pucp.sia.model.StudentResult;
import pe.edu.pucp.sia.model.SuccessPercentage;
import pe.edu.pucp.sia.repository.SemesterRepository;
import pe.edu.pucp.sia.repository.SpecialtyRepository;
import pe.edu.pucp.sia.repository.SuccessPercentageRepository;
import pe.edu.pucp.sia.response.ApiResponse;
import pe.edu.pucp.sia.service.SemesterService;

@Service
public class SemesterServiceImpl implements SemesterService{
	@Autowired
	private SemesterRepository semesterRepository;
	
	@Autowired
	private SpecialtyRepository specialtyRepository;
	
	@Autowired
	private SuccessPercentageRepository successPercentageRepository;
	
	@Override
	public ApiResponse listAll() {
		ApiResponse response = null;
		 try {
			Iterable<Semester> list = semesterRepository.findAll();
		 	response = new ApiResponse(list,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse createSemester(Semester s) {
		ApiResponse response = null;
		try {
			Integer id = semesterRepository.save(s).getId(); 
			Iterable<Specialty> lista = specialtyRepository.findAll();
			if (lista!=null) {
				s.setId(id);
				for (Specialty specialty : lista) {
					SuccessPercentage sp = new SuccessPercentage();
					sp.setSemester(s);
					sp.setSpecialty(specialty);
					successPercentageRepository.save(sp);
				}
			}
			response = new ApiResponse(id,201);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse updateSemester(Semester s) {
		ApiResponse response = null;
		try {
			Integer id = semesterRepository.save(s).getId();
			response = new ApiResponse(id,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse deleteSemester(Integer id) {
		ApiResponse response = null;
		try {
			semesterRepository.deleteSemester(id);
			response = new ApiResponse("Success",200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}
	
	@Override
	public ApiResponse updateCurrent(Integer id) {
		ApiResponse response = null;
		try {
			Integer previous = semesterRepository.changeCurrentSemester(id);
			response = new ApiResponse(previous,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse findCurrent() {
		ApiResponse response = null;
		try {
			Semester semester = semesterRepository.findByCurrent(true);
			response = new ApiResponse(semester,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

}
