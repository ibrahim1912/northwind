package com.etiya.northwind.business.abstracts;

import java.util.List;

import com.etiya.northwind.business.requests.employees.CreateEmployeeRequest;
import com.etiya.northwind.business.requests.employees.DeleteEmployeeRequest;
import com.etiya.northwind.business.requests.employees.UpdateEmployeeRequest;
import com.etiya.northwind.business.responses.employees.EmployeeGetResponse;
import com.etiya.northwind.business.responses.employees.EmployeeListResponse;

public interface EmployeeService {

	void add(CreateEmployeeRequest createEmployeeRequest);
	void delete(DeleteEmployeeRequest deleteEmployeeRequest);
	void update(UpdateEmployeeRequest updateEmployeeRequest);
	
	EmployeeGetResponse getById(int id);
	List<EmployeeListResponse> getAll();
}
