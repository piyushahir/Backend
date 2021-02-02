package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "faculty")
//@JsonIgnoreProperties({"course"})
public class Faculty {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fac_id",insertable = false, updatable = false)
	private int faculty_id;
	
	@Column(name = "faculty_name",length=30)
	private String faculty_name;
	
	@Column(name = "fac_address",length=30)
	private String address;
	
	@Column(name="fac_contact",length = 10)
	private String contact_no;
	
//----------faculty and course----------//
	//@JsonIgnore
	//@JsonManagedReference
	@JsonIgnoreProperties("faculty")
	@OneToOne
	@JoinColumn(name = "fk_cf_id")
	private Course course;

//---------constructors--------------//
	
	public Faculty() {
	super();
}

public Faculty(int faculty_id, String faculty_name, String address, String contact_no, Course course) {
	super();
	this.faculty_id = faculty_id;
	this.faculty_name = faculty_name;
	this.address = address;
	this.contact_no = contact_no;
	this.course = course;
}

public int getFaculty_id() {
	return faculty_id;
}

public void setFaculty_id(int faculty_id) {
	this.faculty_id = faculty_id;
}

public String getFaculty_name() {
	return faculty_name;
}

public void setFaculty_name(String faculty_name) {
	this.faculty_name = faculty_name;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getContact_no() {
	return contact_no;
}

public void setContact_no(String contact_no) {
	this.contact_no = contact_no;
}

public Course getCourse() {
	return course;
}

public void setCourse(Course course) {
	this.course = course;
}

@Override
public String toString() {
	return "Faculty [faculty_id=" + faculty_id + ", faculty_name=" + faculty_name + ", address=" + address
			+ ", contact_no=" + contact_no + ", course=" + course + "]";
}

	
	
	
	
}
