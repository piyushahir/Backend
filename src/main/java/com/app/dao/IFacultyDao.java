package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Faculty;

public interface IFacultyDao extends JpaRepository<Faculty, Integer>{

	
}
