package com.etiya.northwind.business.responses.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductListResponse {

	private int productId;

	private String productName;

	private double unitPrice;

	private int unitsInStock;

	private int categoryId;

	private String categoryName;
	
	private int supplierId;
	
	private String supplierCompanyName;
}
