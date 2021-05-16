package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.User;

public class UserService {
    public Iterable<User> listAll();
	public int createUser(User m);
	public int deleteUser(Integer id);
	public int updateUser(User m);    
}