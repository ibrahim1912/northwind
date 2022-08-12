package com.etiya.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etiya.northwind.entities.concretes.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {

	Customer findByCustomerNumber(String id);
}
