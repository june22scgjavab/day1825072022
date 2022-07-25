package com.infytraining.model;

import java.time.LocalDate;

public class TraineeReport {
	private String traineeName;
	private LocalDate dateOfJoining;
	private Long contactNumber;
	
	
	public TraineeReport(String traineeName, LocalDate dateOfJoining, Long contactNumber) {
		super();
		this.traineeName = traineeName;
		this.dateOfJoining = dateOfJoining;
		this.contactNumber = contactNumber;
	}
	public String getTraineeName() {
		return traineeName;
	}
	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}
	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public Long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}
	@Override
	public String toString() {
		return "TraineeReport [traineeName=" + traineeName + ", dateOfJoining=" + dateOfJoining + ", contactNumber="
				+ contactNumber + "]";
	}

}
