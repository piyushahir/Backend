package com.app.controller;

import java.util.List;
import java.util.Optional;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Feedback;
import com.app.pojos.Student;
import com.app.service.IFeedbackService;

@CrossOrigin
@RestController
@RequestMapping("/feedback")
public class FeedbackController
{
	//dependency
	@Autowired
	private IFeedbackService service;

   public FeedbackController()
   {
	   System.out.println("in the constructor of "+getClass().getName());
   }
	
	
	
	//add new feedback
	@PostMapping()
	public ResponseEntity<?> addNewFeedback(@RequestBody Feedback transientpojo)
	{
		System.out.println("in add new feedback controller "+transientpojo);
		try {
			Feedback NewFeedback = service.addNewFeedback(transientpojo);
			return new ResponseEntity<>(NewFeedback,HttpStatus.OK);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	//get all feedbacks
	@GetMapping()
	public List<Feedback> getAllFeedbacks()
	{
		System.out.println("in get all feedbacks controller");
		try {
			List<Feedback> feedbacks=service.getAllFeedbacks();
			return feedbacks;
		} catch (RuntimeException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//get feedback by id
	@GetMapping("/{feed_id}")
	 public ResponseEntity<?> getFeedbackById(@PathVariable int feed_id)
	 {
		 System.out.println("in get Feedback by ID "+feed_id);
		
	   Optional<Feedback> feedback= service.getFeedbackById(feed_id);
			
	   if(feedback.isPresent())
				return new ResponseEntity<>(feedback,HttpStatus.OK);
		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	 
	//delete feedback by id
	 @DeleteMapping("/{feed_id}")
	 public  boolean deleteFeedbackById(@PathVariable int feed_id)
	 {
		 System.out.println("in delete feeback  by id controller ");
       System.out.println("feed id ->"+feed_id);
	     boolean data= service.deleteFeedbackById(feed_id);
	     if(data==true)
	    	 return true;
	     return false;
	 }
	 
}
