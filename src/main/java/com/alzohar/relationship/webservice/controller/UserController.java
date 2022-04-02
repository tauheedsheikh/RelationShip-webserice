package com.alzohar.relationship.webservice.controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alzohar.relationship.webservice.entity.User;
import com.alzohar.relationship.webservice.repositrory.UserRepository;
import com.alzohar.relationship.webservice.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	private static final Logger LOGGER = LogManager.getLogger(UserController.class);
		
	@Autowired
	UserRepository repository;
	
	@Autowired 
	UserService service;
	

	@GetMapping("/user/{id}")
	public Optional<User> getById(@PathVariable("id") long id) {
		Optional<User> user = repository.findById(id);
		if(user!=null) {
			LOGGER.info("User is Found With Id  ::"+id);
			return user;
		}
		LOGGER.info("User is not found with id "+id);
		throw new UsernameNotFoundException("User Not Found ");
	}

	@GetMapping("/user")
	public List<User> getAlUser() {
		List<User> user = repository.findAll();
		if (user.isEmpty()) {
			LOGGER.info("User is Not Found , User List is Empty");
			throw new UsernameNotFoundException("User Not Found");
		}
		LOGGER.info("Get user list Successfully");
		return user;
	}

	@PostMapping("/user")
	public User createUser(@RequestBody User users) {
		return repository.save(users);
	}

	@PutMapping("/user")
	public User updateUser(@RequestBody User users) {
		return repository.save(users);
	}

	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable("id") long id) {
		return "User is Delete Successfully";
	}
}