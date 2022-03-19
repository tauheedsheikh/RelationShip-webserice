package com.alzohar.relationship.webservice.exception;

public class CustomerNotFound extends RuntimeException {

	
	private static final long serialVersionUID = 1L;

	public CustomerNotFound (String message) {
		super(message);
	}
}
