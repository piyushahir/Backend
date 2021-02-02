package com.app.pojos;

import java.sql.Blob;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "courses")
//@JsonIgnoreProperties({"faculty"})
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_id", insertable = false, updatable = false)
	private int course_id;

	@Column(name = "Course_name", length = 20, unique = true)
	private String course_name;

	@Column(name = "start_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate start_date;

	@Column(name = "end_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate end_date;

	@Column(name = "batch_size")
	private int batch_size;

	@Column(name = "fees")
	private double fees;

	/*
	 * @Lob
	 * 
	 * @Column(name ="course_data",nullable = true) private Blob course_data;
	 */

	// ---enroll to course mapping-----//
	 
/*
	public void addCourseEnroll(Enrollments e) {
		this.courseEnrolls.add(e);
		e.setCourse(this);
	}
	

	public void removeCourseEnroll(Enrollments e) {
		this.courseEnrolls.remove(e);
		e.setCourse(null);
	}
*/
	// --------Course And Faculty-----------------//

	//@JsonIgnore
	//@JsonBackReference
	@JsonIgnoreProperties("course")
	@OneToOne(mappedBy = "course",cascade = CascadeType.ALL)
	private Faculty faculty;
	
	
//-----------constructors-----------//
	public Course() {
		super();
	}


public Course(int course_id, String course_name, LocalDate start_date, LocalDate end_date, int batch_size, double fees,
		Faculty faculty) {
	super();
	this.course_id = course_id;
	this.course_name = course_name;
	this.start_date = start_date;
	this.end_date = end_date;
	this.batch_size = batch_size;
	this.fees = fees;
	this.faculty = faculty;
}


public int getCourse_id() {
	return course_id;
}


public void setCourse_id(int course_id) {
	this.course_id = course_id;
}


public String getCourse_name() {
	return course_name;
}


public void setCourse_name(String course_name) {
	this.course_name = course_name;
}


public LocalDate getStart_date() {
	return start_date;
}


public void setStart_date(LocalDate start_date) {
	this.start_date = start_date;
}


public LocalDate getEnd_date() {
	return end_date;
}


public void setEnd_date(LocalDate end_date) {
	this.end_date = end_date;
}


public int getBatch_size() {
	return batch_size;
}


public void setBatch_size(int batch_size) {
	this.batch_size = batch_size;
}


public double getFees() {
	return fees;
}


public void setFees(double fees) {
	this.fees = fees;
}


public Faculty getFaculty() {
	return faculty;
}


public void setFaculty(Faculty faculty) {
	this.faculty = faculty;
}


@Override
public String toString() {
	return "Course [course_id=" + course_id + ", course_name=" + course_name + ", start_date=" + start_date
			+ ", end_date=" + end_date + ", batch_size=" + batch_size + ", fees=" + fees + ", faculty=" + faculty + "]";
}

	
	

}
