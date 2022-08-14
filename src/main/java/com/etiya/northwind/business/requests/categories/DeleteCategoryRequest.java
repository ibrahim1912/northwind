package com.etiya.northwind.business.requests.categories;

import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteCategoryRequest {

	@Positive
	private int categoryId;
}
