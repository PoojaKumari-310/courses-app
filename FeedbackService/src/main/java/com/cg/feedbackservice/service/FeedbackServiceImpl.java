package com.cg.feedbackservice.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.feedbackservice.exception.FeedbackNotFoundException;
import com.cg.feedbackservice.model.Feedback;
import com.cg.feedbackservice.repository.FeedbackRepository;

@Service
public class FeedbackServiceImpl implements FeedbackService {
	@Autowired
	private FeedbackRepository feedbackRepository;

	@Override
	public List<Feedback> getAllFeedbacks() {
		List<Feedback> feedbacks = feedbackRepository.findAll();
		return feedbacks;
	}

	@Override
	public Feedback getFeedbackById(long feedbackId) {
		Optional<Feedback> optionalFeedback = feedbackRepository.findById(feedbackId);
		if (optionalFeedback.isEmpty()) {
			throw new FeedbackNotFoundException("Feedback Not existing with id:" + feedbackId);
		}
		Feedback feedback = optionalFeedback.get();
		return feedback;
	}

		
	@Override
	public Feedback saveFeedback(Feedback feedback) {
		Feedback newFeedback = feedbackRepository.save(feedback);
		return newFeedback;
	}

	@Override
	public void deleteFeedback(long feedbackId) {
		Optional<Feedback> optionalFeedback = feedbackRepository.findById(feedbackId);
		if (optionalFeedback.isEmpty()) {
			throw new FeedbackNotFoundException("Feedback Not found with id: " + feedbackId);
		}

		feedbackRepository.deleteById(feedbackId);

	}
		
	}


