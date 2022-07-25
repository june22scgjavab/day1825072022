package com.issuetracker.validator;

import java.time.LocalDate;

import com.issuetracker.exception.IssueTrackerException;
import com.issuetracker.model.Issue;
import com.issuetracker.model.IssueStatus;

//Do Not Change Any Signature
public class Validator
{
 public void validate(Issue issue) throws IssueTrackerException
 {
	// Your Code Goes Here
 }

 public Boolean isValidIssueId(String issueId)
 {
	// Your Code Goes Here

	return null;

 }

 public Boolean isValidIssueDescription(String issueDescription)
 {
	// Your Code Goes Here

	return null;
 }

 public Boolean isValidReportedOn(LocalDate reportedOn)
 {
	// Your Code Goes Here

	return null;
 }

 public Boolean isValidStatus(IssueStatus status)
 {
	// Your Code Goes Here

	return null;
 }
}