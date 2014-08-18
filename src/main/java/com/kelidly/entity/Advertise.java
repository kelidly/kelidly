package com.kelidly.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "advertise")
public class Advertise implements Serializable {


	private static final long serialVersionUID = 1L;
	private int id;
	private String name; //文件名
	private String oldName;//原先名字
    private String path;//存放路径
	private String use;//用途
	
	public Advertise() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Advertise(int id, String name, String oldName, String path,
			String use) {
		super();
		this.id = id;
		this.name = name;
		this.oldName = oldName;
		this.path = path;
		this.use = use;
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
	@Column(name = "old_name")  
	public String getOldName() {
		return oldName;
	}

	public void setOldName(String oldName) {
		this.oldName = oldName;
	}

	@Column(name = "PATH")  
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	@Column(name = "USE")  
	public String getUse() {
		return use;
	}

	public void setUse(String use) {
		this.use = use;
	}
	
	
	
}
