package com.ir.model;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;



@Entity
@Table(name="personalinformationtrainee")
public class PersonalInformationTrainee {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "PERSONALINFOTRAINEE_SEQ", allocationSize=1, initialValue=1)
	private int id;
	

	/*private String userType;*/
	
	/*@NotNull
	@Size(min=1, max=50 , message="Select Induction Trainee")
	private String inductionTrainee;*/
	
	@OneToOne (cascade=CascadeType.ALL)  @JoinColumn(name="loginDetails")
	private LoginDetails loginDetails;
	
	
	private String logId;
	
	private String userId;
	private String qualificationCategory;
	private String qsubCategory;
	private String other1;
	private String other2;
	private String other3;
	private String employerCategory;
	private String currentOrganization;
	private String designation;
	private String jobDescription;
	private String trProgram;
	private int expInYear;
	private int expInMonth;
	private int rexpInYear;
	private int rexpInMonth;
	
	
	public String getOther3() {
		return other3;
	}

	public void setOther3(String other3) {
		this.other3 = other3;
	}

	public String getEmployerCategory() {
		return employerCategory;
	}

	public void setEmployerCategory(String employerCategory) {
		this.employerCategory = employerCategory;
	}

	public String getCurrentOrganization() {
		return currentOrganization;
	}

	public void setCurrentOrganization(String currentOrganization) {
		this.currentOrganization = currentOrganization;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getTrProgram() {
		return trProgram;
	}

	public void setTrProgram(String trProgram) {
		this.trProgram = trProgram;
	}

	public int getRexpInYear() {
		return rexpInYear;
	}

	public void setRexpInYear(int rexpInYear) {
		this.rexpInYear = rexpInYear;
	}

	public int getRexpInMonth() {
		return rexpInMonth;
	}

	public void setRexpInMonth(int rexpInMonth) {
		this.rexpInMonth = rexpInMonth;
	}

	public int getExpInYear() {
		return expInYear;
	}

	public void setExpInYear(int expInYear) {
		this.expInYear = expInYear;
	}

	public int getExpInMonth() {
		return expInMonth;
	}

	public void setExpInMonth(int expInMonth) {
		this.expInMonth = expInMonth;
	}

	public String getQualificationCategory() {
		return qualificationCategory;
	}

	public void setQualificationCategory(String qualificationCategory) {
		this.qualificationCategory = qualificationCategory;
	}

	public String getQsubCategory() {
		return qsubCategory;
	}

	public void setQsubCategory(String qsubCategory) {
		this.qsubCategory = qsubCategory;
	}

	public String getOther1() {
		return other1;
	}

	public void setOther1(String other1) {
		this.other1 = other1;
	}

	public String getOther2() {
		return other2;
	}

	public void setOther2(String other2) {
		this.other2 = other2;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLogId() {
		return logId;
	}

	public void setLogId(String logId) {
		this.logId = logId;
	}

	public LoginDetails getLoginDetails() {
		return loginDetails;
	}

	public void setLoginDetails(LoginDetails loginDetails) {
		this.loginDetails = loginDetails;
	}
/*
	private String empID;
	
	
	
	 public String getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}*/

	private String title;
	
	
	@NotNull
	
	@Size(min=1, max=50 , message="enter your FirstName")
	private String firstName;

	private String MiddleName;
	@NotNull
	@Size(min=1, max=50 , message="enter your LastName ")
	private String  LastName ;

	/*@NotNull
	@Size(min=1, max=100 , message="enter your father's name")
	private String FatherName;*/
	
	
	
	@NotNull
	@Size(min=12, max=12 , message="enter your AadharNumber ")
	@Column(unique = true)
	private String  AadharNumber ; 
	 @Email
	private String Email;
	@NotNull
	private String dob;

	@Size(max=10 , message = "enter your mobile Number")
	private String mobile;
	@NotNull
	private String gender;
	@NotNull 
	private int profileCode;
	@NotNull
	@Size(min=1, max=100 , message="enter your ResidentialAddress1 ")
	private String ResidentialLine1;

	private String ResidentialLine2;
/*	
	

	
	private String resState;

	
	private String resCity;
	
	@NotNull
	@Size(min=1, max=6 , message="enter your Pincode")
	private String resPincode;
	@NotNull
	@Size(min=1, max=100 , message="enter your correspondenceAddress1")
	private String correspondenceAddress1;
	@NotNull
	@Size(min=1, max=100 , message="enter your correspondenceAddress1")
	private String correspondenceAddress2;*/

	
	private String correspondenceState;
	
	private String correspondenceCity;
	/*@NotNull @Size(min=6, max=6 , message="* enter your correspondencePincode ")
	private String correspondencePincode;


	private String residentialDistrict;*/
	

	@NotNull
	private String correspondenceDistrict;

	
	
/*
	@Transient
	private boolean checkCorrespondence;
	*/
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return MiddleName;
	}

	public void setMiddleName(String middleName) {
		this.MiddleName = middleName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		this.LastName = lastName;
	}

/*	public String getFatherName() {
		return FatherName;
	}

	public void setFatherName(String fatherName) {
		this.FatherName = fatherName;
	}
*/


	public String getAadharNumber() {
		return AadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.AadharNumber = aadharNumber;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		this.Email = email;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getProfileCode() {
		return profileCode;
	}

	public void setProfileCode(int profileCode) {
		this.profileCode = profileCode;
	}

	public String getResidentialLine1() {
		return ResidentialLine1;
	}

	public void setResidentialLine1(String residentialLine1) {
		this.ResidentialLine1 = residentialLine1;
	}

	public String getResidentialLine2() {
		return ResidentialLine2;
	}

	public void setResidentialLine2(String residentialLine2) {
		this.ResidentialLine2 = residentialLine2;
	}

	/*public String getResState() {
		return resState;
	}

	public void setResState(String resState) {
		this.resState = resState;
	}

	public String getResCity() {
		return resCity;
	}

	public void setResCity(String resCity) {
		this.resCity = resCity;
	}

	public String getResPincode() {
		return resPincode;
	}

	public void setResPincode(String resPincode) {
		this.resPincode = resPincode;
	}

	public String getCorrespondenceAddress1() {
		return correspondenceAddress1;
	}

	public void setCorrespondenceAddress1(String correspondenceAddress1) {
		this.correspondenceAddress1 = correspondenceAddress1;
	}*/

/*	public String getCorrespondenceAddress2() {
		return correspondenceAddress2;
	}

	public void setCorrespondenceAddress2(String correspondenceAddress2) {
		this.correspondenceAddress2 = correspondenceAddress2;
	}*/

	public String getCorrespondenceState() {
		return correspondenceState;
	}

	public void setCorrespondenceState(String correspondenceState) {
		this.correspondenceState = correspondenceState;
	}

	public String getCorrespondenceCity() {
		return correspondenceCity;
	}

	public void setCorrespondenceCity(String correspondenceCity) {
		this.correspondenceCity = correspondenceCity;
	}

	/*public String getCorrespondencePincode() {
		return correspondencePincode;
	}

	public void setCorrespondencePincode(String correspondencePincode) {
		this.correspondencePincode = correspondencePincode;
	}*/

	/*public String getResidentialDistrict() {
		return residentialDistrict;
	}

	public void setResidentialDistrict(String residentialDistrict) {
		this.residentialDistrict = residentialDistrict;
	}
*/
	public String getCorrespondenceDistrict() {
		return correspondenceDistrict;
	}

	public void setCorrespondenceDistrict(String correspondenceDistrict) {
		this.correspondenceDistrict = correspondenceDistrict;
	}

/*		public boolean isCheckCorrespondence() {
		return checkCorrespondence;
	}

	public void setCheckCorrespondence(boolean checkCorrespondence) {
		this.checkCorrespondence = checkCorrespondence;
	}
	*/
	private int steps;

	public int getSteps() {
		return steps;
	}

	public void setSteps(int steps) {
		this.steps = steps;
	}
	
	private String Status;
	
	

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	@Override
	public String toString() {
		return "PersonalInformationTrainee [id=" + id + ", FirstName=" + firstName + ", mobile=" + mobile +  ", Email="+Email +" , AadharNumber="+AadharNumber+   "]";
	}
	
}
