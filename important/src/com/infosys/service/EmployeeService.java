package com.infosys.service;

import java.util.List;

import com.infosys.exception.InvalidEmployeeException;
import com.infosys.model.Employee;
import com.infosys.model.EmployeeReport;

public interface EmployeeService {
	void addEmployee(Employee employee) throws InvalidEmployeeException;
	List<Employee> displayAllEmployees() throws InvalidEmployeeException;
	List<Employee> displayFilteredOnDesignation(String designation) throws InvalidEmployeeException;
	void removeEmployee(int id) throws InvalidEmployeeException;
	void updateEmployee(int id, Employee employee) throws InvalidEmployeeException;
	Employee searchEmployee(int id) throws InvalidEmployeeException;
	List<EmployeeReport> generateReport(long basic) throws InvalidEmployeeException;
}
