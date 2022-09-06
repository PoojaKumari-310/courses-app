package com.cg.courseservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.courseservice.model.Course;

public interface CourseRepository extends JpaRepository<Course,Long> {

}
