package com.ir.model;

public class ApplicationStatus {
	private String trainingName,trainingDate,noOfApplicants,numberOfVacancies;

	public String getNoOfApplicants() {
		return noOfApplicants;
	}

	public void setNoOfApplicants(String noOfApplicants) {
		this.noOfApplicants = noOfApplicants;
	}

	public String getNumberOfVacancies() {
		return numberOfVacancies;
	}

	public void setNumberOfVacancies(String numberOfVacancies) {
		this.numberOfVacancies = numberOfVacancies;
	}

	public String getTrainingName() {
		return trainingName;
	}

	public String getTrainingDate() {
		return trainingDate;
	}

	public void setTrainingDate(String trainingDate) {
		this.trainingDate = trainingDate;
	}

	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}
}
