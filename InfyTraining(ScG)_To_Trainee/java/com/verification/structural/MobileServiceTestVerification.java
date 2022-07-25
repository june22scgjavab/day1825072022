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
import com.infy.service.MobileService;
import com.infy.test.MobileServiceTest;


@Tag("JUnit")
class MobileServiceTestVerification {
	@Test
    void attributes()
    {
	Map<String, Class> expectedAttributes = new HashMap<>();

	expectedAttributes.put("mobileService",MobileService.class);
	

	Field[] fields = MobileServiceTest.class.getDeclaredFields();

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
	    void registerRequestInvalidBrandTest() throws NoSuchMethodException, SecurityException
	    {
		Assertions.assertNotNull(MobileServiceTest.class.getDeclaredMethod("registerRequestInvalidBrandTest")
							       .getDeclaredAnnotation(Test.class));
	    }
	    @Test
	    void registerRequestInvalidContactNumberTest() throws NoSuchMethodException, SecurityException
	    {
		Assertions.assertNotNull(MobileServiceTest.class.getDeclaredMethod("registerRequestInvalidContactNumberTest")
							       .getDeclaredAnnotation(Test.class));
	    }
	    @Test
	    void registerRequestInvalidIssuesTest() throws NoSuchMethodException, SecurityException
	    {
		Assertions.assertNotNull(MobileServiceTest.class.getDeclaredMethod("registerRequestInvalidIssuesTest")
							       .getDeclaredAnnotation(Test.class));
	    }
}
