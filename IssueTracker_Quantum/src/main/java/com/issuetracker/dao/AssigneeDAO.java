package com.issuetracker.dao;

import java.util.List;

import com.issuetracker.model.Assignee;
import com.issuetracker.model.Unit;

public interface AssigneeDAO
{
    public abstract List<Assignee> fetchAssignees(Unit unit) ;

    public abstract Assignee getAssigneeByEmail(String assigneeEmail);
}