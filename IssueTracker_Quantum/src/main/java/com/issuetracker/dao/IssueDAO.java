package com.issuetracker.dao;

import com.issuetracker.model.Issue;
import com.issuetracker.model.IssueStatus;

import java.util.List;


public interface IssueDAO
{
    public abstract String reportAnIssue(Issue issue);

    public abstract void updateStatus(Issue issue, IssueStatus status);

    public abstract Issue getIssueById(String issueId);

    public abstract List<Issue> getIssueList();

    public abstract void setIssueList(List<Issue> issueList);
}