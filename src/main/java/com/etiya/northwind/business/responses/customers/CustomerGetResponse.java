package com.etiya.northwind.business.responses.customers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerGetResponse {

	private String customerNumber;
	private String companyName;
	private String contactName;
	private String contactTitle;
	private String address;

	private String cityName;
	private String countryName;
}
