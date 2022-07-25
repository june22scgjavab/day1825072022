package com.verification.structural;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.infy.exception.MobileServiceException;


@Tag("Exception")
class MobileServiceExceptionVerification {
	@Test
    void inheritance()
    {
	Assertions.assertEquals(Exception.class,
			MobileServiceException.class.getSuperclass());
    }

    @Test
    void constructor() throws NoSuchMethodException, SecurityException
    {
	Assertions.assertNotNull(MobileServiceException.class.getDeclaredConstructor(String.class));
    }
}
