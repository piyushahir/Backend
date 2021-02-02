package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Enrollments;
import com.app.service.IEnrollmentService;
@CrossOrigin
@RestController
@RequestMapping("/enrollment")
public class EnrollmentController {

	//dependency
	private IEnrollmentService service; 

  public EnrollmentController()
  {
	  System.out.println("in the controller of "+getClass().getName());
  }
  
  //update enrollment by id
  @PutMapping("/{enroll_id}")
  public ResponseEntity<?> updateEnrollments(@RequestBody Enrollments e,@PathVariable int enroll_id)
  {
	  System.out.println(" in the update enrollments controller "+e+" "+enroll_id);
	  
	  try {
		  Enrollments entity=service.updateEnrollmentById(e, enroll_id);
		  return new ResponseEntity<>(entity,HttpStatus.ACCEPTED);
	  }
	  catch (RuntimeException exp) {
		exp.printStackTrace();
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
  }

  
  @GetMapping("/{enroll_id}")
  public ResponseEntity<?> getEnrollmentById(@PathVariable int enroll_id)
  {
	  System.out.println(" in the get enrollment by id "+enroll_id);
	 
	  Optional<Enrollments> enroll=service.getEnrollmentById(enroll_id);
	
	  if(enroll.isPresent())
		  return new ResponseEntity<>(enroll,HttpStatus.OK);
	  return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
  }
  
   @GetMapping()
   public ResponseEntity<?> getAllEnrollments()
   {
	   System.out.println(" in the get all enrollments");
	   try {
		   List<Enrollments> enrolls_list=service.getAllEnrollments();
		return new ResponseEntity<>(enrolls_list,HttpStatus.OK);
	} catch (RuntimeException e) {
		e.printStackTrace();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}   
   
   }
  
   @PostMapping()
   public ResponseEntity<?> addNewEnrollment(@RequestBody Enrollments e)
   {
	   System.out.println(" in the add enrollment controller "+e);
	   try {
		   Enrollments addedEnrollment=service.addNewEnrollment(e);
		   return new ResponseEntity<>(addedEnrollment,HttpStatus.OK);
	   }
	   catch(RuntimeException exp)
	   {
		   exp.printStackTrace();
		   return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	   }
   }
  
}
