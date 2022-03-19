package com.alzohar.relationship.webservice.repositrory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.alzohar.relationship.webservice.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	
	@Query(value = "select * from relationship_order s where s.name like %:name%", nativeQuery = true)
	List<Order> findByname(String name);

	@Query(value = "select * from relationship_order s where s.email like %:email%", nativeQuery = true)
	List<Order> findEmail(String email);

	@Query(value = "select * from relationship_order s where s.product_Type like %:product_Type%", nativeQuery = true)
	List<Order> findByProductTypes(String product_Type);

}
