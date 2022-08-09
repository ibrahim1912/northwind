package com.etiya.northwind.business.abstracts;

import java.util.List;

import com.etiya.northwind.business.responses.categories.CategoryListResponse;

public interface CategoryService {

	List<CategoryListResponse> getAll();
	
}
