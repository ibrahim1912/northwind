package com.etiya.northwind.business.abstracts;

import java.util.List;

import com.etiya.northwind.business.requests.customers.CreateCustomerRequest;
import com.etiya.northwind.business.requests.customers.DeleteCustomerRequest;
import com.etiya.northwind.business.requests.customers.UpdateCustomerRequest;
import com.etiya.northwind.business.responses.customers.CustomerGetResponse;
import com.etiya.northwind.business.responses.customers.CustomerListResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;

public interface CustomerService {

	Result add(CreateCustomerRequest createCustomerRequest);
	Result delete(DeleteCustomerRequest deleteCustomerRequest);
	Result update(UpdateCustomerRequest updateCustomerRequest);
	
	DataResult<CustomerGetResponse> getById(String id);
	DataResult<List<CustomerListResponse>> getAll();
}
