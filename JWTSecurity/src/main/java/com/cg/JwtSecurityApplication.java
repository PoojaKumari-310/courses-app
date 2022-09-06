package com.cg;


import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cg.model.User;
import com.cg.repository.UserRepository;

@SpringBootApplication
public class JwtSecurityApplication {
	

	@Autowired
	private UserRepository repo;
	
	@PostConstruct
	public void initUsers()
	{
		User user = new User(10,"akshita","akshita@123","akshita@gmail.com");
		repo.save(user);
	}


	public static void main(String[] args) {
		SpringApplication.run(JwtSecurityApplication.class, args);
		
	}

}
