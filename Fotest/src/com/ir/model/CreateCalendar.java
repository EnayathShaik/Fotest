package com.ir.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name = "CREATECALENDAR")
public class CreateCalendar {


		@Id
		@Column(name = "ID")
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence")
		@SequenceGenerator(name = "id_Sequence", sequenceName = "FBM_SEQ", allocationSize = 1, initialValue = 1)
		private int id;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		private String trainingLab;
		private String courseName;
		private String trainingDate;
		private String noOfSeats;
		private String trainerName;

		
		public String getTrainingLab() {
			return trainingLab;
		}
		public void setTrainingLab(String trainingLab) {
			this.trainingLab = trainingLab;
		}
		public String getCourseName() {
			return courseName;
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
		public String getNoOfSeats() {
			return noOfSeats;
		}
		public void setNoOfSeats(String noOfSeats) {
			this.noOfSeats = noOfSeats;
		}
		public String getTrainerName() {
			return trainerName;
		}
		public void setTrainerName(String trainerName) {
			this.trainerName = trainerName;
		}

}
