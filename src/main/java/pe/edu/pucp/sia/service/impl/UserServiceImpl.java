package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.User;
import pe.edu.pucp.sia.repository.UserRepository;
import pe.edu.pucp.sia.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Iterable<User> listAll() {
		return userRepository.findAll();
	}

	@Override
	public int createUser(User u) {
		int response = 0;
		try {
			response = userRepository.registerUser(u.getPerson().getId(), u.getUsername(), u.getPassword());
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public String deleteUser(Integer id) {
		 String response = "";
		 try {
			 userRepository.deleteUser(id);
			 response = "Deleted";
		 } catch(Exception ex) {
			 System.out.println(ex.getMessage());
		 }
		return response;
	}

	@Override
	public int updateUser(User u) {
		int response = 0;
		try {
			response = userRepository.updateUser(u.getId(),u.getUsername(), u.getPassword());
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}
	
	public int authenticate(User u) {
		int response = 0;
		try {
			response = userRepository.authenticate(u.getUsername(), u.getPassword());
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

}
