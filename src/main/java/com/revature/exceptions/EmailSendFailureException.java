package com.revature.exceptions;

public class EmailSendFailureException extends Exception{
	private static final long serialVersionUID = 1L;

	public EmailSendFailureException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public EmailSendFailureException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public EmailSendFailureException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	

}
