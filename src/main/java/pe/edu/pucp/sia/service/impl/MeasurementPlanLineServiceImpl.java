package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.MeasurementPlanLine;
import pe.edu.pucp.sia.repository.MeasurementPlanLineRepository;
import pe.edu.pucp.sia.service.MeasurementPlanLineService;

@Service
public class MeasurementPlanLineServiceImpl implements MeasurementPlanLineService{
	@Autowired
	private MeasurementPlanLineRepository mPlanLineRepository;

	@Override
	public Iterable<MeasurementPlanLine> listAll() {
		return mPlanLineRepository.findAll();
	}

	@Override
	public String createMeasurementPlanLine(MeasurementPlanLine m) {
		String response = "";
		try {
			mPlanLineRepository.save(m);
			response = "Created";
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public String updateMeasurementPlanLine(MeasurementPlanLine m) {
		String response = "";
		try {
			mPlanLineRepository.save(m);
			response = "Updated";
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public String deleteMeasurementPlanLine(Integer id) {
		String response = "";
		try {
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
		}
	} catch(Exception ex) {
		System.out.println(ex.getMessage());
	}
	
	return list;
	}

}
