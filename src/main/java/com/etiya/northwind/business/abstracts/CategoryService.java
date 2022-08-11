package com.etiya.northwind.business.abstracts;

import java.util.List;

import com.etiya.northwind.business.requests.categories.CreateCategoryRequest;
import com.etiya.northwind.business.requests.categories.DeleteCategoryRequest;
import com.etiya.northwind.business.requests.categories.UpdateCategoryRequest;
import com.etiya.northwind.business.responses.categories.CategoryGetResponse;
import com.etiya.northwind.business.responses.categories.CategoryListResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;

public interface CategoryService {

	Result add(CreateCategoryRequest createCategoryRequest);
	Result delete(DeleteCategoryRequest deleteCategoryRequest);
	Result update(UpdateCategoryRequest updateCategoryRequest);
	
	DataResult<CategoryGetResponse> getById(int id);
	DataResult<List<CategoryListResponse>> getAll();
	 
}
