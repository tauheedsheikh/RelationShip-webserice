package com.alzohar.relationship.webservice.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alzohar.relationship.webservice.entity.Customer;
import com.alzohar.relationship.webservice.exception.CustomerNotFound;
import com.alzohar.relationship.webservice.repositrory.CustomerRepository;


@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	CustomerRepository repoCustomer;

	@GetMapping("/customer/{id}")
	public Customer getcutomerById(@PathVariable("id") long id) {
		return repoCustomer.getById(id);

	}
	

	@GetMapping("/customers")
	public List<Customer> getByName(@RequestParam("name") String name) {
		List<Customer> customer=repoCustomer.findByname(name);
		if(customer.isEmpty()) {
			throw new CustomerNotFound("Customer Not Found With The Given Information"+name);
		}
		return customer;

	}

	@GetMapping("/custom")
	public List<Customer> getbyEmail(@RequestParam("email") String email) {
		List<Customer> customer= repoCustomer.findByEmail(email);
		if(customer.isEmpty()) {
			throw new CustomerNotFound("Customer Not Found With The Given Information"+email);
		}
		return customer;
	}

	@GetMapping("/custome")
	public List<Customer> getAllCustomer() {
		List<Customer> cutomer = repoCustomer.findAll();
		if (cutomer.isEmpty()) {
			throw new CustomerNotFound("Customer Not Found With The Given Information");
		}

		return cutomer;
	}

	@PostMapping("/customer")
	public Customer createdCustomer( @RequestBody Customer customer) {
		return repoCustomer.save(customer);
		
	}

	@PutMapping("/customer")
	public Customer updateCustomer(@RequestBody Customer customer) {
		return repoCustomer.save(customer);
	}

	@DeleteMapping("/customer/{id}")
	public String deleteCustomer(@PathVariable("id") long id) {
		return "Customer is Delete Successfully";
	}
}
