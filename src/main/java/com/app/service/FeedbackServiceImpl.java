package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IFeedbackDao;
import com.app.pojos.Feedback;

@Service
@Transactional
public class FeedbackServiceImpl implements IFeedbackService {

	//dependency
	@Autowired
	private IFeedbackDao dao;
	
	
	//add new feedback
	@Override
	public Feedback addNewFeedback(Feedback transientpojo) {
		System.out.println("in add new feedback "+transientpojo);
		return dao.save(transientpojo);
	}

	@Override
	public List<Feedback> getAllFeedbacks() {
		System.out.println("in get all feedback");
		return dao.findAll();
	}

	@Override
	public Optional<Feedback> getFeedbackById(int feed_id) {
		System.out.println(" in get feedback by id "+feed_id);
		// TODO Auto-generated method stub
		return dao.findById(feed_id);
	}

	@Override
	public boolean deleteFeedbackById(int feed_id) {
		System.out.println("in delete feed by id "+feed_id);
		
		Optional<Feedback> feedback = dao.findById(feed_id);
		if(feedback.isPresent())
		{
			dao.deleteById(feed_id);
			return  true;
		}
		else {
			return false;
		}
	}

}
