package com.etiya.northwind.business.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

import com.etiya.northwind.business.requests.products.CreateProductRequest;
import com.etiya.northwind.business.requests.products.DeleteProductRequest;
import com.etiya.northwind.business.requests.products.UpdateProductRequest;
import com.etiya.northwind.business.responses.products.ProductGetResponse;
import com.etiya.northwind.business.responses.products.ProductListResponse;
import com.etiya.northwind.entities.concretes.Product;

public interface ProductService {
	
	void add(CreateProductRequest createProductRequest);
	void delete(DeleteProductRequest deleteProductRequest);
	void update(UpdateProductRequest updateProductRequest);
	
	ProductGetResponse getById(int id);
	List<ProductListResponse> getAll();
	
	List<ProductListResponse> getAll(int pageNo,int pageSize);
	List<ProductListResponse> getAllSortedByAsc(String field);
	List<ProductListResponse> getAllSortedByDesc(String field);
	
}
