package com.cg.feedbackservice.model;

import javax.persistence.Column;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;




@Entity
@Table(name = "feedback_tbl")

public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	

	@Column(name = "Feedback_id")
	private long feedbackId;

	@Column(name = "fullName")
	@NotNull(message = "Full Name is required")
	private String FullName;
	
	@Column(name = "email")
	@NotNull(message = "invalid email address")
	private String Email;
	
	
	@Column(name = "phone")
  
	private long Phone;

	@Column(name = "Message")
	@NotNull(message = "Message is required")
	private String Message;
	

	@Column(name = "Course_id")
	private long courseId;
	
	public Feedback() {
		super();
		
	}



	public Feedback(long feedbackId, @NotNull(message = "FullName is required") String fullName,
			@NotNull(message = "Email is required") String email, long phone,
			@NotNull(message = "Message is required") String message, long courseId) {
		super();
		this.feedbackId = feedbackId;
		FullName = fullName;
		Email = email;
		Phone = phone;
		Message = message;
		this.courseId = courseId;
	}



	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", FullName=" + FullName + ", Email=" + Email + ", Phone=" + Phone
				+ ", Message=" + Message + ", courseId=" + courseId + "]";
	}





	
	
	public long getFeedbackId() {
		return feedbackId;
	}



	public void setFeedbackId(long feedbackId) {
		this.feedbackId = feedbackId;
	}



	public String getFullName() {
		return FullName;
	}



	public void setFullName(String fullName) {
		FullName = fullName;
	}



	public String getEmail() {
		return Email;
	}



	public void setEmail(String email) {
		Email = email;
	}



	public long getPhone() {
		return Phone;
	}



	public void setPhone(long phone) {
		Phone = phone;
	}



	public String getMessage() {
		return Message;
	}



	public void setMessage(String message) {
		Message = message;
	}



	public long getCourseId() {
		return courseId;
	}



	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}



	




}

