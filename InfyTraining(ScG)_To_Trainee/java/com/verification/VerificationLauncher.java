package com.verification;

import static org.junit.platform.engine.discovery.DiscoverySelectors.selectPackage;

import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;

public class VerificationLauncher
{
    public static Boolean isDescriptive;

    public static void main(String[] args) throws DescriptiveAnnotationNotFoundException
    {
	isDescriptive = DescriptiveCheck.isDescriptive();

	if (isDescriptive == null)
	{
	    throw new DescriptiveAnnotationNotFoundException("The Descriptive annotation is not found! Please provide the same in any one of the test classes");
	}

	LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
									  .selectors(selectPackage("com.verification"))
									  .build();

	VerificationListener listener = new VerificationListener();

	Launcher launcher = LauncherFactory.create();

	launcher.registerTestExecutionListeners(listener);

	launcher.execute(request);
    }
}