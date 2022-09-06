package com.cg.feedbackservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.feedbackservice.model.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long>{

}
