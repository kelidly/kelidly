package com.kelidly.util;

import javax.servlet.http.HttpServletRequest;

public class FileUploadBean {

	// 文件大小常量, 单位kb
	private static final int MAX_SIZE = 500 * 1024;
	// 输出文件地址
	private String url = "";
	// 上传文件名
	private String fileName = "";
	// 状态
	private String state = "";
	// 文件类型
	private String type = "";
	// 原始文件名
	private String originalName = "";
	// 文件大小
	private String size = "";

	private HttpServletRequest request = null;
	private String title = "";
	
	//相对路径
	private String relativeURL;

	// 保存路径
	private String savePath = "upload";

	public FileUploadBean(String url, String fileName, String state,
			String type, String originalName, String size,
			HttpServletRequest request, String title,
			String savePath,String relativePath) {
		super();
		this.url = url;
		this.fileName = fileName;
		this.state = state;
		this.type = type;
		this.originalName = originalName;
		this.size = size;
		this.request = request;
		this.title = title;
		this.savePath = savePath;
		this.relativeURL = relativePath;
	}

	public FileUploadBean() {
		super();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOriginalName() {
		return originalName;
	}

	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String getRelativeURL() {
		return relativeURL;
	}

	public void setRelativeURL(String relativeURL) {
		this.relativeURL = relativeURL;
	}

	
	
	
}
