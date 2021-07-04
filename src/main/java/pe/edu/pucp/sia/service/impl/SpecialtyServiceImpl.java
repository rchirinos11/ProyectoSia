package pe.edu.pucp.sia.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.Faculty;
import pe.edu.pucp.sia.model.Person;
import pe.edu.pucp.sia.model.ResultsPerCard;
import pe.edu.pucp.sia.model.Role;
import pe.edu.pucp.sia.model.Semester;
import pe.edu.pucp.sia.model.Specialty;
import pe.edu.pucp.sia.model.SuccessPercentage;
import pe.edu.pucp.sia.repository.PersonRepository;
import pe.edu.pucp.sia.repository.ResultsPerCardRepository;
import pe.edu.pucp.sia.repository.RoleRepository;
import pe.edu.pucp.sia.repository.SemesterRepository;
import pe.edu.pucp.sia.repository.SpecialtyRepository;
import pe.edu.pucp.sia.repository.SuccessPercentageRepository;
import pe.edu.pucp.sia.response.ApiResponse;
import pe.edu.pucp.sia.service.SpecialtyService;

@Service
public class SpecialtyServiceImpl implements SpecialtyService{
	@Autowired
	private SpecialtyRepository specialtyRepository;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private SemesterRepository semesterRepository;
	
	@Autowired
	private SuccessPercentageRepository successPercentageRepository;
	
	@Override
	public ApiResponse listAll(){
		ApiResponse response = null;
		 try {
			Iterable<Specialty> list = specialtyRepository.findAll();
		 	response = new ApiResponse(list,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse createSpecialty(Specialty s) {
		ApiResponse response = null;
		try {
			List<Role> roleList1=new ArrayList<Role>();
			List<Role> roleList2=new ArrayList<Role>();
			Integer evaulateIfCoordinator=0;
			Integer evaluateIfAssistant=0;
			if(s.getCoordinator()!=null){
				Person person1 =personRepository.findById(s.getCoordinator().getId()).get();
				roleList1=person1.getRoleList();
				for(Role r: roleList1) {
					if(r.getId()==3) {
						evaulateIfCoordinator=1;
					}					
				}		
				if(evaulateIfCoordinator==0) {
					roleList1.add(roleRepository.findById(3).get());
					person1.setRoleList(roleList1);
					personRepository.save(person1);
				}
			}	

			if(s.getAssistant()!=null){
				Person person2 =personRepository.findById(s.getAssistant().getId()).get();
				roleList2=person2.getRoleList();
				for(Role r: roleList2) {
					if(r.getId()==4) {
						evaluateIfAssistant=1;
					}					
				}		
				if(evaluateIfAssistant==0) {
					roleList2.add(roleRepository.findById(4).get());
					person2.setRoleList(roleList2);
					personRepository.save(person2);
				}
			}			
			//Registra specialty
			Integer id = specialtyRepository.save(s).getId();
			
			//Agrega porcentaje del semestre actual
			Semester semester = semesterRepository.findByCurrent(true);
			SuccessPercentage sucPer = new SuccessPercentage();
			sucPer.setSpecialty(s);
			sucPer.setSemester(semester);
			successPercentageRepository.save(sucPer);
			
			response = new ApiResponse(id,201);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse updateSpecialty(Specialty s) {
		ApiResponse response = null;
		try {
			Person cord=specialtyRepository.findById(s.getId()).get().getCoordinator();	
			List<Role> roleList1=new ArrayList<Role>();
			Integer evaulateIfCoordinator=0;
			if(s.getCoordinator()!=null){
				Person person1 =personRepository.findById(s.getCoordinator().getId()).get();				
				if(cord!=null) {
					if(person1!=cord) {
						roleList1=person1.getRoleList();
						for(Role r: roleList1) {
							if(r.getId()==3) {
								evaulateIfCoordinator=1;
							}					
						}		
						if(evaulateIfCoordinator==0) {
							roleList1.add(roleRepository.findById(3).get());
							person1.setRoleList(roleList1);
							personRepository.save(person1);
						}	
						List <Specialty> fs1=specialtyRepository.findByCoordinatorId(cord.getId());
						if(fs1.size()==1) {
							List<Role> cordRoleList=cord.getRoleList();
							cordRoleList.removeIf(r -> r.getId()==3);
							cord.setRoleList(cordRoleList);
							personRepository.save(cord);
						}
					}
				}
				else {
					roleList1=person1.getRoleList();
					for(Role r: roleList1) {
						if(r.getId()==3) {
							evaulateIfCoordinator=1;
						}					
					}		
					if(evaulateIfCoordinator==0) {
						roleList1.add(roleRepository.findById(3).get());
						person1.setRoleList(roleList1);
						personRepository.save(person1);
					}	
				}											
			}
			else {
				if(cord!=null) {
					List <Specialty> fs1=specialtyRepository.findByCoordinatorId(cord.getId());
					if(fs1.size()==1) {
						List<Role> cordRoleList=cord.getRoleList();
						cordRoleList.removeIf(r -> r.getId()==3);
						cord.setRoleList(cordRoleList);
						personRepository.save(cord);
					}
				}
			}	
			
			Person ass=specialtyRepository.findById(s.getId()).get().getAssistant();	
			List<Role> roleList2=new ArrayList<Role>();
			Integer evaluateIfAssistant=0;
			if(s.getAssistant()!=null){
				Person person2 =personRepository.findById(s.getAssistant().getId()).get();				
				if(ass!=null) {
					if(person2!=ass) {
						roleList2=person2.getRoleList();
						for(Role r: roleList2) {
							if(r.getId()==4) {
								evaluateIfAssistant=1;
							}					
						}		
						if(evaluateIfAssistant==0) {
							roleList2.add(roleRepository.findById(4).get());
							person2.setRoleList(roleList2);
							personRepository.save(person2);
						}	
						List <Specialty> fs2=specialtyRepository.findByAssistantId(ass.getId());
						if(fs2.size()==1) {
							List<Role> assRoleList=ass.getRoleList();
							assRoleList.removeIf(r -> r.getId()==4);
							ass.setRoleList(assRoleList);
							personRepository.save(ass);
						}
					}
				}
				else {
					roleList2=person2.getRoleList();
					for(Role r: roleList2) {
						if(r.getId()==4) {
							evaluateIfAssistant=1;
						}					
					}		
					if(evaluateIfAssistant==0) {
						roleList2.add(roleRepository.findById(4).get());
						person2.setRoleList(roleList2);
						personRepository.save(person2);
					}	
				}											
			}
			else {
				if(ass!=null) {
					List <Specialty> fs2=specialtyRepository.findByAssistantId(ass.getId());
					if(fs2.size()==1) {
						List<Role> assRoleList=ass.getRoleList();
						assRoleList.removeIf(r -> r.getId()==4);
						ass.setRoleList(assRoleList);
						personRepository.save(ass);
					}
				}
			}	
			
			Integer id = specialtyRepository.save(s).getId();
			response = new ApiResponse(id,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse deleteSpecialty(Integer id) {
		ApiResponse response = null;
		try {
			specialtyRepository.deleteSpecialty(id);
			response = new ApiResponse("Success",200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse listByFaculty(Integer id) {
		ApiResponse response = null;
		 try {
			Iterable<Specialty> list = specialtyRepository.findByFacultyId(id);
			for (Specialty specialty : list) {
				specialty.setFaculty(null);
			}
		 	response = new ApiResponse(list,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse listByCoordinator(Integer id) {
		ApiResponse response = null;
		 try {
			Iterable<Specialty> list = specialtyRepository.findByCoordinatorId(id);
			for (Specialty specialty : list) {
				specialty.setCoordinator(null);
			}
		 	response = new ApiResponse(list,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse listByAssistant(Integer id) {
		ApiResponse response = null;
		 try {
			Iterable<Specialty> list = specialtyRepository.findByAssistantId(id);
			for (Specialty specialty : list) {
				specialty.setAssistant(null);
			}
		 	response = new ApiResponse(list,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse updateCoordinator(Integer idSpecialty, Integer idCoordinator) {
		ApiResponse response = null;
		try {
			specialtyRepository.setCoordinator(idSpecialty,idCoordinator);
			response = new ApiResponse("Success",200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse updateAssitant(Integer idSpecialty, Integer idAssistant) {
		ApiResponse response = null;
		try {
			specialtyRepository.setAssistant(idSpecialty,idAssistant);
			response = new ApiResponse("Success",200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse updatePercentage(Integer idSpecialty, Integer percentage){
		ApiResponse response = null;
		try {
			Semester semester = semesterRepository.findByCurrent(true);
			if (semester!=null) {
				specialtyRepository.setPercentage(idSpecialty,semester.getId(),percentage);
				response = new ApiResponse("Success",200);
			}
			else
				response = new ApiResponse(500, "Don't exist a current semester.");
			
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse archiveSpecialty(Integer idSpecialty, boolean state) {
		ApiResponse response = null;
		try {
			specialtyRepository.archiveSpecialty(idSpecialty,state);
			response = new ApiResponse("Success", 200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}
}
