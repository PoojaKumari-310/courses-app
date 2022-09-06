package com.cg.userservice.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.userservice.model.User;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository userRepository;

	@Test
	void givenUserShouldReturnUserObject() {
		User user1 = new User(2, "pinky", "pinky@gmail.com", 8697545,"pinky","pinky@123");
		userRepository.save(user1);
		User user2 = userRepository.findByUsername(user1.getUsername());
		assertNotNull(user2);
		assertEquals(user1.getName(), user2.getName());
	}
	
	@Test
	void getAllMustReturnAllCourse()
	{
		User a1 = new User(1, "pooja", "pooja@gmail.com", 869754,"pooja","pooja@123");
		User a2 = new User(2, "pinky", "pinky@gmail.com", 8697545,"pinky","pinky@123");
		userRepository.save(a1);
		userRepository.save(a2);
		List<User> userList = (List<User>) userRepository.findAll();
		assertEquals("pooja", userList.get(1).getName());
		
	}
	

	@Test
	void testSaveUser()
	{
		
		User u2 = new User(5, "suraj", "suraj@mail.com", 796545,"suraj","suraj@123");
		userRepository.save(u2);
		User newUser =userRepository.findById(u2.getUserId()).get();
		assertNotNull(newUser);
		assertEquals(u2.getUserId(), newUser.getUserId());
		
	}

	
	@Test
	void testDeleteCourse() {
		User user4 = new User(3, "aman", "aman@gmail.com", 796545,"aman","aman@123");
		userRepository.save(user4);
		userRepository.delete(user4);
		assertEquals(userRepository.findById(3L),Optional.empty());

	}
	   
}



