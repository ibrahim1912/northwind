package com.etiya.northwind.business.responses.orders;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderListResponse {
	
	private int orderId;
	private LocalDate orderDate;
	private LocalDate requiredDate;
	private LocalDate shippedDate;
	private String customerId;
	private String customerCompanyName;
	private int employeeId;
//	private String employeeFirstName;
//	private String employeeLastName;
	private String employeeFullName;
}
