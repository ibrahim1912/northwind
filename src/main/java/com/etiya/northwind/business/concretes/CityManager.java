package com.etiya.northwind.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.northwind.business.abstracts.CityService;
import com.etiya.northwind.business.requests.cities.CreateCityRequest;
import com.etiya.northwind.business.responses.cities.CityListResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;
import com.etiya.northwind.core.utilities.results.SuccessDataResult;
import com.etiya.northwind.core.utilities.results.SuccessResult;
import com.etiya.northwind.dataAccess.abstracts.CityRepository;
import com.etiya.northwind.entities.concretes.City;

@Service
public class CityManager implements CityService {

	private CityRepository cityRepository;
	private ModelMapperService modelMapperService;

	@Autowired
	public CityManager(CityRepository cityRepository, ModelMapperService modelMapperService) {
		this.cityRepository = cityRepository;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public Result add(CreateCityRequest createCityRequest) {
		City city = this.modelMapperService.forRequest().map(createCityRequest, City.class);
		this.cityRepository.save(city);
		return new SuccessResult("CITY.ADDED");
	}

	@Override
	public DataResult<List<CityListResponse>> getAll() {
		List<City> result = this.cityRepository.findAll();
		List<CityListResponse> response = result.stream()
				.map(city -> this.modelMapperService.forResponse().map(city, CityListResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<CityListResponse>>(response);
	}

}
