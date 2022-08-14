package com.etiya.northwind.business.requests.countries;

import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCountryRequest {
	
	@Size(min=1,max=20)
	private String countryName;
}
