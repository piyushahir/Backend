package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Enrollments;
import com.app.pojos.Student;

public interface IStudentDao extends JpaRepository<Student,Integer> {
	
	
	Student findByEmailAndPassword(String email,String pass);
	

	
	}


	

