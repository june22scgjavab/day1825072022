package com.issuetracker.service;

import java.util.List;
import java.util.Map;

import com.issuetracker.exception.IssueTrackerException;
import com.issuetracker.model.Issue;
import com.issuetracker.model.IssueReport;
import com.issuetracker.model.IssueStatus;

public interface IssueService
{
    public abstract String reportAnIssue(Issue issue) throws IssueTrackerException;

    public abstract Boolean updateStatus(String issueId,
					 IssueStatus status) throws IssueTrackerException;

    public abstract List<IssueReport> showIssues(Map<Character, Object> filterCriteria) throws IssueTrackerException;

    public abstract List<Issue> deleteIssues() throws IssueTrackerException;
    
}