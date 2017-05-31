package com.ir.form;

import javax.validation.constraints.NotNull;

public class ContactTrainee {
	
	private  String emailAddress;
	private String messageDetails;
	private String subject;
	private String queryCatagory;
	private String querySubCatagory;
	
	
	public String getQueryCatagory() {
		return queryCatagory;
	}
	public void setQueryCatagory(String queryCatagory) {
		this.queryCatagory = queryCatagory;
	}
	public String getQuerySubCatagory() {
		return querySubCatagory;
	}
	public void setQuerySubCatagory(String querySubCatagory) {
		this.querySubCatagory = querySubCatagory;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	private String userId;
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getMessageDetails() {
		return messageDetails;
	}
	public void setMessageDetails(String messageDetails) {
		this.messageDetails = messageDetails;
	}
	@Override
	public String toString() {
		return "ContactTrainee [emailAddress=" + emailAddress + ", messageDetails=" + messageDetails + "]";
	}
	public ContactTrainee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public static String[] split(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
