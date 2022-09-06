package com.cg.feedbackservice.service;

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


import com.cg.feedbackservice.exception.FeedbackNotFoundException;
import com.cg.feedbackservice.exception.FeedbackNotFoundExceptionTest;
import com.cg.feedbackservice.model.Feedback;
import com.cg.feedbackservice.repository.FeedbackRepository;



@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class FeedbackServiceTest {
	@Mock
	private FeedbackRepository feedbackRepository;
	
	@InjectMocks
	private FeedbackServiceImpl feedbackServiceImpl;

	@Test
	public void TestSaveFeedback() throws FeedbackNotFoundExceptionTest {
		Feedback f1 = new Feedback(1,"ashwin","ashwin@gmail.com",675432190,"amazing",1);
		
		when(feedbackRepository.save(any())).thenReturn(f1);
		feedbackRepository.save(f1);
    	verify(feedbackRepository,times(1)).save(any());
		// useful for testing void methods
	}
	@Test
	public void testGetAllFeedback() {
		Feedback f1 = new Feedback(1,"ashwin","ashwin@gmail.com",675432190,"amazing",1);
		feedbackRepository.save(f1);
		
		Feedback f2 = new Feedback(2,"pooja","pooja@gmail.com",453217865,"It was a good concept",1);
		feedbackRepository.save(f2);
		

		Feedback f3 = new Feedback(3,"pokemon","poke11@gmail.com",106789321,"some msg will be display",1);
		feedbackRepository.save(f3);
		
		List<Feedback> feedbackList = new ArrayList<>();
		feedbackList.add(f1);
		feedbackList.add(f2);
		feedbackList.add(f3);
		
		when(feedbackRepository.findAll()).thenReturn(feedbackList);
		List<Feedback> feedbackList1 = feedbackServiceImpl.getAllFeedbacks();
		assertEquals(feedbackList,feedbackList1);
		
		verify(feedbackRepository,times(1)).save(f1);
		
		verify(feedbackRepository,times(1)).findAll();
		
		
		
	}
	
	 @Test
	    void testGetCourseByIdWithException() {

	        when(feedbackRepository.findById(10L)).thenThrow(FeedbackNotFoundException.class);

	        assertThrows(FeedbackNotFoundException.class, () -> feedbackServiceImpl.getFeedbackById(10L));
	    }
		
		@Test
		void testDeleteFeedback() {
			
			Feedback feedback = new Feedback(2,"pooja","pooja@gmail.com",453217865,"It was a good concept",1);

			Optional<Feedback> optionalFeedback = Optional.of(feedback);

			when(feedbackRepository.findById(2L)).thenReturn(optionalFeedback);

			feedbackServiceImpl.deleteFeedback(2);

			verify(feedbackRepository, times(1)).findById(2L);
			verify(feedbackRepository, times(1)).deleteById(2L);

		}

}
