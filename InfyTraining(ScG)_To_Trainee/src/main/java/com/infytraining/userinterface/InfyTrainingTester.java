package com.infytraining.userinterface;

import java.time.LocalDate;
import java.util.List;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.infytraining.exception.InfyTrainingException;
import com.infytraining.model.Trainee;
import com.infytraining.model.TraineeReport;
import com.infytraining.service.InfyTrainingServiceImpl;

public class InfyTrainingTester {
	private static InfyTrainingServiceImpl infyTrainingServiceImpl;

	private static PropertiesConfiguration propertiesConfiguration;

	private static final Log LOG = LogFactory.getLog(InfyTrainingTester.class);

	public static void main(String[] args) throws ConfigurationException{
		infyTrainingServiceImpl=new InfyTrainingServiceImpl();
		propertiesConfiguration=new Configurations().properties("configuration.properties");
		addTrainee();
		//generateTraineeDetails();
	}

	public static void addTrainee() {
		Trainee trainee = new Trainee("John Paul",LocalDate.of(2022, 7, 24) ,"Passport","john_paul" ,9876340976L);
		String mailId = null;
		try {
			mailId = infyTrainingServiceImpl.addTrainee(trainee);
			if (mailId!=null) {
				LOG.info("\n"+mailId+" "+propertiesConfiguration.getProperty("Tester.SUCCESS"));
			}
		} catch (InfyTrainingException ee) {
			 	LOG.info("\n");
				LOG.info("\n\t\t" + propertiesConfiguration.getProperty(ee.getMessage()));
		}
	}

	
	//Uncomment the below code after creating TraineeReport class
	public static void generateTraineeDetails() {
		
	
		try {
			List<TraineeReport> allTrainees =infyTrainingServiceImpl.generateTraineeReport("pasport");

			LOG.info("\n");
			allTrainees = infyTrainingServiceImpl.generateTraineeReport("Aadhar");
			LOG.info("  Infy Trainee Management  ");
			LOG.info("**************************");
			LOG.info("Trainee Name\t\tDate of Joining\t\tContact No.");
			LOG.info("------------------------------------------------------------------------------------");
			for (TraineeReport report : allTrainees) {
				LOG.info(report.getTraineeName()+"\t\t"+report.getDateOfJoining()+"\t\t"+report.getContactNumber());
			}
			
		} catch (InfyTrainingException ee) {
			LOG.info("\t"+propertiesConfiguration.getProperty(ee.getMessage()));
		}
	}

}
