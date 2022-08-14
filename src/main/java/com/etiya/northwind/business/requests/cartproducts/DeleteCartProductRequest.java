package com.etiya.northwind.business.requests.cartproducts;

import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteCartProductRequest {

	@Positive
	private int cartProductId;
}
