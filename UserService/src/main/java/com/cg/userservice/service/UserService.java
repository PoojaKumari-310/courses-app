package com.cg.userservice.service;

import java.util.List;



import com.cg.userservice.model.User;

public interface UserService {
	
	User saveUser(User user);
	
	User updateUser(User user);
	
	void deleteUser(long userId);
	
	User getUserByUsername(String username);
	

	

}
