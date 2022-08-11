package com.etiya.northwind.business.abstracts;

import java.util.List;

import com.etiya.northwind.business.requests.employees.CreateEmployeeRequest;
import com.etiya.northwind.business.requests.employees.DeleteEmployeeRequest;
import com.etiya.northwind.business.requests.employees.UpdateEmployeeRequest;
import com.etiya.northwind.business.responses.employees.EmployeeGetResponse;
import com.etiya.northwind.business.responses.employees.EmployeeListResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;

public interface EmployeeService {

	Result add(CreateEmployeeRequest createEmployeeRequest);
	Result delete(DeleteEmployeeRequest deleteEmployeeRequest);
	Result update(UpdateEmployeeRequest updateEmployeeRequest);
	
	DataResult<EmployeeGetResponse> getById(int id);
	DataResult<List<EmployeeListResponse>> getAll();
}
