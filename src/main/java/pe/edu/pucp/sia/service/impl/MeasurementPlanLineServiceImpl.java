package pe.edu.pucp.sia.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.var;
import pe.edu.pucp.sia.model.Indicator;
import pe.edu.pucp.sia.model.Measurement;
import pe.edu.pucp.sia.model.MeasurementPlanLine;
import pe.edu.pucp.sia.model.ResultsPerCard;
import pe.edu.pucp.sia.model.Person;
import pe.edu.pucp.sia.model.Section;
import pe.edu.pucp.sia.model.comparators.LevelDetailComparator;
import pe.edu.pucp.sia.model.comparators.MeasurementPlanLineComparator;
import pe.edu.pucp.sia.repository.MeasurementPlanLineRepository;
import pe.edu.pucp.sia.repository.MeasurementRepository;
import pe.edu.pucp.sia.repository.ResultsPerCardRepository;
import pe.edu.pucp.sia.repository.RoleRepository;
import pe.edu.pucp.sia.repository.SectionRepository;
import pe.edu.pucp.sia.requests.MPlanLineBatchRegisterRequest;
import pe.edu.pucp.sia.response.ApiResponse;
import pe.edu.pucp.sia.response.ResultsPerCardScheduleDataResponse;
import pe.edu.pucp.sia.response.ResultsPerCardScheduleListDataResponse;
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
	@Autowired
	private MeasurementRepository measurementRepository;

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
				List<ResultsPerCard> list= new ArrayList<ResultsPerCard>();
				for(Section s : m.getSections()) {
					if(s.getId()==null) {
						s.setId(sectionRepository.save(s).getId());

						ResultsPerCard r= new ResultsPerCard();
						r.setSection(s);
						r.setId(resultsPerCardRepository.save(r).getId());
						list.add(r);

						//Asigna rol profesor
						if(s.getTeachers()!=null) {
							for(Person p : s.getTeachers()) 
								roleRepository.assignRole(idRoleProfesor, p.getId());
						}
					}
				}
				m.setResultsPerCards(list);
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
		MeasurementPlanLine mOri = null;
		boolean valido=true;
		try {
			//Obtiene measurement plan line original
			var valMpl = mPlanLineRepository.findById(m.getId());
			if (valMpl.isPresent())
				mOri = valMpl.get();
			//Verifica si antiguo curso se cambio y tenían mediciones
			if (!mOri.getCourse().getId().equals(m.getCourse().getId())) {
				for (ResultsPerCard rpc : mOri.getResultsPerCards()) {
					if (rpc.getTotalStudents()>0) {
						valido = false;
						response = new ApiResponse(500, "Course "+mOri.getCourse().getName()+" with section "+rpc.getSection().getCode()+" has meditions done.");
						break;
					}
				}
			}
			//Verifica si antiguos horarios se cambiaron y tenían mediciones
			if (valido)
				for (ResultsPerCard rpc : mOri.getResultsPerCards()) {
					int sectionOri = rpc.getSection().getCode();
					valido = false;
					for (Section section : m.getSections()) {
						//Si aún está, es válido
						if (sectionOri == section.getCode()) {
							valido = true;
							break;
						}
					}
					//Si ya no está, verifica si tenía mediciones
					if (!valido && rpc.getTotalStudents()>0) {
						valido = false;
						response = new ApiResponse(500, "Section "+sectionOri+" has meditions done.");
						break;
					}
					valido = true;
				}
			
			if (valido) {
				//Obtiene rol profesor
				Integer idRoleProfesor = roleRepository.findByDescription("Profesor").getId();
				List<ResultsPerCard> rPerCardList = m.getResultsPerCards();
				if(m.getSections()!=null) {
					for(Section s : m.getSections()) {
						if(s.getId()==null) {
							s.setId(sectionRepository.save(s).getId());
							
							ResultsPerCard r= new ResultsPerCard();
							r.setSection(s);
							r.setId(resultsPerCardRepository.save(r).getId());
							rPerCardList.add(r);
							//Verifica curso y horario existente
							copyStudentList(m,s,r);
							
						} else {
							//Verifica curso y horario existente
							List<ResultsPerCard> listRPC = resultsPerCardRepository.findByMeasurementPlanLineIdAndSectionId(m.getId(),s.getId());
							if (!listRPC.isEmpty()) {
								copyStudentList(m,s,listRPC.get(0));
							}
							//Busca profesores a cargo originalmente
							List<Integer> teachersOld = new ArrayList<>();
							var val = sectionRepository.findById(s.getId());
							if (val.isPresent() && val.get().getTeachers()!=null) {
								for (Person p : val.get().getTeachers())
									teachersOld.add(p.getId());
							}
							
							//Verifica si fueron removidos los originales
							if (!teachersOld.isEmpty()) {
								boolean find=false;
								for(Integer idTeacher : teachersOld){
									for(Person t : s.getTeachers()) {
										if (idTeacher.equals(t.getId())) {
											find=true;
											break;
										}
									}
									//Busca si no es profesor de otro curso para quitarle el rol
									if (find==false)
										roleRepository.unassignTeacher(idTeacher);
								}
							}
							sectionRepository.save(s);
						}
						//Asigna rol a profesores agregados
						if(s.getTeachers()!=null) {
							for(Person p : s.getTeachers())
								roleRepository.assignRole(idRoleProfesor, p.getId());
						}
					}
					m.setResultsPerCards(rPerCardList);
				}			
				Integer id = mPlanLineRepository.save(m).getId();
				response = new ApiResponse(id,201);
			}
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
			Iterable<MeasurementPlanLine> list = mPlanLineRepository.findDistinctBySemesterIdAndSectionsTeachersIn(idSemester, personList);
			for(MeasurementPlanLine mpl : list) {
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

	@Override
	public ApiResponse listByCourseAndSemesterPlusCode(Integer idCourse, Integer idSemester) {
		ApiResponse response = null;
		try {
			List<ResultsPerCardScheduleListDataResponse> list = new ArrayList<ResultsPerCardScheduleListDataResponse>();
			Iterable<MeasurementPlanLine>  listMpl = mPlanLineRepository.findByCourseIdAndSemesterId(idCourse, idSemester);
			for(MeasurementPlanLine mpl : listMpl) {	
				ResultsPerCardScheduleListDataResponse rs = new ResultsPerCardScheduleListDataResponse();
				Indicator ind=mpl.getIndicator();
				ind.setStudentResult(null);
				ind.setLevelDetails(null);
				rs.setIndicator(ind);				
				List<ResultsPerCardScheduleDataResponse> listr = new ArrayList<ResultsPerCardScheduleDataResponse>();
				for(ResultsPerCard rc : mpl.getResultsPerCards()) {
					ResultsPerCardScheduleDataResponse r= new ResultsPerCardScheduleDataResponse();			
					r.setCode(resultsPerCardRepository.findById(rc.getId()).get().getSection().getCode());
					rc.setSection(null);
					r.setResultsPerCard(rc);	
					listr.add(r);
				}
				rs.setResultsPerCardScheduleDataResponses(listr); 
				list.add(rs);
			}
			response = new ApiResponse(list,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	private boolean copyStudentList(MeasurementPlanLine mpl, Section s, ResultsPerCard r) {
		boolean copio=false;
		//Verifica curso y horario existente
		List<ResultsPerCard> listRPC =
		resultsPerCardRepository.findByMeasurementPlanLineCourseIdAndSectionCode(
				mpl.getCourse().getId(),s.getCode());
		if (listRPC!=null) {
			for (ResultsPerCard rpc : listRPC) {
				//Busca que tenga mediciones con alumnos
				List<Measurement> listMea = rpc.getMeasurements();
				if (listMea != null) {
					for (Measurement m : listMea) {
						Measurement newMea = new Measurement();
						newMea.setResultsPerCard(r);
						newMea.setPerson(m.getPerson());
						measurementRepository.save(newMea);
					}
					copio = true;
					break; //terminó de copiar lista
				}
			}
		}
		return copio;
	}
	
	@Override
	public ApiResponse registerMeasurementPlanLineBatch(MPlanLineBatchRegisterRequest mplRequest) {
		ApiResponse response = null;
		Indicator indicator = new Indicator();
		try {
			MeasurementPlanLine mpl = mplRequest.getMeasurementPlanLine();
			//Lista indicadores
			for (Integer idIndicator : mplRequest.getIndicators()) {
				indicator.setId(idIndicator);
				mpl.setIndicator(indicator);
				//Debe crear secciones nuevas, porque no permite poner id null una vez registrado
				List<Section> listSection = new ArrayList<Section>();
				for(Section s : mpl.getSections()) {
					Section newSection = new Section();
					newSection.setCode(s.getCode());
					//Al igual que los profesores de las secciones
					List<Person> listTeacher = new ArrayList<Person>();
					for (Person t : s.getTeachers()) {
						Person newTeacher = new Person();
						newTeacher.setId(t.getId());
						listTeacher.add(newTeacher);
					}
					newSection.setTeachers(listTeacher);
					listSection.add(newSection);
				}
				mpl.setSections(listSection);
				
				//Obtiene rol profesor
				Integer idRoleProfesor = roleRepository.findByDescription("Profesor").getId();
				
				if(mpl.getSections()!=null) {
					List<ResultsPerCard> list= new ArrayList<ResultsPerCard>();
					for(Section s : mpl.getSections()) {
						s.setId(sectionRepository.save(s).getId());

						//Genera ResultPerCard
						ResultsPerCard r= new ResultsPerCard();
						r.setSection(s);
						r.setId(resultsPerCardRepository.save(r).getId());
						list.add(r);

						//Asigna rol profesor
						if(s.getTeachers()!=null) {
							for(Person p : s.getTeachers()) 
								roleRepository.assignRole(idRoleProfesor, p.getId());
						}
						
						//Verifica curso y horario existente
						copyStudentList(mpl,s,r);
					}
					mpl.setResultsPerCards(list);
				}		
				mPlanLineRepository.save(mpl).getId();	
			}
			response = new ApiResponse(mplRequest.getIndicators().size(),201);
		} catch (Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}
}
