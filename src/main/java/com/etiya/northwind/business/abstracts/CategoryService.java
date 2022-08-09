package com.etiya.northwind.business.abstracts;

import java.util.List;

import com.etiya.northwind.business.requests.categories.CreateCategoryRequest;
import com.etiya.northwind.business.requests.categories.DeleteCategoryRequest;
import com.etiya.northwind.business.requests.categories.UpdateCategoryRequest;
import com.etiya.northwind.business.responses.categories.CategoryGetResponse;
import com.etiya.northwind.business.responses.categories.CategoryListResponse;

public interface CategoryService {

	void add(CreateCategoryRequest createCategoryRequest);
	void delete(DeleteCategoryRequest deleteCategoryRequest);
	void update(UpdateCategoryRequest updateCategoryRequest);
	
	CategoryGetResponse getById(int id);
	List<CategoryListResponse> getAll();
	
}
