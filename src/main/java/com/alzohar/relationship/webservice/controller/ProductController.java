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

import com.alzohar.relationship.webservice.entity.Product;
import com.alzohar.relationship.webservice.exception.ProductNotFound;
import com.alzohar.relationship.webservice.repositrory.ProductRepositroy;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	ProductRepositroy Repo;

	@GetMapping("/product/{id}")
	public Optional<Product> findById(@PathVariable("id") long id) {
		return Repo.findById(id);
	}

	@GetMapping("/products")
	public List<Product> findByName(@RequestParam("name") String name) {
		return Repo.findByname(name);

	}

	@GetMapping("/types")
	public List<Product> productType(@RequestParam("types") String product_Type) {
		return Repo.findByProductTypes(product_Type);

	}

	@GetMapping("/produc")
	public List<Product> getAccount() {
		List<Product> list = Repo.findAll();
		if (list.isEmpty()) {
			throw new ProductNotFound("Account Not Found with the Given Information");

		}
		return list;
	}

	@PostMapping("product")
	public Product createproduct(@RequestBody Product product) {
		return Repo.save(product);
	}

	@PutMapping("/products")
	public Product updateProduct(@RequestBody Product product) {
		return Repo.save(product);
	}

	@DeleteMapping("/product/{id}")
	public String deleteProduct(@PathVariable("id") long id) {
		Repo.deleteById(id);
		return "Product is Delete Successfully";
	}
}
