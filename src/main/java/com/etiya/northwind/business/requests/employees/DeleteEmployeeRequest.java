package com.etiya.northwind.business.requests.employees;

import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteEmployeeRequest {
	
	@Positive
	private int employeeId;
	
}
