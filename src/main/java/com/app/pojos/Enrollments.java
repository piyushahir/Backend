package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "enrollments")
public class Enrollments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "enroll_id", unique = true, nullable = false)
	private int enroll_id;

	@JsonProperty("payment")
	@Column(name = "payments")
	private double payment;

	@Column(name = "reg_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate reg_date;
	/*
	 * @Lob
	 * 
	 * @Column(name="student_img",nullable = true) private Blob student_img;
	 */
	// ------student and enrollment mapping------//

	@JsonIgnoreProperties("studentEnrolls")
	@ManyToOne
	@JoinColumn(name = "fk_se_id",insertable = false,updatable=false)
	private Student student;

	// ---enroll to course mapping-----//
	  @ManyToOne 
	  //@JoinColumn(name="fk_ce_id")
	  private Course course;
	 

//----enroll to feedback mapping----//

    
	  @JsonIgnoreProperties("enroll")
	  @OneToOne(mappedBy = "enroll",cascade = CascadeType.ALL)
	  private Feedback feedback;


	// -------constructors----------//


public Enrollments() {
	super();
}


	public Enrollments(int enroll_id, double payment, LocalDate reg_date, Student student, Course course,
			Feedback feedback) {
		super();
		this.enroll_id = enroll_id;
		this.payment = payment;
		this.reg_date = reg_date;
		this.student = student;
		this.course = course;
		this.feedback = feedback;
	}


	public int getEnroll_id() {
		return enroll_id;
	}


	public void setEnroll_id(int enroll_id) {
		this.enroll_id = enroll_id;
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


	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}


	public Course getCourse() {
		return course;
	}


	public void setCourse(Course course) {
		this.course = course;
	}


	public Feedback getFeedback() {
		return feedback;
	}


	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}


	@Override
	public String toString() {
		return "Enrollments [enroll_id=" + enroll_id + ", payment=" + payment + ", reg_date=" + reg_date + ", student="
				+ student + ", course=" + course + ", feedback=" + feedback + "]";
	}


	

}
