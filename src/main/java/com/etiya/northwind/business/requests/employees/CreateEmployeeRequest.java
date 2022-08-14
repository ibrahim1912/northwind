package com.etiya.northwind.business.requests.employees;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateEmployeeRequest {
	
	@Positive
	private int employeeId;
	
	@Size(min=1,max=15)
	private String firstName;
	
	@Size(min=1,max=15)
	private String lastName;
	
	@Size(min=1,max=15)
	private String title;
	
	@DateTimeFormat
	private LocalDate birthDate;
	
	@NotNull
	private String address;
	
	@Positive
	private Integer reportsTo;
	
	@Positive
	private int cityId;
	
	@Positive
	private int countryId;
	
	

}
