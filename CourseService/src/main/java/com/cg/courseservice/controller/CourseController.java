package com.cg.courseservice.controller;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.courseservice.model.Course;
import com.cg.courseservice.service.CourseService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value="/course")
public class CourseController {
	
@Autowired
private CourseService courseService;

@GetMapping("/view/all")
public List<Course> fetchAllCourses() {
	List<Course> courseList = courseService.getAllCourses();
	return courseList;
}

@GetMapping("/view/{courseId}")
public ResponseEntity<Course> fetchCourseDetails(@PathVariable("courseId") long courseId) {
	
	Course course = courseService.getCourseById(courseId);
	ResponseEntity<Course> responseEntity = new ResponseEntity<>(course,HttpStatus.OK);
	return responseEntity;
}

@PostMapping("/save")
public ResponseEntity<Course> addCourse( @Valid @RequestBody Course course) {
	
   Course newCourse = courseService.saveCourse(course);
   ResponseEntity<Course> responseEntity = new ResponseEntity<>(newCourse,HttpStatus.CREATED);
   return responseEntity;
	}

@PutMapping("/update")
public ResponseEntity<Course> modifyProduct(@RequestBody Course course) {

Course updatedCourse = courseService.updateCourse(course);
ResponseEntity<Course> responseEntity = new ResponseEntity<>(course,HttpStatus.CREATED);
return responseEntity;
}

@DeleteMapping("/delete/{courseId}")
public ResponseEntity<String> removeCourse(@PathVariable("courseId") int courseId) {

courseService.deleteCourse(courseId);
ResponseEntity<String> responseEntity = new ResponseEntity<>("Course Deleted Successfully.", HttpStatus.OK);
return responseEntity;
}





	
	

}
