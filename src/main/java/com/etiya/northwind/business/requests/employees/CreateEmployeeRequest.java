package com.etiya.northwind.business.requests.employees;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateEmployeeRequest {
	private int employeeId;
	private String firstName;
	private String lastName;
	private String title;
	private LocalDate birthDate;
	private String address;
}
