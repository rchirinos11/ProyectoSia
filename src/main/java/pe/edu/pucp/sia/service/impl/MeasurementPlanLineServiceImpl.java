package pe.edu.pucp.sia.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.Indicator;
import pe.edu.pucp.sia.model.LevelDetail;
import pe.edu.pucp.sia.model.MeasurementPlanLine;
import pe.edu.pucp.sia.model.ResultsPerCard;
import pe.edu.pucp.sia.model.Person;
import pe.edu.pucp.sia.model.Section;
import pe.edu.pucp.sia.repository.MeasurementPlanLineRepository;
import pe.edu.pucp.sia.repository.ResultsPerCardRepository;
import pe.edu.pucp.sia.repository.SectionRepository;
import pe.edu.pucp.sia.response.MeasurementPlanResponse;
import pe.edu.pucp.sia.service.MeasurementPlanLineService;


@Service
public class MeasurementPlanLineServiceImpl implements MeasurementPlanLineService{
	@Autowired
	private MeasurementPlanLineRepository mPlanLineRepository;
	@Autowired
	private SectionRepository sectionRepository;
	@Autowired
	private ResultsPerCardRepository resultsPerCardRepository;

	@Override
	public Iterable<MeasurementPlanLine> listAll() {
		return mPlanLineRepository.findAll();
	}

	@Override
	public Integer createMeasurementPlanLine(MeasurementPlanLine m) {
		Integer response = null;
		try {
			if(m.getSections()!=null) {
				for(Section s : m.getSections())
					if(s.getId()==null)
						sectionRepository.save(s);
			}
			if(m.getResultsPerCards()!=null) {
				for(ResultsPerCard r : m.getResultsPerCards()) 
					if(r.getId()==null) 
						resultsPerCardRepository.save(r).getId();												
			}		
			response = mPlanLineRepository.save(m).getId();
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public Integer updateMeasurementPlanLine(MeasurementPlanLine m) {
		Integer response = null;
		try {
			if(m.getSections()!=null) {
				for(Section s : m.getSections())
					if(s.getId()==null)
						sectionRepository.save(s);
			}
			if(m.getResultsPerCards()!=null) {
				for(ResultsPerCard r : m.getResultsPerCards())
					if(r.getId()==null)
						resultsPerCardRepository.save(r);
			}
			
			response = mPlanLineRepository.save(m).getId();
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public String deleteMeasurementPlanLine(Integer id) {
		String response = "";
		try {
			MeasurementPlanLine m=mPlanLineRepository.findById(id).get();
			for(ResultsPerCard r:m.getResultsPerCards()) {
				resultsPerCardRepository.deleteById(r.getId());
			}
			mPlanLineRepository.deleteById(id);
			response = "Deleted";
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}
	
	public Iterable<MeasurementPlanLine> listByCourse(Integer idFaculty){
		return mPlanLineRepository.findByCourseId(idFaculty);
	}

	@Override
	public Iterable<MeasurementPlanLine> listBySpecialtyAndSemester(Integer idSpecialty, Integer idSemester) {
		Iterable<MeasurementPlanLine> list = null;
		try {
			list = mPlanLineRepository.findByIndicatorStudentResultSpecialtyIdAndSemesterId(idSpecialty, idSemester);
			for(MeasurementPlanLine mpl : list) {
				mpl.getIndicator().getStudentResult().setSpecialty(null);
				mpl.setSemester(null);
			}
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return list;
	}

	@Override
	public Iterable<MeasurementPlanLine> listByCourseSemesterTeacher(Integer idCourse, Integer idSemester,Integer idPerson) 
	{
		Iterable<MeasurementPlanLine> list = null;
		try {
			list = mPlanLineRepository.listMeasurementPlanLineByCourseSemesterTeacher(idCourse, idSemester, idPerson);
			for(MeasurementPlanLine mpl : list) {	
				mpl.setCourse(null);
				mpl.setSemester(null);
				//indicator = mpl.getIndicator();
				//indicator.setSpecialty(null);
				//mpl.setIndicator(indicator);
				//mpl.setIndicator(mpl.getIndicator());
				mpl.getIndicator().getStudentResult().setSpecialty(null);
				List<LevelDetail> listLevelDetail = mpl.getIndicator().getLevelDetails();
				for (LevelDetail ld : listLevelDetail) {
					ld.getMeasurementLevel().setSpecialty(null);
				}
			}
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return list;
	}

	@Override
	public Iterable<MeasurementPlanLine> listByCourseAndSemester(Integer idCourse, Integer idSemester) {
		Iterable<MeasurementPlanLine> list = null;
		try {
			list = mPlanLineRepository.findByCourseIdAndSemesterId(idCourse, idSemester);
			for(MeasurementPlanLine mpl : list) {	
				mpl.setCourse(null);
				mpl.setSemester(null);
			}
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return list;
	}

	@Override
	public Iterable<MeasurementPlanLine> listBySemesterAndTeachers(Integer idSemester, Integer idPerson) {
		Iterable<MeasurementPlanLine> list = null;
		try {
			Person p = new Person();
			p.setId(idPerson);
			List<Person> personList = new ArrayList<Person>();
			personList.add(p);
			list = mPlanLineRepository.findBySemesterIdAndPersonsIn(idSemester, personList);
			for(MeasurementPlanLine mpl : list) {
				mpl.setIndicator(null);
				mpl.setPersons(null);
				mpl.setSemester(null);
			}
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return list;
	}
	/*
	@Override
	public Iterable<MeasurementPlanResponse> listByCourseSemesterTeacher(Integer idCourse, Integer idSemester,
			Integer idPerson) {
		Iterable<MeasurementPlanResponse> responseList = null;
		List<MeasurementPlanResponse> list = new ArrayList<MeasurementPlanResponse>();
		Iterable<MeasurementPlanLine> measurementPlanList;
		Iterable<ResultsPerCard> resultsPerCardList;
		Iterable<Section> sectionList;
		
		try {
			measurementPlanList = mPlanLineRepository.listMeasurementPlanLineByCourseSemesterTeacher(idCourse, idSemester, idPerson);
			for(MeasurementPlanLine mpl : measurementPlanList) {	
				mpl.setCourse(null);
				mpl.setSemester(null);
				
				resultsPerCardList = resultsPerCardRepository.findByMeasurementPlanLineId(mpl.getId());
				for (ResultsPerCard rc : resultsPerCardList) {
					rc.setMeasurementPlanLine(null);
				}
				sectionList = sectionRepository.listSectionByMeasurementPlanLine(mpl.getId());
				MeasurementPlanResponse response = new MeasurementPlanResponse();
				response.setMeasurementPlanLine(mpl);
				response.setResultsPerCardList(resultsPerCardList);
				response.setSectionList(sectionList);
				list.add(response);
			}
			//Genera Iterable a partir de la lista
			responseList = list;
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return responseList;	
	}
	*/

}
