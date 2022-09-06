package com.cg.courseservice.service;

import java.util.List;

import com.cg.courseservice.model.Course;

public interface CourseService {

	public List<Course> getAllCourses();

	public Course getCourseById(long courseId);

	public Course saveCourse(Course course);

	public Course updateCourse(Course course);

	public void deleteCourse(long courseId);

}
