package pe.edu.pucp.sia.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.Person;
import pe.edu.pucp.sia.model.Role;
import pe.edu.pucp.sia.model.User;
import pe.edu.pucp.sia.repository.PersonRepository;
import pe.edu.pucp.sia.repository.UserRepository;
import pe.edu.pucp.sia.response.ApiResponse;
import pe.edu.pucp.sia.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Override
	public ApiResponse listAll() {
		ApiResponse response = null;
		try {
			Iterable<User> list = userRepository.findAll();
			for(User u : list)
				u.setPassword(null);
			
			response = new ApiResponse(list,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse createUser(User u) {
		ApiResponse response = null;
		try {
			if(u.getPerson()==null) {
				Person p = new Person();
				List<Role> list = new ArrayList<>();
				list.add(new Role(7));
				p.setRoleList(list);
				p.setId(personRepository.save(p).getId());
				u.setPerson(p);
			}
			Integer id = userRepository.registerUser(u.getPerson().getId(), u.getUsername(), u.getPassword());
			if(id==-1) {
				response = new ApiResponse(409, "This username already exists");
				return response;
			}
			response = new ApiResponse(id,201);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse deleteUser(Integer id) {
		 ApiResponse response = null;
		 try {
			userRepository.deleteUser(id);
			response = new ApiResponse("Success",200);
		 } catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		 }
		return response;
	}

	@Override
	public ApiResponse updateUser(User u) {
		ApiResponse response = null;
		try {
			Integer id = userRepository.updateUser(u.getId(),u.getUsername(), u.getPassword());
			response = new ApiResponse(id,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}
	
	public ApiResponse authenticate(String username, String password) {
		ApiResponse response = null;
		try {
			Integer id = userRepository.authenticate(username, password);
			if(id>0) {
				response = new ApiResponse(id,200);
			} else {
				response = new ApiResponse(401,"Invalid Credentials");
			}
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

}
