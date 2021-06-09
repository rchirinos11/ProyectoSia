package pe.edu.pucp.sia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.MeasurementPlanLine;
import pe.edu.pucp.sia.model.ResultsPerCard;
import pe.edu.pucp.sia.model.Section;
import pe.edu.pucp.sia.repository.MeasurementPlanLineRepository;
import pe.edu.pucp.sia.repository.ResultsPerCardRepository;
import pe.edu.pucp.sia.repository.SectionRepository;
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
						resultsPerCardRepository.save(r);
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
			/*MeasurementPlanLine m=mPlanLineRepository.findById(id).get();
			for(ResultsPerCard r:m.getResultsPerCards()) {
				resultsPerCardRepository.deleteById(r.getId());
			}*/
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
		/*try {
			list = mPlanLineRepository.listMeasurementPlanLineByCourseSemesterTeacher(idCourse, idSemester, idPerson);
			for(MeasurementPlanLine mpl : list) {	
				mpl.setCourse(null);
				mpl.setSemester(null);
			}
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}*/
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
}
