package com.kelidly.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "words")
public class Words implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String guest; 
	private String tel;

	private String fax;
	private String email;
	private String company;
	private String content;
	private Date leaveTime;
	private int productId;
	
	public Words() {
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

	public Words(int id, String guest, String tel, String fax,
			String email, String company, String content,Date leaveTime) {
		super();
		this.id = id;
		this.guest = guest;
		this.tel = tel;
		this.fax = fax;
		this.email = email;
		this.company = company;
		this.content = content;
		this.leaveTime = leaveTime;
	}

	@Column(name = "GUEST")  
	public String getGuest() {
		return guest;
	}

	public void setGuest(String guest) {
		this.guest = guest;
	}
	@Column(name = "TEL")  
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	@Column(name = "FAX")  
	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}
	@Column(name = "EMAIL")  
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name = "COMPANY")  
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	@Column(name = "CONTENT")  
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	@Column(name = "LEAVE_TIME")  
	public Date getLeaveTime() {
		return leaveTime;
	}

	public void setLeaveTime(Date leaveTime) {
		this.leaveTime = leaveTime;
	}
	@Column(name = "PRO_ID")  
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	
	
	
	
}
