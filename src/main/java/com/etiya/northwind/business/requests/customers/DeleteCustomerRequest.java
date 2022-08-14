package com.etiya.northwind.business.requests.customers;

import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteCustomerRequest {

	@Size(min=1,max=5)
	private String customerNumber;
}
