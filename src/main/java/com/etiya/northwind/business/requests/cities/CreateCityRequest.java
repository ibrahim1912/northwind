package com.etiya.northwind.business.requests.cities;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCityRequest {

	@Size(min=1,max=20)
	private String cityName;
	
	@Positive
	private int countryId;
	
}
