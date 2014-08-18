package com.kelidly.exception;

public class DaoException extends RuntimeException {
	private static final long serialVersionUID = 538922474277376456L;
	private String backUrl;
	private String text;
	
	public String getBackUrl() {
		return backUrl;
	}

	public void setBackUrl(String backUrl) {
		this.backUrl = backUrl;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public DaoException() {
		super();
	}
	
	public DaoException(DaoException e) {
		super(e.getMessage());
		this.backUrl = e.getBackUrl();
	}
	
	public DaoException(String message) {
		super(message);
	}
	
	public DaoException(String message, String backUrl) {
		super(message);
		this.backUrl = backUrl;
	}
	
	public DaoException(String message, String backUrl,String text) {
		super(message);
		this.backUrl = backUrl;
		this.text = text;
	}
}

	

