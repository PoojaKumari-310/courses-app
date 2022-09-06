package com.cg.feedbackservice.repository;



import static org.junit.jupiter.api.Assertions.assertEquals;



import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import com.cg.feedbackservice.model.Feedback;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class FeedbackRepositoryTest {

	
	@Autowired
	private FeedbackRepository feedbackRepository;
	
	@Test
	public void givenFeedbackShouldReturnFeedbackObject()
	{
		Feedback f1 = new Feedback (40,"ashwin","ashwin@gmail.com",675432190,"amazing",1);
		feedbackRepository.save(f1);
		
		Feedback f2 = feedbackRepository.findById(f1.getFeedbackId()).get();
		assertNotNull(f2);
		
		assertEquals(f1.getFullName(),f2.getFullName());
	}
	
	@Test
	public void getAllMustReturnAllFeedback() {
		Feedback f3 = new Feedback(2,"pooja","pooja@gmail.com",453217865,"It was a good concept",1);
		feedbackRepository.save(f3);
		
		Feedback f4 = new Feedback(3,"pokemon","poke11@gmail.com",106789321,"some msg will be display",1);
		feedbackRepository.save(f4);
		
	  List<Feedback>feedbackList=(List<Feedback>)feedbackRepository.findAll();
      assertEquals("pooja",feedbackList.get(2).getFullName());
	}
	
	@Test
	void testSaveFeedback()
	{
		
		Feedback f2 = new Feedback(2,"pooja","pooja@gmail.com",453217865,"It was a good concept",1);
		feedbackRepository.save(f2);
		Feedback newFeedback =feedbackRepository.findById(f2.getFeedbackId()).get();
		assertNotNull(newFeedback);
		assertEquals(f2.getFeedbackId(), newFeedback.getFeedbackId());
		
	}

	
	@Test
	void testDeleteCourse() {
		Feedback feedback4 = new Feedback(44,"pokemon","poke11@gmail.com",106789321,"some msg will be display",1);
		feedbackRepository.save(feedback4);
		feedbackRepository.delete(feedback4);
		assertEquals(feedbackRepository.findById(44L),Optional.empty());

	}


}
