package com.cg.userservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.userservice.exception.UserNotFoundException;
import com.cg.userservice.model.User;
import com.cg.userservice.repository.UserRepository;

@SpringBootTest
public class UserServiceTest {
	
	@InjectMocks
	private UserService userService = new UserServiceImpl();

	@Mock
	private UserRepository userRepository;

	@Test
	void testViewUser() {

		User user = new User(1, "pooja", "pooja@gmail.com", 869754,"pooja","pooja@123");

		Optional<User> optionalCourse = Optional.of(user);

		when(userRepository.findByUsername("pooja")).thenReturn(optionalCourse.get());

		User myUser = userService.getUserByUsername("pooja");

		assertEquals("pooja", myUser.getUsername());
	}
	


	@Test
	void testGetUserByNameWithException() {

		when(userRepository.findByUsername("pooja")).thenThrow(UserNotFoundException.class);

		assertThrows(UserNotFoundException.class, () -> userService.getUserByUsername("pooja"));
	}

	@Test
	void testSaveCourse() {

		
		User user = new User(1, "pooja", "pooja@gmail.com", 869754,"pooja","pooja@123");

		when(userRepository.save(user)).thenReturn(user);

		User newUser = userService.saveUser(user);

		assertEquals("pooja", newUser.getName());

		verify(userRepository, times(1)).save(user); // useful for testing void methods

	}
	
	
	@Test
	void testDeleteCourse() {
		
		User user = new User(2, "pinky", "pinky@gmail.com", 8697545,"pinky","pinky@123");

		Optional<User> optionalCourse = Optional.of(user);

		when(userRepository.findById(2L)).thenReturn(optionalCourse);

		userService.deleteUser(2);

		verify(userRepository, times(1)).findById(2L);
		verify(userRepository, times(1)).deleteById(2L);

	}

}


