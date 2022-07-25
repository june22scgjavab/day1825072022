package com.infytraining.service;

import java.util.List;

import com.infytraining.exception.InfyTrainingException;
import com.infytraining.model.Trainee;
import com.infytraining.model.TraineeReport;

public interface InfyTrainingService {
	public String addTrainee(Trainee trainee) throws InfyTrainingException ;
	public String generateMailId(String traineeName);
	public List<TraineeReport> generateTraineeReport(String idProof) throws InfyTrainingException ;
	

}
