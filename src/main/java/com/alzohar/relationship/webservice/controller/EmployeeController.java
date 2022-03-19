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
import org.springframework.web.bind.annotation.RestController;

import com.alzohar.relationship.webservice.entity.Employee;
import com.alzohar.relationship.webservice.exception.EmployeeNotFound;
import com.alzohar.relationship.webservice.repositrory.EmployeeRepository;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeRepository repoE;

	@GetMapping("/employee/{id}")
	public Employee getById(@PathVariable("id") long id) {
		return repoE.getById(id);
	}

	@GetMapping("/employee")
	public List<Employee> getAllCEmployee() {
		List<Employee> emp = repoE.findAll();
		if (emp.isEmpty()) {
			throw new EmployeeNotFound("employee Not Found With The Given Information");
		}

		return emp;
	}

	@PostMapping("/employee")
	public Employee createdEmployee(@RequestBody Employee emloyee) {
		return repoE.save(emloyee);

	}

	@PutMapping("/employee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return repoE.save(employee);
	}

	@DeleteMapping("/employee/{id}")
	public String deleteEmployee(@PathVariable("id") long id) {
		return "Customer is Delete Successfully";
	}
}
