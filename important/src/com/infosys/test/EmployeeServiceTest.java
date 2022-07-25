package com.infosys.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.infosys.exception.InvalidEmployeeException;
import com.infosys.model.Employee;
import com.infosys.service.EmployeeServiceImpl;

class EmployeeServiceTest {

	@Test
	void validateInvalidTest() {
		EmployeeServiceImpl esi = new EmployeeServiceImpl();
		Employee employee = new Employee(-1, "Raman", "Manager", "Sales", 20000);

		InvalidEmployeeException exception = Assertions.assertThrows(InvalidEmployeeException.class,
				() -> esi.addEmployee(employee));
		Assertions.assertEquals("Validator.INVALID_ID", exception.getMessage());
	}

}
