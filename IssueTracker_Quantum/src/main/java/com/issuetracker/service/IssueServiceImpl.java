package com.issuetracker.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.issuetracker.dao.IssueDAO;
import com.issuetracker.exception.IssueTrackerException;
import com.issuetracker.model.Issue;
import com.issuetracker.model.IssueReport;
import com.issuetracker.model.IssueStatus;
import com.issuetracker.validator.Validator;

public class IssueServiceImpl implements IssueService
{
    private AssigneeService assigneeService;

    private IssueDAO issueDAO;

    private Validator validator;

    /**
     * @params
     *         issue - The new issue to be reported
     * 
     * @operation Reports a new issue by
     *            * validating its details
     *            * fetch an assignee
     *            * persists the issue in the issueList
     * 
     * @returns
     *          String - The issue id
     */
    @Override
    public String reportAnIssue(Issue issue) throws IssueTrackerException
    {
	// Your Code Goes Here

	return null;
    }

    /**
     * @params
     *         issueId - The issue id
     *         status - The new status
     * 
     * @operation Updates the status of the given issue with the given status
     * 
     * @returns
     *          Boolean - Result of the status update
     */
    @Override
    public Boolean updateStatus(String issueId,
				IssueStatus status) throws IssueTrackerException
    {
	// Your Code Goes Here

	return null;
    }

    /**
     * @params
     *         filterCriteria - A map where its
     *         key denotes an attribute of the issue object
     *         value contains the filter value
     * 
     * @operation Generates a report of issues based on the filter criteria
     * 
     * @returns
     *          List<IssueReport> - The list of filtered issue objects
     */
    //  A  email   // String
    //  S  IssueStatus // enum
    @Override
    public List<IssueReport> showIssues(Map<Character, Object> filterCriteria) throws IssueTrackerException
    {
	List<Issue> issues = issueDAO.getIssueList();
	List<IssueReport> issueReports = new ArrayList<>();
	for (Issue issue : issues)
	{
	    if (filterCriteria.containsKey("A"))
	    {
		// String email=filterCriteria.get("A").toString();
		String email = (String) filterCriteria.get("A");
		if (email.equals(issue.getAssigneeEmail()))
		{
		    IssueReport issuereport = new IssueReport(); // Setting the
								 // values
		    issueReports.add(issuereport);
		}
	    }
	    else if (filterCriteria.containsKey("S"))
	    {
		IssueStatus stat = (IssueStatus) filterCriteria.get("S");
		if (stat == issue.getStatus())
		{
		    IssueReport issuereport = new IssueReport(); // Setting the
								 // values
		    issueReports.add(issuereport);
		}

	    }  
	} //for loop
	if(issueReports==null || issueReports.isEmpty())
	{
	    // Throw Exception
	}

	return issueReports;
    }

    /**
     * @operation Deletes the issue object which are resolved or closed,
     *            at least 14 days ago
     * 
     * @returns
     *          List<Issue> - The list of issues which had been deleted
     */
    @Override
    public List<Issue> deleteIssues() throws IssueTrackerException
    {
	// Your Code Goes Here

	return null;
    }
}