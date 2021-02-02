package com.app.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

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

import com.app.pojos.Student;
import com.app.service.IStudentService;

@CrossOrigin
@RestController
@RequestMapping("/student")
public class StudentController {

	//dependency
	@Autowired
	private IStudentService service;
	
	
	public StudentController() 
	{
	System.out.println("in student controller "+getClass().getName());	
	}
	
	
	@PostMapping
	public ResponseEntity<?> addStudentDetails(@RequestBody Student transientpojo)throws UnsupportedEncodingException
	{
	        System.out.println("in add student controller "+transientpojo);
	        try {
	        	String message="This Message from E learning You Registered Successfully So Smile :) and Learn";
				String subject="Coaching Centre Management";
				String from="piyushahir43@gmail.com";
				String to=transientpojo.getEmail();
				
				service.sendemail(message, subject, to, from);
				
	        Student addedStudent = service.addStudentDetails(transientpojo);
	        return new ResponseEntity<> (addedStudent,HttpStatus.OK);
	        }
	        catch(RuntimeException e)
	        {
	        	e.printStackTrace();
	        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }
	        
	        
	  }

		 @GetMapping()
		 public ResponseEntity<?> getAllStudents()
		 {
              System.out.println("in get all student ");
              try 
              {
				List<Student> allStudentDetails = service.getALLStudentDetails();
				return new ResponseEntity<>(allStudentDetails,HttpStatus.OK);
			} catch (RuntimeException e) {
				e.printStackTrace();
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		  }
		 
		 @GetMapping("/{student_id}")
		 public ResponseEntity<?> getStudentById(@PathVariable int student_id)
		 {
			 System.out.println("in get Student by ID "+student_id);
			
		   Optional<Student> student= service.getStudentById(student_id);
				
		   if(student.isPresent())
					return new ResponseEntity<>(student,HttpStatus.OK);
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		 
		 @DeleteMapping("/{student_id}")
		 public   boolean deleteStudentById(@PathVariable int student_id)
		 {
			 System.out.println("in delete student by id controller ");
            
		     return service.deleteStudentById(student_id);
		 
		 }
		 
		 @PostMapping("/validate")
		 public Student validateStudent(@RequestBody Student s)
		 {
			 System.out.println(" in the validate student controller ");
			 
			 String email=s.getEmail();
			 String pass=s.getPassword();
			 
			 Student student= service.validateStudent(email, pass);
			 if(student!=null)
			 {
                  return student; 				 
			 }
			 else 
			 {
				 return null;
			 }
		 }
		 

		 @PutMapping("/{student_id}")
		 public ResponseEntity<?> updateStudent(@PathVariable int student_id,@RequestBody Student detachedpojo)
		 {
			 System.out.println("in the update student "+student_id+"  "+detachedpojo);
			 try {
			 Student entity=service.updateStudent(student_id, detachedpojo);
			 return new ResponseEntity<>(detachedpojo,HttpStatus.OK);
			 }
			 catch(RuntimeException e){
				 e.printStackTrace();
				 return new ResponseEntity(HttpStatus.BAD_REQUEST);
			 }
				 
		 }
		 
		 
}
