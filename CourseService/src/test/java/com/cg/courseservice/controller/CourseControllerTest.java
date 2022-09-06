package com.cg.courseservice.controller;

import static org.mockito.ArgumentMatchers.any;




import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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

import com.cg.courseservice.model.Course;
import com.cg.courseservice.service.CourseService;
import com.fasterxml.jackson.databind.ObjectMapper;


@ExtendWith(MockitoExtension.class)
public class CourseControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	private CourseService courseService;
	
	private Course course;
	
	private List<Course>courseList;
	
	@InjectMocks
	private CourseController courseController;
	
	@BeforeEach
	public void setUp()
	{
		course = new Course(102,"React JS","React is frontend framework for building application",6500);
		
		mockMvc = MockMvcBuilders.standaloneSetup(courseController).build();
	}
	
	@Test
	public void saveCourseControllerTest() throws Exception
	{
		 	when(courseService.saveCourse(any())).thenReturn(course);
		mockMvc.perform(post("/course/save")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(course)))
		        .andExpect(status().isCreated());
		verify(courseService, times(1)).saveCourse(any());
	
	}
	
	@Test
	public void updateCourseControllerTest() throws Exception{
		when(courseService.updateCourse(any())).thenReturn(course);
		mockMvc.perform(put("/course/update")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(course)))
		        .andExpect(status().isCreated());
		verify(courseService, times(1)).updateCourse(any());
	
	}
	
	@Test
	public void getAllCourseControllerTest() throws Exception{
		when(courseService.getAllCourses()).thenReturn(courseList);
		mockMvc.perform(MockMvcRequestBuilders.get("/course/view/all")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(course)))
		        .andDo(MockMvcResultHandlers.print());
		verify(courseService, times(1)).getAllCourses();
	
	}
	
	@Test
	public void getCourseControllerTest() throws Exception {
		when(courseService.getCourseById(course.getCourseId())).thenReturn(course);
		mockMvc.perform(MockMvcRequestBuilders.get("/course/view/102")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(course)))
		        .andDo(MockMvcResultHandlers.print());
		verify(courseService, times(1)).getCourseById(102);
		
		
	}
	
	@Test
	public void deleteCourseControllerTest() throws Exception {
		
		courseService.deleteCourse(course.getCourseId());
		mockMvc.perform(MockMvcRequestBuilders.delete("/course/delete/98",98)
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(course)))
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
