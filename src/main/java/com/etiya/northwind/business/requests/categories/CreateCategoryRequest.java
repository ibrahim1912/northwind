package com.etiya.northwind.business.requests.categories;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCategoryRequest {

	
	private int categoryId;
	
	@NotBlank
	@Size(min=1,max=15)
	private String categoryName;
	
}
