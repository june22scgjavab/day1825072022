package com.infosys.service;

import java.util.ArrayList;
import java.util.List;

import com.infosys.dao.EmployeeDAO;
import com.infosys.dao.EmployeeDAOImpl;
import com.infosys.exception.InvalidEmployeeException;
import com.infosys.model.Employee;
import com.infosys.model.EmployeeReport;
import com.infosys.validator.Validator;

public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDAO employeeDAO = new EmployeeDAOImpl();
	Validator validator = new Validator();

	@Override
	public void addEmployee(Employee employee) throws InvalidEmployeeException {

		validator.validate(employee);
		employeeDAO.addEmployee(employee);
	}

	
	@Override
	public List<Employee> displayAllEmployees() throws InvalidEmployeeException {
		List<Employee> employeeList = employeeDAO.displayAllEmployees();
		if (employeeList == null || employeeList.isEmpty()) {
			throw new InvalidEmployeeException("Service.LIST_IS_NULL_OR_EMPTY");
		}
		return employeeList;
	}

	@Override
	public List<Employee> displayFilteredOnDesignation(String designation) throws InvalidEmployeeException {
		List<Employee> employeeList = employeeDAO.displayFilteredOnDesignation(designation);
		if (employeeList == null || employeeList.isEmpty()) {
			throw new InvalidEmployeeException("Service.LIST_IS_NULL_OR_EMPTY");
		}
		return employeeList;
	}

	@Override
	public void removeEmployee(int id) throws InvalidEmployeeException {
		Employee searched = employeeDAO.searchEmployee(id);
		if (searched == null) {
			throw new InvalidEmployeeException("Service.ID_NOT_FOUND");
		}
		employeeDAO.removeEmployee(searched.getId());
	}

	@Override
	public void updateEmployee(int id, Employee employee) throws InvalidEmployeeException {
		Employee searched = employeeDAO.searchEmployee(id);
		if (searched == null) {
			throw new InvalidEmployeeException("Service.ID_NOT_FOUND");
		}
		employeeDAO.updateEmployee(searched.getId(), employee);

	}

	@Override
	public Employee searchEmployee(int id) throws InvalidEmployeeException {
		Employee searched = employeeDAO.searchEmployee(id);
		if (searched == null) {
			throw new InvalidEmployeeException("Service.ID_NOT_FOUND");
		}
		return searched;
	}

	@Override
	public List<EmployeeReport> generateReport(long basic) throws InvalidEmployeeException {
		List<Employee> employeeList = employeeDAO.displayAllEmployees();
		List<EmployeeReport> employeeReports = new ArrayList<>();
		for (Employee employee : employeeList) {
			if (employee.getBasic() < basic) {
				EmployeeReport er = new EmployeeReport();
				er.setId(employee.getId());
				er.setName(employee.getName());
				er.setBasic(employee.getBasic());
				employeeReports.add(er);
			}
		}

		if (employeeReports == null || employeeReports.isEmpty()) {
			throw new InvalidEmployeeException("Service.LIST_IS_NULL_OR_EMPTY");
		}
		/*
		 * List<EmployeeReport> employeeReports =
		 * employeeList.stream().filter(emp->emp.getBasic()<basic).map(s -> {
		 * EmployeeReport employeeReport = new EmployeeReport();
		 * employeeReport.setId(s.getId()); employeeReport.setName(s.getName());
		 * employeeReport.setBasic(s.getBasic()); return employeeReport;
		 * }).collect(Collectors.toList());
		 */
		return employeeReports;
	}

}
