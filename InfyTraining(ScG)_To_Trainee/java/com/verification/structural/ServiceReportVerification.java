package com.verification.structural;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.infy.model.ServiceReport;


@Tag("Model")
class ServiceReportVerification {

	
	@Test
    void attributes()
    {
	Map<String, Class> expectedAttributes = new HashMap<>();

	expectedAttributes.put("serviceId", Integer.class);
	expectedAttributes.put("brand", String.class);
	expectedAttributes.put("issues",List.class);
	expectedAttributes.put("serviceFee",Float.class);
	

	Field[] fields = ServiceReport.class.getDeclaredFields();

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
    void constructor() throws NoSuchMethodException, SecurityException
    {
	Assertions.assertNotNull(ServiceReport.class.getDeclaredConstructor(
								       Integer.class,
								       String.class,
								       List.class,
								       Float.class
								       ));
    }

	    @Test
	    void  getServiceId() throws NoSuchMethodException, SecurityException
	    {
		Assertions.assertEquals(Integer.class,
					ServiceReport.class.getDeclaredMethod("getServiceId")
						      .getReturnType());
	    }

	    @Test
	    void  setServiceId() throws NoSuchMethodException, SecurityException
	    {
		Assertions.assertEquals(Void.TYPE,
				ServiceReport.class.getDeclaredMethod("setServiceId",
									Integer.class)
						      .getReturnType());
	    }
	    
	    @Test
	    void  getBrand() throws NoSuchMethodException, SecurityException
	    {
		Assertions.assertEquals(String.class,
					ServiceReport.class.getDeclaredMethod("getBrand")
						      .getReturnType());
	    }

	    @Test
	    void  setBrand() throws NoSuchMethodException, SecurityException
	    {
		Assertions.assertEquals(Void.TYPE,
				ServiceReport.class.getDeclaredMethod("setBrand",
									 String.class)
						      .getReturnType());
	    }
	    @Test
	    void  getIssues() throws NoSuchMethodException, SecurityException
	    {
		Assertions.assertEquals(List.class,
					ServiceReport.class.getDeclaredMethod("getIssues")
						      .getReturnType());
	    }
	    @Test
	    void setIssues() throws NoSuchMethodException, SecurityException
	    {
		Assertions.assertEquals(Void.TYPE,
				ServiceReport.class.getDeclaredMethod("setIssues",
									 List.class)
						      .getReturnType());
	    }
	    @Test
	    void  getServiceFee() throws NoSuchMethodException, SecurityException
	    {
		Assertions.assertEquals(Float.class,
					ServiceReport.class.getDeclaredMethod("getServiceFee")
						      .getReturnType());
	    }
	    @Test
	    void setServiceFee() throws NoSuchMethodException, SecurityException
	    {
		Assertions.assertEquals(Void.TYPE,
				ServiceReport.class.getDeclaredMethod("setServiceFee",
									 Float.class)
						      .getReturnType());
	    }
	    
	    
}
