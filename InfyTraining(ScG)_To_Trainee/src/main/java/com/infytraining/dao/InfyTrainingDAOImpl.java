package com.infytraining.dao;

import java.time.LocalDate;
import java.util.List;

import com.infytraining.model.Trainee;

public class InfyTrainingDAOImpl implements InfyTrainingDAO {

	private List<Trainee> traineeList = null;

	public InfyTrainingDAOImpl() {

		Trainee trainee1 = new Trainee("Rohan Tripati", LocalDate.of(2014, 9, 21), "Passport",
				"rohan_tripati@gmail.com", 9632201234L);

		Trainee trainee2 = new Trainee("Lathika Nayer", LocalDate.of(2015, 7, 2), "Passport", "lathika@gmail.com",
				9821873653L);

		Trainee trainee3 = new Trainee("Deepika Das", LocalDate.of(2016, 6, 29), "Aadhar", "deepika@gmail.com",
				854379933L);

		Trainee trainee4 = new Trainee("Aditi Das", LocalDate.of(2017, 10, 9), "Aadhar", "aditi@gmail.com",
				7738487333L);

		Trainee trainee5 = new Trainee("Amit Khan", LocalDate.of(2018, 9, 9), "Pan Card", "amit@gmail.com",
				9938567777L);

		traineeList = List.of(trainee1, trainee2, trainee3, trainee4, trainee5);

	}

	@Override
	public String addTrainee(Trainee trainee) {
		return trainee.getMailId();
	}

	@Override
	public List<Trainee> getAllTraineeDetails() {
		return traineeList;
	}

}
