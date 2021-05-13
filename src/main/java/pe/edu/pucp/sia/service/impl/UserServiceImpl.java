package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.User;
import pe.edu.pucp.sia.repository.UserRepository;
import pe.edu.pucp.sia.service.UserTypeService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserTypeRepository userRepository;
	
	@Override
	public Iterable<User> listAll() {
		return userRepository.findAll();
	}

	@Override
	public int createUser(User u) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUser(User u) {
		// TODO Auto-generated method stub
		return 0;
	}

}
