package com.ir.dao.impl;

import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ir.constantes.Constantes;
import com.ir.constantes.TableLink;
import com.ir.dao.AdminDAO;
import com.ir.dao.TraineeDAO;
import com.ir.dao.TrainerDAO;
import com.ir.form.ApplyForPostForm;
import com.ir.form.ChangePasswordForm;
import com.ir.form.ContactTrainee;
import com.ir.form.CourseEnrolledUserForm;
import com.ir.form.FeedbackForm;
import com.ir.form.MyCalendarForm;

import com.ir.form.PlannedTrainingCalendarForm;
import com.ir.form.RegistrationFormTrainee;
import com.ir.form.TrainerHomePageForm;
import com.ir.form.TrainerRequestForm;
import com.ir.model.AdmitCardForm;
import com.ir.model.CertificateInfo;
import com.ir.model.CheckAadhar;
import com.ir.model.City;
import com.ir.model.ContactTraineee;
import com.ir.model.CourseEnrolledUser;
import com.ir.model.CourseName;
import com.ir.model.CourseTrainee;
import com.ir.model.CourseType;
import com.ir.model.District;
import com.ir.model.FeedbackMaster;
import com.ir.model.KindOfBusiness;
import com.ir.model.LoginDetails;
import com.ir.model.ManageTrainingPartner;
import com.ir.model.PersonalInformationTrainee;
import com.ir.model.PersonalInformationTrainer;
import com.ir.model.PersonalInformationTrainingInstitute;
import com.ir.model.State;
import com.ir.model.Title;
import com.ir.model.TrainingCalendar;
import com.ir.model.Utility;
import com.ir.service.PageLoadService;
import com.ir.util.ChangePasswordUtility;
import com.ir.util.EncryptionPasswordANDVerification;
import com.ir.util.PasswordGenerator;
import com.ir.util.SendContectMail;
import com.zentech.logger.ZLogger;

@Service
public class TrainerDAOImpl implements TrainerDAO {

	@Autowired
	@Qualifier("sessionFactory")
	public SessionFactory sessionFactory;

	@Autowired
	@Qualifier("changePasswordUtility")
	public ChangePasswordUtility changePasswordUtility;

	@Autowired
	@Qualifier("pageLoadService")
	PageLoadService pageLoadService;

	@Override
	public List<TrainerRequestForm> listTrainerRequest(TrainerRequestForm s) {
		// TODO Auto-generated method stub
		System.out.println("inside listTrainingRequestForm");
		TrainerRequestForm bean;
		List<TrainerRequestForm> list = new ArrayList<TrainerRequestForm>();
		Session session = this.sessionFactory.getCurrentSession();

		List<Object[]> lst = session.createSQLQuery(
				" select *  from trainingschedule ts where ts.trainingtype = '"
						+ s.getTrainingType() + "'and ts.usertype='"
						+ s.getUserType() + "'and ts.traininginstitudestatus='"
						+ s.getStatus() + "'").list();

		for (Object[] li : lst) {
			bean = new TrainerRequestForm();
			bean.setId((int) li[0]);
			bean.setTrainingType((String) li[16]);
			bean.setUserType((String) (li[20]));
			// bean.setUnit((String) li[3]);
			// bean.setModule((String) li[4]);
			// bean.setTrainingCenter((String) li[5]);
			bean.setTrainingStartDate((String) li[15]);
			bean.setTrainingEndDate((String) li[10]);
			// bean.setNop((String) li[9]);
			bean.setStatus((String) li[12]);
			// bean.setUpdateHistory((String) li[11]);

			list.add(bean);
		}
		System.out.println("list " + list);
		return list;
	}

	@Override
	public List<MyCalendarForm> listMyCalendar() {
		// TODO Auto-generated method stub
		System.out.println("inside listMyCalendarForm");
		MyCalendarForm bean = new MyCalendarForm();
		List<MyCalendarForm> list = new ArrayList<MyCalendarForm>();
		Session session = this.sessionFactory.getCurrentSession();
		List<Object[]> lst = session
				.createSQLQuery(
						"select cast('1' as int) as id , cast('Induction' as varchar(20)) as trainingType ,cast('FSO' as varchar(20)) as userType  ,cast('26-03-2017' as varchar(40)) as trainingDate,cast('1' as varchar(20)) as unit,cast('Basic' as varchar(20)) as module,cast('12:00 AM' as varchar(20)) as startTime,cast('2:00 PM' as varchar(20)) as endTime, cast('Goa FDA' as varchar(20)) as centerDetails ,cast('completed' as varchar(20)) as status")
				.list();
		for (Object[] li : lst) {
			bean.setId((int) li[0]);
			bean.setTrainingType((String) li[1]);
			bean.setUserType((String) (li[2]));
			bean.setTrainingDate((String) li[3]);
			bean.setUnit((String) li[4]);
			bean.setModule((String) li[5]);
			bean.setStartTime((String) li[6]);
			bean.setEndTime((String) li[7]);
			bean.setCenterDetails((String) li[8]);
			bean.setStatus((String) li[9]);

			list.add(bean);
		}
		System.out.println("list " + list);
		return list;
	}

	/*
	 * // listTrainingType
	 * 
	 * @Override public List<UnitMaster> listTrainingType() { // TODO
	 * Auto-generated method stub System.out.println("inside listTrainingType");
	 * Session session = this.sessionFactory.getCurrentSession();
	 * List<UnitMaster> mccList = session.createQuery("from UnitMaster").list();
	 * for (UnitMaster p : mccList) { System.out.println("unitmaster List::" +
	 * p); } return mccList; } // listUserType
	 * 
	 * @Override public List<UnitMaster> listUserType() { // TODO Auto-generated
	 * method stub System.out.println("inside listUserType"); Session session =
	 * this.sessionFactory.getCurrentSession(); List<UnitMaster> mccList =
	 * session.createQuery("from UnitMaster").list(); for (UnitMaster p :
	 * mccList) { System.out.println("unitmaster List::" + p); } return mccList;
	 * }
	 * 
	 * // listStatusType
	 * 
	 * @Override public List<UnitMaster> listStatusType() { // TODO
	 * Auto-generated method stub System.out.println("inside listStatusType");
	 * Session session = this.sessionFactory.getCurrentSession();
	 * List<UnitMaster> mccList = session.createQuery("from UnitMaster").list();
	 * for (UnitMaster p : mccList) { System.out.println("unitmaster List::" +
	 * p); } return mccList; }
	 */
	//traineeFeedback
			@Override
			public List<FeedbackForm> listtrainerFeedback() {
				System.out.println("inside listprintAdmitCard");
				FeedbackForm bean = new FeedbackForm();
				List<FeedbackForm> resulList = new ArrayList<FeedbackForm>();
				Session session = this.sessionFactory.getCurrentSession();
				List<Object[]> list = session.createSQLQuery("select cast('ICP-MS' as varchar(20)) as courseName , cast('02/05/2017' as varchar(20)) as trainingDate ,  cast('02:00 PM' as varchar(20)) as trainingTime , cast('Adlabs' as varchar(20)) as trainingLab    ").list();
				for (Object[] li : list ) {
					
					bean.setCourseName((String) li[0]);
					bean.setTrainingDate((String) li[1]);
					bean.setTrainingTime((String) li[2]);
					bean.setTrainingLab((String) li[3]);
					new ZLogger("traineeFeedback", "List:" + li, "TraineeDAOImpl.java");
					//logger.info("traineeFeedback List::" + li);
					resulList.add(bean);
				}
				return resulList;
			}

			
			//PlannedTrainingCalendar
			@Override
			public List<PlannedTrainingCalendarForm> listPlannedTrainingCalendar() {
				System.out.println("inside listMyCourses");
				PlannedTrainingCalendarForm bean = new PlannedTrainingCalendarForm();
				List<PlannedTrainingCalendarForm> resulList = new ArrayList<PlannedTrainingCalendarForm>();
				Session session = this.sessionFactory.getCurrentSession();
				List<Object[]> list = session.createSQLQuery("select cast('ICP-MS' as varchar(20)) as courseName , cast('02/05/2017' as varchar(20)) as trainingDate ,  cast('02:00 PM' as varchar(20)) as trainingTime , cast('Adlabs' as varchar(20)) as trainingLab,cast('supriya' as varchar(20)) as name ,cast('zentech@zentechinfo.com' as varchar(20)) as email,cast('pending' as varchar(20)) as status     ").list();
				for (Object[] li : list ) {
					
					bean.setCourseName((String) li[0]);
					bean.setTrainingDate((String) li[1]);
					bean.setTrainingTime((String) li[2]);
					bean.setTrainingLab((String) li[3]);
					bean.setName((String) li[4]);
					bean.setEmail((String) li[5]);
					bean.setStatus((String) li[6]);
					new ZLogger("MyCoursesForm", "List:" + li, "TraineeDAOImpl.java");
					//logger.info("traineeFeedback List::" + li);
					resulList.add(bean);
				}
				return resulList;
			}
			
			//apply for post
			@Override
			public List<ApplyForPostForm> listapplyForPost(ApplyForPostForm form) {
				// TODO Auto-generated method stub

				ApplyForPostForm bean = new ApplyForPostForm();
				List<ApplyForPostForm> resulList = new ArrayList<ApplyForPostForm>();
				Session session = this.sessionFactory.getCurrentSession();
				List<Object[]> list = session.createSQLQuery("select cast('GC MS/MS' as varchar(20)) as courseName , cast('Adlab' as varchar(20)) as trainingCenter ,  cast(' 	Mr. Anuj, WA-10, Kotla Marg, New Delhi, 9900112288' as varchar(50)) as contactPerson , cast('20' as varchar(20)) as vacancy   ").list();
				for (Object[] li : list ) {
					
					bean.setCourseName((String) li[0]);
					bean.setTrainingCenter((String) li[1]);
					bean.setContactPerson((String) li[2]);
					bean.setVacancy((String) li[3]);
					
					//logger.info("listapplyForPost List::" + li);
					resulList.add(bean);
				}
				return resulList;
			}
			//traineeFeedback
			@Override
			public List<FeedbackForm> listtrainingPartnerFeedback() {
				System.out.println("inside TrainingPartnerFeedbackForm");
				FeedbackForm bean = new FeedbackForm();
				List<FeedbackForm> resulList = new ArrayList<FeedbackForm>();
				Session session = this.sessionFactory.getCurrentSession();
				List<Object[]> list = session.createSQLQuery("select cast('ICP-MS' as varchar(20)) as courseName , cast('02/06/1995' as varchar(20)) as trainingDate ,  cast('02:00 PM' as varchar(20)) as trainingTime , cast('Adlabs' as varchar(20)) as trainingLab    ").list();
				for (Object[] li : list ) {
					
					bean.setCourseName((String) li[0]);
					bean.setTrainingDate((String) li[1]);
					bean.setTrainingTime((String) li[2]);
					bean.setTrainingLab((String) li[3]);
					new ZLogger("traineeFeedback", "List:" + li, "TraineeDAOImpl.java");
					//logger.info("traineeFeedback List::" + li);
					resulList.add(bean);
				}
				return resulList;
			}
			//traineeFeedback
			@Override
			public List<FeedbackForm> listFeedback() {
				System.out.println("inside listprintAdmitCard");
				FeedbackForm bean = new FeedbackForm();
				List<FeedbackForm> resulList = new ArrayList<FeedbackForm>();
				Session session = this.sessionFactory.getCurrentSession();
				List<Object[]> list = session.createSQLQuery("select cast('ICP-MS' as varchar(20)) as courseName , cast('19/05/2017' as varchar(20)) as trainingDate ,  cast('02:00 PM' as varchar(20)) as trainingTime , cast('Adlabs' as varchar(20)) as trainingLab    ").list();
				for (Object[] li : list ) {
					
					bean.setCourseName((String) li[0]);
					bean.setTrainingDate((String) li[1]);
					bean.setTrainingTime((String) li[2]);
					bean.setTrainingLab((String) li[3]);
					new ZLogger("traineeFeedback", "List:" + li, "TraineeDAOImpl.java");
					//logger.info("traineeFeedback List::" + li);
					resulList.add(bean);
				}
				return resulList;
			}
			
			//trainerHomepage
			@Override
			public List<TrainerHomePageForm> listtrainerHomepage() {
				System.out.println("inside trainerHomepage");
				TrainerHomePageForm bean = new TrainerHomePageForm();
				List<TrainerHomePageForm> resulList = new ArrayList<TrainerHomePageForm>();
				Session session = this.sessionFactory.getCurrentSession();
				List<Object[]> list = session.createSQLQuery("select cast('ICP-MS' as varchar(20)) as courseName , cast('19/05/2017' as varchar(20)) as trainingDate ,  cast('02:00 PM' as varchar(20)) as trainingTime , cast('Adlabs' as varchar(20)) as trainingLab ,cast('Mr.Smith' as varchar(20)) as contactPersonName,cast('lorem@ipsum.com' as varchar(20)) as email").list();
				for (Object[] li : list ) {
					
					bean.setCourseName((String) li[0]);
					bean.setTrainingDate((String) li[1]);
					bean.setTrainingTime((String) li[2]);
					bean.setTrainingLab((String) li[3]);
					bean.setContactPersonName((String) li[4]);
					bean.setEmail((String) li[5]);
					new ZLogger("trainerHomepage", "List:" + li, "TraineeDAOImpl.java");
					//logger.info("traineeFeedback List::" + li);
					resulList.add(bean);
				}
				return resulList;
			}
			
			@Override
			public List<TrainerHomePageForm> listopenVacancies() {
				System.out.println("inside trainerHomepage");
				TrainerHomePageForm bean = new TrainerHomePageForm();
				List<TrainerHomePageForm> resulList = new ArrayList<TrainerHomePageForm>();
				Session session = this.sessionFactory.getCurrentSession();
				List<Object[]> list = session.createSQLQuery("select cast('ICP-MS' as varchar(20)) as courseName , cast('ICP-MS Certification' as varchar(20)) as trainerProgram , cast('ICP-MS Certification' as varchar(20)) as trainerCourse , cast('ICP-MS Certification' as varchar(20)) as trainingSlot").list();
				for (Object[] li : list ) {
					
					bean.setCourseName((String) li[0]);
					bean.setTrainerProgram((String) li[1]);
					bean.setTrainerCourse((String) li[2]);
					bean.setTrainingSlot((String) li[3]);
					new ZLogger("trainerHomepage", "List:" + li, "TraineeDAOImpl.java");
					//logger.info("traineeFeedback List::" + li);
					resulList.add(bean);
				}
				return resulList;
			}
			@Override
			public List<TrainerHomePageForm> listjobApplication() {
				System.out.println("inside trainerHomepage");
				TrainerHomePageForm bean = new TrainerHomePageForm();
				List<TrainerHomePageForm> resulList = new ArrayList<TrainerHomePageForm>();
				Session session = this.sessionFactory.getCurrentSession();
				List<Object[]> list = session.createSQLQuery("select cast('ICP-MS' as varchar(20)) as courseName , cast('ICP-MS Certification' as varchar(20)) as trainerProgram , cast('ICP-MS Certification' as varchar(20)) as trainerCourse , cast('ICP-MS Certification' as varchar(20)) as trainingSlot,cast('selected' as varchar(20)) as status").list();
				for (Object[] li : list ) {
					
					bean.setCourseName((String) li[0]);
					bean.setTrainerProgram((String) li[1]);
					bean.setTrainerCourse((String) li[2]);
					bean.setTrainingSlot((String) li[3]);
					bean.setStatus((String) li[4]);
					new ZLogger("trainerHomepage", "List:" + li, "TraineeDAOImpl.java");
					//logger.info("traineeFeedback List::" + li);
					resulList.add(bean);
				}
				return resulList;
			}
}
