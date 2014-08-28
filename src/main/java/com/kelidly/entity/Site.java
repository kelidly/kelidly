package com.kelidly.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "site")
public class Site {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private long id;
	private String name;
	private String code;
	private int rank;
	private int state;
	private String url;
	private String content;
	private long pid;
	private int sort;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public long getPid() {
		return pid;
	}
	public void setPid(long pid) {
		this.pid = pid;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public Site(long id, String name, String code, int rank, int state,
			String url, String content, long pid, int sort) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.rank = rank;
		this.state = state;
		this.url = url;
		this.content = content;
		this.pid = pid;
		this.sort = sort;
	}
	public Site() {
		super();
	}
	
	
	
	
}
