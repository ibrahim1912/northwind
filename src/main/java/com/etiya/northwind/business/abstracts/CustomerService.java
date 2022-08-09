package com.etiya.northwind.business.abstracts;

import java.util.List;

import com.etiya.northwind.business.requests.customers.CreateCustomerRequest;
import com.etiya.northwind.business.requests.customers.DeleteCustomerRequest;
import com.etiya.northwind.business.requests.customers.UpdateCustomerRequest;
import com.etiya.northwind.business.responses.customers.CustomerGetResponse;
import com.etiya.northwind.business.responses.customers.CustomerListResponse;

public interface CustomerService {

	void add(CreateCustomerRequest createCustomerRequest);
	void delete(DeleteCustomerRequest deleteCustomerRequest);
	void update(UpdateCustomerRequest updateCustomerRequest);
	
	CustomerGetResponse getById(String id);
	List<CustomerListResponse> getAll();
}
