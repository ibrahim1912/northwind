package com.etiya.northwind.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.northwind.business.abstracts.CategoryService;
import com.etiya.northwind.business.requests.categories.CreateCategoryRequest;
import com.etiya.northwind.business.requests.categories.DeleteCategoryRequest;
import com.etiya.northwind.business.requests.categories.UpdateCategoryRequest;
import com.etiya.northwind.business.responses.categories.CategoryGetResponse;
import com.etiya.northwind.business.responses.categories.CategoryListResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.CategoryRepository;
import com.etiya.northwind.entities.concretes.Category;

@Service
public class CategoryManager implements CategoryService {

	private CategoryRepository categoryResponse;
	private ModelMapperService modelMapperService;

	@Autowired
	public CategoryManager(CategoryRepository categoryResponse, ModelMapperService modelMapperService) {
		this.categoryResponse = categoryResponse;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public void add(CreateCategoryRequest createCategoryRequest) {
		Category category = this.modelMapperService.forRequest().map(createCategoryRequest, Category.class);
		this.categoryResponse.save(category);
		
	}

	@Override
	public void delete(DeleteCategoryRequest deleteCategoryRequest) {
		this.categoryResponse.deleteById(deleteCategoryRequest.getCategoryId());
		
	}

	@Override
	public void update(UpdateCategoryRequest updateCategoryRequest) {
		Category category = this.modelMapperService.forRequest().map(updateCategoryRequest, Category.class);
		this.categoryResponse.save(category);
	}

	@Override
	public CategoryGetResponse getById(int id) {
		Category category = this.categoryResponse.findById(id);
		CategoryGetResponse response = this.modelMapperService.forResponse().map(category, CategoryGetResponse.class);
		return response;
	}
	
	@Override
	public List<CategoryListResponse> getAll() {
		List<Category> result = this.categoryResponse.findAll();
		List<CategoryListResponse> response = result.stream()
				.map(category -> this.modelMapperService.forResponse().map(category, CategoryListResponse.class))
				.collect(Collectors.toList());

		return response;
	}

	
}
