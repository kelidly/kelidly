package com.kelidly.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "NEWS_TYPE")
public class NewsType implements Serializable{

	private static final long serialVersionUID = 1L;

	private int id;
	private String type;
	
	public NewsType(int id, String type) {
		super();
		this.id = id;
		this.type = type;
	}
	public NewsType() {
		super();
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
	@Column(name = "TYPE_NAME") 
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	
	
	
	
}
