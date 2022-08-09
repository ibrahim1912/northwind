package com.etiya.northwind.business.requests.categories;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCategoryRequest {

	private int categoryId;
	private String companyName;
	private String contactName;
	private String contactTitle;
	private String address;
	private String city;
}