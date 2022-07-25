package com.infytraining.service;



import java.util.ArrayList;
import java.util.List;

import com.infytraining.dao.InfyTrainingDAO;
import com.infytraining.dao.InfyTrainingDAOImpl;
import com.infytraining.exception.InfyTrainingException;
import com.infytraining.model.Trainee;
import com.infytraining.model.TraineeReport;
import com.infytraining.validator.Validator;

public class InfyTrainingServiceImpl implements InfyTrainingService {
	
	private InfyTrainingDAO infyTrainingDAO= new InfyTrainingDAOImpl();
	
	private Validator validator=new Validator();
	
	@Override
	public String addTrainee(Trainee trainee) throws InfyTrainingException {
		validator.validate(trainee);	
		trainee.setMailId(generateMailId(trainee.getTraineeName()));
		return infyTrainingDAO.addTrainee(trainee);
	}

	/*
	 * DO NOT CHANGE METHOD SIGNATURE
	 * DO NOT DELETE/COMMENT METHOD
	 */
	@Override
	public String generateMailId(String traineeName){
		String[] arr=traineeName.split(" ");
		String lastPart=arr[arr.length-1].toLowerCase();
		String firstPart=arr[0].toLowerCase();
		
		return firstPart+"_"+lastPart;
	}
	/*
	 * DO NOT CHANGE METHOD SIGNATURE
	 * DO NOT DELETE/COMMENT METHOD
	 */
	@Override
	public List<TraineeReport> generateTraineeReport(String idProof) throws InfyTrainingException{
		List<TraineeReport> report=new ArrayList<>();
		List<Trainee> trainees=infyTrainingDAO.getAllTraineeDetails();
		for(Trainee trainee : trainees) {
			if(trainee.getIdProof().equalsIgnoreCase(idProof)) {
				TraineeReport traineeReport=new TraineeReport(trainee.getTraineeName(),trainee.getDateOfJoining(),trainee.getContactNumber());
				report.add(traineeReport);
				
			}
		}
	    if(report.isEmpty())
	    {
	    	 throw new InfyTrainingException("TraineeService.NO_RECORDS_FOUND");
	    }
		return report;
	
	}

}
