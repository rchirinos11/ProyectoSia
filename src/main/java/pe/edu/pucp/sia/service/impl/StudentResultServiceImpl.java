package pe.edu.pucp.sia.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.MeasurementLevel;
import pe.edu.pucp.sia.model.MeasurementPlanLine;
import pe.edu.pucp.sia.model.ResultsPerCard;
import pe.edu.pucp.sia.model.Semester;
import pe.edu.pucp.sia.model.Course;
import pe.edu.pucp.sia.model.Indicator;
import pe.edu.pucp.sia.model.StudentResult;
import pe.edu.pucp.sia.repository.IndicatorRepository;
import pe.edu.pucp.sia.repository.MeasurementLevelRepository;
import pe.edu.pucp.sia.repository.MeasurementPlanLineRepository;
import pe.edu.pucp.sia.repository.ResultsPerCardRepository;
import pe.edu.pucp.sia.repository.SemesterRepository;
import pe.edu.pucp.sia.repository.StudentResultRepository;
import pe.edu.pucp.sia.requests.MPlanLineCourseSemesterRequest;
import pe.edu.pucp.sia.requests.MPlanLineSpecialtySemesterRequest;
import pe.edu.pucp.sia.requests.StudentResultSpecialtySemestersRequest;
import pe.edu.pucp.sia.response.ApiResponse;
import pe.edu.pucp.sia.response.IndicatorCoursePercentageDataResponse;
import pe.edu.pucp.sia.response.IndicatorCoursePercentagesDataResponse;
import pe.edu.pucp.sia.response.SemesterPercentagesDataResponse;
import pe.edu.pucp.sia.response.StudentResultICPDataResponse;
import pe.edu.pucp.sia.response.StudentResultIndicatorsCoursesPercentagesDataResponse;
import pe.edu.pucp.sia.response.StudentResultPercentageDataResponse;
import pe.edu.pucp.sia.response.StudentResultResponse;
import pe.edu.pucp.sia.response.StudentResultSuccessDataResponse;
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
	private ResultsPerCardRepository resultsPerCardRepository;
	
	@Autowired
	private MeasurementPlanLineRepository measurementPlanLineRepository;
	
	@Autowired
	private SemesterRepository semesterRepository;
	
	
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
	public ApiResponse listBySemester(Integer idSemester) {
		ApiResponse response = null;
		try {
			Iterable<StudentResult> list = studentResultRepository.findBySemesterId(idSemester);
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
		//Old version
		/*ApiResponse response = null;
		try {
			studentResultRepository.deleteById(id);
			response = new ApiResponse("Success",200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
		*/
		ApiResponse response = null;
		try {
			Iterator<Indicator> i = indicatorRepository.findBystudentResultIdOrderByCode(id).iterator();
			if(i.hasNext()) {
				studentResultRepository.deleteStudentResult(id);					
				response = new ApiResponse("Success",200);
			} 
			else {
				response = new ApiResponse(409,"Cannot Delete due to dependency");
			}
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse listBySpecialtySemester(MPlanLineSpecialtySemesterRequest lss) {
		ApiResponse response = null;
		try {
			Iterable<StudentResult> list = studentResultRepository.findBySpecialtyIdAndSemesterIdOrderByCode(lss.getIdSpecialty(),lss.getIdSemester());
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
	public ApiResponse listBySpecialtySemesterPlusIndicator(MPlanLineSpecialtySemesterRequest lss) {
		ApiResponse response = null;
		try {
			List<StudentResult> list = studentResultRepository.findBySpecialtyIdAndSemesterIdOrderByCode(lss.getIdSpecialty(),lss.getIdSemester());
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
			List<StudentResultResponse> studentResultResponses = new ArrayList<>();
			for(StudentResult s: studentResults){
				StudentResultResponse studentResultResponse = new StudentResultResponse();
				mapper.map(s,studentResultResponse);
				studentResultResponse.setIndicators(indicatorRepository.findBystudentResultIdOrderByCode(studentResultResponse.getId()));
				studentResultResponses.add(studentResultResponse);
			}
			response = new ApiResponse(studentResultResponses,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
    }

	@Override
	public ApiResponse listBySpecialtySemesterPlusAchievementPercentage(MPlanLineSpecialtySemesterRequest lss) {
		ApiResponse response = null;
		try {
			List<StudentResult> listSr = studentResultRepository.findBySpecialtyIdAndSemesterIdOrderByCode(lss.getIdSpecialty(),lss.getIdSemester());
			List<StudentResultPercentageDataResponse> list= new ArrayList<StudentResultPercentageDataResponse>();
			Float percentage=100f;
			Integer counter;
			Integer counterTotal;
			Integer evalua;
			for(StudentResult studentResult : listSr) {
				StudentResultPercentageDataResponse sr= new StudentResultPercentageDataResponse();
				counter=0;
				counterTotal=0;
				evalua=1;
				for(Indicator indicator : indicatorRepository.findBystudentResultIdOrderByCode(studentResult.getId())) {
					counterTotal++;
					List<ResultsPerCard> rcs=resultsPerCardRepository.listResultsPerCardByIndicatorAll(indicator.getId());
					if(rcs!=null) {
						for(ResultsPerCard rc : rcs) {
								if(resultsPerCardRepository.evaluaStudentResultTotalMeasured(rc.getId())!=1f) {
									evalua=0;
								}					
						}
					}
					Float p = resultsPerCardRepository.listResultsPerCardByIndicator(indicator.getId());
					if(p!=null) {
						counter++;
						if(p<percentage)
							percentage=p;	
					}									
				}
				if(counter==0) {
					percentage=0f;
					sr.setFlagg(1);
				}
				else {
					if(counter!=counterTotal) {
						percentage=0f;		
						sr.setFlagg(2);
					}
					else {
						if(counter==counterTotal) {
							sr.setFlagg(3);
							if(evalua==1) {
								sr.setFlagg(4);
							}								
						}
				
					}
				}
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

	@Override
	public ApiResponse copyBySpecialtySemester(Integer idSpecialtyFrom, Integer idSemesterFrom, Integer idSpecialtyTo, Integer idSemesterTo) {
		ApiResponse response = null;
		try {
			Integer count = studentResultRepository.cloneStudentResults(idSpecialtyFrom, idSemesterFrom, idSpecialtyTo, idSemesterTo);
			if(count>0)
				response = new ApiResponse(count, 200);
			else
				response = new ApiResponse(400,"Nothing was updated");
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	//New method. If fails, delete
	@Override
	public ApiResponse listBySemestersPlusAchievementPercentage(Integer id_semester_start, Integer id_semester_end){
		ApiResponse response=null;
		try {
			List<StudentResult> listSr=studentResultRepository.findBySemesters(id_semester_start, id_semester_end);
			List<StudentResultPercentageDataResponse> list= new ArrayList<StudentResultPercentageDataResponse>();
			Float percentage=100f;
			Integer counter;
			Integer counterTotal;
			Integer evalua;
			for(StudentResult studentResult : listSr) {
				StudentResultPercentageDataResponse sr= new StudentResultPercentageDataResponse();
				counter=0;
				counterTotal=0;
				evalua=1;
				for(Indicator indicator : indicatorRepository.findBystudentResultIdOrderByCode(studentResult.getId())) {
					counterTotal++;
					List<ResultsPerCard> rcs=resultsPerCardRepository.listResultsPerCardByIndicatorAll(indicator.getId());
					if(rcs!=null) {
						for(ResultsPerCard rc : rcs) {
								if(resultsPerCardRepository.evaluaStudentResultTotalMeasured(rc.getId())!=1f) {
									evalua=0;
								}					
						}
					}
					Float p = resultsPerCardRepository.listResultsPerCardByIndicator(indicator.getId());
					if(p!=null) {
						counter++;
						if(p<percentage)
							percentage=p;	
					}									
				}
				if(counter==0) {
					percentage=0f;
					sr.setFlagg(1);
				}
				else {
					if(counter!=counterTotal) {
						percentage=0f;		
						sr.setFlagg(2);
					}
					else {
						if(counter==counterTotal) {
							sr.setFlagg(3);
							if(evalua==1) {
								sr.setFlagg(4);
							}								
						}
				
					}
				}
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
	@Override
	public ApiResponse listByCourseSemesterPlusSuccess(MPlanLineCourseSemesterRequest lss) {
		ApiResponse response = null;
		try {
			List<StudentResult> listSr = studentResultRepository.listStudentResultBySemesterCourse(lss.getIdSemester(),lss.getIdCourse());
			List<StudentResultSuccessDataResponse> list= new ArrayList<StudentResultSuccessDataResponse>();
			Integer counter;
			for(StudentResult studentResult : listSr) {
				StudentResultSuccessDataResponse sr= new StudentResultSuccessDataResponse();
				counter=0;
				for(Indicator indicator : indicatorRepository.findBystudentResultIdOrderByCode(studentResult.getId())) {
					Float p = resultsPerCardRepository.listResultsPerCardByIndicator(indicator.getId());
					if(p!=null) {
						counter++;
					}									
				}
				sr.setStudentResult(studentResult);
				if (counter!=0) sr.setSuccess(1);
				else sr.setSuccess(-1);				
				list.add(sr);
			}
			response = new ApiResponse(list,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse listBySpecialtySemesterPlusIndicatorsCoursesPercentage(MPlanLineSpecialtySemesterRequest lss) {
		ApiResponse response = null;
		try {
			List<StudentResult> listSr = studentResultRepository.findBySpecialtyIdAndSemesterIdOrderByCode(lss.getIdSpecialty(),lss.getIdSemester());
			List<StudentResultIndicatorsCoursesPercentagesDataResponse> list= new ArrayList<StudentResultIndicatorsCoursesPercentagesDataResponse>();
			Integer evalua;
			for(StudentResult studentResult : listSr) {
				StudentResultIndicatorsCoursesPercentagesDataResponse sr= new StudentResultIndicatorsCoursesPercentagesDataResponse();
				List<IndicatorCoursePercentageDataResponse> listICP= new ArrayList<IndicatorCoursePercentageDataResponse>();
				for(Indicator indicator : indicatorRepository.findBystudentResultIdOrderByCode(studentResult.getId())) {
					IndicatorCoursePercentageDataResponse icp = new IndicatorCoursePercentageDataResponse();
					icp.setIndicator(indicator);
					icp.setCourse(null);
					icp.setPercentage(0f);
					icp.setFlagg(0);
					evalua=1;
					Iterator<MeasurementPlanLine> i = measurementPlanLineRepository.findByIndicatorId(indicator.getId()).iterator();
					if(i.hasNext()) {	
						icp.setCourse(measurementPlanLineRepository.findByIndicatorId(indicator.getId()).iterator().next().getCourse());	
						Float p = resultsPerCardRepository.listResultsPerCardByIndicator(indicator.getId());
						if(p!=null) {
							icp.setPercentage(p);
						}	
						
						List<ResultsPerCard> rcs=resultsPerCardRepository.listResultsPerCardByIndicatorAll(indicator.getId());
						Integer counter1=0;
						Integer counter2=0;
						if(rcs!=null) {
							for(ResultsPerCard rc : rcs) {
								counter1++;
								if(resultsPerCardRepository.evaluaStudentResultTotalMeasured(rc.getId())==-1f) {
									counter2++;
								}
								if(resultsPerCardRepository.evaluaStudentResultTotalMeasured(rc.getId())!=1f) {
									evalua=0;
								}				
									
									
							}
						}
						if(evalua==0) {
							icp.setFlagg(1);
						}
						else {
							icp.setFlagg(2);
						}
						if(counter1!=0) {
							if(counter1==counter2) {
								icp.setFlagg(0);
							}
						}		
					}
					listICP.add(icp);
				}
				sr.setStudentResult(studentResult);
				sr.setListICP(listICP);	
				list.add(sr);
			}
			response = new ApiResponse(list,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse listBySpecialtySemestersPlusIndicatorsCoursesPercentage(
			StudentResultSpecialtySemestersRequest lss) {
		ApiResponse response = null;
		try {
			List<Semester> listSemester = semesterRepository.listSemestersRange(lss.getIdSemesterStart(), lss.getIdSemesterEnd());
			List<SemesterPercentagesDataResponse> listFinal = new ArrayList<SemesterPercentagesDataResponse>();
			for(Semester s : listSemester) {
				SemesterPercentagesDataResponse sps = new SemesterPercentagesDataResponse();
				sps.setSemester(s);				
				List<StudentResult> listSr = studentResultRepository.findBySpecialtyIdAndSemesterIdOrderByCode(lss.getIdSpecialty(),s.getId());
				List<StudentResultIndicatorsCoursesPercentagesDataResponse> list= new ArrayList<StudentResultIndicatorsCoursesPercentagesDataResponse>();
				Integer evalua;
				for(StudentResult studentResult : listSr) {
					StudentResultIndicatorsCoursesPercentagesDataResponse sr= new StudentResultIndicatorsCoursesPercentagesDataResponse();
					List<IndicatorCoursePercentageDataResponse> listICP= new ArrayList<IndicatorCoursePercentageDataResponse>();
					for(Indicator indicator : indicatorRepository.findBystudentResultIdOrderByCode(studentResult.getId())) {
						IndicatorCoursePercentageDataResponse icp = new IndicatorCoursePercentageDataResponse();
						icp.setIndicator(indicator);
						icp.setCourse(null);
						icp.setPercentage(0f);
						icp.setFlagg(0);
						evalua=1;
						Iterator<MeasurementPlanLine> i = measurementPlanLineRepository.findByIndicatorId(indicator.getId()).iterator();
						if(i.hasNext()) {	
							icp.setCourse(measurementPlanLineRepository.findByIndicatorId(indicator.getId()).iterator().next().getCourse());	
							Float p = resultsPerCardRepository.listResultsPerCardByIndicator(indicator.getId());
							if(p!=null) {
								icp.setPercentage(p);
							}	
							
							List<ResultsPerCard> rcs=resultsPerCardRepository.listResultsPerCardByIndicatorAll(indicator.getId());
							Integer counter1=0;
							Integer counter2=0;
							if(rcs!=null) {
								for(ResultsPerCard rc : rcs) {
									counter1++;
									if(resultsPerCardRepository.evaluaStudentResultTotalMeasured(rc.getId())==-1f) {
										counter2++;
									}
									if(resultsPerCardRepository.evaluaStudentResultTotalMeasured(rc.getId())!=1f) {
										evalua=0;
									}				
										
										
								}
							}
							if(evalua==0) {
								icp.setFlagg(1);
							}
							else {
								icp.setFlagg(2);
							}
							if(counter1!=0) {
								if(counter1==counter2) {
									icp.setFlagg(0);
								}
							}		
						}
						listICP.add(icp);
					}
					sr.setStudentResult(studentResult);
					sr.setListICP(listICP);	
					list.add(sr);				
			}
				sps.setPercentages(list);
				listFinal.add(sps);	
			}
			response = new ApiResponse(listFinal,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}
}
