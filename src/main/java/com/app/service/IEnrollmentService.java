package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.Enrollments;

public interface IEnrollmentService {

	//update enrollment by id
	Enrollments updateEnrollmentById(Enrollments e,int enroll_id);

   //get enrollments by id
	Optional<Enrollments> getEnrollmentById(int enroll_id);

   //get all enrollments
	List<Enrollments> getAllEnrollments();
	
	//add new Enrollment
	Enrollments addNewEnrollment(Enrollments e);
	
}
