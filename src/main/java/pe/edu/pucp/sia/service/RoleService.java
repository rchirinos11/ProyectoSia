package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.Role;
public interface RoleService {
    public Iterable<Role>  listAll();
	public String createRole(Role r);
	public String updateRole(Role r);
	public String deleteRole(Integer id);
}
