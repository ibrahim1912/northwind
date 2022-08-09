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
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.EmployeeRepository;
import com.etiya.northwind.entities.concretes.Employee;

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
	public void add(CreateEmployeeRequest createEmployeeRequest) {
		Employee employee = this.modelMapperService.forRequest().map(createEmployeeRequest, Employee.class);
		this.employeeRepository.save(employee);
	}

	@Override
	public void delete(DeleteEmployeeRequest deleteEmployeeRequest) {
		this.employeeRepository.deleteById(deleteEmployeeRequest.getEmployeeId());

	}

	@Override
	public void update(UpdateEmployeeRequest updateEmployeeRequest) {
		Employee employee = this.modelMapperService.forRequest().map(updateEmployeeRequest, Employee.class);
		this.employeeRepository.save(employee);
	}

	@Override
	public EmployeeGetResponse getById(int id) {
		Employee employee = this.employeeRepository.findById(id).get();
		EmployeeGetResponse response = this.modelMapperService.forRequest().map(employee, EmployeeGetResponse.class);
		return response;
	}

	@Override
	public List<EmployeeListResponse> getAll() {
		List<Employee> result = this.employeeRepository.findAll();
		List<EmployeeListResponse> response = result.stream()
				.map(employee -> this.modelMapperService.forResponse().map(employee, EmployeeListResponse.class))
				.collect(Collectors.toList());

		return response;
	}
}
