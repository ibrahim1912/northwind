package com.etiya.northwind.business.abstracts;

import java.util.List;

import com.etiya.northwind.business.requests.cities.CreateCityRequest;
import com.etiya.northwind.business.responses.cities.CityListResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;

public interface CityService {

	Result add(CreateCityRequest createCityRequest);
	DataResult<List<CityListResponse>> getAll();
	
}
