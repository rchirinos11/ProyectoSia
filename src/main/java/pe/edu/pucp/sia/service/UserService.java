package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.User;
import pe.edu.pucp.sia.response.ApiResponse;

public interface UserService {
    public ApiResponse listAll();
	public ApiResponse createUser(User u);
	public ApiResponse updateUser(User u);
	public ApiResponse deleteUser(Integer id);
	public ApiResponse authenticate(String username, String password);
}