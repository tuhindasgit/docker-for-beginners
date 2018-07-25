package com.cloud.banking.system.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloud.banking.system.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

	/**
	 * Query for finding customer by id
	 * @param id
	 * @return
	 */
	Optional<Customer> findByCustomerId(Integer id);
}
