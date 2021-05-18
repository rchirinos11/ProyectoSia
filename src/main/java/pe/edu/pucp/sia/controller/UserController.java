package pe.edu.pucp.sia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.pucp.sia.model.User;
import pe.edu.pucp.sia.service.UserService;
import pe.edu.pucp.sia.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {
	Logger logger = LoggerFactory.getLogger(EducationalObjectiveController.class);
	@Autowired
	private UserService userService = new UserServiceImpl(); 
	
	@GetMapping("/list")
	public ResponseEntity<Object> listUser(){
		logger.info("Entered method listUser()");
		return ResponseEntity.status(HttpStatus.OK).body(userService.listAll());
	}
	
	@PostMapping("/create")
	public ResponseEntity<Object> createUser(@RequestBody User u){
		logger.info("Entered method createUser()");
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(u));
	}
	
	@PostMapping("/update")
	public ResponseEntity<Object> updateUser(@RequestBody User u){
		logger.info("Entered method updateUser()");
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.updateUser(u));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable Integer id){
		logger.info("Entered method deleteUser()");
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.deleteUser(id));
	}
}