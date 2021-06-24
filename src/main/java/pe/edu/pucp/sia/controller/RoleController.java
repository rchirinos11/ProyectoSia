package pe.edu.pucp.sia.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.pucp.sia.model.Person;
import pe.edu.pucp.sia.model.Role;
import pe.edu.pucp.sia.response.ApiResponse;
import pe.edu.pucp.sia.service.RoleService;
import pe.edu.pucp.sia.service.impl.RoleServiceImpl;

@RestController
@RequestMapping("/role")
public class RoleController {
    Logger logger=LoggerFactory.getLogger(RoleController.class);    
    @Autowired
    private RoleService roleService=new RoleServiceImpl();
    @GetMapping("/list")
    public ResponseEntity<ApiResponse>listRole(){
        logger.info("Entered method listRole()");
		ApiResponse response = roleService.listAll();
		return ResponseEntity.status(response.getStatus()).body(response);
    }
    @PostMapping("/create")
    public ResponseEntity<ApiResponse>createRole(@RequestBody Role r){
        logger.info("Entered method createRole()");
		ApiResponse response = roleService.createRole(r);
		return ResponseEntity.status(response.getStatus()).body(response);
    }
    @PostMapping("/update")
	public ResponseEntity<ApiResponse> updateRole(@RequestBody Role r){
		logger.info("Entered method updateRole()");
		ApiResponse response = roleService.updateRole(r);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> deleteRole(@PathVariable Integer id){
		logger.info("Entered method deleteRole()");
		ApiResponse response = roleService.deleteRole(id);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/listByEmail")
	public ResponseEntity<ApiResponse> listByEmail(@RequestBody Person p){
		logger.info("Entered method listByEmail()");
		ApiResponse response = roleService.listByEmail(p.getEmail());
		return ResponseEntity.status(response.getStatus()).body(response);
	}
}
