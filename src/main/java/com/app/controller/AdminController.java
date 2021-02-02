package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Admin_Details;
import com.app.service.IAdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
   
    //depenedency
	private IAdminService service;
	
	public AdminController()
	{
		System.out.println("in the  controller of "+getClass().getName());
	}
	
	@PostMapping("/validate")
	public String validateAdmin(@RequestBody Admin_Details a)
	{
		String uname=a.getEmail();
		String pass=a.getPassword();
	    System.out.println(uname+"  "+pass);	
		 Admin_Details admin=service.validateAdmin(uname,pass);
		 String mesg="admin details validated successfully!!!!!";
		if(uname==admin.getEmail() && pass==admin.getPassword())
		{
			return mesg;
		}
		else {
			mesg="admin validation failed";
			return mesg;
		}
		
	}
	/*
	@GetMapping("/{uname}/{pass}")
	public String checkAdminDetails(@PathVariable String uname,@PathVariable String pass)
	{
		//String uname=a.getUsername();
		//String pass=a.getPassword();
	    System.out.println(uname+"  "+pass);	
	    
	    Optional<Admin_Details> admin=service.findByUsername(uname);
	     Admin_Details a1=admin.get();
	    if(admin.isPresent())
	    {
	    	if(uname==a1.getUsername() && pass==a1.getPassword())
	    	{
	    		return "admin details validated successfully!!!!!";
	    	}
	    	else {
	    		return "Entered password is wrong";
	    	}
	    }
	    else {
	    	return "admin validation failed..";
	    }
	
	}
	*/

}
