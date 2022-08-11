package com.etiya.northwind.business.requests.orders;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderRequest {
	private int orderId;
	
	@FutureOrPresent
	private LocalDate orderDate;
	
	@Future
	private LocalDate requiredDate;
	
	private LocalDate shippedDate;
	private int employeeId;
	private String customerId;
}
