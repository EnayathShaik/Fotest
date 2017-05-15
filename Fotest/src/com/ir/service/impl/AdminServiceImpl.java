package com.ir.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ir.bean.common.IntStringBean;
import com.ir.dao.AdminDAO;
import com.ir.form.AdminUserManagementForm;
import com.ir.form.AssessmentQuestionForm;
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
import com.ir.form.ManageTrainingPartnerForm;
import com.ir.form.RegionForm;
import com.ir.form.StateForm;
import com.ir.form.TraineeUserManagementForm;
import com.ir.form.TrainerUserManagementForm;
import com.ir.form.TrainingCalendarForm;
import com.ir.form.TrainingCenterUserManagementForm;
import com.ir.form.TrainingClosureForm;
import com.ir.form.TrainingScheduleForm;
import com.ir.model.AdminUserManagement;
import com.ir.model.AssessmentQuestions;
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
import com.ir.model.ManageTrainingPartner;
import com.ir.model.ModuleMaster;
import com.ir.model.NomineeTrainee;
import com.ir.model.PersonalInformationAssessor;
import com.ir.model.PersonalInformationTrainee;
import com.ir.model.PersonalInformationTrainer;
import com.ir.model.PersonalInformationTrainingInstitute;
import com.ir.model.PersonalInformationTrainingPartner;
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
import com.ir.service.AdminService;


@Service
public class AdminServiceImpl implements AdminService {

	
	@Autowired
	@Qualifier("adminDAO")
	AdminDAO adminDAO; 

	
	/**
	 * @author Jyoti Mekal
	 *
	 * Impl For State Master
	 */
	
	@Override
	@Transactional
	public String addStateMaster(StateMaster p){
		 return this.adminDAO.addStateMaster(p);
		
	}
	
	//updateStateMaster
	@Override
	@Transactional
	public void updateStateMaster(StateMaster p){
		 this.adminDAO.updateStateMaster(p);
		
	}
	
	//removeStateMaster
	
	@Override
	@Transactional
	public void removeStateMaster(int id){
		 this.adminDAO.removeStateMaster(id);
		
	}
	
//	/getStateMasterById
	@Override
	@Transactional
	public StateMaster getStateMasterById(int id){
		return this.adminDAO.getStateMasterById(id);
		
	}
	
	//listStateMaster
	
	@Override
	@Transactional
	public List<StateMaster> listStateMaster() {
		// TODO Auto-generated method stub
		return this.adminDAO.listStateMaster();
	}
	
	
	
	
	
	

	/**
	 * @author Jyoti Mekal
	 *
	 * Impl For District Master
	 */
	
	@Override
	@Transactional
	public String addDistrictMaster(DistrictMaster p){
		 return this.adminDAO.addDistrictMaster(p);
		
	}
	
	//updateDistrictMaster
	@Override
	@Transactional
	public void updateDistrictMaster(DistrictMaster p){
		 this.adminDAO.updateDistrictMaster(p);
		
	}
	
	//removeDistrictMaster
	
	@Override
	@Transactional
	public void removeDistrictMaster(int id){
		 this.adminDAO.removeDistrictMaster(id);
		
	}
	
//	/getDistrictMasterById
	@Override
	@Transactional
	public DistrictMaster getDistrictMasterById(int id){
		return this.adminDAO.getDistrictMasterById(id);
		
	}
	
	//listDistrictMaster
	
	@Override
	@Transactional
	public List<DistrictMaster> listDistrictMaster() {
		// TODO Auto-generated method stub
		return this.adminDAO.listDistrictMaster();
	}

	/**
	 * @author Jyoti Mekal
	 *
	 * Impl For City Master
	 */
	
	@Override
	@Transactional
	public String addCityMaster(CityMaster p){
		return this.adminDAO.addCityMaster(p);
	
		
	}
	
	//updateCityMaster
	@Override
	@Transactional
	public void updateCityMaster(CityMaster p){
		 this.adminDAO.updateCityMaster(p);
		
	}
	
	//removeCityMaster
	
	@Override
	@Transactional
	public void removeCityMaster(int id){
		 this.adminDAO.removeCityMaster(id);
		
	}
	
//	/getCityMasterById
	@Override
	@Transactional
	public CityMaster getCityMasterById(int id){
		return this.adminDAO.getCityMasterById(id);
		
	}
	
	//listCityMaster
	
	@Override
	@Transactional
	public List<CityMaster> listCityMaster() {
		// TODO Auto-generated method stub
		return this.adminDAO.listCityMaster();
	}
	
	
	
	
	
	

	/**
	 * @author Jyoti Mekal
	 *
	 * Impl For Region Master
	 */
	
	@Override
	@Transactional
	public String addRegionMaster(RegionMaster p){
		 return this.adminDAO.addRegionMaster(p);
		
	}
	
	//updateRegionMaster
	@Override
	@Transactional
	public void updateRegionMaster(RegionMaster p){
		 this.adminDAO.updateRegionMaster(p);
		
	}
	
	//removeRegionMaster
	
	@Override
	@Transactional
	public void removeRegionMaster(int id){
		 this.adminDAO.removeRegionMaster(id);
		
	}
	
//	/getRegionMasterById
	@Override
	@Transactional
	public RegionMaster getRegionMasterById(int id){
		return this.adminDAO.getRegionMasterById(id);
		
	}
	
	//listRegionMaster
	
	@Override
	@Transactional
	public List<RegionMaster> listRegionMaster() {
		// TODO Auto-generated method stub
		return this.adminDAO.listRegionMaster();
	}
	
	
	@Override
	@Transactional
	public boolean changePasswordadminSave(ChangePasswordForm changePasswordForm, String id) {
		boolean changePasswordadmin = adminDAO.trainingadminForm(changePasswordForm,id);
		return changePasswordadmin;
	}

	@Override
	@Transactional
	public boolean changePasswordTPSave(ChangePasswordForm changePasswordForm, String id) {
		boolean changePasswordadmin = adminDAO.trainingPartnerPass(changePasswordForm,id);
		return changePasswordadmin;
	}

	
	
	
		
}
