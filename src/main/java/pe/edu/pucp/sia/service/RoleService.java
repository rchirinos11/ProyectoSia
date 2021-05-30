package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.Role;
public interface RoleService {
    public Iterable<Role>  listAll();
	public Integer createRole(Role r);
	public Integer updateRole(Role r);
	public String deleteRole(Integer id);
	public Iterable<Role> listByEmail(String email);
}
