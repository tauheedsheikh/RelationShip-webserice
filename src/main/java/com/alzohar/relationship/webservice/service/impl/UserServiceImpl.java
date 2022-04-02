package com.alzohar.relationship.webservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.alzohar.relationship.webservice.entity.User;
import com.alzohar.relationship.webservice.exception.UserIsAlreadyExist;
import com.alzohar.relationship.webservice.repositrory.UserRepository;
import com.alzohar.relationship.webservice.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = LogManager.getLogger(UserServiceImpl.class);
	@Autowired
	private UserRepository repo;

	@Autowired
	PasswordEncoder encoder;

	@Override
	public User register(User user) {
		User fetchedUser = repo.getUsername(user.getUsername());
		if (fetchedUser != null) {
			LOGGER.error("User already exists for this username :: " + user.getUsername());
			throw new UserIsAlreadyExist("User already exists for this email");
		}
		encodePassword(user);
		LOGGER.info(user.getUsername() + " user is registred successfuly. ");
		return repo.save(user);
	}

	private void encodePassword(User user) {
		String encodedPass = encoder.encode(user.getPassword());
		user.setPassword(encodedPass);

	}

}
