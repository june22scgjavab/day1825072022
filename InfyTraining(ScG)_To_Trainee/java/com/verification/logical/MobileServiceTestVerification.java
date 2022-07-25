package com.verification.logical;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.infy.exception.MobileServiceException;
import com.infy.service.MobileService;
import com.infy.service.MobileServiceImpl;
import com.infy.test.MobileServiceTest;

import org.opentest4j.AssertionFailedError;

@Tag("JUnit")
@ExtendWith(MockitoExtension.class)
class MobileServiceTestVerification {
	
	@Mock
	private  MobileService mobileService = new MobileServiceImpl();
	
	@InjectMocks
	private  MobileServiceTest  mobileServiceTest = new  MobileServiceTest();

    @Test
    void registerRequestInvalidBrandTest$UsageOfAssertThrows() throws MobileServiceException
    {
    Mockito.when(mobileService.registerRequest(ArgumentMatchers.any())).thenThrow(new MobileServiceException("Validator.INVALID_BRAND"));
    assertDoesNotThrow(() ->  mobileServiceTest.registerRequestInvalidBrandTest());
    Mockito.verify(mobileService).registerRequest(ArgumentMatchers.any());
    }
    
    @Test
    void registerRequestInvalidBrandTest$AssertingExceptionMessage() throws MobileServiceException
    { 
    Mockito.when(mobileService.registerRequest(ArgumentMatchers.any()))
	       .thenThrow(new MobileServiceException("UNEXPECTED_EXCEPTION_MESSAGE"));

	AssertionFailedError assertionsFailedError = Assertions.assertThrows(AssertionFailedError.class,
									     () -> mobileServiceTest.registerRequestInvalidBrandTest());

	Assertions.assertTrue(assertionsFailedError.getExpected()
						   .getStringRepresentation()
						   .matches(".*(Validator.INVALID_BRAND|true).*"));
	}

    @Test
    void registerRequestInvalidContactNumberTest$UsageOfAssertThrows() throws MobileServiceException
    { 
    Mockito.when(mobileService.registerRequest(ArgumentMatchers.any())).thenThrow(new MobileServiceException("Validator.INVALID_CONTACT_NUMBER"));
    assertDoesNotThrow(() ->  mobileServiceTest.registerRequestInvalidContactNumberTest());
    Mockito.verify(mobileService).registerRequest(ArgumentMatchers.any());
    }
    @Test
    void registerRequestInvalidContactNumberTest$AssertingExceptionMessage() throws MobileServiceException
    {
    Mockito.when(mobileService.registerRequest(ArgumentMatchers.any()))
	       .thenThrow(new MobileServiceException("UNEXPECTED_EXCEPTION_MESSAGE"));

	AssertionFailedError assertionsFailedError = Assertions.assertThrows(AssertionFailedError.class,
									     () -> mobileServiceTest.registerRequestInvalidContactNumberTest());

	Assertions.assertTrue(assertionsFailedError.getExpected()
						   .getStringRepresentation()
						   .matches(".*(Validator.INVALID_CONTACT_NUMBER|true).*"));
    }

    @Test
    void registerRequestInvalidIssuesTest$UsageOfAssertThrows() throws MobileServiceException
    {
    Mockito.when(mobileService.registerRequest(ArgumentMatchers.any())).thenThrow(new MobileServiceException("Service.INVALID_ISSUES"));
    assertDoesNotThrow(() ->  mobileServiceTest.registerRequestInvalidIssuesTest());
    Mockito.verify(mobileService).registerRequest(ArgumentMatchers.any());
    }
    @Test
    void registerRequestInvalidIssuesTest$AssertingExceptionMessage() throws MobileServiceException
    {
    Mockito.when(mobileService.registerRequest(ArgumentMatchers.any()))
	       .thenThrow(new MobileServiceException("UNEXPECTED_EXCEPTION_MESSAGE"));

	AssertionFailedError assertionsFailedError = Assertions.assertThrows(AssertionFailedError.class,
									     () -> mobileServiceTest.registerRequestInvalidIssuesTest());

	Assertions.assertTrue(assertionsFailedError.getExpected()
						   .getStringRepresentation()
						   .matches(".*(Service.INVALID_ISSUES|true).*"));
    }

   
}
