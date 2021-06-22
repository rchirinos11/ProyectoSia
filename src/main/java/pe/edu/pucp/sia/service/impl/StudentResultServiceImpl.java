package pe.edu.pucp.sia.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.MeasurementLevel;
import pe.edu.pucp.sia.model.MeasurementPlanLine;
import pe.edu.pucp.sia.model.ResultsPerCard;
import pe.edu.pucp.sia.model.Indicator;
import pe.edu.pucp.sia.model.StudentResult;
import pe.edu.pucp.sia.model.dozers.StudentResultDozer;
import pe.edu.pucp.sia.repository.IndicatorRepository;
import pe.edu.pucp.sia.repository.MeasurementLevelRepository;
import pe.edu.pucp.sia.repository.MeasurementPlanLineRepository;
import pe.edu.pucp.sia.repository.ResultsPerCardRepository;
import pe.edu.pucp.sia.repository.StudentResultRepository;
import pe.edu.pucp.sia.response.ApiResponse;
import pe.edu.pucp.sia.response.StudentResultPercentageDataResponse;
import pe.edu.pucp.sia.service.IndicatorService;
import pe.edu.pucp.sia.service.StudentResultService;

@Service
public class StudentResultServiceImpl implements StudentResultService{

	
	private Mapper mapper = new DozerBeanMapper();
	
	@Autowired
	private IndicatorRepository indicatorRepository;

	@Autowired
	private StudentResultRepository studentResultRepository;
	
	@Autowired
	private MeasurementLevelRepository measurementLevelRepository;
	
	@Autowired
	private MeasurementPlanLineRepository measurementPlanLineRepository;
	
	@Autowired
	private ResultsPerCardRepository resultsPerCardRepository;
	

	
	
	@Override
	public ApiResponse listAll() {
		ApiResponse response = null;
		try {
			Iterable<StudentResult> list = studentResultRepository.findAll();
			response = new ApiResponse(list,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse createStudentResult(StudentResult sr) {
		ApiResponse response = null;
		try {
			Integer id = studentResultRepository.save(sr).getId();
			response = new ApiResponse(id,201);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse updateStudentResult(StudentResult sr) {
		ApiResponse response = null;
		try {
			Integer id = studentResultRepository.save(sr).getId();
			response = new ApiResponse(id,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse deleteStudentResult(Integer id) {
		ApiResponse response = null;
		try {
			studentResultRepository.deleteById(id);
			response = new ApiResponse("Success",200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse listBySpecialty(Integer id) {
		ApiResponse response = null;
		try {
			Iterable<StudentResult> list = studentResultRepository.findBySpecialtyIdOrderByOrderNumber(id);
			for (StudentResult studentResult : list) {
				studentResult.setSpecialty(null);
			}
			response = new ApiResponse(list,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse listBySpecialtyPlusIndicator(Integer id) {
		ApiResponse response = null;
		try {
			List<StudentResult> list = studentResultRepository.findBySpecialtyIdOrderByOrderNumber(id);
			for (StudentResult studentResult : list) {
				studentResult.setSpecialty(null);
			}
			response = mapListDTO(list);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	private ApiResponse mapListDTO(List<StudentResult> studentResults){
		ApiResponse response = null;
		try{
			List<StudentResultDozer> studentResultDozers = new ArrayList<>();
			for(StudentResult s: studentResults){
				StudentResultDozer studentResultDozer = new StudentResultDozer();
				mapper.map(s,studentResultDozer);
				studentResultDozer.setIndicators(indicatorRepository.findBystudentResultIdOrderByCode(studentResultDozer.getId()));
				studentResultDozers.add(studentResultDozer);
			}
			response = new ApiResponse(studentResultDozers,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
    }

	@Override
	public ApiResponse listBySpecialtyPlusAchievementPercentage(Integer id) {
		ApiResponse response = null;
		try {
			List<StudentResult> listSr = studentResultRepository.findBySpecialtyIdOrderByOrderNumber(id);
			List<StudentResultPercentageDataResponse> list= new ArrayList<StudentResultPercentageDataResponse>();
			Float percentage=100f;
			Integer contador;
			for(StudentResult studentResult : listSr) {
				StudentResultPercentageDataResponse sr= new StudentResultPercentageDataResponse();
				contador=0;
				for(Indicator indicator : indicatorRepository.findBystudentResultIdOrderByCode(studentResult.getId())) {
					Float p = resultsPerCardRepository.listResultsPerCardByIndicator(indicator.getId());
					if(p!=null) {
						contador++;
						if(p<percentage)
							percentage=p;	
					}									
				}
				if(contador==0) percentage=-1f;
				sr.setStudentResult(studentResult);
				sr.setAchievementPercentage(percentage);
				list.add(sr);
				percentage=100f;
			}
			response = new ApiResponse(list,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}
}
