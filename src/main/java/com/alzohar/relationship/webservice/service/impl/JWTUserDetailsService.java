package com.alzohar.relationship.webservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.alzohar.relationship.webservice.entity.User;
import com.alzohar.relationship.webservice.repositrory.UserRepository;
import com.alzohar.relationship.webservice.service.MyUserDetails;

@Service
public class JWTUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.getUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found !");
		}
		return new MyUserDetails(user);
	}

}
