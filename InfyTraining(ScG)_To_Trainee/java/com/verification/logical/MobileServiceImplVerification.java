package com.verification.logical;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;



import com.infy.exception.MobileServiceException;
import com.infy.model.ServiceReport;
import com.infy.model.ServiceRequest;
import com.infy.model.Status;
import com.infy.service.MobileService;
import com.infy.service.MobileServiceImpl;

import com.verification.equator.ServiceReportEquator;


@Tag("Service")
class MobileServiceImplVerification {
	    private MobileService mobileService = new MobileServiceImpl();
	    
	    static Stream<Arguments> calculateEstimateCost()
	    {
	    	 return Stream.of(
	    		        Arguments.of(Arrays.asList("Battery Issue"),0.0F),
	    		        Arguments.of(Arrays.asList("Battery"),10.0F),
	    		        Arguments.of(Arrays.asList("Camera"),5.0F),
	    		        Arguments.of(Arrays.asList("Screen"),15.0F),
	    		        Arguments.of(Arrays.asList("Camera","Battery"),15.0F),
	    		        Arguments.of(Arrays.asList("Screen","Camera","Battery"),30.0F),
	    		        Arguments.of(Arrays.asList("Screen","Camera","Camera Screen","Screen"),35.0F)
	    		    );
	    	
	    }
	    
	    @Test
	    void registerRequest() throws MobileServiceException
	    {
	    ServiceRequest service = new ServiceRequest("Brand", Arrays.asList("BatTery"), 8103436348L,"Chap Chow",9988998899889988L);
	    
		ServiceRequest expectedServiceObject=new ServiceRequest("Brand", Arrays.asList("BatTery"), 8103436348L,"Chap Chow",9988998899889988L);
		expectedServiceObject.setServiceId(1000);
		expectedServiceObject.setServiceFee(10F);
		expectedServiceObject.setStatus(Status.ACCEPTED);
		expectedServiceObject.setTimeOfRequest(LocalDateTime.now());
		ServiceRequest actualServiceObject=mobileService.registerRequest(service);
		Assertions.assertTrue(EqualsBuilder.reflectionEquals(expectedServiceObject, actualServiceObject,"timeOfRequest"));
		
	    }
	    
	    
	    @Test
	    @DisplayName("ELTC8-MobileServiceImpl.registerRequest | Verifying the functionality of registerRequest | Expecting an exception throw - 'Service.INVALID_ISSUES'")
	    void registerRequest$InvalidIssuesException() 
	    {
	    ServiceRequest service = new ServiceRequest("Brand", Arrays.asList("Battery Replacement"), 8103436348L,"Chap Chow",9988998899889988L);
	    Exception exception = Assertions.assertThrows(MobileServiceException.class,() -> mobileService.registerRequest(service));
        Assertions.assertEquals("Service.INVALID_ISSUES",exception.getMessage());
	    }
	    
	    
	    @ParameterizedTest(name = "ELTC{index}-MobileServiceImpl.calculateEstimateCost | Verifying the functionality of calculateEstimateCost for ''{0}'' ")
	    @MethodSource("calculateEstimateCost")
	    void calculateEstimateCost(List<String> issues, Float expectedServiceFee) throws MobileServiceException
	    {Float actualServiceFee= mobileService.calculateEstimateCost(issues);
	     Assertions.assertEquals(expectedServiceFee,actualServiceFee);
		
	    }
	    
	    
	    @Test
	    void getServices() throws MobileServiceException
	    {
        Status status=Status.IN_PROGRESS;
		List<ServiceReport> expectedServiceReportList = new ArrayList<>();
		ServiceReport service = new ServiceReport(1001,"TwoMinus",Arrays.asList("Battery", "Camera", "Screen"),15f);
		expectedServiceReportList.add(service);
		

	

		List<ServiceReport> actualSericeReportList = mobileService.getServices(status);

		Assertions.assertTrue(CollectionUtils.isEqualCollection(expectedServiceReportList,
				actualSericeReportList,	new ServiceReportEquator()));
		
	    }
	    @Test
	    @DisplayName("ELTC9-MobileServiceImpl.getServices | Verifying the functionality of getServices | Expecting an exception throw - 'Service.NO_RECORDS_FOUND'")
	    void getServices$NoRecordsFound() throws MobileServiceException
	    {
        Status status=Status.REJECTED;
	    Exception exception = Assertions.assertThrows(MobileServiceException.class,() -> mobileService.getServices(status));
        Assertions.assertEquals("Service.NO_RECORDS_FOUND",exception.getMessage());
		
	    }

	   
}
