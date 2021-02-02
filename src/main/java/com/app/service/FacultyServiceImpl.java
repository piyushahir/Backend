package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IFacultyDao;
import com.app.pojos.Faculty;

@Service
@Transactional
public class FacultyServiceImpl implements IFacultyService {
     
	@Autowired
	private IFacultyDao dao;
	
	@Override
	public Faculty addNewFaculty(Faculty transientpojo) {

		System.out.println("in faculty service impl "+transientpojo);
		
		return dao.save(transientpojo);
	}

	//get all faculty
	@Override
	public List<Faculty> getAllFaculty() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	//get faculty by id
	@Override
	public Optional<Faculty> getFacultyById(int faculty_id) {
		// TODO Auto-generated method stub
		return dao.findById(faculty_id);
	}

	//delete faculty by id
	@Override
	public String deleteFacultyById(int faculty_id) {
		// TODO Auto-generated method stub
		Optional<Faculty> faculty = dao.findById(faculty_id);
		if(faculty.isPresent())
		{
			dao.deleteById(faculty_id);
			return "faculty with "+faculty_id+"deleted successfully";
		}
		else
		{
			return "faculty with "+faculty_id+" not found";
		}
	}
    
	@Override
	public Faculty updateFacultyById(int faculty_id, Faculty detachedpojo) {
		Optional <Faculty> value=getFacultyById(faculty_id);
		if(value.isPresent())
		{
            Faculty pojo=value.get();
			pojo.setFaculty_name(detachedpojo.getFaculty_name());
			pojo.setContact_no(detachedpojo.getContact_no());
			pojo.setAddress(detachedpojo.getAddress());

		 return detachedpojo;
		}
		return null;
	}

	
	
	
}
