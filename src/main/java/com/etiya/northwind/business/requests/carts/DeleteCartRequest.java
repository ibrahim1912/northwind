package com.etiya.northwind.business.requests.carts;

import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteCartRequest {
	@Positive
	private int cartId;


}
