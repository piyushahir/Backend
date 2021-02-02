package com.app.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IAdminDao;
import com.app.pojos.Admin_Details;

@Service
@Transactional
public class AdminServiceImpl implements IAdminService {

	@Autowired
	private IAdminDao dao;
	
	
	@Override
	public Admin_Details validateAdmin(String uname, String pass) {
		
		System.out.println("in validate service impl "+uname+" "+pass);
		return dao.findByEmailAndPassword(uname, pass);
	}


	@Override
	public Optional<Admin_Details> findByUsername(String uname) {
		// TODO Auto-generated method stub
		return findByUsername(uname);
	}

	
}
