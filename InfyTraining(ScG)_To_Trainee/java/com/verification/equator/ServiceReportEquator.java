package com.verification.equator;

import org.apache.commons.collections4.Equator;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.infy.model.ServiceReport;


public class ServiceReportEquator implements Equator<ServiceReport> {

	@Override
	public boolean equate(ServiceReport serviceOne, ServiceReport serviceTwo) {
		return new EqualsBuilder().append(serviceOne.getServiceId(),
				  serviceTwo.getServiceId())
			  .append(serviceOne.getBrand(),
				  serviceTwo.getBrand())
			  .append(serviceOne.getIssues(),
				  serviceTwo.getIssues())
			  .append(serviceOne.getServiceFee(),
				  serviceTwo.getServiceFee())
			  .isEquals();
	}

	@Override
	public int hash(ServiceReport service) {
		return new HashCodeBuilder().append(service.getServiceId())
			    .toHashCode();
	}

}
