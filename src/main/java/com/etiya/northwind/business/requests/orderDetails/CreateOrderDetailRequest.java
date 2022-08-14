package com.etiya.northwind.business.requests.orderDetails;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderDetailRequest {

	@Positive
	private int orderId;
	
	@Positive
	private int  productId;
	
	@Positive
	private double unitPrice;
	
	@Positive
	private int quantity;
	
	@PositiveOrZero
	private double discount;
}
