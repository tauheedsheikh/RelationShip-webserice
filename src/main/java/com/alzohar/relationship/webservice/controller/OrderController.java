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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alzohar.relationship.webservice.entity.Order;
import com.alzohar.relationship.webservice.exception.OrderNotFound;
import com.alzohar.relationship.webservice.repositrory.OrderRepository;
@RestController
@RequestMapping("/api")
public class OrderController {
	
	@Autowired
	OrderRepository repo;

	@GetMapping("/order/{id}")
	public Optional<Order> findById(@PathVariable("id") long id) {
		return repo.findById(id);
	}

	@GetMapping("/orders")
	public List<Order> getByName(@RequestParam("name") String name) {
		List<Order> order = repo.findByname(name);
		if (order.isEmpty()) {
			throw new OrderNotFound("Order Not Found with the Given name " + name);
		}
		return order;
	}

	@GetMapping("/ordere")
	public List<Order> getByEmail(@RequestParam("email") String email) {
		return repo.findEmail(email);
	}

//	@GetMapping("/ordet")
//	public List<Order> getByOrderType(@RequestParam("order_Type") String order_Type) {
//		return repo.findByOrderTypes(order_Type);
//	}

	@GetMapping("/order")
	public List<Order> getAll() {
		List<Order> order = repo.findAll();
		if (order.isEmpty()) {
			throw new OrderNotFound("Order Not Found with the Given Information");

		}
		return order;
	}

	@PostMapping("/ordes")
	public Order createOrder( @RequestBody Order order) {
		return repo.save(order);
	}

	@PutMapping("/orders")
	public Order updateOrder(@RequestBody Order order) {
		return repo.save(order);
	}

	@DeleteMapping("/order/{id}")
	public String deleteOrders(@PathVariable("id") long id) {
		repo.deleteById(id);
		return "Order is Delete Successfully";
	}
}
