package com.infytraining.test;


import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.infytraining.exception.InfyTrainingException;
import com.infytraining.model.Trainee;
import com.infytraining.service.InfyTrainingService;
import com.infytraining.service.InfyTrainingServiceImpl;

public class InfyTrainingServiceTest {
// In the below testcase we first created an object of Trainee with invalid date
// With assertThrows we are getting an object of InfyTrainingException when infyTraineeService.addTrainee(trainee) is called inside assertThrows 
// With assertEqual we are checking the The string returned , The expected String is Validator.INVALID_DATEOFJOINING
	 private InfyTrainingService infyTrainingService= new InfyTrainingServiceImpl();
	
   @Test
	public void addTraineeInvalidDateOfJoiningTest() throws InfyTrainingException{
		Trainee trainee = new Trainee("John Paul",LocalDate.of(2021, 7, 14) ,"Passport","john_paul" ,9876340976L);
		InfyTrainingException exception=Assertions.assertThrows(InfyTrainingException.class,()->infyTrainingService.addTrainee(trainee));
        Assertions.assertEquals("Validator.INVALID_DATEOFJOINING", exception.getMessage());
	}
   @Test
	public void generateTraineeReportNoRecordsFoundTest() throws InfyTrainingException {
		
		InfyTrainingException exception=Assertions.assertThrows(InfyTrainingException.class,()->infyTrainingService.generateTraineeReport("abc"));
        Assertions.assertEquals("TraineeService.NO_RECORDS_FOUND", exception.getMessage());
		
	}

}
