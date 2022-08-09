package com.etiya.northwind.business.abstracts;

import java.util.List;

import com.etiya.northwind.business.responses.products.ProductListResponse;

public interface ProductService {

	List<ProductListResponse> getAll();
}
