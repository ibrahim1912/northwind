package com.etiya.northwind.business.requests.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductRequest {

	private int productId;
	private String productName;
	private double unitPrice;
	private int unitsInStock;
	private int categoryId;
	private int supplierId;
}
