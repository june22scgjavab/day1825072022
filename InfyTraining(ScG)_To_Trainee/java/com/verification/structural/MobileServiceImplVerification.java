package com.verification.structural;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.infy.dao.MobileServiceDAO;
import com.infy.model.ServiceRequest;
import com.infy.model.Status;
import com.infy.service.MobileService;
import com.infy.service.MobileServiceImpl;
import com.infy.validator.Validator;
import com.verification.Descriptive;

@Tag("Service")
@Descriptive(true)
class MobileServiceImplVerification {
	    @Test
	    void inheritance()
	    {
		Assertions.assertEquals(MobileService.class,
				MobileServiceImpl.class.getInterfaces()[0]);
	    }
	    
	    @Test
	    void attributes()
	    {
		Map<String, Class> expectedAttributes = new HashMap<>();

		expectedAttributes.put("dao", MobileServiceDAO.class);
		expectedAttributes.put("validator", Validator.class);

		Field[] fields =MobileServiceImpl.class.getDeclaredFields();

		Map<String, Class> actualAttributes = new HashMap<>();
		for (Field field : fields)
		    actualAttributes.put(field.getName(), field.getType());

		// Asserting the attributes and their types
		Assertions.assertEquals(expectedAttributes, actualAttributes);

		// Asserting all the attributes to be private
		for (Field field : fields)
		    Assertions.assertTrue(Modifier.isPrivate(field.getModifiers()));
	    }

	    @Test
	    void registerRequest() throws NoSuchMethodException , SecurityException
	    {
		Assertions.assertEquals(ServiceRequest.class,
				MobileServiceImpl.class.getDeclaredMethod("registerRequest",
						         ServiceRequest.class)
								 .getReturnType());
	    }
	    @Test
	    void calculateEstimateCost() throws NoSuchMethodException, SecurityException
	    {
		Assertions.assertEquals(Float.class,
				MobileServiceImpl.class.getDeclaredMethod("calculateEstimateCost",
						         List.class)
								 .getReturnType());
	    }
	    @Test
	    void getServices() throws NoSuchMethodException, SecurityException
	    {
		Assertions.assertEquals(List.class,
				MobileServiceImpl.class.getDeclaredMethod("getServices",
						         Status.class)
								 .getReturnType());
	    }

	   
}
