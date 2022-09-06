package com.cg.courseservice.model;

import javax.persistence.Column;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "course_tbl")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "Course_id")
	private long courseId;

	@Column(name = "name")
	@NotNull(message = "CourseName is required")
	private String name;

	@Column(name = "description")
	@NotNull(message = "CourseDescription is required")
	private String description;

	@Column(name = "fee")
	@Positive(message = "Course fee must be a positive number")
	private long fee;

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getFee() {
		return fee;
	}

	public void setFee(long fee) {
		this.fee = fee;
	}

	public Course(long courseId, String name, String description, long fee) {
		super();
		this.courseId = courseId;
		this.name = name;
		this.description = description;
		this.fee = fee;
	}

	public Course() {
		super();

	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", name=" + name + ", description=" + description + ", fee=" + fee
				+ "]";
	}



	
}
