package com.ir.model;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Email;

@Entity
@Table(name="personalInformationTrainingPartner")
public class PersonalInformationTrainingPartner {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	


	@OneToOne (cascade=CascadeType.ALL)  @JoinColumn(name="loginDetails")
	public LoginDetails loginDetails;
	
/*	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date")
	private Date createDate;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modify_date")
	private Date modifyDate;
	
	*/
	//@NotNull @Size(min=1, max=20 , message="* Enter UserId")
		private String userId;
		
		//private String TPName;
		
		private String title;
		
		String dob;
		//@NotNull @Size(min=1, max=50 , message="* Enter First Name")
		private String firstName;
		//@Size(min= 0 , max=50)
		private String middleName;
		//@NotNull @Size(min=1, max=20 , message="* Enter Last Name")
		private String lastName;
		
		private String gender,designation,labName,NABLStatus,chemicalFieldValidity,biologicalFieldValidity,labNotified,registrationNumber,testingFacilities;
	

		//@NotNull @Size(min=1, max=100 , message="* Enter Training lab Address ")
		private String labAddressLine1;
		//@Size(min=1, max=100 , message="* Enter Training lab Address")
		private String labAddressLine2;
	//	@NotNull(message="* Select State")
		private String state;
		//@NotNull(message="* Select District")
		private String district;
		//@NotNull(message="* Select City")
		private  String closestCity;
		//@NotNull @Size(min=6, max=6 , message="* Enter Valid PIN Code")
		private String pincode;
		
		private String emailId;
		
		private String contactNumber;
		
		
		//@NotNull @Size(min=1, max=4 , message="* Enter Seating Capacity Per Session")
		private String seatingCapacity;

		//@NotNull @Size(min=1, max=4 , message="* Enter Availabilty Of TV Projectors ")
		private String availabiltyOfTVProjector;

		//@NotNull @Size(min=1, max=1 , message="* Enter Availabilty Of In-House Trainers In Food Safety")
		private String availabiltyAudioVideoRecording;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
		public String getTestingFacilities() {
			return testingFacilities;
		}

		public void setTestingFacilities(String testingFacilities) {
			this.testingFacilities = testingFacilities;
		}

		public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDob() {
			return dob;
		}

		public void setDob(String dob) {
			this.dob = dob;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getMiddleName() {
			return middleName;
		}

		public void setMiddleName(String middleName) {
			this.middleName = middleName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getDesignation() {
			return designation;
		}

		public void setDesignation(String designation) {
			this.designation = designation;
		}

		public String getLabName() {
			return labName;
		}

		public void setLabName(String labName) {
			this.labName = labName;
		}

		public String getNABLStatus() {
			return NABLStatus;
		}

		public void setNABLStatus(String nABLStatus) {
			NABLStatus = nABLStatus;
		}

		public String getChemicalFieldValidity() {
			return chemicalFieldValidity;
		}

		public void setChemicalFieldValidity(String chemicalFieldValidity) {
			this.chemicalFieldValidity = chemicalFieldValidity;
		}

		public String getBiologicalFieldValidity() {
			return biologicalFieldValidity;
		}

		public void setBiologicalFieldValidity(String biologicalFieldValidity) {
			this.biologicalFieldValidity = biologicalFieldValidity;
		}

		public String getLabNotified() {
			return labNotified;
		}

		public void setLabNotified(String labNotified) {
			this.labNotified = labNotified;
		}

		public String getRegistrationNumber() {
			return registrationNumber;
		}

		public void setRegistrationNumber(String registrationNumber) {
			this.registrationNumber = registrationNumber;
		}

		public String getLabAddressLine1() {
			return labAddressLine1;
		}

		public void setLabAddressLine1(String labAddressLine1) {
			this.labAddressLine1 = labAddressLine1;
		}

		public String getLabAddressLine2() {
			return labAddressLine2;
		}

		public void setLabAddressLine2(String labAddressLine2) {
			this.labAddressLine2 = labAddressLine2;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getDistrict() {
			return district;
		}

		public void setDistrict(String district) {
			this.district = district;
		}

		public String getClosestCity() {
			return closestCity;
		}

		public void setClosestCity(String closestCity) {
			this.closestCity = closestCity;
		}

		public String getPincode() {
			return pincode;
		}

		public void setPincode(String pincode) {
			this.pincode = pincode;
		}

		public String getEmailId() {
			return emailId;
		}

		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}

		public String getContactNumber() {
			return contactNumber;
		}

		public void setContactNumber(String contactNumber) {
			this.contactNumber = contactNumber;
		}

		public String getSeatingCapacity() {
			return seatingCapacity;
		}

		public void setSeatingCapacity(String seatingCapacity) {
			this.seatingCapacity = seatingCapacity;
		}

		public String getAvailabiltyOfTVProjector() {
			return availabiltyOfTVProjector;
		}

		public void setAvailabiltyOfTVProjector(String availabiltyOfTVProjector) {
			this.availabiltyOfTVProjector = availabiltyOfTVProjector;
		}

		public String getAvailabiltyAudioVideoRecording() {
			return availabiltyAudioVideoRecording;
		}

		public void setAvailabiltyAudioVideoRecording(String availabiltyAudioVideoRecording) {
			this.availabiltyAudioVideoRecording = availabiltyAudioVideoRecording;
		}

/*	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	*/
	
	
	public LoginDetails getLoginDetails() {
		return loginDetails;
	}
	public void setLoginDetails(LoginDetails loginDetails) {
		this.loginDetails = loginDetails;
	}
	
	
	
	
}
