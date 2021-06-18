package pe.edu.pucp.sia.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.Faculty;
import pe.edu.pucp.sia.model.Person;
import pe.edu.pucp.sia.model.Role;
import pe.edu.pucp.sia.model.Specialty;
import pe.edu.pucp.sia.repository.FacultyRepository;
import pe.edu.pucp.sia.repository.PersonRepository;
import pe.edu.pucp.sia.repository.RoleRepository;
import pe.edu.pucp.sia.response.ApiResponse;
import pe.edu.pucp.sia.service.FacultyService;

@Service
public class FacultyServiceImpl implements FacultyService{

	@Autowired
	private FacultyRepository facultyRepository;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public ApiResponse listAll() {
		ApiResponse response = null;
		try {
			Iterable<Faculty> list = facultyRepository.findAll();
			response = new ApiResponse(list, 200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse createFaculty(Faculty f) {
		ApiResponse response = null;
		try {
			List<Role> roleList=new ArrayList<Role>();
			Integer evaluaSiCoordinador=0;
			if(f.getCoordinator()!=null){
				Person person =personRepository.findById(f.getCoordinator().getId()).get();
				roleList=person.getRoleList();
				for(Role r: roleList) {
					if(r.getId()==2) {
						evaluaSiCoordinador=1;
					}					
				}		
				if(evaluaSiCoordinador==0) {
					roleList.add(roleRepository.findById(2).get());
					person.setRoleList(roleList);
					personRepository.save(person);
				}
			}		
			Integer id = facultyRepository.save(f).getId();
			response = new ApiResponse(id, 201);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse updateFaculty(Faculty f) {
		ApiResponse response = null;
		try {
			Person cord=facultyRepository.findById(f.getId()).get().getCoordinator();	
			List<Role> roleList=new ArrayList<Role>();
			Integer evaluaSiCoordinador=0;
			if(f.getCoordinator()!=null){
				Person person =personRepository.findById(f.getCoordinator().getId()).get();				
				if(cord!=null) {
					if(person!=cord) {
						roleList=person.getRoleList();
						for(Role r: roleList) {
							if(r.getId()==2) {
								evaluaSiCoordinador=1;
							}					
						}		
						if(evaluaSiCoordinador==0) {
							roleList.add(roleRepository.findById(2).get());
							person.setRoleList(roleList);
							personRepository.save(person);
						}	
						List <Faculty> fs=facultyRepository.findByCoordinatorId(cord.getId());
						if(fs.size()==1) {
							List<Role> cordRoleList=cord.getRoleList();
							cordRoleList.removeIf(r -> r.getId()==2);
							cord.setRoleList(cordRoleList);
							personRepository.save(cord);
						}
					}
				}
				else {
					roleList=person.getRoleList();
					for(Role r: roleList) {
						if(r.getId()==2) {
							evaluaSiCoordinador=1;
						}					
					}		
					if(evaluaSiCoordinador==0) {
						roleList.add(roleRepository.findById(2).get());
						person.setRoleList(roleList);
						personRepository.save(person);
					}	
				}											
			}
			else {
				if(cord!=null) {
					List <Faculty> fs=facultyRepository.findByCoordinatorId(cord.getId());
					if(fs.size()==1) {
						List<Role> cordRoleList=cord.getRoleList();
						cordRoleList.removeIf(r -> r.getId()==2);
						cord.setRoleList(cordRoleList);
						personRepository.save(cord);
					}
				}
			}			
			Integer id = facultyRepository.save(f).getId();
			response = new ApiResponse(id, 200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse deleteFaculty(Integer id) {
		ApiResponse response = null;
		try {
			int x = facultyRepository.deleteFaculty(id);
			if(x==0)
				response = new ApiResponse("Success", 200);
			else
				response = new ApiResponse(409,"Cannot delete due to dependency");
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse listByCoordinator(Integer id) {
		ApiResponse response = null;
		try {
			Iterable<Faculty> list = facultyRepository.findByCoordinatorId(id);
			for (Faculty faculty : list)
				faculty.setCoordinator(null);
			response = new ApiResponse(list, 200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse updateCoordinator(Integer idFaculty, Integer idCoordinator) {
		ApiResponse response = null;
		try {
			facultyRepository.setCoordinator(idFaculty,idCoordinator);
			response = new ApiResponse("Success", 200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}
}
