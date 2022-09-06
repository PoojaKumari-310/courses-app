package com.cg.feedbackservice.service;

import java.util.List;


import com.cg.feedbackservice.model.Feedback;

public interface FeedbackService {
	
	public List<Feedback> getAllFeedbacks();

	public Feedback getFeedbackById(long feedbackId);

	public Feedback saveFeedback(Feedback feedback);
	
	public void deleteFeedback(long feedbackId);

}
