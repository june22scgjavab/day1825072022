package com.infosys.tester;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.infosys.model.Employee;

public class TesterSimple {

	public static void main(String[] args) {
		
		Employee employees[]= {new Employee(1,"Ram","Manager","Sales",23000),new Employee(2,"Suresh","Analyst","Development",20000)};
		List<Employee> employeeList=Arrays.asList(employees);
        System.out.println(employeeList); //Exception in thread "main" java.lang.UnsupportedOperationException
        employeeList.add(new Employee(1,"Ram","Manager","Sales",23000));
        
        List<Employee> filteredList=  employeeList.stream().filter(employee->employee.getDesignation().equals("Manager")).collect(Collectors.toList());
		System.out.println(filteredList);
		//employeeList.add(new Employee(1,"Tom","Manager","Sales",23000));
	    // Not allowed as it is unmodifiable
		/*
		 * The returned list implements the optional Collection methods, exceptthose that would change the size of the returned list.
		 *  Those methods leavethe list unchanged and throw UnsupportedOperationException.
		 */
	
	}

}

