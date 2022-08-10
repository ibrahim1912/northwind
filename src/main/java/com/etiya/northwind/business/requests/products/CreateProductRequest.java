package com.etiya.northwind.business.requests.products;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductRequest {
	
	private int productId;
	
	@NotBlank
	@NotBlank
	@Size(min=1,max=10)
	private String productName;
	
	@Positive
	private double unitPrice;
	
	@Positive
	private int unitsInStock;
	
	@Positive
	private int categoryId;
	
	@Positive
	private int supplierId;
	
	@Positive
	private int discontinued; 
}
