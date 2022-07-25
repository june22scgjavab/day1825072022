package com.issuetracker.userinterface;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.issuetracker.exception.IssueTrackerException;
import com.issuetracker.model.Issue;
import com.issuetracker.model.IssueReport;
import com.issuetracker.model.IssueStatus;
import com.issuetracker.model.Unit;
import com.issuetracker.service.IssueServiceImpl;
//Uncomment the commented lines of code after implementing modal classes.
public class IssueTester
{
    private static IssueServiceImpl issueService;

    public static void main(String[] args) 
    {
	issueService = new IssueServiceImpl();

	System.out.println();
	System.out.print("Mont Trance Inc.");

	reportAnIssue();
//	updateStatus();
//	showIssues();
//	deleteIssues();
	
    }

    public static void reportAnIssue()
    {
	System.out.println(" | Reporting An Issue");

	 Issue issue = new Issue("MTI-I-013-LS", "Booting up time is very high",
	 Unit.ADMINISTRATION,
	 LocalDate.now().minusDays(1), null, null,
	 IssueStatus.OPEN);

//	try
//	{
//	     String issueId = issueService.reportAnIssue(issue);
//	     System.out.println("The issue has been logged successfully. Issue ID: "+issueId);
//	}
//	catch (IssueTrackerException exception)
//	{
//	    String exceptionMessage = exception.getMessage();
//	    if (exceptionMessage == null)
//	    {
//		exceptionMessage = "An error seems to have occurred! Please try again after sometime.";
//	    }
//	    System.out.println(String.format("ERROR: %s", exceptionMessage));
//	}
    }

    public static void updateStatus()
    {
	System.out.println(" | Updating Status");

	String issueId = "MTI-I-001-MS";
	 IssueStatus status = IssueStatus.RESOLVED;

	try
	{
	     Boolean isUpdateSuccess = issueService.updateStatus(issueId,
	     status);
	    
	     if (isUpdateSuccess)
	    {
	    System.out.println("The status have been updated successfully!");
	    }
	}
catch (IssueTrackerException exception)
	{

    String exceptionMessage = exception.getMessage();
	    if (exceptionMessage == null)
	    {
		exceptionMessage = "An error seems to have occurred! Please try again after sometime.";
	    
	    }
	    System.out.println(String.format("ERROR: %s", exceptionMessage));
	}
    }

    public static void showIssues()
    {
	System.out.println(" | Showing Issues");

	Map<Character, Object> filterCriteria = new HashMap<>();
	filterCriteria.put('A', "jane_andrews");
	filterCriteria.put('S',IssueStatus.OPEN);

	try
	{
	    List<IssueReport> issueReportList = issueService.showIssues(filterCriteria);

	    if (filterCriteria.containsKey('A'))
	    {
		System.out.println(String.format("Filter Criteria: Assignee Email > %s",
						 filterCriteria.get('A')));

		System.out.println("====================================================================================");
		System.out.printf("%s %-12s %s %-50s %s %-12s %s\n", "|",
				  "Issue ID", "|", "Issue Description", "|",
				  "Issue Status", "|");
		System.out.println("====================================================================================");

		//for (IssueReport issueReport : issueReportList)
		//{
		    // System.out.printf("%s %-12s %s %-50s %s %-12s %s\n", "|",
		    // issueReport.getIssueId(), "|",
		    // issueReport.getIssueDescription(), "|",
		    // issueReport.getStatus(), "|");
		//}
		System.out.println("====================================================================================");
	    }
	    else
	    {
		System.out.println(String.format("Filter Criteria: Issue Status > %s",
						 filterCriteria.get('S')));

		System.out.println("=======================================================================================");
		System.out.printf("%s %-12s %s %-50s %s %-15s %s\n", "|",
				  "Issue ID", "|", "Issue Description", "|",
				  "Assignee EMail", "|");
		System.out.println("=======================================================================================");

		for (IssueReport issueReport : issueReportList)
		{
		    // System.out.printf("%s %-12s %s %-50s %s %-15s %s\n", "|",
		    // issueReport.getIssueId(), "|",
		    // issueReport.getIssueDescription(), "|",
		    // issueReport.getAssigneeEmail(), "|");
		}
		System.out.println("=======================================================================================");
	    }
	}
	catch (IssueTrackerException exception)
	{
	    String exceptionMessage = exception.getMessage();
	    if (exceptionMessage == null)
	    {
		exceptionMessage = "An error seems to have occurred! Please try again after sometime.";
	    }
		System.out.println(String.format("ERROR: %s", exceptionMessage));
	}
    }

    public static void deleteIssues()
    {
	System.out.println(" | Deleting Issues");
	try
	{

	    List<Issue> deletedIssueList = issueService.deleteIssues();

//	    if (!deletedIssueList.isEmpty())
//	    {
//		System.out.println(deletedIssueList.size() + " "
//				   + "issues have been deleted. The issues that are deleted are:");
//	    }
	    System.out.println("==================================================================================================");
	    System.out.printf("%s %-12s %s %-50s %s %-15s %s %-8s %s\n", "|",
			      "Issue ID", "|", "Issue Description", "|",
			      "Assignee EMail", "|", "Status", "|");
	    System.out.println("==================================================================================================");
//	    for (Issue issue : deletedIssueList)
//	    {
//		System.out.printf("%s %-12s %s %-50s %s %-15s %s %-8s %s\n",
//				  "|", issue.getIssueId(), "|",
//				  issue.getIssueDescription(), "|",
//				  issue.getAssigneeEmail(), "|",
//				  issue.getStatus(), "|");
//	    }
	    System.out.println("==================================================================================================");
	}
	catch (IssueTrackerException exception)
	{
	    String exceptionMessage = exception.getMessage();
	    if (exceptionMessage == null)
	    {
		exceptionMessage = "An error seems to have occurred! Please try again after sometime.";
	    
	    }
	    System.out.println(String.format("ERROR: %s", exceptionMessage));
	}
    }
}