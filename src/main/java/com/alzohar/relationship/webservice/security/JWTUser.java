package com.alzohar.relationship.webservice.security;

import lombok.Data;

@Data
public class JWTUser {
	private String username;
	private String password;
}
