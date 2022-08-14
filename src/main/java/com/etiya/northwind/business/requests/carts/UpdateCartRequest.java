package com.etiya.northwind.business.requests.carts;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCartRequest {

	@Positive
	private int cartId;
	
	@Size(min=1,max=5)
    private String customerNumber;
}
