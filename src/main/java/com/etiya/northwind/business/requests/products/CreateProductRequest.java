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
	
	
	private int productId;
	
	@NotBlank
	@Size(min=1,max=10,message="Ürün ismi en az 1 ve en fazla 10 karakterli olabilir")
	private String productName;
	
	
	@Min(1)
	@Max(100)
	private double unitPrice;
	
	@Positive
	private int unitsInStock;
	
	@PositiveOrZero
	private int categoryId;
	
	@Positive
	private int supplierId;
	
	@Positive
	private int discontinued; 
	
	
	
	
}
