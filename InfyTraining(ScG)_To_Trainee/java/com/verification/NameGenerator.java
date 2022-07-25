package com.verification;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayNameGenerator;

public class NameGenerator extends DisplayNameGenerator.Standard
{
    private Map<String, Integer> currentTestCaseIdMap = new HashMap<>();

    @Override
    public String generateDisplayNameForClass(Class<?> testClass)
    {
	if (testClass.getPackageName().endsWith("structural"))
	    return (testClass.getSimpleName().split("Verification")[0]
		    + " (Structural)");
	else if (testClass.getPackageName().endsWith("logical"))
	    return (testClass.getSimpleName().split("Verification")[0]
		    + " (Logical)");
	else
	    return super.generateDisplayNameForClass(testClass);
    }

    @Override
    public String generateDisplayNameForMethod(Class<?> testClass,
					       Method testMethod)
    {
	String testClassName = testClass.getSimpleName()
					.split("Verification")[0];

	currentTestCaseIdMap.compute(testClassName,
				     (key, value) -> (value == null) ? 1
								     : ++value);

	Integer currentTestCaseId = currentTestCaseIdMap.get(testClassName);

	String displayName = "TC" + currentTestCaseId + "-" + testClassName
			     + "." + testMethod.getName().split("[$]")[0]
			     + " | ";

	if (testClass.getPackageName().endsWith("structural"))
	{
	    displayName = "S".concat(displayName);

	    displayName += "Verifying the structure of "
			   + testMethod.getName().split("[$]")[0];
	}
	else if (testClass.getPackageName().endsWith("logical"))
	{
	    displayName = "L".concat(displayName);

	    displayName += "Verifying the functionality of "
			   + testMethod.getName().split("[$]")[0];
	}
	else
	    displayName += super.generateDisplayNameForMethod(testClass,
							      testMethod);

	return displayName;
    }
}