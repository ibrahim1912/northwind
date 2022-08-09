package com.etiya.northwind.business.abstracts;

import java.util.List;

import com.etiya.northwind.business.responses.customers.CustomerListResponse;

public interface CustomerService {

	List<CustomerListResponse> getAll();
}
