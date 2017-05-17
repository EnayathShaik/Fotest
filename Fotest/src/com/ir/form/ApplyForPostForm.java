package com.ir.form;

public class ApplyForPostForm {
	
    private int id;
    private String trainingCenter;
	private String courseName;
	private String trainingDate;
	private String district;
	private String vacancy;
	private String contactPerson;
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public String getVacancy() {
		return vacancy;
	}
	public void setVacancy(String vacancy) {
		this.vacancy = vacancy;
	}
	public String getCourseName() {
		return courseName;
	}
	public String getTrainingCenter() {
		return trainingCenter;
	}
	public void setTrainingCenter(String trainingCenter) {
		this.trainingCenter = trainingCenter;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getTrainingDate() {
		return trainingDate;
	}
	public void setTrainingDate(String trainingDate) {
		this.trainingDate = trainingDate;
	}
	
}
