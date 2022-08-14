package com.etiya.northwind.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.northwind.business.abstracts.CountryService;
import com.etiya.northwind.business.requests.countries.CreateCountryRequest;
import com.etiya.northwind.business.responses.countries.CountryListResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("api/countries")
public class CountriesController {
	
	private CountryService countryService;

	@Autowired
	public CountriesController(CountryService countryService) {
		this.countryService = countryService;
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody CreateCountryRequest createCountryRequest) {
		return this.countryService.add(createCountryRequest);
	}
	
	@GetMapping("/getall")
	public DataResult<List<CountryListResponse>>getAll(){
		return this.countryService.getAll();
	}

}
