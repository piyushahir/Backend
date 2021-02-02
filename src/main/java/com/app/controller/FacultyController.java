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

import com.app.pojos.Faculty;
import com.app.service.IFacultyService;

@CrossOrigin
@RestController
@RequestMapping("/faculty")
public class FacultyController {

	@Autowired
	private IFacultyService service;
	
	public FacultyController() {
	    System.out.println("In the  controller of  "+getClass().getName());
	}
	
	@PostMapping()
	public ResponseEntity<?> addNewFaculty(@RequestBody Faculty transientpojo)
	{
		System.out.println("in the add new faculty controller");
		try {
			Faculty addedFaculty= service.addNewFaculty(transientpojo);
		     return new ResponseEntity<>(HttpStatus.OK);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping()
	public ResponseEntity<?> getAllFaculties()
	{
		System.out.println("in get all faculties ");
		try {
			      List<Faculty> faculties = service.getAllFaculty();
			     return new ResponseEntity<>(faculties,HttpStatus.OK);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{faculty_id}")
	public ResponseEntity<?> getFacultyById(@PathVariable int faculty_id)
	{
          System.out.println("in get faculty by id "+faculty_id);
          
          Optional<Faculty> faculty = service.getFacultyById(faculty_id);
	       if(faculty.isPresent())
	    	   return new ResponseEntity<>(faculty,HttpStatus.OK);
	       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/{faculty_id}")
	public String deleteFacultyById(@PathVariable int faculty_id)
	{
		System.out.println("in delete faculty controller"+faculty_id);
	   
	     return service.deleteFacultyById(faculty_id);
	}
	
	

	@PutMapping("/{faculty_id}")
	public ResponseEntity<?> updateFacultyById(@PathVariable int faculty_id,@RequestBody Faculty detachedpojo)
	{
		try {
		Faculty entity=service.updateFacultyById(faculty_id, detachedpojo);
		return new ResponseEntity<>(entity,HttpStatus.OK);
		}
		catch(RuntimeException e)
		{
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
