package com.etiya.northwind.business.abstracts;

import java.util.List;

import com.etiya.northwind.business.requests.products.CreateProductRequest;
import com.etiya.northwind.business.requests.products.DeleteProductRequest;
import com.etiya.northwind.business.requests.products.UpdateProductRequest;
import com.etiya.northwind.business.responses.products.ProductGetResponse;
import com.etiya.northwind.business.responses.products.ProductListResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;

public interface ProductService {
	
	Result add(CreateProductRequest createProductRequest);
	Result delete(DeleteProductRequest deleteProductRequest);
	Result update(UpdateProductRequest updateProductRequest);
	
	DataResult<ProductGetResponse> getById(int id);
	DataResult<List<ProductListResponse>> getAll();
	
	DataResult<List<ProductListResponse>> getAll(int pageNo,int pageSize);
	DataResult<List<ProductListResponse>> getAllSortedByAsc(String field);
	DataResult<List<ProductListResponse>> getAllSortedByDesc(String field);
	
}
