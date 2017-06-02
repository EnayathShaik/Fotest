package com.ir.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="TP_RegisterationInfoTables")
public class TP_RegisterationInfoTables {

		@Id
		@GeneratedValue(strategy=GenerationType.SEQUENCE)
		private int id;
		
		private String foodAnalyst_0,foodAnalyst_1;
		
		private String foodAnalystAvail;
		
		private String prevtrainingExp_0,prevtrainingExp_1,prevtrainingExp_2,prevtrainingExp_3,prevtrainingExp_4;
		private String trainedStaff_0,trainedStaff_1,trainedStaff_2,trainedStaff_3,trainedStaff_4;

		public String getFoodAnalystAvail() {
			return foodAnalystAvail;
		}

		public void setFoodAnalystAvail(String foodAnalystAvail) {
			this.foodAnalystAvail = foodAnalystAvail;
		}

		public String getPrevtrainingExp_0() {
			return prevtrainingExp_0;
		}

		public void setPrevtrainingExp_0(String prevtrainingExp_0) {
			this.prevtrainingExp_0 = prevtrainingExp_0;
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

		public String getTrainedStaff_0() {
			return trainedStaff_0;
		}

		public void setTrainedStaff_0(String trainedStaff_0) {
			this.trainedStaff_0 = trainedStaff_0;
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

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getFoodAnalyst_0() {
			return foodAnalyst_0;
		}

		public void setFoodAnalyst_0(String foodAnalyst_0) {
			this.foodAnalyst_0 = foodAnalyst_0;
		}

		public String getFoodAnalyst_1() {
			return foodAnalyst_1;
		}

		public void setFoodAnalyst_1(String foodAnalyst_1) {
			this.foodAnalyst_1 = foodAnalyst_1;
		}
}
