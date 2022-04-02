package com.alzohar.relationship.webservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alzohar.relationship.webservice.entity.Project;
import com.alzohar.relationship.webservice.exception.OrderNotFound;
import com.alzohar.relationship.webservice.repositrory.ProjectRepository;

@RestController
@RequestMapping("/api")
public class ProjectController {

	@Autowired
	ProjectRepository repo;

	@GetMapping("/project/{id}")
	public Optional<Project> findById(@PathVariable("id") long id) {
		return repo.findById(id);
	}

	@GetMapping("/projects")
	public List<Project> getAll() {
		List<Project> project = repo.findAll();
		if (project.isEmpty()) {
			throw new OrderNotFound("Order Not Found with the Given Information");

		}
		return project;
	}

	@PostMapping("/project")
	public Project createOrder(@RequestBody Project project) {
		return repo.save(project);
	}

	@PutMapping("/projects")
	public Project updateOrder(@RequestBody Project project) {
		return repo.save(project);
	}

	@DeleteMapping("/projcets/{id}")
	public String deleteOrders(@PathVariable("id") long id) {
		repo.deleteById(id);
		return "Order is Delete Successfully";
	}
}
