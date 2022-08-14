package com.etiya.northwind.business.requests.orders;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderRequest {
	
	@NotEmpty
	@Positive
	private int orderId;
	
	@FutureOrPresent
	private LocalDate orderDate;
	
	@Future
	private LocalDate requiredDate;
	
	@Future
	private LocalDate shippedDate;
	
	@NotEmpty
	@Positive
	private int employeeId;
	
	@NotEmpty
	@Positive
	private String customerNumber;
}
