package com.issuetracker.model;

import java.time.LocalDate;

public class Issue
{
    private String issueId;
    private String issueDescription;
    private Unit issueUnit;
    private LocalDate reportedOn;
    private LocalDate updatedOn;
    private String assigneeEmail;
    private IssueStatus status;

    public Issue(String issueId, String issueDescription, Unit issueUnit,
		 LocalDate reportedOn, LocalDate updatedOn,
		 String assigneeEmail, IssueStatus status)
    {
	super();
	this.issueId = issueId;
	this.issueDescription = issueDescription;
	this.issueUnit = issueUnit;
	this.reportedOn = reportedOn;
	this.updatedOn = updatedOn;
	this.assigneeEmail = assigneeEmail;
	this.status = status;
    }

    public String getIssueId()
    {
	return issueId;
    }

    public void setIssueId(String issueId)
    {
	this.issueId = issueId;
    }

    public String getIssueDescription()
    {
	return issueDescription;
    }

    public void setIssueDescription(String issueDescription)
    {
	this.issueDescription = issueDescription;
    }

    public Unit getIssueUnit()
    {
	return issueUnit;
    }

    public void setIssueUnit(Unit issueUnit)
    {
	this.issueUnit = issueUnit;
    }

    public LocalDate getReportedOn()
    {
	return reportedOn;
    }

    public void setReportedOn(LocalDate reportedOn)
    {
	this.reportedOn = reportedOn;
    }

    public LocalDate getUpdatedOn()
    {
	return updatedOn;
    }

    public void setUpdatedOn(LocalDate updatedOn)
    {
	this.updatedOn = updatedOn;
    }

    public String getAssigneeEmail()
    {
	return assigneeEmail;
    }

    public void setAssigneeEmail(String assigneeEmail)
    {
	this.assigneeEmail = assigneeEmail;
    }

    public IssueStatus getStatus()
    {
	return status;
    }

    public void setStatus(IssueStatus status)
    {
	this.status = status;
    }
}