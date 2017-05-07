package com.ir.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ir.dao.TraineeDAO;
import com.ir.form.AssessmentQuestionForm;
import com.ir.form.CertificateForm;
import com.ir.form.ChangePasswordForm;
import com.ir.form.ContactTrainee;
import com.ir.form.CourseEnrolledUserForm;
import com.ir.form.GenerateCertificateForm;
import com.ir.form.GetScoreCardForm;
import com.ir.form.MyTrainingForm;
import com.ir.form.OnlineTrainingForm;
import com.ir.form.InstituteMyCalendarForm;
import com.ir.form.MarkAttendanceForm;
import com.ir.form.RegistrationFormTrainee;
import com.ir.form.TrainingRequestForm;
import com.ir.model.AdmitCardForm;
import com.ir.model.CertificateInfo;
import com.ir.model.CheckAadhar;
import com.ir.model.CourseName;
import com.ir.model.CourseTrainee;
import com.ir.model.CourseType;
import com.ir.model.FeedbackForm;
import com.ir.model.FeedbackMaster;
import com.ir.model.ManageTrainingPartner;
import com.ir.model.ModuleMaster;
import com.ir.model.PersonalInformationTrainee;
import com.ir.model.PersonalInformationTrainer;
import com.ir.model.PersonalInformationTrainingInstitute;
import com.ir.model.State;
import com.ir.model.TrainingSchedule;
import com.ir.model.UnitMaster;
import com.ir.model.Utility;
import com.ir.service.TraineeService;
@Service
public class TraineeServiceImpl implements TraineeService {

	@Autowired
	@Qualifier("traineeDAO")
	public TraineeDAO traineeDAO;
	
	@Override
	@Transactional
	public List<CourseName> courseNameList() {
		List<CourseName> courseNameList = traineeDAO.courseNameList();
		return courseNameList;
	}
	
	@Override
	@Transactional
	public List<String> courseTypes() {
		System.out.println("trainee");
		List<String> courseTypeList = traineeDAO.courseTypes();
		return courseTypeList;
	}
	
	
	@Override
	@Transactional
	public List<CourseType> courseTypeList() {
		System.out.println("traineeDAO");
		List<CourseType> courseTypeList = traineeDAO.courseTypeList();
		return courseTypeList;
	}
	@Override
	@Transactional
	public List<CourseName> courseNameListByType(int courseType) {
		List<CourseName> courseNameList = traineeDAO.courseNameListByType(courseType);
		return courseNameList;
	}
	@Override
	@Transactional
		public CourseTrainee getCourseTrainingByCourseTypeID(int typeId) {
			CourseTrainee courseTrainee = traineeDAO.getCourseTrainingByCourseTypeID(typeId);
			return courseTrainee;
		}
	
	//getCourseTrainingByCourseTypeIDList
	
	@Override
	@Transactional
		public List<CourseTrainee> getCourseTrainingByCourseTypeIDList(int typeId) {
			List<CourseTrainee> courseTrainee = traineeDAO.getCourseTrainingByCourseTypeIDList(typeId);
			return courseTrainee;
		}
	
	@Override
	@Transactional
	public String isTraineeEligible(int userID) {
		String eligible = traineeDAO.isTraineeEligible(userID);
		return eligible;
	}
	@Override
	@Transactional
	public CourseName getCourseName(int loginId) {
		CourseName courseName = traineeDAO.getCourseName(loginId);
		return courseName;
	}
	@Override
	@Transactional
	public CourseName getCourseDetails(int loginId) {
		CourseName courseName = traineeDAO.getCourseDetails(loginId);
		return courseName;
	}
	@Override
	@Transactional
	public List<FeedbackMaster> getFeedMasterList(int profileId) {
		List<FeedbackMaster> feedbackMasters = traineeDAO.getFeedMasterList(profileId);
		return feedbackMasters;
	}

	@Override
	@Transactional
	public List<ManageTrainingPartner> trainingPartnerList() {
		List<ManageTrainingPartner> trainingPartnerList = traineeDAO.trainingPartnerList();
		return trainingPartnerList;
	}

	@Override
	@Transactional
	public List<State> trainingCenterStateList() {
		List<State> trainingCenterStateList = traineeDAO.trainingCenterStateList();
		return trainingCenterStateList;
	}

	@Override
	@Transactional
	public String updateTrainee(RegistrationFormTrainee registrationFormTrainee , Integer ss) {
		String updateTrainee= traineeDAO.updateTrainee(registrationFormTrainee , ss);
		return updateTrainee;
	}

	@Override
	@Transactional
	public String basicSave(CourseEnrolledUserForm courseEnrolledUserForm ,int loginid, int tableID,Integer profileID) {
		String basicEnroll= traineeDAO.basicSave(courseEnrolledUserForm , loginid , tableID, profileID);
		return basicEnroll;
	}
	@Override
	@Transactional
	public boolean changePasswordTraineeSave(ChangePasswordForm changePasswordForm, String id) {
		boolean changePasswordTraineeSave= traineeDAO.changePasswordTraineeSave(changePasswordForm , id);
		return changePasswordTraineeSave;
	}
	@Override
	@Transactional
	public String contactTraineeSave(ContactTrainee contactTrainee , String id) {
		String contactTraineeSave = traineeDAO.contactTraineeSave(contactTrainee , id);
		return contactTraineeSave;
	}
@Override
@Transactional
	public long advanceTraineeSave(CourseEnrolledUserForm courseEnrolledUserForm, int loginid, int tableID,Integer profileID) {
		long advanceEnroll= traineeDAO.advanceTraineeSave(courseEnrolledUserForm , loginid , tableID, profileID);
		return advanceEnroll;
	}

	@Override
	@Transactional
	public long specialTrainee(CourseEnrolledUserForm courseEnrolledUserForm, int loginid,int tableID, Integer profileId) {
		long specialEnroll= traineeDAO.specialTraineeSave(courseEnrolledUserForm , loginid , tableID,profileId);
		return specialEnroll;
	}
	

	@Override
	@Transactional
	public boolean changePasswordAssesorSave(ChangePasswordForm changePasswordForm, String id) {
		boolean changePasswordAssesorSave= traineeDAO.changePasswordAssesorSave(changePasswordForm , id);
		return changePasswordAssesorSave;
	}
	@Override
	@Transactional
	public AdmitCardForm generateAdmitCard(int loginId,int profileId){
		AdmitCardForm admitCardObj = traineeDAO.generateAdmitCard(loginId,profileId);
		return admitCardObj;
	}
	@Override
	@Transactional
	public List<FeedbackForm> getFeedbackDetails(Utility utility) {
		return traineeDAO.getFeedbackDetails(utility);
	}
	@Override
	@Transactional
	public int getCurrentModuleId(int loginId){
		return traineeDAO.getCurrentModuleId(loginId);
	}
	@Override
	@Transactional
	public AdmitCardForm generateTrainerAdmitCard(int loginId,int profileId){
		AdmitCardForm admitCardObj = traineeDAO.generateTrainerAdmitCard(loginId,profileId);
		return admitCardObj;
	}
	@Override
	@Transactional
	public String getDefaultMailID(int loginId, int profileId) {
		// TODO Auto-generated method stub
		return traineeDAO.getDefaultMailID(loginId, profileId);
	}
	@Override
	@Transactional
	public PersonalInformationTrainee FullDetail(int loginId) {
		PersonalInformationTrainee personalInformationTrainee = traineeDAO.fullDetail(loginId);
		return personalInformationTrainee;
	}
	@Override
	@Transactional
	public int getTableIdForEnrolmentID(int loginId, int profileId) {
		// TODO Auto-generated method stub
		return traineeDAO.getTableIdForEnrolmentID(loginId, profileId);
	}
	@Override
	@Transactional
	public Boolean updateSteps(int tableID,  int steps) {
		// TODO Auto-generated method stub
		return traineeDAO.updateSteps(tableID, steps);
	}
	@Override
	@Transactional
	public String isCourseOnline(int userID) {
		// TODO Auto-generated method stub
		return traineeDAO.isCourseOnline(userID);
	}
	@Override
	@Transactional
	public Boolean closeCourse(int userId, String status) {
		// TODO Auto-generated method stub
		return traineeDAO.closeCourse(userId, status);
	}
	@Override
	@Transactional
	public CertificateInfo getCertificateID(int userId,  String certificateID) {
		// TODO Auto-generated method stub
		return traineeDAO.getCertificateID(userId,  certificateID);
	}
	
	@Override
	@Transactional
	public String isAadharExist(CheckAadhar checkAadhar) {
		// TODO Auto-generated method stub
		return traineeDAO.isAadharExist(checkAadhar);
	}
	
	

	@Override
	@Transactional
	public List<State> stateList() {
		// TODO Auto-generated method stub
		List<State> stateList = traineeDAO.stateList();
		return stateList;
	}
	
	//getCourseDetails
	
	
	@Override
	@Transactional
	public List getCourseDetails(String  data) {
		// TODO Auto-generated method stub
		return traineeDAO.getCourseDetails(data);
	}
	
	//getAttendanceDeatilsByID
	@Override
	@Transactional
	public List getAttendanceDeatilsByID(String  data) {
		// TODO Auto-generated method stub
		return traineeDAO.getAttendanceDeatilsByID(data);
	}	
	
	
	//savePaymentStatus

	@Override
	@Transactional
	public String savePaymentStatus(String  data) {
		// TODO Auto-generated method stub
		return traineeDAO.savePaymentStatus(data);
	}	
	
	//addPersonalInfoTrainee
	
	
	
	@Override
	@Transactional
	public String addPersonalInfoTrainee(PersonalInformationTrainee  p) {
		// TODO Auto-generated method stub
		return traineeDAO.addPersonalInfoTrainee(p);
	}
	
	
	@Override
	@Transactional
	public String updatePersonalInfoTrainee(PersonalInformationTrainee  p) {
		// TODO Auto-generated method stub
		return traineeDAO.updatePersonalInfoTrainee(p);
	}
	
	
	@Override
	@Transactional
	public String addPersonalInfoTrainer(PersonalInformationTrainer  p) {
		// TODO Auto-generated method stub
		return traineeDAO.addPersonalInfoTrainer(p);
	}
	
	@Override
	@Transactional
	public String updatePersonalInfoTrainer(PersonalInformationTrainer  p) {
		// TODO Auto-generated method stub
		return traineeDAO.updatePersonalInfoTrainer(p);
	}
	
	
//	/addPersonalInfoTrainingInstitute
	
	@Override
	@Transactional
	public String addPersonalInfoTrainingInstitute(PersonalInformationTrainingInstitute  p) {
		// TODO Auto-generated method stub
		return traineeDAO.addPersonalInfoTrainingInstitute(p);
	}



//listGenerateCertificate
//my training	
	@Override
	@Transactional
	public List<MyTrainingForm> listMyTraining() {
		// TODO Auto-generated method stub
		return this.traineeDAO.listMyTraining();
	}
	
	@Override
	@Transactional
	public GetScoreCardForm listGetScoreCard(int id) {
		// TODO Auto-generated method stub
		return this.traineeDAO.listGetScoreCard(id);
	}
	
	@Override
	@Transactional
	public List<CertificateForm> listCertificate(int loginId) {
		// TODO Auto-generated method stub
		return this.traineeDAO.listCertificate(loginId);
	}
	

	
	
	//updatePersonalInfoTrainingInstitute
	
	@Override
	@Transactional
	public String updatePersonalInfoTrainingInstitute(PersonalInformationTrainingInstitute  p) {
		// TODO Auto-generated method stub
		return traineeDAO.updatePersonalInfoTrainingInstitute(p);
	}

	@Override
	@Transactional
	public PersonalInformationTrainer FullDetailTrainer(int loginId) {
		PersonalInformationTrainer personalInformationTrainer = traineeDAO.fullDetailtrainer(loginId);
		return personalInformationTrainer;
	}
	
	//FullDetailTrainingInstitude
	
	@Override
	@Transactional
	public PersonalInformationTrainingInstitute FullDetailTrainingInstitude(int loginId) {
		PersonalInformationTrainingInstitute personalInformationTraineInstitute = traineeDAO.FullDetailTrainingInstitude(loginId);
		return personalInformationTraineInstitute;
	}
	
	
	
	
	
	//trainee topic from online training
	@Override
	@Transactional
	public UnitMaster listTrainingTopic(int id){
		return this.traineeDAO.listTrainingTopic(id);
		
	}
			@Override
		@Transactional
		public OnlineTrainingForm listOnlineTraining(int id) {
			// TODO Auto-generated method stub
			return this.traineeDAO.listOnlineTraining(id);
		}
	
	


		@Override
		@Transactional
		public List<AssessmentQuestionForm> listingAssessmentQuestion(
				AssessmentQuestionForm assesQuestionForm , int id) {
			// TODO Auto-generated method stub
			return this.traineeDAO.listingAssessmentQuestion( assesQuestionForm, id);
		}



}