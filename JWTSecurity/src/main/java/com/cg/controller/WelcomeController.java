package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.model.AuthRequest;
import com.cg.util.JwtUtil;

@RestController
public class WelcomeController {
	
	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@GetMapping("/")
	public String welcome() {
		return "welcome to my channel";
	}

	@PostMapping("/generate")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {

		try
		{
			 // validate the username and password
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		} 
		catch (Exception e) // e is exception
		{
			throw new Exception("Invalid Username or Password");
		}

		return jwtUtil.generateToken(authRequest.getUsername());

	}


}
