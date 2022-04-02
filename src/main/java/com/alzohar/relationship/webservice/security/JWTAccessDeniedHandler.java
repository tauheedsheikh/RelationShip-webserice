package com.alzohar.relationship.webservice.security;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class JWTAccessDeniedHandler implements AccessDeniedHandler, Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);

		Map<String, Object> data = new HashMap<>();
		data.put("message", "Forbidden user access ");
		data.put("error", "User attempted to access the protected URL");
		data.put("timestamp", new Date());
		data.put("status", HttpServletResponse.SC_FORBIDDEN);

		OutputStream out = response.getOutputStream();
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(out, data);
		out.flush();
	}

}
