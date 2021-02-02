package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.Course;


public interface ICourseService {

	//adding new course
	Course addCourseDetails(Course transientpojo);

   //getting all course details
	List<Course> getAllCourseDetails();
	
	//get course by id
	Optional<Course> getCourseBytId(int course_id);

   //delete course by id
	String deleteCourseById(int course_id);
	

	//update course by id
	Course updateCourseById(int course_id,Course detachedpojo);


}
