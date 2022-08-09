package com.etiya.northwind.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.northwind.business.abstracts.CustomerService;
import com.etiya.northwind.business.responses.customers.CustomerListResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.CustomerRepository;
import com.etiya.northwind.entities.concretes.Customer;

@Service
public class CustomerManager implements CustomerService {

	private CustomerRepository customerRepository;
	private ModelMapperService modelManagerService;

	@Autowired
	public CustomerManager(CustomerRepository customerRepository, ModelMapperService modelManagerService) {
		this.customerRepository = customerRepository;
		this.modelManagerService = modelManagerService;
	}

	@Override
	public List<CustomerListResponse> getAll() {
		List<Customer> result = this.customerRepository.findAll();
		List<CustomerListResponse> response = result.stream()
				.map(customer -> this.modelManagerService.forResponse().map(customer, CustomerListResponse.class))
				.collect(Collectors.toList());

		return response;
	}

}
