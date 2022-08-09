package com.etiya.northwind.business.requests.suppliers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateSupplierRequest {

	private int supplierId;
	private String companyName;
	private String contactName;
	private String contactTitle;
	private String address;

}
