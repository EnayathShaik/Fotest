package com.ir.form;

import com.ir.model.LoginDetails;

public class PersonalInformationTrainingPartnerForm {

	
		private int id;
		private LoginDetails loginDetails;
			
			public LoginDetails getLoginDetails() {
			return loginDetails;
		}

		public void setLoginDetails(LoginDetails loginDetails) {
			this.loginDetails = loginDetails;
		}

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

			private String foodAnalystAvail;
		
			private String prevtrainingExp_0,prevtrainingExp_1,prevtrainingExp_2,prevtrainingExp_3,prevtrainingExp_4;
			private String trainedStaff_0,trainedStaff_1,trainedStaff_2,trainedStaff_3,trainedStaff_4;
			private String foodAnalyst_0,foodAnalyst_1;
			
		
			public String getFoodAnalystAvail() {
				return foodAnalystAvail;
			}

			public void setFoodAnalystAvail(String foodAnalystAvail) {
				this.foodAnalystAvail = foodAnalystAvail;
			}
			
			public String getPrevtrainingExp_1() {
				return prevtrainingExp_1;
			}

			public void setPrevtrainingExp_1(String prevtrainingExp_1) {
				this.prevtrainingExp_1 = prevtrainingExp_1;
			}

			public String getPrevtrainingExp_2() {
				return prevtrainingExp_2;
			}

			public void setPrevtrainingExp_2(String prevtrainingExp_2) {
				this.prevtrainingExp_2 = prevtrainingExp_2;
			}

			public String getPrevtrainingExp_3() {
				return prevtrainingExp_3;
			}

			public void setPrevtrainingExp_3(String prevtrainingExp_3) {
				this.prevtrainingExp_3 = prevtrainingExp_3;
			}

			public String getPrevtrainingExp_4() {
				return prevtrainingExp_4;
			}

			public void setPrevtrainingExp_4(String prevtrainingExp_4) {
				this.prevtrainingExp_4 = prevtrainingExp_4;
			}


			public String getTrainedStaff_1() {
				return trainedStaff_1;
			}

			public void setTrainedStaff_1(String trainedStaff_1) {
				this.trainedStaff_1 = trainedStaff_1;
			}

			public String getTrainedStaff_2() {
				return trainedStaff_2;
			}

			public void setTrainedStaff_2(String trainedStaff_2) {
				this.trainedStaff_2 = trainedStaff_2;
			}

			public String getTrainedStaff_3() {
				return trainedStaff_3;
			}

			public void setTrainedStaff_3(String trainedStaff_3) {
				this.trainedStaff_3 = trainedStaff_3;
			}

			public String getTrainedStaff_4() {
				return trainedStaff_4;
			}

			public void setTrainedStaff_4(String trainedStaff_4) {
				this.trainedStaff_4 = trainedStaff_4;
			}

			public String getFoodAnalyst_1() {
				return foodAnalyst_1;
			}

			public void setFoodAnalyst_1(String foodAnalyst_1) {
				this.foodAnalyst_1 = foodAnalyst_1;
			}

			

			public String getPrevtrainingExp_0() {
				return prevtrainingExp_0;
			}

			public void setPrevtrainingExp_0(String prevtrainingExp_0) {
				this.prevtrainingExp_0 = prevtrainingExp_0;
			}

			public String getTrainedStaff_0() {
				return trainedStaff_0;
			}

			public void setTrainedStaff_0(String trainedStaff_0) {
				this.trainedStaff_0 = trainedStaff_0;
			}

			public String getFoodAnalyst_0() {
				return foodAnalyst_0;
			}

			public void setFoodAnalyst_0(String foodAnalyst_0) {
				this.foodAnalyst_0 = foodAnalyst_0;
			}

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

			/*public String getUserId() {
				return userId;
			}

			public void setUserId(String userId) {
				this.userId = userId;
			}*/

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
		
	}
