package com.etiya.northwind.business.responses.suppliers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplierGetResponse {

	private int supplierId;
	private String companyName;
	private String contactName;
	private String contactTitle;
	private String address;
	
	private String cityName;
	private String countryName;
}
