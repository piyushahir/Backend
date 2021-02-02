package com.app.dto;

import java.sql.Blob;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;

import org.springframework.format.annotation.DateTimeFormat;

import com.app.pojos.GenderType;
import com.app.pojos.QualificationType;

public class StudentEnrollmentDTO {

	private int student_id;
	
	private String student_name;
	
	private String email;
	
    private String contact_no;
	
	private String password;
	
	private String confirm_pass;
	
	private String address;
	
	private GenderType gentype;
	
	private QualificationType qualitype;
	
    private double payment;
    
    private LocalDate reg_date;
  
	private Blob student_img;

	//private  Course joinCourseEnroll;
	
	public StudentEnrollmentDTO() {
		super();
	}

	public StudentEnrollmentDTO(int student_id, String student_name, String email, String contact_no, String password,
			String confirm_pass, String address, GenderType gentype, QualificationType qualitype, double payment,
			LocalDate reg_date, Blob student_img) {
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
		this.payment = payment;
		this.reg_date = reg_date;
		this.student_img = student_img;
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

	public double getPayment() {
		return payment;
	}

	public void setPayment(double payment) {
		this.payment = payment;
	}

	public LocalDate getReg_date() {
		return reg_date;
	}

	public void setReg_date(LocalDate reg_date) {
		this.reg_date = reg_date;
	}

	public Blob getStudent_img() {
		return student_img;
	}

	public void setStudent_img(Blob student_img) {
		this.student_img = student_img;
	}

	@Override
	public String toString() {
		return "StudentEnrollmentDTO [student_id=" + student_id + ", student_name=" + student_name + ", email=" + email
				+ ", contact_no=" + contact_no + ", password=" + password + ", confirm_pass=" + confirm_pass
				+ ", address=" + address + ", gentype=" + gentype + ", qualitype=" + qualitype + ", payment=" + payment
				+ ", reg_date=" + reg_date + ", student_img=" + student_img + "]";
	}
	
	
	
	
	
	
}
