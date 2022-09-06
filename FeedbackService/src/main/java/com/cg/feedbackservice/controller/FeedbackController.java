package com.cg.feedbackservice.controller;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.feedbackservice.model.Course;
import com.cg.feedbackservice.model.Feedback;
import com.cg.feedbackservice.model.ResponseMessage;
import com.cg.feedbackservice.service.FeedbackService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value="/feedback")
public class FeedbackController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private FeedbackService feedbackservice;
	
	@GetMapping("/view/all")
	public List<Feedback> fetchAllFeedbacks() {
		List<Feedback> feedbackList = feedbackservice.getAllFeedbacks();
		return feedbackList;
	}
	
	@GetMapping("/view/{feedbackId}")
	public ResponseEntity<Feedback> fetchFeedbackDetails(@PathVariable("feedbackId") long feedbackId) {
		
		Feedback feedback = feedbackservice.getFeedbackById(feedbackId);
		ResponseEntity<Feedback> responseEntity = new ResponseEntity<>(feedback,HttpStatus.OK);
		return responseEntity;
	}
	

	

	@PostMapping("/save")
	public ResponseMessage feedbackCourse(@Valid @RequestBody Feedback feedback)
	{
		
		Feedback newFeedback = feedbackservice.saveFeedback(feedback);
		
		Course course = restTemplate.getForObject("http://localhost:8081/course/view/"+feedback.getCourseId(), Course.class);
		
		ResponseMessage responseMessage = new ResponseMessage();
		responseMessage.setFeedback(newFeedback);
		responseMessage.setCourse(course);
		return responseMessage;
	}
	
	@DeleteMapping("/delete/{feedbackId}")
	public ResponseEntity<String> removeFeedback(@PathVariable("feedbackId") int feedbackId) {

	feedbackservice.deleteFeedback(feedbackId);
	ResponseEntity<String> responseEntity = new ResponseEntity<>("Feedback Deleted Successfully.", HttpStatus.OK);
	return responseEntity;
	}


}
		


