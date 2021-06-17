package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.Role;
import pe.edu.pucp.sia.repository.RoleRepository;
import pe.edu.pucp.sia.response.ApiResponse;
import pe.edu.pucp.sia.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public ApiResponse listAll() {
        ApiResponse response = null;
		try {
			Iterable<Role> list = roleRepository.findAll();
			response = new ApiResponse(list,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
    }

    @Override
    public ApiResponse createRole(Role r) {
        ApiResponse response = null;
        try{
            Integer id = roleRepository.save(r).getId();
            response = new ApiResponse(id,201);
        }
        catch(Exception ex){
            response = new ApiResponse(500, ex.getMessage());
        }
        return response;
    }

    @Override
    public ApiResponse updateRole(Role r) {
        ApiResponse response = null;
		try {
			Integer id= roleRepository.save(r).getId();
            response = new ApiResponse(id,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
    }

    @Override
    public ApiResponse deleteRole(Integer id) {
        ApiResponse response = null;
		try {
			roleRepository.deleteById(id);
			response = new ApiResponse("Success",200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
    }

	@Override
	public ApiResponse listByEmail(String email) {
         ApiResponse response = null;
		try {
			Iterable<Role> list = roleRepository.findByPersonListEmail(email);
			response = new ApiResponse(list,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}
}
