package pe.edu.pucp.sia.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.Measurement;
import pe.edu.pucp.sia.model.MeasurementPlanLine;
import pe.edu.pucp.sia.model.Person;
import pe.edu.pucp.sia.model.ResultsPerCard;
import pe.edu.pucp.sia.repository.MeasurementPlanLineRepository;
import pe.edu.pucp.sia.repository.MeasurementRepository;
import pe.edu.pucp.sia.repository.PersonRepository;
import pe.edu.pucp.sia.repository.ResultsPerCardRepository;
import pe.edu.pucp.sia.requests.DeleteMultipleMeasurementRequest;
import pe.edu.pucp.sia.requests.MultipleMeasurementRequest;
import pe.edu.pucp.sia.response.ApiResponse;
import pe.edu.pucp.sia.service.MeasurementService;
@Service
public class MeasurementServiceImpl implements MeasurementService {
	@Autowired
	private MeasurementRepository measurementRepository;
	@Autowired
	private ResultsPerCardRepository resultsPerCardRepository;
	@Autowired
	private MeasurementPlanLineRepository measurementPlanLineRepository;
	@Autowired
	private PersonRepository personRepository;

	@Override
	public ApiResponse listAll() {
		ApiResponse response = null;
		try {
			Iterable<Measurement> list = measurementRepository.findAll();
			response = new ApiResponse(list,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse createMeasurement(Measurement m) {
		ApiResponse response = null;
		try {			
			Integer id = measurementRepository.save(m).getId();
			response = new ApiResponse(id,201);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse updateMeasurement(Measurement m) {
		ApiResponse response = null;
		try {
			Integer id = measurementRepository.save(m).getId();
			response = new ApiResponse(id,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse deleteMeasurement(Integer id) {
		ApiResponse response = null;
		try {
			measurementRepository.deleteMeasurement(id);
			response = new ApiResponse("Success",200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse deleteByResultsPerCard(Integer idResultsPerCard) {
		ApiResponse response = null;
		try {
			if(measurementRepository.deleteByResultsPerCardId(idResultsPerCard) > 0)
				response = new ApiResponse("Success",200);
			else 
				response = new ApiResponse(409,"Error occurred while deleting");
			
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse createMultipleMeasurement(MultipleMeasurementRequest m) {
		ApiResponse response = null;
		try {
			Iterable<ResultsPerCard> resultsPerCards;
			Person person = new Person();
			person = personRepository.findById(m.getIdTeacher()).get();
			List<Person> persons = new ArrayList<Person>();
			List<ResultsPerCard> rpcs = new ArrayList<ResultsPerCard>();
			persons.add(person);
			Iterable<MeasurementPlanLine> mpls = measurementPlanLineRepository.findByCodeTeacherCourseSemester(m.getCode(),m.getIdTeacher(),m.getIdCourse(),m.getIdSemester());
			for(MeasurementPlanLine mpl : mpls) {
				resultsPerCards = resultsPerCardRepository.findByMeasurementPlanLineCode(mpl.getId(),m.getCode());
				for(ResultsPerCard rpc : resultsPerCards) {
					rpcs.add(rpc);
				}
			}
			
			if(rpcs.isEmpty()) {
				response = new ApiResponse(403,"Could not find any ResultsPerCards");
			}
			else {
				Integer id = null;
				person = null;
				Measurement measurement;
				for(Person p : m.getStudents()) {
					person=personRepository.findByCode(p.getCode());
					if(person==null) {
						person = personRepository.save(p);
					}
					for(ResultsPerCard rpc : rpcs) {
						measurement = new Measurement();
						measurement.setPerson(person);
						measurement.setResultsPerCard(rpc);
						measurementRepository.save(measurement);
					}
				}
				response = new ApiResponse("Success",201);
			}
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse deleteMultipleMeasurement(DeleteMultipleMeasurementRequest m) {
		ApiResponse response = null;
		try {
			String errors = "could not deactivate measurements from the following results per card: ( ";
			Integer errorFlag = 0;
			Iterable<ResultsPerCard> resultsPerCards;
			Person person = new Person();
			person = personRepository.findById(m.getIdTeacher()).get();
			List<Person> persons = new ArrayList<Person>();
			List<ResultsPerCard> rpcs = new ArrayList<ResultsPerCard>();
			persons.add(person);
			Iterable<MeasurementPlanLine> mpls = measurementPlanLineRepository.findByCodeTeacherCourseSemester(m.getCode(),m.getIdTeacher(),m.getIdCourse(),m.getIdSemester());
			for(MeasurementPlanLine mpl : mpls) {
				resultsPerCards = resultsPerCardRepository.findByMeasurementPlanLineCode(mpl.getId(),m.getCode());
				for(ResultsPerCard rpc : resultsPerCards) {
					if(measurementRepository.findDeleteMultipleMeasurement(rpc.getId()).isEmpty()) {
						measurementRepository.deleteByResultsPerCardId(rpc.getId());
					}
					else {
						errorFlag = 1;
						errors = errors + rpc.getId() + " ";
					}
				}
			}
			if(errorFlag == 0) {
				response = new ApiResponse("Success",200);
			}
			else {
				response = new ApiResponse(500, errors+")");
			}
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse deleteByAlumnosAndResultsPerCard(Integer idResultsPerCard) {
		ApiResponse response = null;
		try {
			measurementRepository.deleteByRolAndIdResultPerCard(6,idResultsPerCard);
			response = new ApiResponse("Success",200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

}
