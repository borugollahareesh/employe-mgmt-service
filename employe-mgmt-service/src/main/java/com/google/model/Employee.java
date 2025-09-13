package com.google.model;

import java.util.Date;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "employee")
@Data
public class Employee {


	@Id
	@Column(name = "empno")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empno")
	@SequenceGenerator(name="empno", sequenceName = "empno", allocationSize=1)
	private Integer employeeNumber;

	@Column(name = "ename")
	private String employeeName;

	@Column(name = "job")
	private String employeeJob;

	@Column(name = "mgr")
	private Integer employeeMgr;

	@Column(name = "hiredate")
	private Date employeeHireDate;

	@Column(name = "sal")
	private Double employeeSalary;

	@Column(name = "comm")
	private Double employeeCommission;

	@Column(name = "deptno")
	private Integer employeeDeptNum;
}
