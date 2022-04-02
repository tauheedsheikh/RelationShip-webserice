package com.alzohar.relationship.webservice.exception;

public class UserIsAlreadyExist extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserIsAlreadyExist(String message) {
		super(message);
	}
}
