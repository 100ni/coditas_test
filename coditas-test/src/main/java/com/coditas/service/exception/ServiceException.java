package com.coditas.service.exception;

public class ServiceException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String errorMessage;
 
	public String getErrorMessage() {
		return errorMessage;
	}
	public ServiceException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}
	public ServiceException() {
		super();
	}
}
