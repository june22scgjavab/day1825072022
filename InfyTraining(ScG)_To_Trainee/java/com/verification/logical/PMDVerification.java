package com.verification.logical;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.verification.PMDReport;
import com.verification.PMDReportFile;
import com.verification.PMDReportViolation;

import net.sourceforge.pmd.PMD;
import net.sourceforge.pmd.PMDConfiguration;

@Tag("PMD")
class PMDVerification
{
    @Test
    @DisplayName("ELTC1-PMD.analyseCode | Verifying the code for adherence to coding standards")
    void analyseCode() throws IOException
    {
	String sourceCodePath = new File("src/").getAbsolutePath();
	String ruleSetPath = new File("src/verification/resources/RuleSet_v6.23.0.xml").getAbsolutePath();
	String reportFormat = "json";

	PrintStream originalOutputStream = System.out;
	ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	System.setOut(new PrintStream(outputStream));

	PMDConfiguration pmdConfiguration = new PMDConfiguration();
	pmdConfiguration.setInputPaths(sourceCodePath);
	pmdConfiguration.setRuleSets(ruleSetPath);
	pmdConfiguration.setReportFormat(reportFormat);
	pmdConfiguration.setShowSuppressedViolations(true);

	PMD.doPMD(pmdConfiguration);

	System.setOut(originalOutputStream);
	outputStream.close();

	PMDReport pmdReport = new Gson().fromJson(outputStream.toString(),
						  PMDReport.class);

	assertTrue(pmdReport.files.isEmpty(),
		   String.format(pmdReport.files.size() == 1 ? "%d file contains violation(s)! %s"
							     : "%d files contain violation(s)! %s",
				 pmdReport.files.size(),
				 violationMessageGenerator(pmdReport.files)));

	assertTrue(pmdReport.suppressedViolations.isEmpty(),
		   String.format(pmdReport.suppressedViolations.size() == 1 ? "%d file contains suppressed violation(s)! %s"
									    : "%d files contain suppressed violation(s)! %s",
				 pmdReport.suppressedViolations.size(),
				 violationMessageGenerator(pmdReport.files)));
    }

    private String violationMessageGenerator(List<PMDReportFile> pmdReportFiles)
    {
	String violationMessages = "";

	for (PMDReportFile pmdReportFile : pmdReportFiles)
	{
	    Matcher matcher = Pattern.compile("([A-Z][a-zA-Z]*\\.java$)")
				     .matcher(pmdReportFile.filename);

	    if (matcher.find())
	    {
		violationMessages = violationMessages.concat("File Name: ")
						     .concat(matcher.group(1));
	    }

	    for (PMDReportViolation pmdReportViolation : pmdReportFile.violations)
	    {
		violationMessages = violationMessages.concat(" - ")
						     .concat(pmdReportViolation.rule)
						     .concat(" : ")
						     .concat(pmdReportViolation.description);

		if (pmdReportViolation.suppressiontype != null)
		{
		    violationMessages = violationMessages.concat(" : ")
							 .concat("Suppressed by ")
							 .concat(pmdReportViolation.suppressiontype);
		}
	    }

	    violationMessages = violationMessages.concat(" | ");
	}

	return violationMessages.strip();
    }
}