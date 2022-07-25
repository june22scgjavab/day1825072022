package com.verification;

public class DescriptiveAnnotationNotFoundException extends Exception
{
    private static final long serialVersionUID = -1405155752478784443L;

    public DescriptiveAnnotationNotFoundException(String exceptionMessage)
    {
	super(exceptionMessage);
    }
}