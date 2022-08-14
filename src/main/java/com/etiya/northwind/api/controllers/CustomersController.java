package com.etiya.northwind.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.northwind.business.abstracts.CustomerService;
import com.etiya.northwind.business.requests.customers.CreateCustomerRequest;
import com.etiya.northwind.business.requests.customers.DeleteCustomerRequest;
import com.etiya.northwind.business.requests.customers.UpdateCustomerRequest;
import com.etiya.northwind.business.responses.customers.CustomerGetResponse;
import com.etiya.northwind.business.responses.customers.CustomerListResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;

@RestController
@RequestMapping("/api/customers")
public class CustomersController {

	private CustomerService customerService;

	@Autowired
	public CustomersController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@PostMapping("/add")
    public Result add(@Valid @RequestBody CreateCustomerRequest createCustomerRequest) {
		return this.customerService.add(createCustomerRequest);
    }

    @PostMapping("/delete")
    public Result delete(@Valid @RequestBody DeleteCustomerRequest deleteCustomerRequest) {
    	return this.customerService.delete(deleteCustomerRequest);
    }

    @PostMapping("/update")
    public Result update(@Valid @RequestBody UpdateCustomerRequest updateCustomerRequest) {
    	return this.customerService.update(updateCustomerRequest);
    }

    @GetMapping("/getbyid")
    public DataResult<CustomerGetResponse> getById(@RequestParam String customerNumber) {
        return this.customerService.getById(customerNumber);
    }
	
	@GetMapping("/getall")
	public DataResult<List<CustomerListResponse>> getAll(){
		return this.customerService.getAll();
	}
}
