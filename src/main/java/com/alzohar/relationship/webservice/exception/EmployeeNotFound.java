package com.alzohar.relationship.webservice.exception;

public class EmployeeNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmployeeNotFound(String message) {
		super(message);
	}

}
