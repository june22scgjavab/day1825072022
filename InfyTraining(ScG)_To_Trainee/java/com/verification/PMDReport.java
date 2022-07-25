package com.verification;

import java.util.List;

public class PMDReport
{
    public Integer formatVersion;
    public String pmdVersion;
    public String timestamp;
    public List<PMDReportFile> files;
    public List<PMDReportFile> suppressedViolations;
    public List processingErrors;
    public List configurationErrors;
}