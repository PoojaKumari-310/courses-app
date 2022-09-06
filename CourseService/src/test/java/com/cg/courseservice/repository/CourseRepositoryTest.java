package com.cg.courseservice.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;



import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.courseservice.model.Course;


@SpringBootTest
@ExtendWith(SpringExtension.class)
public class CourseRepositoryTest {
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Test
	public void givenCourseShouldReturnCourseObject()
	{
		Course c1 = new Course (102,"React JS","React is frontend framework for building application",6500);
		courseRepository.save(c1);
		
		Course c2 = courseRepository.findById(c1.getCourseId()).get();
		assertNotNull(c2);
		
		assertEquals(c1.getName(),c2.getName());
	}
	
	@Test
	public void getAllMustReturnAllCourse() {
		Course c3 = new Course(98,"Web development","This course is create for webpages",5500);
		courseRepository.save(c3);
		
		Course c4 = new Course(99,"Spring Core","This course is for backened framework",4500);
		courseRepository.save(c4);
		
	  List<Course>courseList=(List<Course>)courseRepository.findAll();
      assertEquals("Web development",courseList.get(2).getName());
	}
	
	@Test
	void testSaveCourse()
	{
		
		Course c2 = new Course(98,"Web development","This course is create for webpages",5500);
		courseRepository.save(c2);
		Course newCourse =courseRepository.findById(c2.getCourseId()).get();
		assertNotNull(newCourse);
		assertEquals(c2.getCourseId(), newCourse.getCourseId());
		
	}

	
	@Test
	void testDeleteCourse() {
		Course c4 = new Course(101,"Web development","This course is create for webpages",5500);
		courseRepository.save(c4);
		courseRepository.delete(c4);
		assertEquals(courseRepository.findById(101L),Optional.empty());

	}

}
