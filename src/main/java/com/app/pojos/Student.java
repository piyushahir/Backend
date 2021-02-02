package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "student_info")
//@JsonIgnoreProperties({"studentEnrolls"})
public class Student  {
     
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "student_id",unique = true, nullable = false)
	private int student_id;
	
	@Column(name="student_name",length = 30)
	private String student_name;
	
	@Column(name="email",length = 200,unique=true)
	private String email;
	
	@Column(name="contact_no",length = 10)
	private String contact_no;
	
	@JsonProperty("password")
	@Column(length=10,name = "pass")
	private String password;
	
	@JsonProperty("confirm_password")
	@Column(length=10,name = "c_pass")
	private String confirm_pass;
	
	@JsonProperty("student_address")
	@Column(length=30,name = "stud_address")
	private String address;
	
	@JsonProperty("gender")
	@Column(length=10,name = "gender")
	@Enumerated(EnumType.STRING)
	private GenderType gentype;
	
	@JsonProperty("qualification")
	@Column(length=10,name = "qualification")
	@Enumerated(EnumType.STRING)
	private QualificationType qualitype;
	
	//-----enroll to student mapping-----//
	
	@JsonIgnoreProperties("student")
    //@JsonManagedReference
    //@JsonIgnore
	@OneToMany(targetEntity = Enrollments.class,cascade = CascadeType.ALL)
    @JoinColumn(name="fk_se_id")
    public List<Enrollments>  studentEnrolls=new ArrayList<Enrollments>();

   
    public void addEnrollments(Enrollments e)
    {
    	this.studentEnrolls.add(e);
    	e.setStudent(this);
    }
    public void removeEnrollments(Enrollments e)
    {
    	this.studentEnrolls.remove(e);
    	e.setStudent(null);
    }
	
    
//-----------constructors----------------//
    public Student() {
		super();
	}
public Student(int student_id, String student_name, String email, String contact_no, String password,
		String confirm_pass, String address, GenderType gentype, QualificationType qualitype,
		List<Enrollments> studentEnrolls) {
	super();
	this.student_id = student_id;
	this.student_name = student_name;
	this.email = email;
	this.contact_no = contact_no;
	this.password = password;
	this.confirm_pass = confirm_pass;
	this.address = address;
	this.gentype = gentype;
	this.qualitype = qualitype;
	this.studentEnrolls = studentEnrolls;
}
public int getStudent_id() {
	return student_id;
}
public void setStudent_id(int student_id) {
	this.student_id = student_id;
}
public String getStudent_name() {
	return student_name;
}
public void setStudent_name(String student_name) {
	this.student_name = student_name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getContact_no() {
	return contact_no;
}
public void setContact_no(String contact_no) {
	this.contact_no = contact_no;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getConfirm_pass() {
	return confirm_pass;
}
public void setConfirm_pass(String confirm_pass) {
	this.confirm_pass = confirm_pass;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public GenderType getGentype() {
	return gentype;
}
public void setGentype(GenderType gentype) {
	this.gentype = gentype;
}
public QualificationType getQualitype() {
	return qualitype;
}
public void setQualitype(QualificationType qualitype) {
	this.qualitype = qualitype;
}
public List<Enrollments> getStudentEnrolls() {
	return studentEnrolls;
}
public void setStudentEnrolls(List<Enrollments> studentEnrolls) {
	this.studentEnrolls = studentEnrolls;
}
@Override
public String toString() {
	return "Student [student_id=" + student_id + ", student_name=" + student_name + ", email=" + email + ", contact_no="
			+ contact_no + ", password=" + password + ", confirm_pass=" + confirm_pass + ", address=" + address
			+ ", gentype=" + gentype + ", qualitype=" + qualitype + ", studentEnrolls=" + studentEnrolls + "]";
}
    
    
    
}
