package com.cg.userservice.controller;

import javax.validation.Valid;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.userservice.model.User;
import com.cg.userservice.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	

	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@Valid @RequestBody User user) {
		User newUser = userService.saveUser(user);

		return new ResponseEntity<>(newUser, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<User> modifyUser(@RequestBody User user) {
		User updatedUser = userService.updateUser(user);
		return new ResponseEntity<>(updatedUser, HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<String> removeUser(@PathVariable("userId") int userId) {
		userService.deleteUser(userId);
		return new ResponseEntity<>("User deleted Successfully", HttpStatus.OK);
	}
	@GetMapping("/find/{userName}")
	public ResponseEntity<User> removeUser(@PathVariable("userName") String username) {
		User user =userService.getUserByUsername(username);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

}
