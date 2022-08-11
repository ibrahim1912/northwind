package com.etiya.northwind.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.northwind.business.abstracts.EmployeeService;
import com.etiya.northwind.business.requests.employees.CreateEmployeeRequest;
import com.etiya.northwind.business.requests.employees.DeleteEmployeeRequest;
import com.etiya.northwind.business.requests.employees.UpdateEmployeeRequest;
import com.etiya.northwind.business.responses.employees.EmployeeGetResponse;
import com.etiya.northwind.business.responses.employees.EmployeeListResponse;
import com.etiya.northwind.core.exceptions.BusinessException;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;
import com.etiya.northwind.core.utilities.results.SuccessDataResult;
import com.etiya.northwind.core.utilities.results.SuccessResult;
import com.etiya.northwind.dataAccess.abstracts.EmployeeRepository;
import com.etiya.northwind.entities.concretes.Employee;
import com.etiya.northwind.entities.concretes.Product;

@Service
public class EmployeeManager implements EmployeeService {

	private EmployeeRepository employeeRepository;
	private ModelMapperService modelMapperService;

	@Autowired
	public EmployeeManager(EmployeeRepository employeeRepository, ModelMapperService modelMapperService) {
		this.employeeRepository = employeeRepository;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public Result add(CreateEmployeeRequest createEmployeeRequest) {
		checkIEmployeeReportLimitExceeds(createEmployeeRequest.getReportsTo());
	
		Employee employee = this.modelMapperService.forRequest().map(createEmployeeRequest, Employee.class);
		this.employeeRepository.save(employee);
		
		return new SuccessResult("EMPLOYEE.ADDED");
	}

	@Override
	public Result delete(DeleteEmployeeRequest deleteEmployeeRequest) {
		this.employeeRepository.deleteById(deleteEmployeeRequest.getEmployeeId());

		return new SuccessResult("EMPLOYEE.DELETED");
	}

	@Override
	public Result update(UpdateEmployeeRequest updateEmployeeRequest) {
		Employee employee = this.modelMapperService.forRequest().map(updateEmployeeRequest, Employee.class);
		this.employeeRepository.save(employee);
		
		return new SuccessResult("EMPLOYEE.UPDATED");
	}

	@Override
	public DataResult<EmployeeGetResponse> getById(int id) {
		Employee employee = this.employeeRepository.findById(id).get();
		EmployeeGetResponse response = this.modelMapperService.forRequest().map(employee, EmployeeGetResponse.class);
		
		return new SuccessDataResult<EmployeeGetResponse>(response);
	}

	@Override
	public DataResult<List<EmployeeListResponse>> getAll() {
		List<Employee> result = this.employeeRepository.findAll();
		List<EmployeeListResponse> response = result.stream()
				.map(employee -> this.modelMapperService.forResponse().map(employee, EmployeeListResponse.class))
				.collect(Collectors.toList());
		
		return new SuccessDataResult<List<EmployeeListResponse>>(response);
	}
	
	private void checkIEmployeeReportLimitExceeds(int reportsTo) {
		List<Employee> result = this.employeeRepository.findByReportsTo(reportsTo);
		if (result.size() >= 10) {
			throw new BusinessException("A manager can only manage up to 10 employees");
		}
	}
	
	
	

	
}
