package com.etiya.northwind.business.abstracts;

import java.util.List;

import com.etiya.northwind.business.responses.employees.EmployeeListResponse;

public interface EmployeeService {

	List<EmployeeListResponse> getAll();
}
