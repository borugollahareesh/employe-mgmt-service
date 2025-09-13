package com.google.service;

import java.util.List;

import com.google.model.Employee;
import org.springframework.http.ResponseEntity;

public interface EmployeeMgmtService {
	
	List<Employee> getAllEmployeeDetails();

	Employee getEmployeeById(Integer empId);

	Employee createEmployee(Employee employee);

	Employee updateEmployee(Integer empId, Employee updatedEmployee);

	void deleteEmployee(Integer empNumber);
}
