package com.verification;

import java.io.IOException;

import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;
import com.google.common.reflect.ClassPath.ClassInfo;

public class DescriptiveCheck
{
    public static Boolean isDescriptive()
    {
	Boolean isDescriptive = null;

	try
	{
	    ImmutableSet<ClassInfo> structuralClassInfos = ClassPath.from(DescriptiveCheck.class.getClassLoader())
								    .getTopLevelClasses("com.verification.structural");

	    for (ClassInfo structuralClassInfo : structuralClassInfos)
	    {
		Class structuralTestClass = Class.forName(structuralClassInfo.getName(),
							  false,
							  DescriptiveCheck.class.getClassLoader());

		Descriptive descriptiveAnnotation = (Descriptive) structuralTestClass.getAnnotation(Descriptive.class);

		if (descriptiveAnnotation != null)
		{
		    isDescriptive = descriptiveAnnotation.value();
		    break;
		}
	    }

	    ImmutableSet<ClassInfo> logicalClassInfos = ClassPath.from(DescriptiveCheck.class.getClassLoader())
								 .getTopLevelClasses("com.verification.logical");

	    for (ClassInfo logicalClassInfo : logicalClassInfos)
	    {
		Class logicalTestClass = Class.forName(logicalClassInfo.getName(),
						       false,
						       DescriptiveCheck.class.getClassLoader());

		Descriptive descriptiveAnnotation = (Descriptive) logicalTestClass.getAnnotation(Descriptive.class);

		if (descriptiveAnnotation != null)
		{
		    isDescriptive = descriptiveAnnotation.value();
		    break;
		}
	    }
	}
	catch (ClassNotFoundException classNotFoundException)
	{
	    System.err.println("ERROR: An unexpected ClassNotFoundException is thrown during DescriptiveCheck!");
	    classNotFoundException.printStackTrace();
	}
	catch (IOException ioException)
	{
	    System.err.println("ERROR: An unexpected IOException is thrown during DescriptiveCheck!");
	    ioException.printStackTrace();
	}

	return isDescriptive;
    }
}