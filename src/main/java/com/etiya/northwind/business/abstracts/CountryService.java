package com.etiya.northwind.business.abstracts;

import java.util.List;

import com.etiya.northwind.business.requests.countries.CreateCountryRequest;
import com.etiya.northwind.business.responses.countries.CountryListResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;

public interface CountryService {


	Result add(CreateCountryRequest createCountryRequest);
	DataResult<List<CountryListResponse>> getAll();
}
