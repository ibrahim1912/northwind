package com.etiya.northwind.business.requests.cartproducts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCartProductRequest {

    private int cartProductId;
	private int cartId;
	private int productId;
	private int quantity;
}
