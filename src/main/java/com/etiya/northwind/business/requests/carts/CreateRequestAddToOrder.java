package com.etiya.northwind.business.requests.carts;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRequestAddToOrder {

	private int orderId;
	private String customerNumber;;
	private int productId;
	private int quantity;
	private double unitPrice;
	private LocalDate orderDate;
	private LocalDate requiredDate;
	private LocalDate shippedDate;
	private int employeeId;
}
