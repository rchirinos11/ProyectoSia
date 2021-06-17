package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.Role;
import pe.edu.pucp.sia.response.ApiResponse;
public interface RoleService {
    public ApiResponse  listAll();
	public ApiResponse createRole(Role r);
	public ApiResponse updateRole(Role r);
	public ApiResponse deleteRole(Integer id);
	public ApiResponse listByEmail(String email);
}
