package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.Role;
import pe.edu.pucp.sia.repository.RoleRepository;
import pe.edu.pucp.sia.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public Iterable<Role> listAll() {
        return roleRepository.findAll();
    }

    @Override
    public String createRole(Role r) {
        String response="";
        try{
            roleRepository.save(r);
            response="Created";
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return response;
    }

    @Override
    public String updateRole(Role r) {
        String response = "";
		try {
			roleRepository.save(r);
			response = "Updated";
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
    }

    @Override
    public String deleteRole(Integer id) {
        String response = "";
		try {
			roleRepository.deleteById(id);
			response = "Deleted";
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
    }
    
    
}
