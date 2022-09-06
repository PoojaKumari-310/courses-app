package com.cg.feedbackservice.model;

public class ResponseMessage {
	
private Feedback feedback;
	
	private Course course;

	public Feedback getFeedback() {
		return feedback;
	}

	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	
	

}
