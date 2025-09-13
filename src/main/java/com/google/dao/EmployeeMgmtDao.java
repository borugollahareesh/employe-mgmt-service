package com.google.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.google.model.Employee;

@Repository
public interface EmployeeMgmtDao extends JpaRepository<Employee, Serializable> {

}
