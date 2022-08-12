package com.etiya.northwind.business.requests.customers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCustomerRequest {

	private String customerNumber;
	private String companyName;
	private String contactName;
	private String contactTitle;
	private String address;
	
	private int cityId;
	private int countryId;
}
