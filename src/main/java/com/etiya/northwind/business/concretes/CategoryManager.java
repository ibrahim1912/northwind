package com.etiya.northwind.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.northwind.business.abstracts.CategoryService;
import com.etiya.northwind.business.responses.categories.CategoryListResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.CategoryRepository;
import com.etiya.northwind.entities.concretes.Category;

@Service
public class CategoryManager implements CategoryService {

	private CategoryRepository categoryResponse;
	private ModelMapperService modelManagerService;

	@Autowired
	public CategoryManager(CategoryRepository categoryResponse, ModelMapperService modelManagerService) {
		this.categoryResponse = categoryResponse;
		this.modelManagerService = modelManagerService;
	}

	@Override
	public List<CategoryListResponse> getAll() {
		List<Category> result = this.categoryResponse.findAll();
		List<CategoryListResponse> response = result.stream()
				.map(category -> this.modelManagerService.forResponse().map(category, CategoryListResponse.class))
				.collect(Collectors.toList());

		return response;
	}

}
