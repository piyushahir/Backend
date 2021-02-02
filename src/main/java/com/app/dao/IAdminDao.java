package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Admin_Details;

public interface IAdminDao extends JpaRepository<Admin_Details, Integer> {

	Admin_Details  findByEmailAndPassword(String uname,String pass); 
	
	//Optional<Admin_Details> findByUsername(String uname);
}
