package com.etiya.northwind.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	@Id
	@Column(name="employee_id")
	private int employeeId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="title")
	private String title;
	
	@Column(name="birth_date")
	private LocalDate birthDate;
	
	@Column(name="address")
	private String address;
	
	@OneToMany(mappedBy="employee")
	private List<Order> orders;
	
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;
	
	@ManyToOne
	@JoinColumn(name = "country_id")
	private Country country;
	
	
	@Column(name = "reports_to")
	private Integer reportsTo;
	
	
	
	/////////////////////////////////////
	
//	 @ManyToOne
//	 @JoinColumn(name = "reports_to")
//	 private Employee reportsTo;
//
//	 @OneToMany(mappedBy = "reportsTo")
//	 private List<Employee> reportingEmployees;
	
	
}
