package com.ir.dao;
import java.util.List;

import com.ir.bean.common.IntStringBean;
import com.ir.form.ActivateAssessmentOfTraineeForm;
import com.ir.form.ActivateTrainingOfTraineeForm;
import com.ir.form.AdminUserManagementForm;
import com.ir.form.AssessmentQuestionsForm;
import com.ir.form.AssessmentQuestionForm_old;
import com.ir.form.AssessorUserManagementForm;
import com.ir.form.ChangePasswordForm;
import com.ir.form.CityForm;
import com.ir.form.ContactTrainee;
import com.ir.form.DistrictForm;
import com.ir.form.GenerateCertificateForm;
import com.ir.form.InvoiceInfoForm;
import com.ir.form.InvoiceMasterForm;
import com.ir.form.ManageAssessmentAgencyForm;
import com.ir.form.ManageCourse;
import com.ir.form.ManageCourseContentForm;
import com.ir.form.ManageTrainingCalendarForm;
import com.ir.form.ManageTrainingPartnerForm;
import com.ir.form.RegionForm;
import com.ir.form.StateForm;
import com.ir.form.TraineeUserManagementForm;
import com.ir.form.TrainerUserManagementForm;
import com.ir.form.TrainingCalendarForm;
import com.ir.form.TrainingCenterUserManagementForm;
import com.ir.form.TrainingClosureForm;
import com.ir.form.TrainingRequestForm;
import com.ir.form.TrainingScheduleForm;
import com.ir.form.ViewTrainingCalendarForm;
import com.ir.form.verifyTraineeEnrollmentForm;
import com.ir.form.viewEnrolledCoursesForm;
import com.ir.model.AdminUserManagement;
import com.ir.model.AssessmentQuestions;
import com.ir.model.City;
import com.ir.model.CityMaster;
import com.ir.model.CourseName;
import com.ir.model.CourseType;
import com.ir.model.CustomerDetails;
import com.ir.model.CustomerMaster;
import com.ir.model.District;
import com.ir.model.DistrictMaster;
import com.ir.model.EmployeeMonthlyCharges;
import com.ir.model.FeedbackMaster;
import com.ir.model.HolidayMaster;
import com.ir.model.InvoiceMaster;
import com.ir.model.LoginDetails;
import com.ir.model.ManageCourseCarricullum;
import com.ir.model.ManageTraining;
import com.ir.model.ManageTrainingPartner;
import com.ir.model.ModuleMaster;
import com.ir.model.NomineeTrainee;
import com.ir.model.PersonalInformationAssessor;
import com.ir.model.PersonalInformationTrainee;
import com.ir.model.PersonalInformationTrainer;
import com.ir.model.PersonalInformationTrainingInstitute;
import com.ir.model.PersonalInformationTrainingPartner;
import com.ir.model.RegionMapping;
import com.ir.model.RegionMaster;
import com.ir.model.State;
import com.ir.model.StateMaster;
import com.ir.model.SubjectMaster;
import com.ir.model.TaxMaster;
import com.ir.model.TrainingPartner;
import com.ir.model.TrainingSchedule;
import com.ir.model.UnitMaster;
import com.ir.model.admin.TrainerAssessmentSearchForm;
import com.ir.model.trainer.TrainerAssessmentEvaluation;

public interface AdminDAO {
	
	
	public String addStateMaster(StateMaster p);
	
	public void updateStateMaster(StateMaster p);
	
	public void removeStateMaster(int id);
	
	public StateMaster getStateMasterById(int id);
	
	public List<StateMaster> listStateMaster();
	
	
	
	

	public String addDistrictMaster(DistrictMaster p);
	
	public void updateDistrictMaster(DistrictMaster p);
	
	public void removeDistrictMaster(int id);
	
	public DistrictMaster getDistrictMasterById(int id);
	
	public List<DistrictMaster> listDistrictMaster();
	
	
	
	
	

	public String addCityMaster(CityMaster p);
	
	public void updateCityMaster(CityMaster p);
	
	public void removeCityMaster(int id);
	
	public CityMaster getCityMasterById(int id);
	
	public List<CityMaster> listCityMaster();
	
	
	
	public String addRegionMaster(RegionMaster p);
	
	public void updateRegionMaster(RegionMaster p);
	
	public void removeRegionMaster(int id);
	
	public RegionMaster getRegionMasterById(int id);
	
	public List<RegionMaster> listRegionMaster();
	public boolean trainingadminForm(ChangePasswordForm changePasswordForm, String id);
	public boolean trainingPartnerPass(ChangePasswordForm changePasswordForm, String id);

	// listactivateAssessmentOfTrainee
		public List<ActivateAssessmentOfTraineeForm> listactivateAssessmentOfTrainee(ActivateAssessmentOfTraineeForm p);

		public List<ActivateTrainingOfTraineeForm> listactivateTrainingOfTrainee(ActivateTrainingOfTraineeForm p);
		// region Mapping

		// public void addRegionMapping(RegionMapping p);
		public void updateRegionMapping(RegionMapping p);

		public List<RegionMapping> listRegionMapping();

		public RegionMapping getRegionMappingById(int id);

		public void removeRegionMapping(int id);

		public void addRegionMapping(RegionMapping p);
		
		// Feedback Master
		public void addFeedbackMaster(FeedbackMaster p);

		public void updateFeedbackMaster(FeedbackMaster p);

		public List<FeedbackMaster> listFeedbackMasterForm();

		public FeedbackMaster getFeedbackMasterById(int id);

		public void removeFeedbackMaster(int id);

	// managetraining---
    public void addManageTraining(ManageTraining p);
	public void updateManageTraining(ManageTraining p);
	public List<ManageTraining> listManageTraining();
	public ManageTraining getManageTrainingById(int id);
	public void removeManageTraining(int id);
		
		// verifyTraineeEnrollment
	public List<verifyTraineeEnrollmentForm> listVerifyTraineeEnrollment(verifyTraineeEnrollmentForm p);
	
	// View Enrolled Courses
		public List<viewEnrolledCoursesForm> listviewEnrolledCourses(viewEnrolledCoursesForm p);
		
		//listGenerateCertificate
		public List<GenerateCertificateForm> listgenerateCertificate(GenerateCertificateForm p);
	
	// Manage course carricullum
		public void addManageCourseCarricullum(ManageCourseCarricullum p);

		public void updateManageCourseCarricullum(ManageCourseCarricullum p);

		public List<ManageCourseCarricullum> listManageCourseCarricullum();

		public ManageCourseCarricullum getManageCourseCarricullumById(int id);

		public void removeManageCourseCarricullum(int id);

		
		//listviewTrainingCalendar
			public List<ViewTrainingCalendarForm> listviewTrainingCalendar(ViewTrainingCalendarForm p);
					
			public	List<ManageTrainingCalendarForm> listmanageTrainingCalendar(ManageTrainingCalendarForm p);
						
			public List getQuestions(String data);
}
