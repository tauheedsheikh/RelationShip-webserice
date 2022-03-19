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

import com.alzohar.relationship.webservice.entity.House;
import com.alzohar.relationship.webservice.exception.OrderNotFound;
import com.alzohar.relationship.webservice.repositrory.HouseRepository;

@RestController
public class HouseController {

	@Autowired
	HouseRepository repo;

	@GetMapping("/house/{id}")
	public Optional<House> findById(@PathVariable("id") long id) {
		return repo.findById(id);

	}

	@GetMapping("/hous")
	public List<House> getAll() {
		List<House> order = repo.findAll();
		if (order.isEmpty()) {
			throw new OrderNotFound("Order Not Found with the Given Information");

		}
		return order;
	}

	@PostMapping("/house")
	public House createOrder(@RequestBody House house) {
		return repo.save(house);
	}

	@PutMapping("/house")
	public House updateOrder(@RequestBody House house) {
		return repo.save(house);
	}

	@DeleteMapping("/house/{id}")
	public String deleteOrders(@PathVariable("id") long id) {
		repo.deleteById(id);
		return "Order is Delete Successfully";
	}
}
