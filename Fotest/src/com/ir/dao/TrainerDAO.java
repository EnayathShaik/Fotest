package com.ir.dao;

import java.util.List;

import com.ir.form.ChangePasswordForm;
import com.ir.form.ContactTrainee;
import com.ir.form.CourseEnrolledUserForm;
import com.ir.form.MyCalendarForm;
import com.ir.form.PlannedTrainingCalendarForm;
import com.ir.form.RegistrationFormTrainee;
import com.ir.form.TrainerFeedbackForm;
import com.ir.form.TrainerRequestForm;
import com.ir.model.AdmitCardForm;
import com.ir.model.CertificateInfo;
import com.ir.model.CheckAadhar;
import com.ir.model.City;
import com.ir.model.CourseName;
import com.ir.model.CourseTrainee;
import com.ir.model.CourseType;
import com.ir.model.District;
import com.ir.model.FeedbackMaster;
import com.ir.model.KindOfBusiness;
import com.ir.model.ManageTrainingPartner;
import com.ir.model.PersonalInformationTrainee;
import com.ir.model.PersonalInformationTrainer;
import com.ir.model.PersonalInformationTrainingInstitute;
import com.ir.model.State;
import com.ir.model.Title;
import com.ir.model.Utility;

public interface TrainerDAO {
	public List<TrainerRequestForm> listTrainerRequest(TrainerRequestForm s);

	public List<MyCalendarForm> listMyCalendar();

	public List<TrainerFeedbackForm> listtrainerFeedback();

	public List<PlannedTrainingCalendarForm> listPlannedTrainingCalendar();

	public List<TrainerFeedbackForm> listtrainingPartnerFeedback();

	public List<TrainerFeedbackForm> listFeedback();



	/*
	 * public List<UnitMaster> listTrainingType(); public List<UnitMaster>
	 * listUserType(); 
	 * public List<UnitMaster> listStatusType();
	 */
	
}
