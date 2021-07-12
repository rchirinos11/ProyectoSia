package pe.edu.pucp.sia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.pucp.sia.model.User;
import pe.edu.pucp.sia.requests.AuthenticateRequest;
import pe.edu.pucp.sia.response.ApiResponse;
import pe.edu.pucp.sia.service.UserService;
import pe.edu.pucp.sia.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService = new UserServiceImpl(); 
	
	@GetMapping("/list")
	public ResponseEntity<ApiResponse> listUser(){
		ApiResponse response = userService.listAll();
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/register")
	public ResponseEntity<ApiResponse> createUser(@RequestBody User u){
		ApiResponse response = userService.createUser(u);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/update")
	public ResponseEntity<ApiResponse> updateUser(@RequestBody User u){
		ApiResponse response = userService.updateUser(u);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer id){
		ApiResponse response = userService.deleteUser(id);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<ApiResponse> authenticateUser(@RequestBody AuthenticateRequest user){
		ApiResponse response = userService.authenticate(user.getUsername(), user.getPassword());
		return ResponseEntity.status(response.getStatus()).body(response);
	}
}