package com.issuetracker.service;

import java.util.List;

import com.issuetracker.dao.AssigneeDAO;

import com.issuetracker.model.Assignee;
import com.issuetracker.model.Unit;

public class AssigneeServiceImpl implements AssigneeService
{
    private AssigneeDAO assigneeDAO;

    /**
     * @params
     *         unit - The assignee unit
     * 
     * @operation Fetches the assignees list for the given unit
     * 
     * @returns
     *          List<Assignee> - List of assignees fetched
     */
    @Override
    public List<Assignee> fetchAssignee(Unit unit) 
    {
	// Your Code Goes Here

	return null;
    }

    /**
     * @params
     *         assigneeEmail - The assignee email id
     *         operation - The operation code
     * 
     * @operation Updates the active issues count for the given assignee email,
     *            by incrementing or decrementing it based on the operation code
     * 
     */
    @Override
    public void updateActiveIssueCount(String assigneeEmail,
				       Character operation)
    {
	// Your Code Goes Here
    }
}