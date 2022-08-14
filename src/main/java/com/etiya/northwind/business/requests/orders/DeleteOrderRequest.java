package com.etiya.northwind.business.requests.orders;

import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteOrderRequest {
	
	@Positive
	private int orderId;
}
