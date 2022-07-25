package com.verification.logical;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.infy.model.ServiceRequest;
import com.infy.model.Status;
import com.infy.service.MobileServiceImpl;
import com.infy.validator.Validator;



@Tag("Logging")
class LoggingVerification
{
    private String logFilePath;

    @BeforeEach
    void clearLogFile() throws FileNotFoundException, IOException
    {
	Properties properties = new Properties();
	properties.load(new FileReader("src/main/resources/log4j2.properties"));

	logFilePath = properties.getProperty("appender.file.fileName");

	try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(logFilePath)))
	{
	    writer.write("");
	    writer.flush();
	}
    }

    @Test
    @DisplayName("ELTC1-Logger.validatorLogging | Verifying that logging is done | Expecting exact exceptions to be logged in Validator")
    void validatorLogging() throws IOException
    {
    Boolean flag = false;
	try
	{
	    new Validator().validate(new ServiceRequest("Brand", Arrays.asList("BatTery"), 0000000000L,"Chap Chow",9988998899889988L));
	}
	catch (Exception exception)
	{
	    List<String> logs = Files.readAllLines(Paths.get(logFilePath));

	    Assertions.assertNotEquals(0, logs.size());

	  

	    for (String log : logs)
	    {
		if (log.contains("Validator.INVALID_CONTACT_NUMBER"))
		{
		    flag = true;
		    break;
		}
	    }

	}
	Assertions.assertTrue(flag);
	
    }

    @Test
    @DisplayName("ELTC2-Logger.serviceLogging | Verifying that logging is done | Expecting exact exceptions to be logged in MobileServiceImpl")
    void serviceLogging() throws IOException
    {
    Boolean flag = false;
	try
	{
	    new MobileServiceImpl().getServices(Status.REJECTED);
	}
	catch (Exception exception)
	{
	    List<String> logs = Files.readAllLines(Paths.get(logFilePath));

	    Assertions.assertNotEquals(0, logs.size());


	    for (String log : logs)
	    {
		if (log.contains("ERROR - Service.NO_RECORDS_FOUND"))
		{
		    flag = true;
		    break;
		}
	    }

	  
	}
	  Assertions.assertTrue(flag);
    }

    @Test
    @DisplayName("ELTC3-Logger.serviceLogging | Verifying that logging is done | Expecting Validator exceptions to be not logged in MobileServiceImpl")
    void serviceLogging$NoValidatorExceptions() throws IOException
    { 
    Integer flag = 0;
	try
	{
	    new MobileServiceImpl().registerRequest(new ServiceRequest("Brand", Arrays.asList(), 0000000001L,"Chap Chow",99889988998899L));
	}
	catch (Exception exception)
	{
	    List<String> logs = Files.readAllLines(Paths.get(logFilePath));

	    Assertions.assertNotEquals(0, logs.size());

	   

	    for (String log : logs)
	    {
		if (log.contains("ERROR - Validator.INVALID_NO_OF_ISSUES"))
		{
		    flag++;
		}
	    }
	}

	    Assertions.assertEquals(1, flag);
	
    }
}