package com.verification.equator;

import org.apache.commons.collections4.Equator;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.infy.model.ServiceRequest;

public class ServiceRequestEquator implements Equator<ServiceRequest> {

	@Override
	public boolean equate(ServiceRequest serviceOne, ServiceRequest serviceTwo) {
		return new EqualsBuilder().append(serviceOne.getServiceId(),
				  serviceTwo.getServiceId())
			  .append(serviceOne.getBrand(),
				  serviceTwo.getBrand())
			  .append(serviceOne.getContactNumber(),
				  serviceTwo.getContactNumber())
			  .append(serviceOne.getCustomerName(),
				  serviceTwo.getCustomerName())
			  .append(serviceOne.getIssues(),
				  serviceTwo.getIssues())
			  .append(serviceOne.getiMEINumber(),
				  serviceTwo.getiMEINumber())
			  .append(serviceOne.getStatus(),
				  serviceTwo.getStatus())
			  .append(serviceOne.getServiceFee(),
					  serviceTwo.getServiceFee())
			  .append(serviceOne.getTimeOfRequest(),
					  serviceTwo.getTimeOfRequest())
						  .isEquals();
		
	}

	@Override
	public int hash(ServiceRequest service) {
		return new HashCodeBuilder().append(service.getServiceId())
			    .toHashCode();
	}

}
