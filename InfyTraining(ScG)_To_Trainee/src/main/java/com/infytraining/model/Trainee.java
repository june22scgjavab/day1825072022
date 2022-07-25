package com.infytraining.model;

import java.time.LocalDate;

public class Trainee {
	private String traineeName;
	private LocalDate dateOfJoining;
	private String idProof ;	
	private String mailId;
	private Long contactNumber;
	
	
	
	public Trainee(String traineeName, LocalDate dateOfJoining, String idProof, String mailId, Long contactNumber) {
		
		this.traineeName = traineeName;
		this.dateOfJoining = dateOfJoining;
		this.idProof = idProof;
		this.mailId = mailId;
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
	public String getIdProof() {
		return idProof;
	}
	public void setIdProof(String idProof) {
		this.idProof = idProof;
	}
		
	public Long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}


}
