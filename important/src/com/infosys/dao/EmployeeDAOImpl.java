package com.infosys.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import com.infosys.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	private List<Employee> employeeList=null;

	public EmployeeDAOImpl() {
		employeeList = new ArrayList<>();
		employeeList.add(new Employee(1, "Ram", "Manager", "Sales", 23000));
		employeeList.add(new Employee(2, "Suresh", "Analyst", "Development", 20000));
	}

	@Override
	public void addEmployee(Employee employee) {
		employeeList.add(employee);

	}

	@Override
	public List<Employee> displayAllEmployees() {
		// TODO Auto-generated method stub
		return employeeList;
	}

	@Override
	public List<Employee> displayFilteredOnDesignation(String designation) {
		List<Employee> filteredList = new ArrayList<>();
		for (Employee employee : employeeList) {
			if (employee.getDesignation().equalsIgnoreCase(designation)) {
				filteredList.add(employee);
			}
		}

		// List<Employee> filteredList=
		// employeeList.stream().filter(employee->employee.getDesignation().equals(designation)).collect(Collectors.toList());
		return filteredList;
	}

	@Override
	public void removeEmployee(int id) {

		Iterator<Employee> iterator = employeeList.iterator();
		while (iterator.hasNext()) {
			Employee found = iterator.next();
			if (found.getId() == id) {

				iterator.remove();
				break;
			}

		}

		// employeeList.removeIf(employee->employee.getId()==id);
	}

	@Override
	public void updateEmployee(int id, Employee employee) {
		Iterator<Employee> iterator = employeeList.iterator();
		while (iterator.hasNext()) {
			Employee found = iterator.next();
			if (found.getId() == id) {

				found.setName(employee.getName());
				found.setBasic(employee.getBasic());
				break;
			}

		}

		/* @Override
		public void updateEmployee(int id, String changedEmployeeName) {
			Iterator<Employee> iterator = employeeList.iterator();
			while (iterator.hasNext()) {
				Employee found = iterator.next();
				if (found.getId() == id) {

					found.setName(changedEmployeeName);
					
					break;
				}

			}	*/
		
		
		// Employee
		// tobeUpdated=employeeList.stream().filter(employee1->employee1.getId()==id).findFirst().get();
		// tobeUpdated.setBasic(0);
	}

	@Override
	public Employee searchEmployee(int id) {

		Employee employeeFound = null;
		Iterator<Employee> iterator = employeeList.iterator();
		while (iterator.hasNext()) {
			Employee employee = iterator.next();
			if (employee.getId() == id) {
				employeeFound = employee;
				break;
			}

		}
		
		
	/*	@Override
		public Employee searchEmployee(String desig) {
            List<Employee>  designationwise=new ArrayList<>();
			
			Iterator<Employee> iterator = employeeList.iterator();
			while (iterator.hasNext()) {
				Employee employee = iterator.next();
				if (employee.getDesig().equals(desig)) {
					designationwise.add(employee);
					
				}

			} */

		/*
		 * Optional<Employee>
		 * optionalEmployee=employeeList.stream().filter(employee1->employee1.getId()==1
		 * ).findFirst(); if(optionalEmployee.isPresent()) {
		 * employee=optionalEmployee.get(); }
		 */
		return employeeFound;
	}

}
