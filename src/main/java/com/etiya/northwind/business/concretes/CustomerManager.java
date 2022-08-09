package com.etiya.northwind.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.northwind.business.abstracts.CustomerService;
import com.etiya.northwind.business.requests.customers.CreateCustomerRequest;
import com.etiya.northwind.business.requests.customers.DeleteCustomerRequest;
import com.etiya.northwind.business.requests.customers.UpdateCustomerRequest;
import com.etiya.northwind.business.responses.customers.CustomerGetResponse;
import com.etiya.northwind.business.responses.customers.CustomerListResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.CustomerRepository;
import com.etiya.northwind.entities.concretes.Customer;

@Service
public class CustomerManager implements CustomerService {

	private CustomerRepository customerRepository;
	private ModelMapperService modelMapperService;

	@Autowired
	public CustomerManager(CustomerRepository customerRepository, ModelMapperService modelMapperService) {
		this.customerRepository = customerRepository;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public void add(CreateCustomerRequest createCustomerRequest) {
		Customer customer = this.modelMapperService.forRequest().map(createCustomerRequest, Customer.class);
		this.customerRepository.save(customer);
	}

	@Override
	public void delete(DeleteCustomerRequest deleteCustomerRequest) {
		this.customerRepository.deleteById(deleteCustomerRequest.getCustomerId());
	}

	@Override
	public void update(UpdateCustomerRequest updateCustomerRequest) {
		Customer customer = this.modelMapperService.forRequest().map(updateCustomerRequest, Customer.class);
		this.customerRepository.save(customer);
	}

	@Override
	public CustomerGetResponse getById(String customerId) {
		Customer customer = this.customerRepository.findById(customerId).get();
		CustomerGetResponse response = this.modelMapperService.forRequest().map(customer, CustomerGetResponse.class);
		return response;
	}

	@Override
	public List<CustomerListResponse> getAll() {
		List<Customer> result = this.customerRepository.findAll();
		List<CustomerListResponse> response = result.stream()
				.map(customer -> this.modelMapperService.forResponse().map(customer, CustomerListResponse.class))
				.collect(Collectors.toList());

		return response;
	}

}
