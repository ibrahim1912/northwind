package com.etiya.northwind.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.northwind.business.abstracts.CityService;
import com.etiya.northwind.business.requests.cities.CreateCityRequest;
import com.etiya.northwind.business.responses.cities.CityListResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;

import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
@RequestMapping("api/cities")
public class CitiesController {
	
	private CityService cityService;

	@Autowired
	public CitiesController(CityService cityService) {
		this.cityService = cityService;
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody CreateCityRequest createCityRequest) {
		return this.cityService.add(createCityRequest);
	}
	
	@GetMapping("/getall")
	public DataResult<List<CityListResponse>> getAll(){
		return this.cityService.getAll();
	}

}
