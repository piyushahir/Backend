package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.app.dao.IEnrollmentDao;
import com.app.pojos.Enrollments;

@Service
@Transactional
public class EnrollmentServiceImpl implements IEnrollmentService {

	//dependency
	private IEnrollmentDao dao;

	//update the enrollments
	@Override
	public Enrollments updateEnrollmentById(Enrollments e,int enroll_id) {
		// TODO Auto-generated method stub
		System.out.println("in the update enrollment by id "+enroll_id);
	  Optional<Enrollments> value=dao.findById(enroll_id);
	  if(value.isPresent())
	  {
		  Enrollments pojo=value.get();
		  pojo.setPayment(e.getPayment());
		  pojo.setReg_date(e.getReg_date());
		  pojo.setCourse(e.getCourse());
		  pojo.setStudent(e.getStudent());
		  pojo.setFeedback(e.getFeedback());
		  
		  return pojo;
	  }
	  return null;
		
	}

	//get enrollment by id
	@Override
	public Optional<Enrollments> getEnrollmentById(int enroll_id) {
		
		System.out.println(" in the get erollment by id "+enroll_id);
		
		return dao.findById(enroll_id);
	}

	@Override
	public List<Enrollments> getAllEnrollments() {
		
		return dao.findAll();
	}

	@Override
	public Enrollments addNewEnrollment(Enrollments e) {
		
		System.out.println(" in the enrollment service impl "+e);
		return dao.save(e);
	}

    

}
