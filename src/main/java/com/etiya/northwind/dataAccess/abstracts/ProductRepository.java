package com.etiya.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etiya.northwind.entities.concretes.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>{

	Product findById(int id);
	Product findByProductName(String name);
	List<Product> findByCategory_CategoryId(int categoryId);
}
