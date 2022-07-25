package com.issuetracker.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.issuetracker.model.Issue;
import com.issuetracker.model.IssueStatus;

//Uncomment the commented lines of code after implementing modal classes.
public class IssueDAOImpl implements IssueDAO
{
    private List<Issue> issueList = new ArrayList<>();

    public IssueDAOImpl()
    {
//	Issue issueOne = new Issue("MTI-I-001-MS",
//				   "Unable to update the container specifications",
//				   Unit.CONSIGNMENT,
//				   LocalDate.now().minusDays(5), null, "miki.w",
//				   IssueStatus.IN_PROGRESS);
//
//	Issue issueTwo = new Issue("MTI-I-002-HS",
//				   "The active transactions are not shown",
//				   Unit.PAYMENT, LocalDate.now().minusDays(24),
//				   LocalDate.now().minusDays(14),
//				   "larita.conklin", IssueStatus.RESOLVED);
//
//	Issue issueThree = new Issue("MTI-I-003-HS",
//				     "Alternate transactions are not visible",
//				     Unit.PAYMENT,
//				     LocalDate.now().minusDays(15),
//				     LocalDate.now().minusDays(14), "elyse.chu",
//				     IssueStatus.CLOSED);
//
//	Issue issueFour = new Issue("MTI-I-004-LS",
//				    "Unable to connect to the Workspace",
//				    Unit.ADMINISTRATION,
//				    LocalDate.now().minusDays(3), null,
//				    "carry.luke", IssueStatus.OPEN);
//
//	Issue issueFive = new Issue("MTI-I-005-LS",
//				    "Unable to generate the report of shipments",
//				    Unit.SHIPMENT, LocalDate.now().minusDays(5),
//				    LocalDate.now().minusDays(3),
//				    "elane_lester", IssueStatus.CLOSED);
//
//	Issue issueSix = new Issue("MTI-I-006-MS", "Workstation is faulty",
//				   Unit.ADMINISTRATION,
//				   LocalDate.now().minusDays(12),
//				   LocalDate.now().minusDays(3),
//				   "rodrick_luther", IssueStatus.RESOLVED);
//
//	Issue issueSeven = new Issue("MTI-I-007-HS",
//				     "Unable to view the Manage Workers tab",
//				     Unit.ADMINISTRATION,
//				     LocalDate.now().minusDays(35), null,
//				     "rodrick_luther", IssueStatus.IN_PROGRESS);
//
//	Issue issueEight = new Issue("MTI-I-008-HS", "Unable to process views",
//				     Unit.ADMINISTRATION,
//				     LocalDate.now().minusDays(5), null,
//				     "rodrick_luther", IssueStatus.IN_PROGRESS);
//
//	Issue issueNine = new Issue("MTI-I-009-LS",
//				    "No documentation of process is available",
//				    Unit.ADMINISTRATION, LocalDate.now(), null,
//				    "carry.luke", IssueStatus.OPEN);
//
//	Issue issueTen = new Issue("MTI-I-010-LS", "Poor connectivity",
//				   Unit.ADMINISTRATION,
//				   LocalDate.now().minusDays(5), null,
//				   "rodrick_luther", IssueStatus.IN_PROGRESS);
//
//	Issue issueEleven = new Issue("MTI-I-011-HS",
//				      "Payment failed, but amount deducted",
//				      Unit.PAYMENT,
//				      LocalDate.now().minusDays(35),
//				      LocalDate.now().minusDays(30),
//				      "elyse.chu", IssueStatus.CLOSED);
//
//	Issue issueTwelve = new Issue("MTI-I-012-HS",
//				      "Unable to update activity status",
//				      Unit.ADMINISTRATION,
//				      LocalDate.now().minusDays(20), null,
//				      "carry.luke", IssueStatus.IN_PROGRESS);
//
//	Collections.addAll(issueList, issueOne, issueTwo, issueThree, issueFour,
//			   issueFive, issueSix, issueSeven, issueEight,
//			   issueNine, issueTen, issueEleven, issueTwelve);
    }

    @Override
    public List<Issue> getIssueList()
    {
	return issueList;
    }

    @Override
    public void setIssueList(List<Issue> issueList)
    {
	this.issueList = issueList;
    }

    /**
     * @params
     *         issue - The new issue to be added
     * 
     * @operation Stores a new issue in the issueList
     * 
     * @returns
     *          String - The issue id
     */
    @Override
    public String reportAnIssue(Issue issue)
    {
	String issueId = issue.getIssueId();

	List<String> issueNumberList = issueList.parallelStream()
						.map(existingIssue -> existingIssue.getIssueId()
										   .split("-")[2])
						.collect(Collectors.toList());

	if (issueNumberList.contains(issueId.split("-")[2]))
	{
	    return null;
	}
	else
	{
	    this.issueList.add(issue);

	    return issueId;
	}
    }

    /**
     * @params
     *         issue - The issue to be updated
     *         status - The new status
     * 
     * @operation Updates the status of the given issue
     *            with the given status
     */

    @Override
    public void updateStatus(Issue issue, IssueStatus status)
    {
	issue.setStatus(status);

	if (!(IssueStatus.OPEN.equals(status)
	      || IssueStatus.IN_PROGRESS.equals(status)))
	{
	    issue.setUpdatedOn(LocalDate.now());
	}
    }

    /**
     * @params
     *         issueId - The issue id to be fetched
     * 
     * @operation Fetches the issue object based on the given issue id
     * 
     * @returns
     *          Issue - The fetched issue object
     */
    @Override
    public Issue getIssueById(String issueId)
    {
	return issueList.parallelStream()
			.filter(issue -> issue.getIssueId().equals(issueId))
			.findFirst()
			.orElse(null);
    }
}