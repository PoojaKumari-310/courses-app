package com.cg.feedbackservice.controller;

import static org.mockito.ArgumentMatchers.any;


import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

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

import com.cg.feedbackservice.model.Feedback;
import com.cg.feedbackservice.service.FeedbackService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class FeedbackControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	private FeedbackService feedbackService;
	
	private Feedback feedback;
	
	private List<Feedback>feedbackList;
	
	@InjectMocks
	private FeedbackController feedbackController;
	
	@BeforeEach
	public void setUp()
	{
		feedback = new Feedback(40,"ashwin","ashwin@gmail.com",675432190,"amazing",1);
		
		mockMvc = MockMvcBuilders.standaloneSetup(feedbackController).build();
	}
	
	@Test
	public void saveFeedbackControllerTest() throws Exception
	{
		 	when(feedbackService.saveFeedback(any())).thenReturn(feedback);
		mockMvc.perform(post("/feedback/save")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(feedback)))
				.andExpect(status().isCreated());
		verify(feedbackService, times(1)).saveFeedback(any());
	
	}

	
	@Test
	public void getAllFeedbackControllerTest() throws Exception{
		when(feedbackService.getAllFeedbacks()).thenReturn(feedbackList);
		mockMvc.perform(MockMvcRequestBuilders.get("/feedback/view/all")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(feedback)))
		        .andDo(MockMvcResultHandlers.print());
		verify(feedbackService, times(1)).getAllFeedbacks();
	
	}
	
	@Test
	public void getFeedbackControllerTest() throws Exception {
		when(feedbackService.getFeedbackById(feedback.getFeedbackId())).thenReturn(feedback);
		mockMvc.perform(MockMvcRequestBuilders.get("/feedback/view/40")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(feedback)))
		        .andDo(MockMvcResultHandlers.print());
		verify(feedbackService, times(1)).getFeedbackById(40);
		
		
	}
	
	@Test
	public void deleteFeedbackControllerTest() throws Exception {
		
		feedbackService.deleteFeedback(feedback.getFeedbackId());
		mockMvc.perform(MockMvcRequestBuilders.delete("/feedback/delete/4",4)
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(feedback)))
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


