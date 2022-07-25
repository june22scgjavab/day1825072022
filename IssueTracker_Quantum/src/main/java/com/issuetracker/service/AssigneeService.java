package com.issuetracker.service;

import java.util.List;

import com.issuetracker.model.Assignee;
import com.issuetracker.model.Unit;

public interface AssigneeService
{
    public abstract List<Assignee> fetchAssignee(Unit unit);

    public abstract void updateActiveIssueCount(String assigneeEmail,
						Character operation);
}