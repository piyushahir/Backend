package com.app.service;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

import com.app.pojos.Student;

public interface IStudentService {

	//adding new student
	Student   addStudentDetails(Student transientpojo); 
    //getting list of student
	List<Student>   getALLStudentDetails();
    //getting student by id
	Optional<Student> getStudentById(int student_id);
    //deleting student by id
	boolean deleteStudentById(int student_id);
	//validate student
	Student validateStudent(String email,String pass);

	//update student by id
	Student updateStudent(int student_id,Student detachedpojo);
	public void sendemail(String message ,String subject,String to,String from ) throws UnsupportedEncodingException;
	

}
