package com.kelidly.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "NEWS")
public class News implements Serializable {


	
	private static final long serialVersionUID = 1L;
	private int id;
	private String title; 
	private String content;
	private Date pubTime;
	private int hot;
	private int typeId;
	
	
	public News() {
		super();
	}

	public News(int id, String title, String content, Date pubTime,
			int hot) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.pubTime = pubTime;
		this.hot = hot;
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
	@Column(name = "TITLE")  
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Column(name = "CONTENT")  
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Column(name = "PUB_TIME")  
	public Date getPubTime() {
		return pubTime;
	}
	public void setPubTime(Date pubTime) {
		this.pubTime = pubTime;
	}
	@Column(name = "HOT")  
	public int getHot() {
		return hot;
	}
	public void setHot(int hot) {
		this.hot = hot;
	}
	@Column(name = "type_id")  
	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}	
	
	
	
}
