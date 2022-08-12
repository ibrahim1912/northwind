package com.etiya.northwind.dataAccess.abstracts;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.etiya.northwind.entities.concretes.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

	Cart getByCustomer_CustomerNumber(String customerNumber);
	
	@Transactional
	@Modifying
	@Query("Delete from Cart Where customer_number = :customerNumber")	
	void deleteCartWithCustomerNumber(@Param("customerNumber")String customerNumber);
}
