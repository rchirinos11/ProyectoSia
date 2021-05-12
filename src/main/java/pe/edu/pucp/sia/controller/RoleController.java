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

import pe.edu.pucp.sia.model.Role;
import pe.edu.pucp.sia.service.RoleService;
import pe.edu.pucp.sia.service.impl.RoleServiceImpl;

@RestController
@RequestMapping("/role")
public class RoleController {
    Logger logger=LoggerFactory.getLogger(RoleController.class);    
    @Autowired
    private RoleService roleService=new RoleServiceImpl();
    @GetMapping("/list")
    public ResponseEntity<Object>listRole(){
        logger.info("Entered method listRole()");
		return ResponseEntity.status(HttpStatus.OK).body(roleService.listAll());
    }
    @PostMapping("/create")
    public ResponseEntity<Object>createRole(@RequestBody Role r){
        logger.info("Entered method createRole()");
		return ResponseEntity.status(HttpStatus.CREATED).body(roleService.createRole(r));
    }
    @PostMapping("/update")
	public ResponseEntity<Object> updateRole(@RequestBody Role r){
		logger.info("Entered method updateRole()");
		return ResponseEntity.status(HttpStatus.CREATED).body(roleService.updateRole(r));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteRole(@PathVariable Integer id){
		logger.info("Entered method deleteRole()");
		return ResponseEntity.status(HttpStatus.OK).body(roleService.deleteRole(id));
	}
}
