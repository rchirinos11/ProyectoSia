package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.User;
import pe.edu.pucp.sia.repository.UserRepository;
import pe.edu.pucp.sia.response.ApiResponse;
import pe.edu.pucp.sia.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public ApiResponse listAll() {
		ApiResponse response = null;
		try {
			Iterable<User> list = userRepository.findAll();
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
			Integer id = userRepository.registerUser(u.getPerson().getId(), u.getUsername(), u.getPassword());
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
	
	public ApiResponse authenticate(User u) {
		ApiResponse response = null;
		try {
			Integer id = userRepository.authenticate(u.getUsername(), u.getPassword());
			response = new ApiResponse(id,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

}
