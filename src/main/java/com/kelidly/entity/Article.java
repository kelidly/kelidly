package com.kelidly.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "article")
public class Article implements Serializable {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private long siteid;
	private String title;
	private String content;
	private String imgurl;	
	private String flashurl;
	private Date addtime;
	private long hot;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getSiteid() {
		return siteid;
	}
	public void setSiteid(long siteid) {
		this.siteid = siteid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public String getFlashurl() {
		return flashurl;
	}
	public void setFlashurl(String flashurl) {
		this.flashurl = flashurl;
	}
	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	public long getHot() {
		return hot;
	}
	public void setHot(long hot) {
		this.hot = hot;
	}
	public Article(long id, long siteid, String title, String content,
			String imgurl, String flashurl, Date addtime, long hot) {
		super();
		this.id = id;
		this.siteid = siteid;
		this.title = title;
		this.content = content;
		this.imgurl = imgurl;
		this.flashurl = flashurl;
		this.addtime = addtime;
		this.hot = hot;
	}
	public Article() {
		super();
	}
	
	
	
	
}
