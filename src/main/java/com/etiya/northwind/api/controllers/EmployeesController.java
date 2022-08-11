package com.etiya.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.northwind.business.abstracts.EmployeeService;
import com.etiya.northwind.business.requests.employees.CreateEmployeeRequest;
import com.etiya.northwind.business.requests.employees.DeleteEmployeeRequest;
import com.etiya.northwind.business.requests.employees.UpdateEmployeeRequest;
import com.etiya.northwind.business.responses.employees.EmployeeGetResponse;
import com.etiya.northwind.business.responses.employees.EmployeeListResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;

@RestController
@RequestMapping("/api/employees")
public class EmployeesController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeesController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	@PostMapping("/add")
    public Result add(@RequestBody CreateEmployeeRequest createEmployeeRequest) {
		return this.employeeService.add(createEmployeeRequest);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody DeleteEmployeeRequest deleteEmployeeRequest) {
    	return this.employeeService.delete(deleteEmployeeRequest);
    }

    @PostMapping("/update")
    public Result update(@RequestBody UpdateEmployeeRequest updateEmployeeRequest) {
    	return this.employeeService.update(updateEmployeeRequest);
    }

    @GetMapping("/getbyid")
    public DataResult<EmployeeGetResponse> getById(@RequestParam int id) {
        return this.employeeService.getById(id);
    }
    
	@GetMapping("/getall")
	public DataResult<List<EmployeeListResponse>> getAll() {
		return this.employeeService.getAll();
	}

}
