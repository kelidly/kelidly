package com.kelidly.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cust_case")
public class Case implements Serializable {


	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private String pic;
	private String url;
	public Case(int id, String name, String pic, String url) {
		super();
		this.id = id;
		this.name = name;
		this.pic = pic;
		this.url = url;
	}
	public Case() {
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
	@Column(name = "PIC")  
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	@Column(name = "URL")  
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	

	
}
