
package com.alzohar.relationship.webservice.repositrory;

import java.util.List;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.alzohar.relationship.webservice.entity.Customer;


@Repository
@EnableJpaRepositories
@EntityScan
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	@Query(value = "select * from relationship_customer s where s.name like %:name%", nativeQuery = true)
	List<Customer> findByname(String name);

	@Query(value = "select * from relationship_customer s where s.email like %:email%", nativeQuery = true)
	List<Customer> findByEmail(String email);

// @Query(value = "select * from eshopee_order s where s.name like %:name%",nativeQuery = true)
// List<Customer> findByname(String name);
// 
}
