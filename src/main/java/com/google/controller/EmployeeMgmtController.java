package com.google.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.google.model.Employee;
import com.google.service.EmployeeMgmtService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/employee")
public class EmployeeMgmtController {

	private Logger logger = LoggerFactory.getLogger(EmployeeMgmtController.class);
	@Autowired
	private EmployeeMgmtService employeeMgmtService;
	
	@GetMapping("/all")
	public List<Employee> getAllEmployeeDetails(){

		logger.info("getAllEmployeeDetails - started");
		 List<Employee> empList = employeeMgmtService.getAllEmployeeDetails();
		logger.info("getAllEmployeeDetails - end");
		return empList;
	}

	@GetMapping("/{employeeId}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("employeeId") Integer empId)
	{
		logger.info("getEmployeeById - started");
		return ResponseEntity.ok(employeeMgmtService.getEmployeeById(empId));
	}

	@PostMapping("/create")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee)
	{
		return new ResponseEntity<>(employeeMgmtService.createEmployee(employee), HttpStatus.CREATED);
	}

	@PutMapping("/update/{empId}")
	public ResponseEntity<Employee> createEmployee(@PathVariable("empId") Integer employeeId, @RequestBody Employee updateEmployee)
	{
		return ResponseEntity.ok(employeeMgmtService.updateEmployee(employeeId, updateEmployee));
	}

	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("empId") Integer employeeId)
	{
		employeeMgmtService.deleteEmployee(employeeId);
		return ResponseEntity.ok("Employee record is deleted successfully for the ID :: " +employeeId);
	}

	@GetMapping("/requestParam")
	public ResponseEntity<Employee> getEmployeeByIdUsingRequestParam(@RequestParam (name="empNo") Integer empNo)
	{
		logger.info("getEmployeeById using RequestParam - started");
		return ResponseEntity.ok(employeeMgmtService.getEmployeeById(empNo));
	}

}
