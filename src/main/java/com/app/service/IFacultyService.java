package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.Faculty;

public interface IFacultyService {
	
	//add new faculty
	Faculty addNewFaculty(Faculty transientpojo);
 
	//get all faculty
	List<Faculty> getAllFaculty();

    //get faculty by id
	Optional<Faculty> getFacultyById(int faculty_id);

   //delete faculty by id
	String deleteFacultyById(int faculty_id);
	
	//update faculty by id
	Faculty updateFacultyById(int faculty_id,Faculty detachedpojo);

}
