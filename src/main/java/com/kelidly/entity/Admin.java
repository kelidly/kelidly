package com.kelidly.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")  
public class Admin implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private Integer id;  
	private String adminName;  
	private String password;
	
	public Admin(Integer id, String adminName, String password) {
		super();
		this.id = id;
		this.adminName = adminName;
		this.password = password;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@Id  
	@GeneratedValue
	@Column(name = "id")  
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}


	@Column(name = "name")  
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	@Column(name = "password")  
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	
}
