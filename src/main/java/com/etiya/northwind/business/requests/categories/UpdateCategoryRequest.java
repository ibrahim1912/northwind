package com.etiya.northwind.business.requests.categories;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCategoryRequest {

	@Positive
	private int categoryId;
	
	@Size(min=1,max=15)
	private String categoryName;
	
}
