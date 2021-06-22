package pe.edu.pucp.sia.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.LevelDetail;
import lombok.var;
import pe.edu.pucp.sia.model.MeasurementPlanLine;
import pe.edu.pucp.sia.model.ResultsPerCard;
import pe.edu.pucp.sia.model.Role;
import pe.edu.pucp.sia.model.Person;
import pe.edu.pucp.sia.model.Section;
import pe.edu.pucp.sia.model.comparators.LevelDetailComparator;
import pe.edu.pucp.sia.model.comparators.MeasurementPlanLineComparator;
import pe.edu.pucp.sia.repository.MeasurementPlanLineRepository;
import pe.edu.pucp.sia.repository.ResultsPerCardRepository;
import pe.edu.pucp.sia.repository.RoleRepository;
import pe.edu.pucp.sia.repository.SectionRepository;
import pe.edu.pucp.sia.response.ApiResponse;
import pe.edu.pucp.sia.service.MeasurementPlanLineService;


@Service
public class MeasurementPlanLineServiceImpl implements MeasurementPlanLineService{
	@Autowired
	private MeasurementPlanLineRepository mPlanLineRepository;
	@Autowired
	private SectionRepository sectionRepository;
	@Autowired
	private ResultsPerCardRepository resultsPerCardRepository;
	@Autowired
	private RoleRepository roleRepository;
	

	@Override
	public ApiResponse listAll() {
		ApiResponse response = null;
		try {
			Iterable<MeasurementPlanLine> list =  mPlanLineRepository.findAll();
			response = new ApiResponse(list,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
		
	}

	@Override
	public ApiResponse createMeasurementPlanLine(MeasurementPlanLine m) {
		ApiResponse response = null;
		try {
			//Obtiene rol profesor
			Integer idRoleProfesor = roleRepository.findByDescription("Profesor").getId();
			
			if(m.getSections()!=null) {
				List<ResultsPerCard> lista= new ArrayList<ResultsPerCard>();
				for(Section s : m.getSections()) {
					Integer idSection;
					idSection=sectionRepository.save(s).getId();
					s.setId(idSection);
					
					ResultsPerCard r= new ResultsPerCard();
					r.setSection(s);
					r.setId(resultsPerCardRepository.save(r).getId());
					lista.add(r);
					
					//Asigna rol profesor
					for(Person p : s.getTeachers()) {
						roleRepository.assignRole(idRoleProfesor, p.getId());
					}
				}
				m.setResultsPerCards(lista);
			}		
			Integer id = mPlanLineRepository.save(m).getId();
			response = new ApiResponse(id,201);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse updateMeasurementPlanLine(MeasurementPlanLine m) {
		ApiResponse response = null;
		try {
			//Obtiene rol profesor
			Integer idRoleProfesor = roleRepository.findByDescription("Profesor").getId();
			
			if(m.getSections()!=null) {
				for(Section s : m.getSections()) {
					//Busca profesores a cargo originalmente
					List<Integer> teachersOld = new ArrayList<>();
					var val = sectionRepository.findById(s.getId());
					if (val.isPresent()) {
						for (Person p : val.get().getTeachers())
							teachersOld.add(p.getId());
					}
					//Registra las secciones
					sectionRepository.save(s);
					
					//Asigna rol a profesores agregados
					for(Person p : s.getTeachers()) {
						roleRepository.assignRole(idRoleProfesor, p.getId());
					}
					
					//Verifica si fueron removidos los originales
					if (teachersOld!=null) {
						List<Integer> teachersRemove = new ArrayList<>();
						boolean find=false;
						for(Integer idTeacher : teachersOld){
							for(Person t : s.getTeachers()) {
								if (idTeacher.compareTo(t.getId())==0) {
									find=true;
									break;
								}
							}
							if (find==false)
								teachersRemove.add(idTeacher);
						}
						//Busca si no es profesor de otro curso para quitarle el rol
						for(Integer idT : teachersRemove){
							roleRepository.unassignTeacher(idT);
						}
					}
				}
			}
			if(m.getResultsPerCards()!=null) {
				for(ResultsPerCard r : m.getResultsPerCards())
					resultsPerCardRepository.save(r);
			}
			
			Integer id = mPlanLineRepository.save(m).getId();
			response = new ApiResponse(id,201);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse deleteMeasurementPlanLine(Integer id) {
		ApiResponse response = null;
		try {
			MeasurementPlanLine m=mPlanLineRepository.findById(id).get();
			for(ResultsPerCard r:m.getResultsPerCards()) {
				resultsPerCardRepository.deleteById(r.getId());
			}
			//Recorre horarios
			if(m.getSections()!=null) {
				for(Section s : m.getSections()) {
					//Busca profesores a cargo originalmente
					List<Integer> teachersOld = new ArrayList<>();
					for (Person p : s.getTeachers())
						teachersOld.add(p.getId());
					
					//Elimina las secciones
					//s.setTeachers(null);
					//sectionRepository.save(s);
					sectionRepository.deleteById(s.getId());
					
					//Busca profesores a cargo
					if (teachersOld != null) {
						//Busca si no es profesor de otro curso para quitarle el rol
						for(Integer idT : teachersOld){
							roleRepository.unassignTeacher(idT);
						}
					}
					
				}
			}
			mPlanLineRepository.deleteById(id);
			response = new ApiResponse("Success",200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}
	
	public ApiResponse listByCourse(Integer idFaculty){
		ApiResponse response = null;
		try {
			Iterable<MeasurementPlanLine> list = mPlanLineRepository.findByCourseId(idFaculty);
			response = new ApiResponse(list,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse listBySpecialtyAndSemester(Integer idSpecialty, Integer idSemester) {
		ApiResponse response = null;
		try {
			Iterable<MeasurementPlanLine> list = mPlanLineRepository.findByIndicatorStudentResultSpecialtyIdAndSemesterId(idSpecialty, idSemester);
			for(MeasurementPlanLine mpl : list) {
				mpl.getCourse().setSpecialty(null);			
				mpl.setSemester(null);
				mpl.setResultsPerCards(null);
			}
			response = new ApiResponse(list,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		
		return response;
	}

	@Override
	public ApiResponse listByCourseSemesterTeacher(Integer idCourse, Integer idSemester,Integer idPerson) {
		ApiResponse response = null;
		try {
			Person person = new Person();
			person.setId(idPerson);
			List<Person> personList = new ArrayList<Person>();
			personList.add(person);
			Iterable<MeasurementPlanLine> list = mPlanLineRepository.findByCourseIdAndSemesterIdAndSectionsTeachersInOrderByIndicatorCodeAsc(idCourse, idSemester, personList);
			for(MeasurementPlanLine m : list) {
				List<Section> newSectionList = new ArrayList<Section>();
				List<ResultsPerCard> newResultspercardList = new ArrayList<ResultsPerCard>();
				Iterator<ResultsPerCard> i = m.getResultsPerCards().iterator();
				for(Section s : m.getSections()) {
					ResultsPerCard r = i.next();
					for(Person p : s.getTeachers())
						if(p.getId().equals(idPerson)) {
							newSectionList.add(s);
							r.setSection(null);
							newResultspercardList.add(r);
					}
				}
				m.setSections(newSectionList);
				m.setResultsPerCards(newResultspercardList);
				
				m.getIndicator().getLevelDetails().sort(new LevelDetailComparator());
			}
			for(MeasurementPlanLine mpl : list) {	
				mpl.setCourse(null);
				mpl.setSemester(null);
			}
			response = new ApiResponse(list,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse listByCourseAndSemester(Integer idCourse, Integer idSemester) {
		ApiResponse response = null;
		try {
			Iterable<MeasurementPlanLine>  list = mPlanLineRepository.findByCourseIdAndSemesterId(idCourse, idSemester);
			for(MeasurementPlanLine mpl : list) {	
				mpl.setCourse(null);
				mpl.setSemester(null);
			}
			response = new ApiResponse(list,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse listBySemesterAndTeachers(Integer idSemester, Integer idPerson) {
		ApiResponse response = null;
		try {
			Person p = new Person();
			p.setId(idPerson);
			List<Person> personList = new ArrayList<Person>();
			personList.add(p);
			Iterable<MeasurementPlanLine> list = mPlanLineRepository.findBySemesterIdAndSectionsTeachersIn(idSemester, personList);
			for(MeasurementPlanLine mpl : list) {
				mpl.setIndicator(null);
				mpl.setSemester(null);
				for(ResultsPerCard r : mpl.getResultsPerCards())
					r.setSection(null);
			}
			response = new ApiResponse(list,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		
		return response;
	}

	@Override
	public ApiResponse listByCourseAndSemesterAndSchedule(Integer idCourse, Integer idSemester,Integer code) {
		ApiResponse response = null;
		try {
			List<MeasurementPlanLine> listMpl = new ArrayList<MeasurementPlanLine>();	
			Iterable<MeasurementPlanLine> list = mPlanLineRepository.findByCourseIdAndSemesterId(idCourse, idSemester);
			for(MeasurementPlanLine mpl : list) {
				mpl.setCourse(null);
				mpl.setSemester(null);

				List<Section> ss=new ArrayList<Section>();
				List<Section> a=sectionRepository.findByCode(code);
				if(!a.isEmpty()) {
					for(Section b: a ) {
						for(Section sec : mpl.getSections()) {
							if(sec.equals(b)) {
								ss.add(b);			
							}
						}
					}
				}		
				/*if(s!=null) {
					for(Section sec : mpl.getSections()) {
						if(sec.equals(s)) {
							ss.add(s);
						}
					}
				}*/
				mpl.setSections(ss);	
				
				List<ResultsPerCard> rr=new ArrayList<ResultsPerCard>();
				if(!(resultsPerCardRepository.findBySectionCodeAndMeasurementPlanLineId(code,mpl.getId())).isEmpty()) {
					ResultsPerCard r=resultsPerCardRepository.findBySectionCodeAndMeasurementPlanLineId(code,mpl.getId()).get(0);
					if(r!=null) {
						for(ResultsPerCard res : mpl.getResultsPerCards()) {
							if(res.equals(r)) {
								rr.add(r);
							}
						}
					}
				}				
				mpl.setResultsPerCards(rr);
				
				List<Section> sections=mpl.getSections();
				if (!sections.isEmpty()) {
					listMpl.add(mpl);
				}			
			}
			listMpl.sort(new MeasurementPlanLineComparator());
			response = new ApiResponse(listMpl,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}
}
