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
import com.ir.form.ActivateAssessmentOfTraineeForm;
import com.ir.form.ActivateTrainingOfTraineeForm;
import com.ir.form.ActivateUserIdForm;
import com.ir.form.AdminHomePageForm;
import com.ir.form.AdminUserManagementForm;
import com.ir.form.AssessmentQuestionsForm;
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
import com.ir.form.ManageTrainingCalendarForm;
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
import com.ir.form.TrainingPartnerUserManagementForm;
import com.ir.form.TrainingScheduleForm;
import com.ir.form.ViewTrainingCalendarForm;
import com.ir.form.verifyTraineeEnrollmentForm;
import com.ir.form.viewEnrolledCoursesForm;
import com.ir.model.AdminUserManagement;
import com.ir.model.AssessmentQuestions;
import com.ir.model.AssessmentQuestion_old;
import com.ir.model.AssessorUserManagement;
import com.ir.model.City;
import com.ir.model.CityMaster;
import com.ir.model.ContactTraineee;
import com.ir.model.CourseName;
import com.ir.model.CourseType;
import com.ir.model.CreateCalendar;
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
import com.ir.model.ManageCourseCarricullum;
import com.ir.model.ManageCourseContent;
import com.ir.model.ManageTraining;
import com.ir.model.ManageTrainingPartner;
import com.ir.model.ModuleMaster;
import com.ir.model.NomineeTrainee;
import com.ir.model.PersonalInformationAssessor;
import com.ir.model.PersonalInformationTrainee;
import com.ir.model.PersonalInformationTrainer;
import com.ir.model.PersonalInformationTrainingInstitute;
import com.ir.model.PersonalInformationTrainingPartner;
import com.ir.model.Region;
import com.ir.model.RegionMapping;
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
		StateMaster state = new StateMaster();
		state.setStateName(p.getStateName().replaceAll("%20", " "));
		state.setStatus(p.getStatus());
		//Integer stateIdd = null;
		String sql = "select * from StateMaster where upper(stateName) = '"
				+ p.getStateName().replaceAll("%20", " ").toUpperCase() + "'";
		Query query = session.createSQLQuery(sql);
		List l = query.list();

		if (l != null && l.size() > 0) {

			return "error";
		} else {

			//stateIdd = (Integer) session.save(state);
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
	
	
	// manage training
			@Override
			public void addManageTraining(ManageTraining p) {
				// TODO Auto-generated method stub
				System.out.println("getTrainingName " + p.getTrainingName());
				Session session = this.sessionFactory.getCurrentSession();
				session.persist(p);

				new ZLogger("ManageTraining saved successfully", " ManageTraining Details=" + p, "AdminDAOImpl.java");
				// new ZLogger("ManageTraining", "list.size() "+list.size(),
				// "AdminDAOImpl.java");
			}

			@Override
			public void updateManageTraining(ManageTraining p) {
				// TODO Auto-generated method stub
				Session session = this.sessionFactory.getCurrentSession();
				session.update(p);
				new ZLogger("ManageTraining saved successfully", " ManageTraining Details=" + p, "AdminDAOImpl.java");
			}

			@SuppressWarnings("unchecked")
			@Override
			public List<ManageTraining> listManageTraining() {
				// TODO Auto-generated method stub
				System.out.println("inside manageCourseCarrilcullum");
				Session session = this.sessionFactory.getCurrentSession();
				List<ManageTraining> mccList = session.createQuery("from ManageTraining").list();
				for (ManageTraining p : mccList) {
					// logger.info("ManageTraining List::" + p);
				}
				return mccList;
			}

			@Override
			public ManageTraining getManageTrainingById(int id) {
				// TODO Auto-generated method stub
				System.out.println(" id " + id);
				Session session = this.sessionFactory.getCurrentSession();
				/*
				 * ManageTraining p = (ManageTraining)
				 * session.load(ManageTraining.class, new Integer(id)); logger.info(
				 * "ManageTraining loaded successfully, ManageTraining details=" + p);
				 * return p;
				 */
				Query query = session.createQuery("from ManageTraining where id=" + id);
				List<ManageTraining> manageTraining = query.list();
				ManageTraining mt = manageTraining.get(0);
				return mt;
			}

			@Override
			public void removeManageTraining(int id) {
				// TODO Auto-generated method stub
				Session session = this.sessionFactory.getCurrentSession();
				ManageTraining p = (ManageTraining) session.load(ManageTraining.class, new Integer(id));
				if (null != p) {
					session.delete(p);
				}
				new ZLogger("ManageTraining saved successfully", " ManageTraining Details=" + p, "AdminDAOImpl.java");
			}
			
			// verifyTraineeEnrollment

			@Override
			public List<verifyTraineeEnrollmentForm> listVerifyTraineeEnrollment(verifyTraineeEnrollmentForm form) {
				// TODO Auto-generated method stub
				System.out.println("inside verifyTraineeEnrollmentForm");
				List<verifyTraineeEnrollmentForm> list = new ArrayList<verifyTraineeEnrollmentForm>();
				System.out.println("courseName " + form.getCourseName() + " trainingName " + form.getTraineeName());
				Session session = this.sessionFactory.getCurrentSession();
				List<Object[]> lst = session.createSQLQuery("select cast('Java' as varchar(20)) as CourseName , cast('2016-12-16 12:00' as varchar(20)) as TrainingDate,cast('12:00' as varchar(20)) as TrainingTime , cast('Mahape' as varchar(20) ) as TrainingLab , cast('jyoti' as varchar(20)) as tarineeName  ").list();
				for (Object[] li : lst) {
					verifyTraineeEnrollmentForm bean = new verifyTraineeEnrollmentForm();
					bean.setCourseName((String) li[0]);
					bean.setTrainingDate((String) li[1]);
					bean.setTrainingTime((String) li[2]);
					bean.setTrainingLab((String) li[3]);
					bean.setTraineeName((String) li[4]);
					// new ZLogger.info("listVerifyTraineeEnrollment List::" + li);
					list.add(bean);
				}
				System.out.println("list " + list);
				return list;
			}
			
			// View Enrolled Courses
			@Override
			public List<viewEnrolledCoursesForm> listviewEnrolledCourses(viewEnrolledCoursesForm form) {
				// TODO Auto-generated method stub
				System.out.println("inside listviewEnrolledCourses");
				String courseName = form.getCourseName();
				String traineeName = form.getTrainingDate();
				viewEnrolledCoursesForm bean = new viewEnrolledCoursesForm();
				List<viewEnrolledCoursesForm> resulList = new ArrayList<viewEnrolledCoursesForm>();
				System.out.println("courseName " + courseName + " traineeName " + traineeName);
				Session session = this.sessionFactory.getCurrentSession();
				List<Object[]> list = session.createSQLQuery("select  cast('Manidra' as varchar(20) ) as trainerName ,  cast('Java' as varchar(20)) as CourseName , cast('2016-12-16' as varchar(20)) as TrainingDate , cast('12:00' as varchar(20)) as TrainingTime, cast('Mahape' as varchar(20) ) as TrainingLab , cast('25'  as varchar(20)) as NoOfSeats , cast('Jyoti' as  varchar(20)) as traineeName , cast('Present' as varchar(20)) as status   ").list();
				for (Object[] li : list) {

					bean.setTrainerName((String) li[0]);
					bean.setCourseName((String) li[1]);
					bean.setTrainingDate((String) li[2]);
					bean.setTrainingTime((String) li[3]);
					bean.setTrainingLab((String) li[4]);
					bean.setNoOfSeats((String) li[5]);
					bean.setTraineeName((String) li[6]);
					bean.setStatus((String) li[7]);

					// logger.info("listviewEnrolledCourses List::" + li);
					resulList.add(bean);
				}
				return resulList;
			}
			
			//listgenerateCertificate
					@Override
					public List<GenerateCertificateForm> listgenerateCertificate(GenerateCertificateForm form) {
						// TODO Auto-generated method stub
						System.out.println("inside listfotestGenerateCertificate");
						String courseName = form.getCourseName();
						String traineeName = form.getTrainingDate();
						GenerateCertificateForm bean = new GenerateCertificateForm();
						List<GenerateCertificateForm> resulList = new ArrayList<GenerateCertificateForm>();
						System.out.println("courseName "+courseName + " traineeName "+traineeName);
						Session session = this.sessionFactory.getCurrentSession();
						List<Object[]> list = session.createSQLQuery("select  cast('Jyoti' as varchar(20) ) as traineeName ,  cast('Java' as varchar(20)) as CourseName ,cast('Mahape' as varchar(20) ) as TrainingLab , cast('2016-12-16' as varchar(20)) as TrainingDate ,cast('12:00' as varchar(20)) as TrainingTime , cast('Present' as varchar(20)) as status   ").list();
						for (Object[] li : list ) {
							
							bean.setTraineeName( (String) li[0]);
							bean.setCourseName((String) li[1]);
							bean.setTrainingLab((String) li[2]);
							bean.setTrainingDate((String) li[3]);
							bean.setTrainingTime((String) li[4]);
							bean.setAttendance( (String)li[5]);

							//logger.info("generateCertificateForm List::" + li);
							resulList.add(bean);
						}
						return resulList;
					}
	
	// managecurriculum
	@Override
	public void addManageCourseCarricullum(ManageCourseCarricullum p) {
		// TODO Auto-generated method stub
		System.out.println("getTrainingName " + p.getTrainingName());
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);

		// new ZLogger("ManageCourseCarricullum saved successfully","",
		// "ManageCourseCarricullum Details=" + p);
	}

	@Override
	public void updateManageCourseCarricullum(ManageCourseCarricullum p) {
		// TODO Auto-generated method stub
		System.out.println("aaaaaa");
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		// new ZLogger("ManageCourseCarricullum updated successfully",
		// "","ManageCourseCarricullum Details=" + p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ManageCourseCarricullum> listManageCourseCarricullum() {
		// TODO Auto-generated method stub
		System.out.println("inside manageCourseCarrilcullum");
		Session session = this.sessionFactory.getCurrentSession();
		List<ManageCourseCarricullum> mccList = session.createQuery("from ManageCourseCarricullum").list();
		for (ManageCourseCarricullum p : mccList) {
			// new ZLogger("","","ManageCourseCarricullum List::" + p);
		}
		return mccList;
	}

	@Override
	public ManageCourseCarricullum getManageCourseCarricullumById(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		// ManageCourseCarricullum p = (ManageCourseCarricullum)
		// session.load(ManageCourseCarricullum.class, new Integer(id));
		Query query = session.createQuery("from ManageCourseCarricullum where id=" + id);
		List<ManageCourseCarricullum> ManageCourseCarricullumList = query.list();
		ManageCourseCarricullum p = ManageCourseCarricullumList.get(0);
		// new ZLogger("ManageCourseCarricullum loaded successfully",
		// "","ManageCourseCarricullum details=" + p);
		return p;
	}

	@Override
	public void removeManageCourseCarricullum(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		ManageCourseCarricullum p = (ManageCourseCarricullum) session.load(ManageCourseCarricullum.class,
				new Integer(id));
		if (null != p) {
			session.delete(p);
		}
	}



	//viewTrainingCalendar
	@Override
	public List<ViewTrainingCalendarForm> listviewTrainingCalendar(ViewTrainingCalendarForm form) {
		// TODO Auto-generated method stub
		System.out.println("inside listviewTrainingCalendar");
		String courseName = form.getCourseName();
		String traineeName = form.getTrainingDate();
		ViewTrainingCalendarForm bean = new ViewTrainingCalendarForm();
		List<ViewTrainingCalendarForm> resulList = new ArrayList<ViewTrainingCalendarForm>();
		System.out.println("courseName "+courseName + " traineeName "+traineeName);
		Session session = this.sessionFactory.getCurrentSession();
		List<Object[]> list = session.createSQLQuery("select  cast('Manidra' as varchar(20) ) as trainerName ,  cast('Java' as varchar(20)) as CourseName , cast('2016-12-16 12:00' as varchar(20)) as TrainingDate , cast('Mahape' as varchar(20) ) as TrainingLab , cast('25'  as varchar(20)) as NoOfSeats , cast('15' as  varchar(20)) as NoOfEnrollment   ").list();
		for (Object[] li : list ) {
			
			bean.setTrainerName( (String) li[0]);
			bean.setCourseName((String) li[1]);
			bean.setTrainingDate((String) li[2]);
			bean.setTrainingLab((String) li[3]);
			bean.setNoOfSeats((String) li[4]);
			bean.setNoOfEnrollment((String) li[5]);

			//new ZLogger("listviewTrainingCalendar List::" + li,"","");
			resulList.add(bean);
		}
		return resulList;
	}
	
	//listmanageTrainingCalendar
	@Override
	public List<ManageTrainingCalendarForm> listmanageTrainingCalendar(ManageTrainingCalendarForm form) {
		// TODO Auto-generated method stub
		System.out.println("inside manageTrainingCalendarForm");
		String courseName = form.getCourseName();
		String traineeName = form.getTrainingDate();
				ManageTrainingCalendarForm bean = new ManageTrainingCalendarForm();
		List<ManageTrainingCalendarForm> resulList = new ArrayList<ManageTrainingCalendarForm>();
		System.out.println("courseName "+courseName + " traineeName "+traineeName);
		Session session = this.sessionFactory.getCurrentSession();
		List<Object[]> list = session.createSQLQuery("select cast('Java' as varchar(20)) as CourseName , cast('2016-12-16 12:00' as varchar(20)) as TrainingDate , cast('Mahape' as varchar(20) ) as TrainingLab , cast('Update' as varchar(20)) as status , cast('Test Comments' as varchar(20)) as comments  ").list();
		for (Object[] li : list ) {
			
			bean.setCourseName((String) li[0]);
			bean.setTrainingDate((String) li[1]);
			bean.setTrainingLab((String) li[2]);
			bean.setStatus((String) li[3]);
			bean.setComments((String) li[4]);

			//new ZLogger("listmanageTrainingCalendar List::" + li,"","");
			resulList.add(bean);
		}
		return resulList;
	}
	
	@Override
	public List<ActivateAssessmentOfTraineeForm> listactivateAssessmentOfTrainee(ActivateAssessmentOfTraineeForm p) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		System.out.println("inside listactivateTrainingOfTrainee");
		String courseName = p.getCourseName();
		String traineeName = p.getTrainingDate();
		ActivateAssessmentOfTraineeForm bean = new ActivateAssessmentOfTraineeForm();
		List<ActivateAssessmentOfTraineeForm> resulList = new ArrayList<ActivateAssessmentOfTraineeForm>();
		System.out.println("courseName " + courseName + " traineeName " + traineeName);

		List<Object[]> list = session
				.createSQLQuery(
						"select cast('Java' as varchar(20)) as CourseName , cast('2040-12-16 12:00' as varchar(20)) as TrainingDate , cast('Mahape' as varchar(20) ) as TrainingLab , cast('Jyoti' as varchar(20)) as traineeName , cast('Present' as varchar(20)) as attendance  ")
				.list();
		for (Object[] li : list) {

			bean.setCourseName((String) li[0]);
			bean.setTrainingDate((String) li[1]);
			bean.setTrainingLab((String) li[2]);
			bean.setTraineeName((String) li[3]);
			bean.setAttendance((String) li[4]);
			new ZLogger("listactivateTrainingOfTrainee", "", "List:" + li);
			// logger.info("listactivateTrainingOfTrainee List::" + li);
			resulList.add(bean);
		}
		return resulList;
	}
	
	// listactivateTrainingOfTrainee
			@Override
			public List<ActivateTrainingOfTraineeForm> listactivateTrainingOfTrainee(ActivateTrainingOfTraineeForm form) {
				// TODO Auto-generated method stub
				System.out.println("inside listactivaaaaaaaaaaateTrainingOfTrainee");
				ActivateTrainingOfTraineeForm bean = new ActivateTrainingOfTraineeForm();
				List<ActivateTrainingOfTraineeForm> resulList = new ArrayList<ActivateTrainingOfTraineeForm>();

				Session session = this.sessionFactory.getCurrentSession();
				List<Object[]> list = session
						.createSQLQuery(
								"select cast('Java' as varchar(20)) as CourseName , cast('2025-12-16 12:00' as varchar(20)) as TrainingDate , cast('Mahape' as varchar(20) ) as TrainingLab , cast('Jyoti' as varchar(20)) as traineeName , cast('Present' as varchar(20)) as attendance  ")
						.list();
				for (Object[] li : list) {

					bean.setCourseName((String) li[0]);
					bean.setTrainingDate((String) li[1]);
					bean.setTrainingLab((String) li[2]);
					bean.setTraineeName((String) li[3]);
					bean.setAttendance((String) li[4]);
					new ZLogger("listactivateTrainingOfTrainee List::" + li,"","");
					//logger.info("listactivateTrainingOfTrainee List::" + li);
					resulList.add(bean);
				}
				return resulList;
			}
			// Region Mapping

			@Override
			public void addRegionMapping(RegionMapping p) {
				// TODO Auto-generated method stub
				System.out.println("RegionMapping " + p.getRegionName());
				Session session = this.sessionFactory.getCurrentSession();
				session.persist(p);
				new ZLogger("RegionMapping", " RegionMapping Details= " + p, "AdminDAOImpl.java");
				/*
				 * logger.info(
				 * "RegionMapping saved successfully, RegionMapping Details=" + p);
				 */
			}

			@Override
			public void updateRegionMapping(RegionMapping p) {
				// TODO Auto-generated method stub
				Session session = this.sessionFactory.getCurrentSession();
				session.update(p);
				/*
				 * logger.info(
				 * "RegionMapping updated successfully, RegionMapping Details=" + p);
				 */
			}

			@SuppressWarnings("unchecked")
			@Override
			public List<RegionMapping> listRegionMapping() {
				// TODO Auto-generated method stub
				System.out.println("inside RegionMapping");
				Session session = this.sessionFactory.getCurrentSession();
				List<RegionMapping> mccList = session.createQuery("from RegionMapping ").list();
				for (RegionMapping p : mccList) {

					new ZLogger("RegionMapping", "list.size() " + p, "AdminDAOImpl.java");
				}

				return mccList;
			}

			@Override
			public RegionMapping getRegionMappingById(int id) {
				// TODO Auto-generated method stub
				Session session = this.sessionFactory.getCurrentSession();
				Query query = session.createQuery("from RegionMapping where id=" + id);
				List<RegionMapping> RegionMappingList = query.list();
				RegionMapping p = RegionMappingList.get(0);
				return p;
			}

			@Override
			public void removeRegionMapping(int id) {
				// TODO Auto-generated method stub
				Session session = this.sessionFactory.getCurrentSession();
				RegionMapping p = (RegionMapping) session.load(RegionMapping.class, new Integer(id));
				if (null != p) {
					session.delete(p);
				}
				/*
				 * logger.info(
				 * "RegionMapping deleted successfully, RegionMapping details=" + p);
				 */
			}

			// Feedback Master

			@Override
			public void addFeedbackMaster(FeedbackMaster p) {
				// TODO Auto-generated method stub
				System.out.println("feedback " + p.getFeedback());
				Session session = this.sessionFactory.getCurrentSession();
				session.persist(p);
				new ZLogger("FeedbackMaster saved successfully", "", "FeedbackMaster Details=" + p);

			}

			@Override
			public void updateFeedbackMaster(FeedbackMaster p) {
				// TODO Auto-generated method stub
				Session session = this.sessionFactory.getCurrentSession();
				session.update(p);
				new ZLogger("FeedbackMaster updated successfully", "", "FeedbackMaster Details=" + p);
				// logger.info("FeedbackMaster updated successfully, FeedbackMaster
				// Details=" + p);
			}

			@SuppressWarnings("unchecked")
			@Override
			public List<FeedbackMaster> listFeedbackMasterForm() {
				// TODO Auto-generated method stub
				System.out.println("inside listFeedbackMasterForm");
				Session session = this.sessionFactory.getCurrentSession();
				List<FeedbackMaster> mccList = session.createQuery("from FeedbackMaster").list();
				for (FeedbackMaster p : mccList) {
					new ZLogger("FeedbackMaster list", "", "FeedbackMaster Details=" + p);
				}
				return mccList;
			}

			@Override
			public FeedbackMaster getFeedbackMasterById(int id) {
				// TODO Auto-generated method stub
				Session session = this.sessionFactory.getCurrentSession();
				Query query = session.createQuery("from FeedbackMaster where id=" + id);
				List<FeedbackMaster> FeedbackMasterList = query.list();
				FeedbackMaster p = FeedbackMasterList.get(0);
				return p;
			}

			@Override
			public void removeFeedbackMaster(int id) {
				// TODO Auto-generated method stub
				Session session = this.sessionFactory.getCurrentSession();
				FeedbackMaster p = (FeedbackMaster) session.load(FeedbackMaster.class, new Integer(id));
				if (null != p) {
					session.delete(p);
				}
				new ZLogger("FeedbackMaster deleted successfully", "", "FeedbackMaster Details=" + p);
				// logger.info("FeedbackMaster deleted successfully, FeedbackMaster
				// details=" + p);
			}
	
	
	// fotestGetQuestions

			@Override
			public List getQuestions(String data) {
				System.out.println("fotest dao questions "+data);
				String[] totalConnected = data.split("-");

				String assesmentTypeSearch = (totalConnected[0].split("="))[1];
				String trainingNameSearch = (totalConnected[1].split("="))[1];
				System.out.println(assesmentTypeSearch+trainingNameSearch);
		/*
				String unitCodeSearch1, moduleCodeSearch1;
				if (unitCodeSearch == 0) {
					unitCodeSearch1 = "%";
				} else {
					unitCodeSearch1 = (totalConnected[0].split("="))[1];
				}

				if (moduleCodeSearch == 0) {
					moduleCodeSearch1 = "%";
				} else {
					moduleCodeSearch1 = (totalConnected[0].split("="))[1];
				}

				System.out.println("unitcodesearch  " + unitCodeSearch + "  " + unitCodeSearch1);
				System.out.println("modulecodesearch   " + moduleCodeSearch + "  " + moduleCodeSearch1);
				StringBuffer wherebuffer = new StringBuffer();
				wherebuffer.append(" WHERE 1=1 ");
				if (unitCodeSearch > 0) {
					wherebuffer.append(" AND um.unitid=" + unitCodeSearch);
				}
				if (moduleCodeSearch > 0) {
					wherebuffer.append(" AND mm.moduleid=" + moduleCodeSearch);
				}

				Session session = sessionFactory.getCurrentSession();
				String sql = "select um.unitcode , mm.modulename , aq.questionnumber, aq.assessmentid, mm.modulecode   from assessmentquestions as aq "
						+ " inner join unitmaster as um on um.unitid= aq.unitmaster"
						+ " inner join modulemaster as mm on mm.moduleid= aq.modulemaster";
				sql = sql + wherebuffer.toString();
				Query query = session.createSQLQuery(sql);
				List list = query.list();
				System.out.println(list.size());
				return list;*/
				
				System.out.println("inside assessmentQuestionsForm");
				
				AssessmentQuestionsForm bean = new AssessmentQuestionsForm();
				List<AssessmentQuestionsForm> resulList = new ArrayList<AssessmentQuestionsForm>();
				Session session = this.sessionFactory.getCurrentSession();
				/*List<Object[]> list = session.createSQLQuery("select cast('Training' as varchar(20)) as assesmentType , cast('SCCC' as varchar(20)) as trainingName").list();
				*/
				Query query = session.createSQLQuery("select cast('Training' as varchar(20)) as assesmentType , cast('SCCC' as varchar(20)) as trainingName");
				List list = query.list();
				System.out.println(list.size());
				return list;
				
			}
			@Override
			public List<PersonalInformationTrainer> trainerUserManagementSearch(
					TrainerUserManagementForm trainerUserManagementForm) {
				Session session = sessionFactory.getCurrentSession();
				String FirstName = trainerUserManagementForm.getFirstName();
				String MiddleName = trainerUserManagementForm.getMiddleName();
				String LastName = trainerUserManagementForm.getLastName();
				String AadharNumber = trainerUserManagementForm.getAadharNumber();
				String status = trainerUserManagementForm.getStatus();

				if (FirstName.length() == 0) {
					FirstName = "%";
				}
				if (MiddleName.length() == 0) {
					MiddleName = "%";
				}
				if (LastName.length() == 0) {
					LastName = "%";
				}
				if (AadharNumber.length() == 0) {
					AadharNumber = "%";
				}
				if (status.equals("0")) {
					status = "%";
				}

				String join = " inner join loginDetails as ld on pitp.loginDetails = ld.id";
				String like = " where upper(pitp.FirstName) like '" + FirstName.toUpperCase() + "' and pitp.MiddleName like '"
						+ MiddleName + "' and pitp.LastName like '" + LastName + "' and " + "pitp.AadharNumber like '"
						+ AadharNumber + "' and ld.status like '" + status + "'";
				String select = "pitp.id,ld.loginid,pitp.FirstName,pitp.MiddleName,pitp.LastName,pitp.AadharNumber,pitp.logindetails ,(CASE WHEN ld.isActive = 'Y' THEN 'INACTIVE' ELSE 'ACTIVE' END) as updateStatus,(CASE WHEN ld.isActive = 'Y' THEN 'ACTIVE' ELSE 'INACTIVE' END) as currentstatus ";

				String sql = "Select " + select + "  from PersonalInformationTrainer as pitp " + join + like;
				Query query = session.createSQLQuery(sql);
				List<PersonalInformationTrainer> list = query.list();
				new ZLogger("trainerUserManagementSearch", "list  " + list, "AdminDAOImpl.java");
				if (list.size() > 0) {
					return list;
				} else {
					new ZLogger("trainerUserManagementSearch", "list size null", "AdminDAOImpl.java");
					list = null;
					return list;
				}
			}
			
			@Override
			public List<PersonalInformationTrainee> traineeUserManagementSearch(
					TraineeUserManagementForm traineeUserManagementForm) {
				Session session = sessionFactory.getCurrentSession();
				String FirstName = traineeUserManagementForm.getFirstName();
				String MiddleName = traineeUserManagementForm.getMiddleName();
				String LastName = traineeUserManagementForm.getLastName();
				String AadharNumber = traineeUserManagementForm.getAadharNumber();
				String status = traineeUserManagementForm.getStatus();

				if (FirstName.length() == 0) {
					FirstName = "%";
				}
				if (MiddleName.length() == 0) {
					MiddleName = "%";
				}
				if (LastName.length() == 0) {
					LastName = "%";
				}
				if (AadharNumber.length() == 0) {
					AadharNumber = "%";
				}
				if (status.equals("0")) {
					status = "%";
				}

				String join = " inner join loginDetails as ld on pitp.loginDetails = ld.id";
				String like = " where upper(pitp.FirstName) like '" + FirstName.toUpperCase() + "' and pitp.MiddleName like '"
						+ MiddleName + "' and pitp.LastName like '" + LastName + "' and " + "pitp.AadharNumber like '"
						+ AadharNumber + "' and ld.status like '" + status + "'";
				String select = "pitp.id,ld.loginid,pitp.FirstName,pitp.MiddleName,pitp.LastName,pitp.AadharNumber,pitp.logindetails ,(CASE WHEN ld.isActive = 'Y' THEN 'INACTIVE' ELSE 'ACTIVE' END) as updateStatus,(CASE WHEN ld.isActive = 'Y' THEN 'ACTIVE' ELSE 'INACTIVE' END) as currentstatus ";

				String sql = "Select " + select + "  from PersonalInformationTrainee as pitp " + join + like;
				Query query = session.createSQLQuery(sql);
				List<PersonalInformationTrainee> list = query.list();
				new ZLogger("traineeUserManagementSearch", "list  " + list, "AdminDAOImpl.java");
				if (list.size() > 0) {
					return list;
				} else {
					new ZLogger("traineeUserManagementSearch", "list size null", "AdminDAOImpl.java");
					list = null;
					return list;
				}
			}
			@Override
			public List<PersonalInformationTrainingPartner> trainingPartnerUserManagementSearch(
					TrainingPartnerUserManagementForm trainingPartnerUserManagementForm) {
				// TODO Auto-generated method stub
				 {
					 System.out.println("in trainingPartnerUserManagementSearch");
					Session session = sessionFactory.getCurrentSession();
					String firstName = trainingPartnerUserManagementForm.getFirstName();
					String middleName = trainingPartnerUserManagementForm.getMiddleName();
					String lastName = trainingPartnerUserManagementForm.getLastName();
					String userId = trainingPartnerUserManagementForm.getUserId();
					String status = trainingPartnerUserManagementForm.getStatus();

					if (firstName.length() == 0) {
						firstName = "%";
					}
					if (middleName.length() == 0) {
						middleName = "%";
					}
					if (lastName.length() == 0) {
						lastName = "%";
					}
					if (userId.length() == 0) {
						userId = "%";
					}
					if (status.equals("0")) {
						status = "%";
					}

					String join = " inner join loginDetails as ld on pitp.loginDetails = ld.id";
					String like = " where upper(pitp.firstName) like '" + firstName.toUpperCase() + "' and pitp.middleName like '"
							+ middleName + "' and pitp.lastName like '" + lastName + "' and " + "pitp.userId like '"
							+ userId + "' and ld.status like '" + status + "'";
					String select = "pitp.id,ld.loginid,pitp.firstName,pitp.middleName,pitp.lastName,pitp.userId,pitp.logindetails ,(CASE WHEN ld.isActive = 'Y' THEN 'INACTIVE' ELSE 'ACTIVE' END) as updateStatus,(CASE WHEN ld.isActive = 'Y' THEN 'ACTIVE' ELSE 'INACTIVE' END) as currentstatus ";

					String sql = "Select " + select + "  from PersonalInformationTrainingPartner as pitp " + join + like;
					Query query = session.createSQLQuery(sql);
					List<PersonalInformationTrainingPartner> list = query.list();
					new ZLogger("PersonalInformationTrainingPartner", "list  " + list, "AdminDAOImpl.java");
					if (list.size() > 0) {
						return list;
					} else {
						new ZLogger("PersonalInformationTrainingPartner", "list size null", "AdminDAOImpl.java");
						list = null;
						return list;
					}
			}
			
}
			// listactivateTrainingOfTrainee
						@Override
						public List<ActivateUserIdForm> listactivateUserId(ActivateUserIdForm form) {
							// TODO Auto-generated method stub
							System.out.println("inside listactivaaaaaaaaaaateTrainingOfTrainee");
							ActivateUserIdForm bean = new ActivateUserIdForm();
							List<ActivateUserIdForm> resulList = new ArrayList<ActivateUserIdForm>();

							Session session = this.sessionFactory.getCurrentSession();
							List<Object[]> list = session
									.createSQLQuery(
											"select cast('Supriya' as varchar(20)) as UserName , cast('1122' as varchar(20)) as UserId , cast('Trainer' as varchar(20) ) as ProfileCode ")
									.list();
							for (Object[] li : list) {

								
								bean.setUserName((String) li[0]);
								bean.setUserId((String) li[1]);
								bean.setProfileCode((String) li[2]);
								
								new ZLogger("listactivateTrainingOfTrainee List::" + li,"","");
								//logger.info("listactivateTrainingOfTrainee List::" + li);
								resulList.add(bean);
							}
							return resulList;
						}

						
						
						
						
						
						// listactivateTrainingOfTrainee
						@Override
						public List<AdminHomePageForm> listPendingTraineeEnrollment(AdminHomePageForm form) {
							// TODO Auto-generated method stub
							System.out.println("inside listactivaaaaaaaaaaateTrainingOfTrainee");
							AdminHomePageForm bean = new AdminHomePageForm();
							List<AdminHomePageForm> resulList = new ArrayList<AdminHomePageForm>();

							Session session = this.sessionFactory.getCurrentSession();
							List<Object[]> list = session
									.createSQLQuery(
											"select cast('Lc-Ims' as varchar(20)) as courseName , cast('20' as varchar(20)) as noOfEnroll , cast('12/05/2017' as varchar(20) ) as trainingDate ")
									.list();
							for (Object[] li : list) {

								bean.setCourseName((String) li[0]);
								bean.setNoOfEnroll((String) li[1]);
								bean.setTrainingDate((String) li[2]);
								
								new ZLogger("listactivateTrainingOfTrainee List::" + li,"","");
								//logger.info("listactivateTrainingOfTrainee List::" + li);
								resulList.add(bean);
							}
							return resulList;
						}
						
						
						
						
						
						
						
						
						// listactivateTrainingOfTrainee
						@Override
						public List<AdminHomePageForm> listuserIdActivation(AdminHomePageForm form) {
							// TODO Auto-generated method stub
							System.out.println("inside listactivaaaaaaaaaaateTrainingOfTrainee");
							AdminHomePageForm bean = new AdminHomePageForm();
							List<AdminHomePageForm> resulList = new ArrayList<AdminHomePageForm>();

							Session session = this.sessionFactory.getCurrentSession();
							List<Object[]> list = session
									.createSQLQuery(
											"select cast('Trainer' as varchar(20)) as UserType, cast('30' as varchar(20)) as noOfUsers ")
									.list();
							for (Object[] li : list) {

								
								bean.setUserType((String) li[0]);
								bean.setNoOfUsers((String) li[1]);
								
								
								new ZLogger("listactivateTrainingOfTrainee List::" + li,"","");
								//logger.info("listactivateTrainingOfTrainee List::" + li);
								resulList.add(bean);
							}
							return resulList;
						}
						
						
						
						
						
						
						
						
						
						
						
						
						
						// listactivateTrainingOfTrainee
						@Override
						public List<AdminHomePageForm> listpendingRequestForCalendar(AdminHomePageForm form) {
							// TODO Auto-generated method stub
							System.out.println("inside listactivaaaaaaaaaaateTrainingOfTrainee");
							AdminHomePageForm bean = new AdminHomePageForm();
							List<AdminHomePageForm> resulList = new ArrayList<AdminHomePageForm>();

							Session session = this.sessionFactory.getCurrentSession();
							List<Object[]> list = session
									.createSQLQuery(
											"select cast('Lc-MS/IS' as varchar(20)) as courseName , cast('12/05/2017' as varchar(20)) as trainingDate , cast('update' as varchar(20) ) as requestType  , cast('220' as varchar(20) ) as noOfRequest ")
									.list();
							for (Object[] li : list) {

								
								bean.setCourseName((String) li[0]);
								bean.setTrainingDate((String) li[1]);
								bean.setRequestType((String) li[2]);
								bean.setNoOfRequest((String) li[3]);
								new ZLogger("listactivateTrainingOfTrainee List::" + li,"","");
								//logger.info("listactivateTrainingOfTrainee List::" + li);
								resulList.add(bean);
							}
							return resulList;
						}
						
			
}

			