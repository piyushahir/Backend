package com.app.controller;

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

import com.app.pojos.Course;
import com.app.service.ICourseService;

@CrossOrigin
@RestController
@RequestMapping("/course")
public class CourseController {
	
	//dependency
    @Autowired
	private ICourseService service;

	public CourseController()
	{
		System.out.println("in  Controller of  "+getClass().getName());
	}
	
	@PostMapping
	public ResponseEntity<?> addCourseDetails(@RequestBody Course transientpojo)
	{
		System.out.println("in add course details");
		try {
			System.out.println("request"+transientpojo);
		Course courseDetails = service.addCourseDetails(transientpojo);
	      return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(RuntimeException e)
		{
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
		
	@GetMapping
	public ResponseEntity<?> getAllCourses()
	{
			System.out.println("in get all courses controller");
			try {
				List<Course> courses=service.getAllCourseDetails();
			    return new ResponseEntity<>(courses,HttpStatus.OK);
			} catch (RuntimeException e) {
				e.printStackTrace();
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
	}
	
	@GetMapping("/{course_id}")
	public ResponseEntity<?> getCourseById(@PathVariable int course_id)
	{
		System.out.println("in the get course by id "+course_id);
		
			Optional<Course>  course = service.getCourseBytId(course_id);
			if(course.isPresent())
				return new ResponseEntity<>(course,HttpStatus.OK);
	       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/{course_id}")
	public String deleteCourseById(@PathVariable int course_id)
	{
		System.out.println("in delete course by id "+course_id);
		return service.deleteCourseById(course_id);
	}
	
	

     @PutMapping("/{course_id}")
	public  ResponseEntity<?> updateCourse(@PathVariable int course_id,@RequestBody Course detachedpojo)
	{
		try {
		Course entity=service.updateCourseById(course_id, detachedpojo);
		return new ResponseEntity<>(entity,HttpStatus.OK);
		}
		catch(RuntimeException e)
		{
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
		
}

