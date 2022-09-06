package com.cg.courseservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.courseservice.exception.CourseNotFoundException;
import com.cg.courseservice.exception.CourseNotFoundExceptionTest;
import com.cg.courseservice.model.Course;
import com.cg.courseservice.repository.CourseRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CourseServiceTest {
	

	@Mock
	private CourseRepository courseRepository;
	
	@InjectMocks
	private CourseServiceImpl courseServiceImpl;

	@Test
	public void TestSaveCourse() throws CourseNotFoundExceptionTest {
		Course c1 = new Course(102,"React JS","React is frontend framework for building application",6500);
		
		when(courseRepository.save(any())).thenReturn(c1);
		courseRepository.save(c1);
    	verify(courseRepository,times(1)).save(any());
		// useful for testing void methods
	}
	@Test
	public void testGetAllCourse() {
		Course c1 = new Course(102,"React JS","React is frontend framework for building application",6500);
		courseRepository.save(c1);
		
		Course c2 = new Course(98,"Web development","This course is create for webpages",5500);
		courseRepository.save(c2);
		

		Course c3 = new Course(99,"Spring Core","This course is for backened framework",4500);
		courseRepository.save(c3);
		
		List<Course> courseList = new ArrayList<>();
		courseList.add(c1);
		courseList.add(c2);
		courseList.add(c3);
		
		when(courseRepository.findAll()).thenReturn(courseList);
		List<Course> courseList1 = courseServiceImpl.getAllCourses();
		assertEquals(courseList,courseList1);
		
		verify(courseRepository,times(1)).save(c1);
		
		verify(courseRepository,times(1)).findAll();
		
		
		
	}
	
    @Test
    void testGetCourseByIdWithException() {

        when(courseRepository.findById(34L)).thenThrow(CourseNotFoundException.class);

        assertThrows(CourseNotFoundException.class, () -> courseServiceImpl.getCourseById(34L));
    }
	
	@Test
	void testDeleteCourse() {
		
		Course course = new Course(98,"Web development","This course is create for webpages",5500);

		Optional<Course> optionalCourse = Optional.of(course);

		when(courseRepository.findById(98L)).thenReturn(optionalCourse);

		courseServiceImpl.deleteCourse(98);

		verify(courseRepository, times(1)).findById(98L);
		verify(courseRepository, times(1)).deleteById(98L);

	}
	
	}


