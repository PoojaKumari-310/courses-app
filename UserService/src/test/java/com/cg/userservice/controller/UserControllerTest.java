package com.cg.userservice.controller;

import static org.mockito.ArgumentMatchers.any;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cg.userservice.model.User;
import com.cg.userservice.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	private UserService userService;
	private User user;
	
	@InjectMocks
	private UserController userController;
	
	@BeforeEach
	public void setUp() {
		user = new User(1, "pooja", "pooja@gmail.com", 869754,"pooja","pooja@123");
		mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
	}
	@Test
	void saveUserControllerTest() throws Exception{
		when(userService.saveUser(any())).thenReturn(user);
		mockMvc.perform(post("/user/register")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(user)))
		        .andExpect(status().isCreated());
		verify(userService, times(1)).saveUser(any());
	
	}
	
	@Test
	void updateCourseControllerTest() throws Exception{
		when(userService.updateUser(any())).thenReturn(user);
		mockMvc.perform(put("/user/update")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(user)))
		        .andExpect(status().isCreated());
		verify(userService, times(1)).updateUser(any());
	
	}
	
	
	
	@Test
	void getUserControllerTest() throws Exception {
		when(userService.getUserByUsername(user.getUsername())).thenReturn(user);
		mockMvc.perform(MockMvcRequestBuilders.get("/user/find/pooja")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(user)))
		        .andDo(MockMvcResultHandlers.print());
		verify(userService, times(1)).getUserByUsername("pooja");
		
		
	}
	
	@Test
	void deleteUserControllerTest() throws Exception {
		
		userService.deleteUser(user.getUserId());;
		mockMvc.perform(MockMvcRequestBuilders.delete("/user/delete/1",1)
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(user)))
		        .andDo(MockMvcResultHandlers.print()).andExpect(status().isOk());
			
	}
	
	 
	 
	public static String asJsonString(final Object obj) {
	    try {
	        final ObjectMapper mapper = new ObjectMapper();
	        final String jsonContent = mapper.writeValueAsString(obj);
	        return jsonContent;
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}  

}



