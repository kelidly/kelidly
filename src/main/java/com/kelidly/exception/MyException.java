package com.kelidly.exception;



public class MyException extends RuntimeException {
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

	public MyException() {
		super();
	}
	
	public MyException(MyException e) {
		super(e.getMessage());
		this.backUrl = e.getBackUrl();
	}
	
	public MyException(String message) {
		super(message);
	}
	
	public MyException(String message, String backUrl) {
		super(message);
		this.backUrl = backUrl;
	}
	
	public MyException(String message, String backUrl,String text) {
		super(message);
		this.backUrl = backUrl;
		this.text = text;
	}
}

	

