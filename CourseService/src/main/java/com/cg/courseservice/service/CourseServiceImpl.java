package com.cg.courseservice.service;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.courseservice.exception.CourseNotFoundException;
import com.cg.courseservice.model.Course;
import com.cg.courseservice.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public List<Course> getAllCourses() {
		List<Course> courses = courseRepository.findAll();
		return courses;
	}

	@Override
	public Course getCourseById(long courseId) {

		Optional<Course> optionalCourse = courseRepository.findById(courseId);
		if (optionalCourse.isEmpty()) {
			throw new CourseNotFoundException("Course Not existing with id:" + courseId);
		}
		Course course = optionalCourse.get();
		return course;
	}

	@Override
	public Course saveCourse(Course course) {
		Course newCourse = courseRepository.save(course);
		return newCourse;
	}

	@Override
	public Course updateCourse(Course course) {
		Optional<Course> optionalCourse = courseRepository.findById(course.getCourseId());

		if (optionalCourse.isEmpty()) {
			throw new CourseNotFoundException("Course Not found with id: " + course.getCourseId());
		}

		Course updatedCourse = courseRepository.save(course);

		return updatedCourse;

	}

	@Override
	public void deleteCourse(long courseId) {
		Optional<Course> optionalCourse = courseRepository.findById(courseId);
		if (optionalCourse.isEmpty()) {
			throw new CourseNotFoundException("Course Not found with id: " + courseId);
		}

		courseRepository.deleteById(courseId);

	}

}
