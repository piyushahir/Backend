package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin_info")
public class Admin_Details {

	@Id
	private int Id;
	@Column(length = 15)
	private String email;
	@Column(length=15)
	private String password;
	public Admin_Details() {
		super();
	}
	public Admin_Details(int id, String email, String password) {
		super();
		Id = id;
		this.email = email;
		this.password = password;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Admin_Details [Id=" + Id + ", email=" + email + ", password=" + password + "]";
	}

	
}
