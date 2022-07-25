package com.infosys.dao;

import java.util.List;

import com.infosys.model.Employee;

public interface EmployeeDAO {
	void addEmployee(Employee employee);
    List<Employee> displayAllEmployees();
	List<Employee> displayFilteredOnDesignation(String designation);
	void removeEmployee(int id);
	void updateEmployee(int id, Employee employee);
	Employee searchEmployee(int id);
}
