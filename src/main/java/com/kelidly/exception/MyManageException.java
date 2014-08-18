package com.kelidly.exception;

public class MyManageException extends RuntimeException {
	private static final long serialVersionUID = 538922474277376456L;

    private String backUrl;
    
    
	public String getBackUrl() {
		return backUrl;
	}

	public void setBackUrl(String backUrl) {
		this.backUrl = backUrl;
	}

	public MyManageException() {
		super();
	}

	public MyManageException(String message) {
		super(message);
	}
	
	public MyManageException(String message, String backUrl) {
		super(message);
		this.backUrl = backUrl;
	}
}
