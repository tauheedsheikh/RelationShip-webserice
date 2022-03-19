package com.alzohar.relationship.webservice.repositrory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.alzohar.relationship.webservice.entity.Product;
@Repository
public interface ProductRepositroy extends  JpaRepository<Product, Long> {
	@Query(value = "select * from relationship_product s where s.name like %:name%", nativeQuery = true)
	List<Product> findByname(String name);

	@Query(value = "select * from relationship_product s where s.email like %:email%", nativeQuery = true)
	List<Product> findEmail(String email);

	@Query(value = "select * from relationship_product s where s.product_Type like %:product_Type%", nativeQuery = true)
	List<Product> findByProductTypes(String product_Type);

}
