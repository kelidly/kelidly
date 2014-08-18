package com.kelidly.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "links")
public class Links implements Serializable {


	private static final long serialVersionUID = 1L;
	private int id;
	private String name; 
	private String url;

	
	public Links() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue
	@Column(name = "ID")  
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "NAME")  
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "URL")  
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public Links(int id, String name, String url) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
		
	}


	
	
	
	
}
