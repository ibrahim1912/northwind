package com.etiya.northwind.dataAccess.abstracts;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.etiya.northwind.entities.concretes.CartProduct;

public interface CartProductRepository extends JpaRepository<CartProduct, Integer>{


	@Transactional
	@Modifying
	@Query("Delete from CartProduct Where cartId = :cartId")	
	void deleteCartWithCartId(@Param("cartId")int cartId);
}
