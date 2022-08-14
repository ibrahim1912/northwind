package com.etiya.northwind.business.requests.orderDetails;

import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteOrderDetailRequest {

	@Positive
	private int orderId;
	
	@Positive
	private int productId;
}
