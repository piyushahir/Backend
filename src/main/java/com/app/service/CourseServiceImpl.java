package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ICourseDao;
import com.app.pojos.Course;

@Service
@Transactional
public class CourseServiceImpl implements ICourseService {

	//dependency
	@Autowired
	private ICourseDao dao;
	
	
	//adding new course
	@Override
	public Course addCourseDetails(Course transientpojo) {
		System.out.println("in course service impl "+transientpojo);
		//reverse mapping for setting fk in faculty
     	//transientpojo.getFac_id().setC_id(transientpojo);
		transientpojo.getFaculty().setCourse(transientpojo);
		return dao.save(transientpojo);
	}

	//getting all courses
	
	@Override
	public List<Course> getAllCourseDetails() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	//get course by id
	@Override
	public Optional<Course> getCourseBytId(int course_id) {
		// TODO Auto-generated method stub
		return dao.findById(course_id);
	}
   
	//delete course by id
	@Override
	public String deleteCourseById(int course_id) {
		// TODO Auto-generated method stub
		Optional<Course> course = dao.findById(course_id);
		if(course.isPresent())
		{
			 dao.deleteById(course_id);
		return "course with "+course_id+"deleted successfully";
	    }
		else {
			return "course with "+course_id+"does not exist";
		}

	}
	
	
    //update course by id

	@Override
	public Course updateCourseById(int course_id, Course detachedpojo) {
		Optional <Course> value=dao.findById(course_id);
		if(value.isPresent())
		{
            Course pojo=value.get();
			
			pojo.setCourse_name(detachedpojo.getCourse_name());
			pojo.setStart_date(detachedpojo.getStart_date());
			pojo.setEnd_date(detachedpojo.getEnd_date());
			pojo.setBatch_size(detachedpojo.getBatch_size());
			pojo.setFees(detachedpojo.getFees());
		
		 return pojo;
		}
			return null;
	}
	
	
	
	
}
