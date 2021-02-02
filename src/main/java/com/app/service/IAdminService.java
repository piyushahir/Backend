package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.Admin_Details;

public interface IAdminService {
	
	Admin_Details validateAdmin(String uname,String pass);
	
	Optional<Admin_Details> findByUsername(String uname);

}
