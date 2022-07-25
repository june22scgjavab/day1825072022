package com.verification.logical;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.google.gson.Gson;
import com.infy.exception.MobileServiceException;
import com.infy.model.ServiceRequest;
import com.infy.validator.Validator;



@Tag("Validator")
class ValidatorVerification {
	static Gson gson = new Gson();

    static ServiceRequest serviceRequest;
    static Validator validator = new Validator();

    @BeforeAll
    static void createObject()
    {
    serviceRequest = new ServiceRequest("Brand", Arrays.asList("BatTery"), 8103436348L,"Chap Chow",9988998899889988L);
    }

    static Stream<Arguments> validate()
    {
	ServiceRequest serviceRequestOne = gson.fromJson(gson.toJson(serviceRequest), ServiceRequest.class);
	serviceRequestOne.setBrand("Invalid brand");

	ServiceRequest serviceRequestTwo = gson.fromJson(gson.toJson(serviceRequest), ServiceRequest.class);
	serviceRequestTwo.setIssues(Arrays.asList());

	ServiceRequest serviceRequestThree = gson.fromJson(gson.toJson(serviceRequest), ServiceRequest.class);
	serviceRequestThree.setiMEINumber(5555L);

	ServiceRequest serviceRequestFour = gson.fromJson(gson.toJson(serviceRequest), ServiceRequest.class);
	serviceRequestFour.setContactNumber(8888L);
	
	ServiceRequest serviceRequestFive = gson.fromJson(gson.toJson(serviceRequest), ServiceRequest.class);
	serviceRequestFive.setCustomerName("Anay78");

	return Stream.of(Arguments.of(serviceRequestOne, "Validator.INVALID_BRAND"),
			 Arguments.of(serviceRequestTwo,
				      "Validator.INVALID_NO_OF_ISSUES"),
			 Arguments.of(serviceRequestThree,
				      "Validator.INVALID_IMEI_NUMBER"),
			 Arguments.of(serviceRequestFour, "Validator.INVALID_CONTACT_NUMBER"),
			 Arguments.of(serviceRequestFive, "Validator.INVALID_CUSTOMER_NAME")
			 );
    }
    
    static Stream<Arguments> isValidBrand()
    {
	return Stream.of(Arguments.of("Brand", true, null),
			 Arguments.of("Invalid Brand", false,
				      "Brand contain spaces"),
			 Arguments.of("Brand55", false,
				      "Brand contain digits"),
			 Arguments.of("brand", false,
				      "Brand first character is not in Upper Case"));
    }
    static Stream<Arguments> isValidIssues()
    {
	return Stream.of(Arguments.of(Arrays.asList("Battery"), true, null),
			Arguments.of(Arrays.asList("Battery","Camera"), true, null),
			Arguments.of(Arrays.asList("Battery Camera"), true, null),
			Arguments.of(Arrays.asList("Battery","Screen","Batttttery"), true, null),
		    Arguments.of(null, false,
				      "Issues are null"),
			 Arguments.of(Arrays.asList(), false,
				      "Issues is an Empty List"));
    }
    static Stream<Arguments> isValidIMEINumber()
    {
	return Stream.of(Arguments.of(1234567812345678L, true, null),
			Arguments.of(12345678L,false,"IMEINumber has Less than 16 digits"),
			Arguments.of(12345678123456789L,false,"IMEINumber has More than 16 digits"));
			
    }
    
    static Stream<Arguments> isValidContactNumber()
    {
	return Stream.of(Arguments.of(1234567890L,true,null),
			Arguments.of(12345678L,false,"Contact Number has Less than 10 digits"),
			Arguments.of(12345678123456789L,false,"Contact Number has More than 10 digits"),
			Arguments.of(9999999999L,false,"ten digits are same.")
			);
			
    }
    static Stream<Arguments>isValidCustomerName()
    {
	return Stream.of(Arguments.of("Valid Name", true, null),
			Arguments.of("Invalid  Name  Because of     Spaces",false,"wordS not separated by a single space"),
			Arguments.of("INvalid Name Wrong Casing",false,"characters other than first character of an words, are in upper case"),
			Arguments.of("invalid Name",false,"first character not in upper case")
			);
			
    }
    @ParameterizedTest(name = "ELTC{index}-Validator.validate | Verifying the functionality of validate | Expecting an exception throw - ''{1}''")
    @MethodSource("validate")
    void validate(ServiceRequest service, String expectionMessage)
    {
	Exception actualException = Assertions.assertThrows(MobileServiceException.class,
							    () -> validator.validate(service));

	Assertions.assertEquals(expectionMessage, actualException.getMessage());
    }
    
    @ParameterizedTest(name = "ELTC{index}-Validator.isValidBrand | Verifying the functionality of isValidBrand for ''{0}'' to be ''{1}'' | {2}")
    @MethodSource("isValidBrand")
    void isValidBrand(String brand , Boolean expectedResult,
			String testCaseDescription)
    {
	Boolean actualResult = validator.isValidBrand(brand);

	Assertions.assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest(name = "ELTC{index}-Validator.isValidIssues | Verifying the functionality of isValidIssues for ''{0}'' to be ''{1}'' | {2}")
    @MethodSource("isValidIssues")
    void isValidIssues(List<String> issues,
				 Boolean expectedResult,
				 String testCaseDescription)
    {
	Boolean actualResult = validator.isValidIssues( issues);

	Assertions.assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest(name = "ELTC{index}-Validator.isValidIMEINumber | Verifying the functionality of isValidIMEINumber for ''{0}'' to be ''{1}'' | {2}")
    @MethodSource("isValidIMEINumber")
    void isValidIMEINumber(Long iMEINumber, Boolean expectedResult,
			   String testCaseDescription)
    {
	Boolean actualResult = validator.isValidIMEINumber(iMEINumber);

	Assertions.assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest(name = "ELTC{index}-Validator.isValidContactNumber | Verifying the functionality of isValidContactNumber for ''{0}'' to be ''{1}'' | {2}")
    @MethodSource("isValidContactNumber")
    void isValidContactNumber(Long contactNumber, Boolean expectedResult,
		       String testCaseDescription)
    {
	Boolean actualResult = validator.isValidContactNumber(contactNumber);

	Assertions.assertEquals(expectedResult, actualResult);
    }
   
    @ParameterizedTest(name = "ELTC{index}-Validator.isValidCustomerName | Verifying the functionality of isValidCustomerName for ''{0}'' to be ''{1}'' | {2}")
    @MethodSource("isValidCustomerName")
    void isValidCustomerName(String customerName , Boolean expectedResult,
			String testCaseDescription)
    {
	Boolean actualResult = validator.isValidCustomerName(customerName);

	Assertions.assertEquals(expectedResult, actualResult);
    }


}

