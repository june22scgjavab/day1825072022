package com.verification;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ReportGenerator
{
    private static Map<String, Map<String, Map<String, List<Integer>>>> overallReport;
    private static Map<String, Map<String, Map<String, List<TestCaseReport>>>> detailedReport;

    public static void generateReports(List<TestCaseReport> testCaseReportList)
    {
	overallReport = null;
	detailedReport = null;

	generateOverallReport(testCaseReportList);
	generateDetailedReport(testCaseReportList);

	writeReports();
    }

    private static void generateOverallReport(List<TestCaseReport> testCaseReportList)
    {
	Map<String, Map<String, List<Integer>>> groupWiseReport;
	Map<String, List<Integer>> classWiseReport;
	List<Integer> testCaseCount;

	for (TestCaseReport testCaseReport : testCaseReportList)
	{
	    if (overallReport == null)
	    {
		overallReport = new HashMap<>();
	    }

	    groupWiseReport = overallReport.get(testCaseReport.cadre);

	    if (groupWiseReport == null)
	    {
		groupWiseReport = new HashMap<>();
	    }

	    classWiseReport = groupWiseReport.get(testCaseReport.group);

	    if (classWiseReport == null)
	    {
		classWiseReport = new HashMap<>();
	    }

	    testCaseCount = classWiseReport.get(testCaseReport.testClass);

	    if (testCaseCount == null)
	    {
		testCaseCount = new ArrayList<>();
		Collections.addAll(testCaseCount, 0, 0, 0);
	    }

	    testCaseCount.set(0, testCaseCount.get(0) + 1);

	    if ("Pass".equals(testCaseReport.result))
	    {
		testCaseCount.set(1, testCaseCount.get(1) + 1);
	    }
	    else if ("Fail".equals(testCaseReport.result))
	    {
		testCaseCount.set(2, testCaseCount.get(2) + 1);
	    }

	    classWiseReport.put(testCaseReport.testClass, testCaseCount);
	    groupWiseReport.put(testCaseReport.group, classWiseReport);
	    overallReport.put(testCaseReport.cadre, groupWiseReport);
	}
    }

    private static void generateDetailedReport(List<TestCaseReport> testCaseReportList)
    {
	Map<String, Map<String, List<TestCaseReport>>> groupWiseReport;
	Map<String, List<TestCaseReport>> classWiseReport;
	List<TestCaseReport> testCaseList;

	for (TestCaseReport testCaseReport : testCaseReportList)
	{
	    if (detailedReport == null)
	    {
		detailedReport = new HashMap<>();
	    }

	    groupWiseReport = detailedReport.get(testCaseReport.cadre);

	    if (groupWiseReport == null)
	    {
		groupWiseReport = new HashMap<>();
	    }

	    classWiseReport = groupWiseReport.get(testCaseReport.group);

	    if (classWiseReport == null)
	    {
		classWiseReport = new HashMap<>();
	    }

	    testCaseList = classWiseReport.get(testCaseReport.testClass);

	    if (testCaseList == null)
	    {
		testCaseList = new ArrayList<>();
	    }

	    testCaseList.add(testCaseReport);
	    classWiseReport.put(testCaseReport.testClass, testCaseList);
	    groupWiseReport.put(testCaseReport.group, classWiseReport);
	    detailedReport.put(testCaseReport.cadre, groupWiseReport);
	}
    }

    private static String getReportAsJSON(Map report)
    {
	Gson gson = new GsonBuilder().setPrettyPrinting()
				     .disableHtmlEscaping()
				     .create();

	return gson.toJson(report);
    }

    private static void writeReports()
    {
    	try (FileWriter overallReportFile = new FileWriter("OverallReport.json");FileWriter detailedReportFile = new FileWriter("DetailedReport.json"))
		
    	{
    		overallReportFile.write(getReportAsJSON(overallReport));
    	    detailedReportFile.write(getReportAsJSON(detailedReport));
    	}
	catch (Exception exception)
	{
	    System.err.println("Report file(s) cannot be created or written!");
	    System.err.println(exception.getMessage());
	}
    }
}