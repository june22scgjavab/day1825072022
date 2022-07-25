package com.infytraining.validator;

import java.time.LocalDate;

import org.apache.commons.logging.LogFactory;

import com.infytraining.exception.InfyTrainingException;
import com.infytraining.model.Trainee;

public class Validator {
	/*
	 * DO NOT CHANGE METHOD SIGNATURE
	 * DO NOT DELETE/COMMENT METHOD
	 */

	public void validate(Trainee trainee) throws InfyTrainingException {
		try {
		String errMsg=null;
		if(!isValidContactNumber(trainee.getContactNumber())){
			errMsg="Validator.INVALID_CONTACTNUMBER";
		}else if(!isValidDateOfJoining(trainee.getDateOfJoining())){
			errMsg="Validator.INVALID_DATEOFJOINING";
		}else if(!isValidIdProof(trainee.getIdProof())){
			errMsg="Validator.INVALID_IDPROOF";
		}else if(!isValidTraineeName(trainee.getTraineeName())){
			errMsg="Validator.INVALID_TRAINEENAME";
		}
		if(errMsg!=null){
			
			InfyTrainingException ee=new InfyTrainingException(errMsg);
			
			throw ee;
		}
		}catch(InfyTrainingException infyTrainingException){
			LogFactory.getLog(Validator.class).error(infyTrainingException.getMessage(),infyTrainingException);
			throw infyTrainingException;
		}
	}

	/*
	 * DO NOT CHANGE METHOD SIGNATURE
	 * DO NOT DELETE/COMMENT METHOD
	 */
	public Boolean isValidIdProof(String idProof) {
		boolean isValidIdProof=true;
		if(!("Passport".equalsIgnoreCase(idProof) ||  "Pan Card".equalsIgnoreCase(idProof) || "Aadhar".equalsIgnoreCase(idProof))) {
			isValidIdProof=false;
		}
		return isValidIdProof;
	}

	
	/*
	 * DO NOT CHANGE METHOD SIGNATURE
	 * DO NOT DELETE/COMMENT METHOD
	 */
	public Boolean isValidDateOfJoining(LocalDate dateOfJoining) {
	     boolean isValidDateOfJoining=true;
	     LocalDate today=LocalDate.now();
		LocalDate TenDaysBefore=today.minusDays(10);
		if(!(dateOfJoining.isAfter(TenDaysBefore) && dateOfJoining.isBefore(LocalDate.now())  ||    dateOfJoining.equals((LocalDate.now())))  )
		{
			isValidDateOfJoining=false;
		}
		
		return isValidDateOfJoining;
		
	}
	
	/*
	 * DO NOT CHANGE METHOD SIGNATURE
	 * DO NOT DELETE/COMMENT METHOD
	 */
	public Boolean isValidTraineeName(String traineeName) {
		
		boolean isValidTraineeName=true;
		//String regex="JohnPaul";
		String regex="^(([^\\s]|[A-Z])[a-z]+)\\s([A-Z]([a-z]{1,}|[^\\s]))$";
		if(!traineeName.matches(regex)) {
			isValidTraineeName=false;
		}
		return isValidTraineeName;
	}


	/*
	 * DO NOT CHANGE METHOD SIGNATURE
	 * DO NOT DELETE/COMMENT METHOD
	 */
	public Boolean isValidContactNumber(Long contactNumber) {
		boolean isValidContactNumber=true;
		String contactNumberString=Long.toString(contactNumber);		
		String regex="^[6-9]\\d{9}$";
			if(!(contactNumberString.matches(regex)))
					{
				       isValidContactNumber=false;
					}
	   
	   return isValidContactNumber;
	}

}
