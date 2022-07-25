package com.verification;

import java.util.ArrayList;
import java.util.List;

import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.engine.TestExecutionResult.Status;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;
import org.junit.platform.launcher.TestPlan;

public class VerificationListener implements TestExecutionListener
{
    private List<TestCaseReport> testCaseReportList;

    private TestCaseReport testCaseReport;

    Boolean isDescriptive = null;

    @Override
    public void testPlanExecutionStarted(TestPlan testPlan)
    {
	try
	{
	    isDescriptive = DescriptiveCheck.isDescriptive();

	    if (isDescriptive == null)
	    {
		throw new DescriptiveAnnotationNotFoundException("The Descriptive annotation is not found! Please provide the same in any one of the test classes");
	    }

	    testCaseReportList = new ArrayList<>();
	}
	catch (DescriptiveAnnotationNotFoundException descriptiveAnnotationNotFoundException)
	{
	    System.err.println(String.format("ERROR: %s",
					     descriptiveAnnotationNotFoundException.getMessage()));
	}
    }

    @Override
    public void executionStarted(TestIdentifier testIdentifier)
    {
	if (testIdentifier.isTest())
	{
	    String displayName = testIdentifier.getDisplayName();

	    testCaseReport = new TestCaseReport();

	    testCaseReport.cadre = displayName.matches("^[E]?[STC].*$") ? "Structural"
									: "Logical";

	    testCaseReport.group = !testIdentifier.getTags()
						  .isEmpty() ? testIdentifier.getTags()
									     .iterator()
									     .next()
									     .getName()
							     : null;

	    testCaseReport.testClass = displayName.split("^[E]?[SL]TC[0-9]*-")[1].split("[.]")[0];

	    testCaseReport.testCaseId = displayName.split("[ ][|][ ]")[0];

	    testCaseReport.testCaseName = displayName.split("[ ][|][ ]")[1];

	    if (Boolean.TRUE.equals(isDescriptive))
	    {
		String[] displayNameChunks = displayName.split("[ ][|][ ]");

		testCaseReport.testCaseDescription = (displayNameChunks.length == 3)
						     && (!"null".equals(displayNameChunks[2])) ? displayNameChunks[2]
											       : null;
	    }
	}
    }

    @Override
    public void executionFinished(TestIdentifier testIdentifier,
				  TestExecutionResult testExecutionResult)
    {
	if (testIdentifier.isTest())
	{
	    if (Status.SUCCESSFUL.equals(testExecutionResult.getStatus()))
	    {
		testCaseReport.result = "Pass";
	    }
	    else if (Status.FAILED.equals(testExecutionResult.getStatus()))
	    {
		testCaseReport.result = "Fail";

		if (Boolean.TRUE.equals(isDescriptive))
		{
		    testExecutionResult.getThrowable()
				       .ifPresent(throwable -> testCaseReport.reasonForFailure = throwable.toString());
		}
	    }

	    testCaseReportList.add(testCaseReport);
	}
    }

    @Override
    public void testPlanExecutionFinished(TestPlan testPlan)
    {
	ReportGenerator.generateReports(testCaseReportList);
    }
}