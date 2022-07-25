package com.verification.structural;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.infy.model.ServiceRequest;
import com.infy.validator.Validator;



@Tag("Validator")
class ValidatorVerification
{
    @Test
    void validate() throws NoSuchMethodException, SecurityException
    {
	Assertions.assertEquals(Void.TYPE,
				Validator.class.getDeclaredMethod("validate",
								  ServiceRequest.class)
					       .getReturnType());
    }

    @Test
    void isValidBrand() throws NoSuchMethodException, SecurityException
    {
	Assertions.assertEquals(Boolean.class,
				Validator.class.getDeclaredMethod("isValidBrand",
								  String.class)
					       .getReturnType());
    }

    @Test
    void isValidIssues() throws NoSuchMethodException, SecurityException
    {
	Assertions.assertEquals(Boolean.class,
				Validator.class.getDeclaredMethod("isValidIssues",
								  List.class)
					       .getReturnType());
    }

    @Test
    void isValidIMEINumber() throws NoSuchMethodException, SecurityException
    {
	Assertions.assertEquals(Boolean.class,
				Validator.class.getDeclaredMethod("isValidIMEINumber",
								  Long.class)
					       .getReturnType());
    }

    @Test
    void isValidContactNumber() throws NoSuchMethodException, SecurityException
    {
	Assertions.assertEquals(Boolean.class,
				Validator.class.getDeclaredMethod("isValidContactNumber",
								  Long.class)
					       .getReturnType());
    }
    
    @Test
    void isValidCustomerName() throws NoSuchMethodException, SecurityException
    {
	Assertions.assertEquals(Boolean.class,
				Validator.class.getDeclaredMethod("isValidCustomerName",
								  String.class)
					       .getReturnType());
    }
}