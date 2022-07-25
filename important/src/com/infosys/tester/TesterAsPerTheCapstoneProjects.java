package com.infosys.tester;

import java.util.List;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.infosys.exception.InvalidEmployeeException;
import com.infosys.model.Employee;
import com.infosys.service.EmployeeService;
import com.infosys.service.EmployeeServiceImpl;

public class TesterAsPerTheCapstoneProjects {
	static PropertiesConfiguration property = null;
	private static final Log logger = LogFactory.getLog(TesterAsPerTheCapstoneProjects.class);
	static EmployeeService employeeService = new EmployeeServiceImpl();

	public static void main(String[] args) throws ConfigurationException {

		Configurations configuration = new Configurations();
		property = configuration.properties("configuration.properties");

		System.out.println("Adding Employee");
		addEmployee();
		System.out.println("Display All Employees");
		displayAllEmployees();
		System.out.println("Display Managers");
		displayEmployeesFilter("Manager");
		System.out.println("Searched Employee");
		searchEmployee();
		System.out.println("Updated Employee");
		updateEmployee();
		System.out.println("Display all Employees after update");
		displayAllEmployees();
		System.out.println("Display All Employees where basic less than 23000");
		displayAllEmployeesBasicLessThan23000();

	}

	private static void displayAllEmployeesBasicLessThan23000() {
		try {
			logger.info(employeeService.generateReport(23000));
		} catch (InvalidEmployeeException e) {
			logger.error(property.getProperty(e.getMessage()));
		}
	}

	private static void updateEmployee() {
		int id = 1;
		Employee employee = new Employee();
		try {
			employeeService.updateEmployee(id, employee);
		} catch (InvalidEmployeeException e) {
			logger.error(property.getProperty(e.getMessage()));
		}

	}

	private static void searchEmployee() {
		try {
			int id = 1;
			logger.info(employeeService.searchEmployee(id));
		} catch (InvalidEmployeeException e) {
			logger.error(property.getProperty(e.getMessage()));
		}

	}

	private static void displayEmployeesFilter(String string) {
		List<Employee> employeeList = null;
		try {
			employeeList = employeeService.displayFilteredOnDesignation(string);

			logger.info(employeeList);

		} catch (InvalidEmployeeException e) {
			logger.error(property.getProperty(e.getMessage()));
		}

	}

	private static void displayAllEmployees() {
		List<Employee> employeeList = null;
		try {
			employeeList = employeeService.displayAllEmployees();

			logger.info(employeeList);

		} catch (InvalidEmployeeException e) {
			logger.error(property.getProperty(e.getMessage()));
		}

	}

	private static void addEmployee() {
		try {
			employeeService.addEmployee(new Employee(3, "Ahmed", "Analyst", "Development", 20000));
			logger.info("SUCCESS");
		} catch (InvalidEmployeeException e) {

			logger.error(property.getProperty(e.getMessage()));
		}

	}

}
