package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.User;

public interface UserService {
    public Iterable<User> listAll();
	public int createUser(User u);
	public int updateUser(User u);
	public String deleteUser(Integer id);
	public int authenticate(User u);
}