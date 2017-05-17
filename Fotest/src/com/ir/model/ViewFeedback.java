package com.ir.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ViewFeedback")
public class ViewFeedback {
	
		@Id
		@GeneratedValue(strategy=GenerationType.SEQUENCE)
		@Column(name= "id")
		private int id;
		private String courseName,userType,sessionDate;

		public String getCourseName() {
			return courseName;
		}

		public void setCourseName(String courseName) {
			this.courseName = courseName;
		}

		public String getUserType() {
			return userType;
		}

		public void setUserType(String userType) {
			this.userType = userType;
		}

		public String getSessionDate() {
			return sessionDate;
		}

		public void setSessionDate(String sessionDate) {
			this.sessionDate = sessionDate;
		}
		

	}
