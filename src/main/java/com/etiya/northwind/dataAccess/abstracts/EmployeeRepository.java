package com.etiya.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.etiya.northwind.entities.concretes.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	List<Employee> findByReportsTo(Integer reportsTo);
	
	
	@Query("select e from Employee e where e.reportsTo.employeeId = :reportsTo")
    List<Employee> reportingEmployees(@Param("reportsTo") int reportsTo);
}
