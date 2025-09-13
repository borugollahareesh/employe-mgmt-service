package com.google.service;

import java.util.List;

import com.google.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.google.dao.EmployeeMgmtDao;
import com.google.model.Employee;

@Service
public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {
	
	@Autowired
	private EmployeeMgmtDao employeeMgmtDao;
	

	@Override
	public List<Employee> getAllEmployeeDetails() {
		return employeeMgmtDao.findAll(Sort.by(Sort.Direction.ASC, "employeeNumber"));
	}

	@Override
	public Employee getEmployeeById(Integer empId) {
		return employeeMgmtDao.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee is not found with the given employee-ID :: "+empId));
	}

	@Override
	public Employee createEmployee(Employee employee) {
		return employeeMgmtDao.save(employee);
	}

	@Override
	public Employee updateEmployee(Integer empId, Employee updatedEmployee) {
		Employee emp = employeeMgmtDao.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee is not found with the given employee-ID :: "+empId));

		emp.setEmployeeName(updatedEmployee.getEmployeeName());
		emp.setEmployeeJob(updatedEmployee.getEmployeeJob());
		emp.setEmployeeMgr(updatedEmployee.getEmployeeMgr());
		emp.setEmployeeHireDate(updatedEmployee.getEmployeeHireDate());
		emp.setEmployeeSalary(updatedEmployee.getEmployeeSalary());
		emp.setEmployeeCommission(updatedEmployee.getEmployeeCommission());
		emp.setEmployeeDeptNum(updatedEmployee.getEmployeeDeptNum());

		return employeeMgmtDao.save(emp);
	}

	@Override
	public void deleteEmployee(Integer empNumber) {
		Employee employee = employeeMgmtDao.findById(empNumber)
				.orElseThrow(() -> new ResourceNotFoundException("Employee is not found with the given employee-ID :: "+empNumber));
		employeeMgmtDao.deleteById(empNumber);
	}

	// prime number logic


}
