package com.infosys.validator;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.infosys.exception.InvalidEmployeeException;
import com.infosys.model.Employee;

public class Validator {

	
	//private Log logger=LogFactory.getLog(getClass());
	private Log logger=LogFactory.getLog(Validator.class);
	PropertiesConfiguration propertyConfiguration=null;
			
	public Validator() 
	{
		
		try {
			Configurations configure=new Configurations();
			propertyConfiguration=configure.properties("configuration.properties");
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void validate(Employee employee) throws InvalidEmployeeException {
	try
	{
		if(!isValidId(employee.getId())) {
			throw new InvalidEmployeeException("Validator.INVALID_ID");
		}
	}catch(InvalidEmployeeException exception) {
	  //logger.error(propertyConfiguration.getProperty(exception.getMessage()),exception);
		logger.error(exception.getMessage(),exception);
		throw exception;
	}
		
		
	}
	

	private boolean isValidId(int id) {
		boolean isValid=true;
		if(id<=0) {
			isValid=false;
		}
		return isValid;
	}
	
	private boolean isValidName(String name)
	{
		return false;
		
	}
	private boolean isValidDesignation(String designation)
	{
	return false;	
	}
	
	private boolean isValidDepartment(String department)
	{
		return false;
	}
}
