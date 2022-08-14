package com.etiya.northwind.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.northwind.business.abstracts.CountryService;
import com.etiya.northwind.business.requests.countries.CreateCountryRequest;
import com.etiya.northwind.business.responses.countries.CountryListResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;
import com.etiya.northwind.core.utilities.results.SuccessDataResult;
import com.etiya.northwind.core.utilities.results.SuccessResult;
import com.etiya.northwind.dataAccess.abstracts.CountryRepository;
import com.etiya.northwind.entities.concretes.Country;

@Service
public class CountryManager implements CountryService {

	private CountryRepository countryRepository;
	private ModelMapperService modelMapperService;

	@Autowired
	public CountryManager(CountryRepository countryRepository, ModelMapperService modelMapperService) {
		this.countryRepository = countryRepository;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public Result add(CreateCountryRequest createCountryRequest) {
		Country country = this.modelMapperService.forRequest().map(createCountryRequest, Country.class);
		this.countryRepository.save(country);
		return new SuccessResult("COUNTRY.ADDED");
	}

	@Override
	public DataResult<List<CountryListResponse>> getAll() {
		List<Country> result = this.countryRepository.findAll();
		List<CountryListResponse> response = result.stream()
				.map(country -> this.modelMapperService.forResponse().map(country, CountryListResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<CountryListResponse>>(response);
	}

}
