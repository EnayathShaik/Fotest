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
@Table(name="personalinformationtrainer")
public class PersonalInformationTrainer {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "PERSONALINFOTRAINEE_SEQ", allocationSize=1, initialValue=1)
	private int id;
	

	private String userId;
	

	
	private String areaSpecialization;
	
	private int trRxpInMonth;
	private int trExpInYear;
	private int assExpInMonth;
	private int assExpInYear;
	
	private String others2;
	private String qualSubCategory;
	private String qualCategory;
	private String others1;
	private String modules;
	
/*	private String residenceCity;
	private String residenceDistrict;
	private String residenceState;
	private String correspondenceState;
	public String getCorrespondenceState() {
		return correspondenceState;
	}

	public void setCorrespondenceState(String correspondenceState) {
		this.correspondenceState = correspondenceState;
	}*/
	
	public String getModules() {
		return modules;
	}

	public void setModules(String modules) {
		this.modules = modules;
	}

	@NotNull
	@Size(min=1, max=100 , message="enter your residenceAddress1")
	private String residenceAddress1;

	private String residenceAddress2;
	@NotNull
	private String gender;
	
	@Size(max=10 , message = "enter your mobile Number")
	private String mobile1;
	@Size(max=10 , message = "enter your mobile Number")
	private String mobile2;
	
	@OneToOne (cascade=CascadeType.ALL)  @JoinColumn(name="loginDetails")
	private LoginDetails loginDetails;
	
	
	public LoginDetails getLoginDetails() {
		return loginDetails;
	}

	public void setLoginDetails(LoginDetails loginDetails) {
		this.loginDetails = loginDetails;
	}

private String title;
	
	
	@NotNull
	
	@Size(min=1, max=50 , message="enter your FirstName")
	private String firstName;

	private String MiddleName;
	@NotNull
	@Size(min=1, max=50 , message="enter your LastName ")
	private String  LastName ;

	@NotNull
	@Size(min=12, max=12 , message="enter your AadharNumber ")
	private String  AadharNumber ; 
	 @Email
	private String Email;
	@NotNull
	private String dob;

	
	
	@NotNull 
	private int profileCode;
	
private String correspondenceState;
	
	private String correspondenceCity;
	private String correspondenceDistrict;
	/*@NotNull
	@Size(min=1, max=6 , message="enter your Pincode")
	private String resPincode;*/
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


	public String getGender() {
		return gender;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMobile1() {
		return mobile1;
	}

	public void setMobile1(String mobile1) {
		this.mobile1 = mobile1;
	}

	public String getMobile2() {
		return mobile2;
	}

	public String getAreaSpecialization() {
		return areaSpecialization;
	}

	public void setAreaSpecialization(String areaSpecialization) {
		this.areaSpecialization = areaSpecialization;
	}

	public int getTrRxpInMonth() {
		return trRxpInMonth;
	}

	public void setTrRxpInMonth(int trRxpInMonth) {
		this.trRxpInMonth = trRxpInMonth;
	}

	public int getTrExpInYear() {
		return trExpInYear;
	}

	public void setTrExpInYear(int trExpInYear) {
		this.trExpInYear = trExpInYear;
	}

	public int getAssExpInMonth() {
		return assExpInMonth;
	}

	public void setAssExpInMonth(int assExpInMonth) {
		this.assExpInMonth = assExpInMonth;
	}

	public int getAssExpInYear() {
		return assExpInYear;
	}

	public void setAssExpInYear(int assExpInYear) {
		this.assExpInYear = assExpInYear;
	}

	public String getOthers2() {
		return others2;
	}

	public void setOthers2(String others2) {
		this.others2 = others2;
	}

	public String getQualSubCategory() {
		return qualSubCategory;
	}

	public void setQualSubCategory(String qualSubCategory) {
		this.qualSubCategory = qualSubCategory;
	}

	public String getQualCategory() {
		return qualCategory;
	}

	public void setQualCategory(String qualCategory) {
		this.qualCategory = qualCategory;
	}

	public String getOthers1() {
		return others1;
	}

	public void setOthers1(String others1) {
		this.others1 = others1;
	}

	/*public String getResidenceCity() {
		return residenceCity;
	}

	public void setResidenceCity(String residenceCity) {
		this.residenceCity = residenceCity;
	}

	public String getResidenceDistrict() {
		return residenceDistrict;
	}

	public void setResidenceDistrict(String residenceDistrict) {
		this.residenceDistrict = residenceDistrict;
	}

	public String getResidenceState() {
		return residenceState;
	}

	public void setResidenceState(String residenceState) {
		this.residenceState = residenceState;
	}
*/
	public String getResidenceAddress2() {
		return residenceAddress2;
	}

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

	public String getCorrespondenceDistrict() {
		return correspondenceDistrict;
	}

	public void setCorrespondenceDistrict(String correspondenceDistrict) {
		this.correspondenceDistrict = correspondenceDistrict;
	}

	public void setResidenceAddress2(String residenceAddress2) {
		this.residenceAddress2 = residenceAddress2;
	}

	public String getResidenceAddress1() {
		return residenceAddress1;
	}

	public void setResidenceAddress1(String residenceAddress1) {
		this.residenceAddress1 = residenceAddress1;
	}

	public void setMobile2(String mobile2) {
		this.mobile2 = mobile2;
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

	

private int steps;

	public int getSteps() {
		return steps;
	}

	public void setSteps(int steps) {
		this.steps = steps;
	}
	
	
	

	
	
	
	/*@Override
	public String toString() {
		return "PersonalInformationTrainee [id=" + id + ", FirstName=" + firstName + ", mobile=" + mobile +  ", Email="+Email +" , AadharNumber="+AadharNumber+   "]";
	}*/
	
}
