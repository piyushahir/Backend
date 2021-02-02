package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.Feedback;

public interface IFeedbackService {
	
	//add new feedback
	Feedback addNewFeedback(Feedback transientpojo);
   //get all feedbacks
	List<Feedback> getAllFeedbacks();
	//get feedback by id
	Optional<Feedback> getFeedbackById(int feed_id);
	//delete feedback by id
	boolean deleteFeedbackById(int feed_id);
	
}
