package com.ir.dao.impl;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.ir.bean.common.IntStringBean;
import com.ir.dao.AdminDAO;
import com.ir.form.AdminUserManagementForm;
import com.ir.form.AssessmentQuestionForm;
import com.ir.form.AssessmentQuestionForm_old;
import com.ir.form.AssessorUserManagementForm;
import com.ir.form.ChangePasswordForm;
import com.ir.form.CityForm;
import com.ir.form.CityMasterForm;
import com.ir.form.ContactTrainee;
import com.ir.form.DistrictForm;
import com.ir.form.DistrictMasterForm;
import com.ir.form.GenerateCertificateForm;
import com.ir.form.HolidayMasterForm;
import com.ir.form.InvoiceInfoForm;
import com.ir.form.InvoiceMasterForm;
import com.ir.form.ManageAssessmentAgencyForm;
import com.ir.form.ManageCourse;
import com.ir.form.ManageCourseContentForm;
import com.ir.form.ManageTrainingPartnerForm;
import com.ir.form.NominateTraineeForm;
import com.ir.form.RegionForm;
import com.ir.form.RegionMasterForm;
import com.ir.form.StateForm;
import com.ir.form.TraineeUserManagementForm;
import com.ir.form.TrainerUserManagementForm;
import com.ir.form.TrainingCalendarForm;
import com.ir.form.TrainingCenterUserManagementForm;
import com.ir.form.TrainingClosureForm;
import com.ir.form.TrainingScheduleForm;
import com.ir.model.AdminUserManagement;
import com.ir.model.AssessmentQuestions;
import com.ir.model.AssessmentQuestion_old;
import com.ir.model.AssessorUserManagement;
import com.ir.model.City;
import com.ir.model.CityMaster;
import com.ir.model.ContactTraineee;
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
import com.ir.model.ManageAssessmentAgency;
import com.ir.model.ManageCourseContent;
import com.ir.model.ManageTrainingPartner;
import com.ir.model.ModuleMaster;
import com.ir.model.NomineeTrainee;
import com.ir.model.PersonalInformationAssessor;
import com.ir.model.PersonalInformationTrainee;
import com.ir.model.PersonalInformationTrainer;
import com.ir.model.PersonalInformationTrainingInstitute;
import com.ir.model.PersonalInformationTrainingPartner;
import com.ir.model.Region;
import com.ir.model.RegionMaster;
import com.ir.model.State;
import com.ir.model.StateMaster;
import com.ir.model.SubjectMaster;
import com.ir.model.TaxMaster;
import com.ir.model.TrainingCalendar;
import com.ir.model.TrainingPartner;
import com.ir.model.TrainingSchedule;
import com.ir.model.UnitMaster;
import com.ir.model.admin.TrainerAssessmentSearchForm;
import com.ir.model.trainer.TrainerAssessmentEvaluation;
import com.ir.service.LoginService;
import com.ir.service.PageLoadService;
import com.ir.service.TraineeService;
import com.ir.util.ChangePasswordUtility;
import com.ir.util.EncryptionPasswordANDVerification;
import com.ir.util.HibernateUtil;
import com.ir.util.PasswordGenerator;
import com.ir.util.SendContectMail;
import com.ir.util.SendMail;
import com.itextpdf.text.log.SysoCounter;
import com.zentech.backgroundservices.Mail;
import com.zentech.logger.ZLogger;
@Repository
@Service
public class AdminDAOImpl implements AdminDAO {

	
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	@Autowired
	@Qualifier("changePasswordUtility")
	public ChangePasswordUtility changePasswordUtility;
	
	
	
	

	/**
	 * @author Jyoti Mekal
	 *
	 *         DAOImpl For State Master
	 * @return
	 */

	@Override
	public String addStateMaster(StateMaster p) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.getCurrentSession();
		State state = new State();
		state.setStateName(p.getStateName().replaceAll("%20", " "));
		state.setStatus(p.getStatus());
		Integer stateIdd = null;
		String sql = "select * from state where upper(stateName) = '"
				+ p.getStateName().replaceAll("%20", " ").toUpperCase() + "'";
		Query query = session.createSQLQuery(sql);
		List l = query.list();

		if (l != null && l.size() > 0) {

			return "error";
		} else {

			stateIdd = (Integer) session.save(state);
			p.setIsActive("Y");

			session.persist(p);

			return "created";
		}

	}

	@Override
	public void updateStateMaster(StateMaster p) {
		// TODO Auto-generated method stub
		p.setIsActive("Y");
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);

	}

	// removeStateMaster

	@Override
	public void removeStateMaster(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String sql = null;
		StateMaster p = (StateMaster) session.load(StateMaster.class, new Integer(id));
		if (null != p) {
			sql = "update StateMaster set isactive='N' where stateid=" + id;
		}
		Query query = session.createSQLQuery(sql);
		query.executeUpdate();
	}

	@Override
	public StateMaster getStateMasterById(int id) {
		// TODO Auto-generated method stub
		System.out.println(" id " + id);
		Session session = this.sessionFactory.getCurrentSession();

		Query query = session.createQuery("from StateMaster where StateId=" + id);

		List<StateMaster> StateMasterList = query.list();
		StateMaster hm = StateMasterList.get(0);
			return hm; 
			
			
		}
		
		@Override
		public List<StateMaster> listStateMaster() {
			// TODO Auto-generated method stub
			System.out.println("inside listStateMaster");
			Session session = this.sessionFactory.getCurrentSession();
			List<StateMaster> mccList = session.createQuery("from StateMaster where coalesce(isactive,'') <> 'N' ").list();
			for (StateMaster p : mccList) {
				System.out.println("State List::" + p);
			}
			return mccList;
		}
		
		
		
		
		
		

	/**
	 * @author Jyoti Mekal
	 *
	 *         DAOImpl For District Master
	 * @return
	 */

	@Override
	public String addDistrictMaster(DistrictMaster p) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		System.out.println("DistrictMaster " + p.getDistrictId());
		StateMaster sm = getStateMasterById(p.getStateMaster().getStateId());
		DistrictMasterForm d = new DistrictMasterForm();
		d.setDistrictName(p.getDistrictName());
		Integer dIdd = null;

		String sql = "select districtname from districtmaster where districtname = '" + p.getDistrictName()
				+ "' and stateid = '" + p.getStateMaster().getStateId() + "'";
		Query query = session.createSQLQuery(sql);

		List l = query.list();
		if (l != null && l.size() > 0) {

			return "error";
		} else {
			p.setStateMaster(sm);
			p.setIsActive("Y");
			session.persist(p);

			return "created";
		}

	}

	@Override
	public void updateDistrictMaster(DistrictMaster p) {
		// TODO Auto-generated method stub
		p.setIsActive("Y");
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);

	}

	// removeDistrictMaster

	@Override
	public void removeDistrictMaster(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String sql = null;
		DistrictMaster p = (DistrictMaster) session.load(DistrictMaster.class, new Integer(id));
		if (null != p) {
			sql = "update DistrictMaster set isactive='N' where districtId=" + id;
		}
		Query query = session.createSQLQuery(sql);
		query.executeUpdate();
	}

	@Override
	public DistrictMaster getDistrictMasterById(int id) {
		// TODO Auto-generated method stub
		System.out.println(" id " + id);
		Session session = this.sessionFactory.getCurrentSession();

		Query query = session.createQuery("from DistrictMaster where DistrictId=" + id);

		List<DistrictMaster> DistrictMasterList = query.list();
		DistrictMaster hm = DistrictMasterList.get(0);
			return hm; 
			
			
		}
		
		@Override
		public List<DistrictMaster> listDistrictMaster() {
			// TODO Auto-generated method stub
			System.out.println("inside listDistrictMaster");
			Session session = this.sessionFactory.getCurrentSession();
			List<DistrictMaster> mccList = session.createQuery("from DistrictMaster where coalesce(isactive,'') <> 'N'").list();
			for (DistrictMaster p : mccList) {
				System.out.println("District List::" + p);
			}
			return mccList;
		}
		
		
		
		
		
		
		

	/**
	 * @author Jyoti Mekal
	 *
	 *         DAOImpl For City Master
	 */

	@Override
	public String addCityMaster(CityMaster p) {
		// TODO Auto-generated method stub
		System.out.println("CityMaster " + p.getCityId());
		DistrictMaster dm = getDistrictMasterById(p.getDistrictMaster().getDistrictId());
		Session session = this.sessionFactory.getCurrentSession();
		CityMasterForm c = new CityMasterForm();
		c.setCityName(p.getCityName().replaceAll("%20", " "));
		Integer cIdd = null;
		String sql = "select * from citymaster where cityname like '" + p.getCityName() + "' and districtid = '"
				+ p.getDistrictMaster().getDistrictId() + "'";
		Query query = session.createSQLQuery(sql);
		List l = query.list();
		if (l != null && l.size() > 0) {
			return "error";
		} else {
			p.setDistrictMaster(dm);
			p.setIsActive("Y");
			session.persist(p);
			return "created";
		}

	}

	@Override
	public void updateCityMaster(CityMaster p) {
		// TODO Auto-generated method stub
		p.setIsActive("Y");
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);

	}

	// removeCityMaster

	@Override
	public void removeCityMaster(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String sql = null;
		CityMaster p = (CityMaster) session.load(CityMaster.class, new Integer(id));
		if (null != p) {
			sql = "update CityMaster set isactive='N' where cityId=" + id;
		}
		Query query = session.createSQLQuery(sql);
		query.executeUpdate();

	}

	@Override
	public CityMaster getCityMasterById(int id) {
		// TODO Auto-generated method stub
		System.out.println(" id " + id);
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from CityMaster where CityId=" + id);
		List<CityMaster> CityMasterList = query.list();
		CityMaster hm = CityMasterList.get(0);
			return hm; 
			
			
		}
		
		@Override
		public List<CityMaster> listCityMaster() {
			// TODO Auto-generated method stub
			System.out.println("inside listCityMaster");
			Session session = this.sessionFactory.getCurrentSession();
			List<CityMaster> mccList = session.createQuery("from CityMaster where coalesce(isactive,'') <> 'N'").list();
			for (CityMaster p : mccList) {
				System.out.println("City List::" + p);
			}
			return mccList;
		}
		
		
		
		
		

		/**
		 * @author Jyoti Mekal
		 *
		 * DAOImpl For Region Master
		 */
		
		@Override
		public String addRegionMaster(RegionMaster p) {
			// TODO Auto-generated method stub
			System.out.println("RegionMaster "+p.getId());
			CityMaster cm =  getCityMasterById(p.getCityMaster().getCityId());
			p.setCityMaster(cm);
			p.setIsActive("Y");
			Session session = this.sessionFactory.getCurrentSession();
			RegionMasterForm rm=new RegionMasterForm();
			rm.setRegionName(p.getRegionName().replaceAll("%20", " "));
			rm.setStatus(p.getStatus());
			String sql="select * from regionmaster where regionName like '"+ p.getRegionName() +  "'and cityId='" +p.getCityMaster().getCityId()+"'"; 
			Query query = session.createSQLQuery(sql);
			List l = query.list();
			if(l != null && l.size() >0){
				
				return "error";
			}
			else{
			
			session.persist(p);
			return "created";
		}
		}
		
		
		@Override
		public void updateRegionMaster(RegionMaster p) {
			// TODO Auto-generated method stub
			Session session = this.sessionFactory.getCurrentSession();
			session.update(p);
			
		}
		
		
		//removeRegionMaster
		
		@Override
		public void removeRegionMaster(int id) {
			// TODO Auto-generated method stub
			Session session = this.sessionFactory.getCurrentSession();
			String sql=null;
			RegionMaster p = (RegionMaster) session.load(RegionMaster.class, new Integer(id));
			if (null != p) {
				sql =	"update RegionMaster set isactive='N' where id="+id;
			}
			Query query = session.createSQLQuery(sql);
			query.executeUpdate();
			
		}
		
		@Override
		public RegionMaster getRegionMasterById(int id) {
			// TODO Auto-generated method stub
			System.out.println(" id " +id);
			Session session = this.sessionFactory.getCurrentSession();
			
		Query query = session.createQuery("from RegionMaster where id="+id);
		
		List<RegionMaster> RegionMasterList = query.list();
		RegionMaster hm = RegionMasterList.get(0);
			return hm; 
			
			
		}
		
		@Override
		public List<RegionMaster> listRegionMaster() {
			// TODO Auto-generated method stub
			System.out.println("inside listRegionMaster");
			Session session = this.sessionFactory.getCurrentSession();
			List<RegionMaster> mccList = session.createQuery("from RegionMaster where coalesce(isactive,'') <> 'N'").list();
			for (RegionMaster p : mccList) {
				System.out.println("Region List::" + p);
			}
			return mccList;
		}
		
		@Override
		public boolean trainingadminForm(ChangePasswordForm changePasswordForm, String id) {
			String oldPassword=	changePasswordForm.getOldPassword();
			String newPassword=changePasswordForm.getNewPassword();
			boolean confirm = changePasswordUtility.changePasswordUtil(oldPassword, newPassword, id);
			
			
			return confirm;
		}
		
	@Override
		public boolean trainingPartnerPass(ChangePasswordForm changePasswordForm, String id) {
			String oldPassword=	changePasswordForm.getOldPassword();
			String newPassword=changePasswordForm.getNewPassword();

			boolean confirm = changePasswordUtility.changePasswordUtil(oldPassword, newPassword, id);		
			return confirm;
		}
	
	
	
	
}
