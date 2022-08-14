package com.etiya.northwind.business.requests.products;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductRequest {
	
	@Positive
	@NotNull
	private int productId;
	
	@NotBlank
	@Size(min=1,max=15)
	private String productName;
	
	
	@Min(1)
	@Max(100)
	private double unitPrice;
	
	@Positive
	private int unitsInStock;
	
	@Positive
	private int categoryId;
	
	@Positive
	private int supplierId;
	
	@PositiveOrZero
	private int discontinued; 
	
	
	
	
}
