package com.ir.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.google.gson.Gson;
import com.ir.dao.TrainingInstitudeDAO;
import com.ir.form.AadharDetails;
import com.ir.form.AfterTraining;
import com.ir.form.BeforeTraining;
import com.ir.form.CertificateForm;
import com.ir.form.CertificationForm;
import com.ir.form.ChangePasswordForm;
import com.ir.form.ContactTrainee;
import com.ir.form.CourseEnrolledUserForm;
import com.ir.form.FeedbackForm;
import com.ir.form.FeedbackMasterForm;
import com.ir.form.GenerateCourseCertificateForm;
import com.ir.form.InstituteMyCalendarForm;
import com.ir.form.MarkAttendanceForm;
import com.ir.form.MyCoursesForm;
import com.ir.form.GetScoreCardForm;
import com.ir.form.MyTrainingForm;
import com.ir.form.OnlineAssessmentForm;
import com.ir.form.OnlineTrainingForm;
import com.ir.form.PrintAdmitCard;
import com.ir.form.RegistrationFormTrainee;
import com.ir.form.RegistrationFormTrainer;
import com.ir.form.TrainingRequestForm;
import com.ir.form.gcEnrollmentForm;
import com.ir.form.generalCourseEnrollmentForm;
import com.ir.form.icpEnrollmentForm;
import com.ir.form.lcEnrollmentForm;
import com.ir.model.AdmitCardForm;
import com.ir.model.AssessmentQuestion_old;
import com.ir.model.AssessmentQuestions;
import com.ir.model.CertificateInfo;
import com.ir.model.City;
import com.ir.model.CourseTrainee;
import com.ir.model.CourseType;
import com.ir.model.District;
import com.ir.model.FeedbackMaster;
import com.ir.model.KindOfBusiness;
import com.ir.model.ManageTrainingPartner;
import com.ir.model.PersonalInformationTrainee;
import com.ir.model.State;
import com.ir.model.SubjectMaster;
import com.ir.model.Title;
import com.ir.model.TraineeAssessment;
import com.ir.model.TrainingPartner_old;
import com.ir.model.Utility;
import com.ir.service.AdminService;
import com.ir.service.AssessmentService;
import com.ir.service.PageLoadService;
import com.ir.service.TraineeService;
import com.ir.util.Profiles;
import com.zentech.backgroundservices.Mail;
import com.zentech.logger.ZLogger;
import com.zentect.list.constant.ListConstant;

@Controller
@SessionAttributes
public class TraineeController {
	
	@Autowired
	@Qualifier("pageLoadService")
	PageLoadService pageLoadService;
	
	@Autowired
	ServletContext servletContext;
	
	@Autowired
	@Qualifier("traineeService")
	public TraineeService traineeService;
	
	@Autowired
	@Qualifier("adminService")
	AdminService adminService;
	
	//..
	@Autowired
	@Qualifier("trainingInstitudeService")
	TrainingInstitudeDAO trainingInstitudeService;
	
	
	@Autowired
	@Qualifier("assessmentService")
	public AssessmentService assessmentService;
	ListConstant lst =  new ListConstant(); 
	
	public boolean checkAccess(HttpSession session){
		if((int)session.getAttribute("profileId")!=3){	
			new ZLogger("Illegal profileId Access","By profileId  " +session.getAttribute("profileId") ,"TraineeController.java");
			return true;
		}
		else
			return false;
	}
	
	// Rishi 
	@RequestMapping(value="/contactTrainee" , method=RequestMethod.GET)
	public String contactTrainee(@ModelAttribute("contactTraineee") ContactTrainee contactTrainee, Model model , HttpSession session){
		try{
			Integer userId = (Integer) session.getAttribute("userId");
			Integer profileId = (Integer) session.getAttribute("profileId");
			String defaultMail = traineeService.getDefaultMailID(userId, profileId);
			model.addAttribute("defaultMail", defaultMail);
		}catch(Exception e){
			e.printStackTrace();
			new ZLogger("contactTrainee", "Exception while  contactTrainee "+e.getMessage(), "TraineeController.java");
		}
		return "contactTrainee";
	}
	@RequestMapping(value="/changePasswordTrainee" , method=RequestMethod.GET)
	public String contactTrainee(@ModelAttribute("changePasswordForm") ChangePasswordForm changePasswordForm ){
		return "changePasswordTrainee";
	}
	

	
	
	
	@RequestMapping(value="/basic" , method=RequestMethod.GET)
	public String basic(Model model,@ModelAttribute("basicTrainee") CourseEnrolledUserForm courseEnrolledUserForm ,
		 @ModelAttribute("loginUser") PersonalInformationTrainee pit ){// , Model modal , HttpSession session ){

		List<CourseType>  courseTypeList = traineeService.courseTypeList();
		List<ManageTrainingPartner> trainingPartnerList = trainingPartnerList = traineeService.trainingPartnerList();
		List<State> stateList = traineeService.stateList();
		model.addAttribute("stateList", stateList);
		model.addAttribute("courseTypeList", courseTypeList);
		model.addAttribute("trainingPartnerList", trainingPartnerList);
		
		return "basic";
	}
	
	
	@RequestMapping(value="/uploadImage" , method=RequestMethod.GET)
	public String uploadImage(@ModelAttribute("uploadImage") CourseEnrolledUserForm courseEnrolledUserForm ,
		 @ModelAttribute("loginUser") PersonalInformationTrainee pit ){
		return "upload-image";
	}
	
	
	@RequestMapping(value="/uploadProfile" , method=RequestMethod.GET)
	public String uploadProfiles(@ModelAttribute("uploadImage") CourseEnrolledUserForm courseEnrolledUserForm ,
		 @ModelAttribute("loginUser") PersonalInformationTrainee pit ){
		return "upload-image";
	}
	
	 @RequestMapping(value="saveFile",method=RequestMethod.POST)  
	    public String saveFile( @RequestParam CommonsMultipartFile file,  
	           HttpSession session) throws Exception{  
		 	String userName = "";
			try{
			userName = (String) session.getAttribute("userName");
			String ss = session.getServletContext().getRealPath("")
					.replace("Fssai_E-Learning_System", "Fostac/Trainer");
			File dir = new File(ss);
			if (!dir.exists())
				dir.mkdirs();
			String extension = "";
			String fileName = file.getOriginalFilename();
			int i = fileName.lastIndexOf('.');
			if (i > 0) {
				extension = fileName.substring(i + 1);
			}
			byte[] bytes = file.getBytes();
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File(ss + File.separator
							+ userName + "." +extension)));
			stream.write(bytes);
			stream.flush();
			stream.close();
		} catch (Exception e) {
			e.printStackTrace();
			new ZLogger("saveFile", "Exception while  saveFile "+e.getMessage(), "TraineeController.java");
		}
		return "upload-image";
	    }  
	
	 
	 
	 @RequestMapping(value="saveImage",method=RequestMethod.POST)  
	    public String saveImage( @RequestParam CommonsMultipartFile file,  
	           HttpSession session) throws Exception{  
		 	String userName = "";
			try{
				userName = (String) session.getAttribute("userName");
				//String ss = session.getServletContext().getContextPath();
				String ss = session.getServletContext().getRealPath("").replace("Fssai_E-Learning_System", "Fostac/Trainee");
				File dir = new File(ss);
				if (!dir.exists())
					dir.mkdirs();
			 	  
		    byte[] bytes = file.getBytes();  
		    BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(  
		         new File(ss + File.separator + userName+".png")));  
		    stream.write(bytes);  
		    stream.flush();  
		    stream.close();  
			}catch(Exception e){
				e.printStackTrace();
				new ZLogger("saveImage", "Exception while  saveImage "+e.getMessage(), "TraineeController.java");
			}
			     
	    return "upload-image";  
	    }  

	@RequestMapping(value="/courseTraining" , method=RequestMethod.GET)
	public String courseTraining(@RequestParam(value = "courseTypeId", required = true)  String courseTypeId , Model model, HttpSession session){
		Integer userId=Integer.parseInt(session.getAttribute("userId").toString());
		try{
				String docPath = "";
				String contentName = "";
				String pdf = ".pdf";
				String mp4 = ".mp4";
				String ppt = ".ppt";
				docPath = servletContext.getContextPath().replace("Fssai_E-Learning_System", "Fostac/Course/");
				if(userId>0){
					CourseTrainee  courseTrainee= traineeService.getCourseTrainingByCourseTypeID(userId);
					new ZLogger("courseTraining", "courseTrainee == "+courseTrainee.getCourseTypeId(), "TraineeController.java");
					new ZLogger("courseTraining","courseTrainee == "+courseTrainee.getContentNameInput() , "TraineeController.java");
					new ZLogger("courseTraining", "courseTrainee == "+courseTrainee.getContentLinkInput(), "TraineeController.java");
					
					if(courseTrainee != null && courseTrainee.getCourseTypeId() != null && courseTrainee.getCourseTypeId().toUpperCase().contains("BASIC")){
						if(courseTrainee.getContentLinkInput() != null && courseTrainee.getContentLinkInput().toUpperCase().contains("STUDY")){
							docPath = docPath + "BASIC/PDF/"+courseTrainee.getContentLinkInput()+pdf;
						}else if(courseTrainee.getContentLinkInput() != null && courseTrainee.getContentLinkInput().toUpperCase().contains("PPT")){
							docPath = docPath + "BASIC/PPT/"+courseTrainee.getContentLinkInput()+ppt;
						}else if(courseTrainee.getContentLinkInput() != null && courseTrainee.getContentLinkInput().toUpperCase().contains("VIDEO")){
							docPath = docPath + "BASIC/VIDEO/"+courseTrainee.getContentLinkInput()+mp4;
						}
					}else if(courseTrainee != null && courseTrainee.getCourseTypeId() != null && courseTrainee.getCourseTypeId().toUpperCase().contains("ADVANCE")){
						if(courseTrainee.getContentLinkInput() != null && courseTrainee.getContentLinkInput().toUpperCase().contains("STUDY")){
							docPath = docPath + "ADVANCE/PDF/"+courseTrainee.getContentLinkInput()+pdf;
						}else if(courseTrainee.getContentLinkInput() != null && courseTrainee.getContentLinkInput().toUpperCase().contains("PPT")){
							docPath = docPath + "ADVANCE/PPT/"+courseTrainee.getContentLinkInput()+ppt;
						}else if(courseTrainee.getContentLinkInput() != null && courseTrainee.getContentLinkInput().toUpperCase().contains("VIDEO")){
							docPath = docPath + "ADVANCE/VIDEO/"+courseTrainee.getContentLinkInput()+mp4;
						}
					}else if(courseTrainee != null && courseTrainee.getCourseTypeId() != null && courseTrainee.getCourseTypeId().toUpperCase().contains("SPECIAL")){
						if(courseTrainee.getContentLinkInput() != null && courseTrainee.getContentLinkInput().toUpperCase().contains("STUDY")){
							docPath = docPath + "SPECIAL/PDF/"+courseTrainee.getContentLinkInput()+pdf;
						}else if(courseTrainee.getContentLinkInput() != null && courseTrainee.getContentLinkInput().toUpperCase().contains("PPT")){
							docPath = docPath + "SPECIAL/PPT/"+courseTrainee.getContentLinkInput()+mp4;
						}else if(courseTrainee.getContentLinkInput() != null && courseTrainee.getContentLinkInput().toUpperCase().contains("VIDEO")){
							docPath = docPath + "SPECIAL/VIDEO/"+courseTrainee.getContentLinkInput();
						}
					}
					contentName = (courseTrainee != null ? "" :  courseTrainee.getContentNameInput());
					model.addAttribute("contentName", contentName);
					model.addAttribute("contentPath", docPath);
					System.out.println("********************** == "+courseTrainee);
					model.addAttribute("courseTrainee", courseTrainee);
			}
		}catch(Exception e){
			e.printStackTrace();
			new ZLogger("courseTraining", "Exception while  courseTraining "+e.getMessage(), "TraineeController.java");
		}
		return "courseTraining12";
	}
	
	
	@RequestMapping(value="/changePasswordTraineeSave" , method=RequestMethod.POST)
	public String changePasswordTraineeSave(@ModelAttribute("changePasswordForm") ChangePasswordForm changePasswordForm,HttpSession session
			,BindingResult result , Model model
			){
		if(result.hasErrors()){
			new ZLogger("changePasswordTraineeSave", "bindingResult.hasErrors  "+result.hasErrors() , "TraineeController.java");
			new ZLogger("changePasswordTraineeSave", "bindingResult.hasErrors  "+result.getErrorCount() +" All Errors "+result.getAllErrors(), "TraineeController.java");
			return "changePasswordTrainee";
		}
		try{
			String id =(String) session.getAttribute("logId");
			boolean changePasswordTraineeSave = traineeService.changePasswordTraineeSave(changePasswordForm , id);
			if(changePasswordTraineeSave){
				model.addAttribute("created" , "Your password has changed !!!");
			}else{
				model.addAttribute("created" , "Oops, something went wrong !!!");
			}
		}catch(Exception e){
			e.printStackTrace();
			new ZLogger("changePasswordTraineeSave", "Exception while changePasswordTraineeSave  "+e.getMessage() , "TraineeController.java");
		}
		return "changePasswordTrainee";
	}
	@RequestMapping(value="/contactTraineeSave" , method=RequestMethod.POST)
	public String contactTrainee1(@ModelAttribute("ContactTraineee") ContactTrainee contactTrainee
			,BindingResult result , HttpSession session, Model model
			){
		if(result.hasErrors()){
			new ZLogger("contactTraineeSave", "bindingResult.hasErrors  "+result.hasErrors() , "TraineeController.java");
			new ZLogger("contactTraineeSave", "bindingResult.hasErrors  "+result.getErrorCount() +" All Errors "+result.getAllErrors(), "TraineeController.java");
			return "contactTraineeSave";
		}
		model.addAttribute("ContactTrainee",  new ContactTrainee());
		try{
			String id=(String) session.getAttribute("userName");
			int id1=(int) session.getAttribute("userId");
			new ZLogger("contactTraineeSave","userid   "+ id  , "TraineeController.java");
			String contactTraineeSave = traineeService.contactTraineeSave(contactTrainee , id);
			if(contactTraineeSave.equalsIgnoreCase("created")){
				model.addAttribute("created" , "Your request has been sent successfully !!!");
			}else{
				model.addAttribute("created" , "Oops, something went wrong !!!");
			}
		}catch(Exception e){
			e.printStackTrace();
			new ZLogger("contactTraineeSave", "Exception while contactTraineeSave  "+e.getMessage() , "TraineeController.java");
		}
		return "traineeContact";
	}


	@RequestMapping(value="/updateInformation" , method=RequestMethod.GET)
	public String updateInformation(@RequestParam(value = "userId", required = true)  Integer userId ,@ModelAttribute("updateInformation") RegistrationFormTrainee registrationFormTrainee, HttpSession session, Model model ){		
		Integer profileID = 0;
		try{
			profileID = (Integer) session.getAttribute("profileId");
			if(profileID == 1 || profileID == 2){
				//Bases On User
			}else{
				userId = (Integer) session.getAttribute("userId");
			}
			
			 if(userId > 0){
					PersonalInformationTrainee personalInformationTrainee = traineeService.FullDetail(userId);
					Title title = new Title();
					//title.setTitleId(personalInformationTrainee.getTitle().getTitleId());
					//title.setTitleName(personalInformationTrainee.getTitle().getTitleName());
					List<Title> titleList = new ArrayList<Title>();
					titleList.add(title);
					List<KindOfBusiness> kindOfBusinessList=pageLoadService.loadKindOfBusiness();
					model.addAttribute("kindOfBusinessList" , kindOfBusinessList);
					session.setAttribute("loginUser", personalInformationTrainee);
					session.setAttribute("PersonalInformationTrainee", personalInformationTrainee);
					session.setAttribute("titleList", titleList);
				 }
		}catch(Exception e){
			e.printStackTrace();
			new ZLogger("updateInformation","Exception while updateInformation "+e.getMessage()   , "TraineeController.java");
		}
		return "updateInformation";
	}
	@RequestMapping(value="/updateTrainee" , method=RequestMethod.POST)
	public String updateTrainee(@RequestParam(value = "id", required = true)  Integer id,@ModelAttribute("updateInformation") RegistrationFormTrainee registrationFormTrainee ,BindingResult bindingResult, HttpSession session , Model model  ){
		Integer ss = 0;
		try{
			if(id <= 0){
				 ss = (Integer)session.getAttribute("loginUser1");
			}else{
				ss = id;
			}
			String updateTrainee = traineeService.updateTrainee(registrationFormTrainee , ss);
			if(updateTrainee != "")
			{
				new ZLogger("updateTrainee","Data are updated successfully"  , "TraineeController.java");
			}
			model.addAttribute("update", "Updated successfully !!!");
		}catch(Exception e){
			e.printStackTrace();
			new ZLogger("updateTrainee","Exception while updateTrainee "+e.getMessage()   , "TraineeController.java");
		}
		return "welcomeupdatetrainee";
	}
	
	
	@RequestMapping(value="/generateAdmitCardtrainee" , method=RequestMethod.GET)
	public String generateAdmitCardtrainee(@ModelAttribute("courseEnrolledUserForm") CourseEnrolledUserForm courseEnrolledUserForm ,BindingResult bindingResult, HttpSession session , Model model ){
		try{
			
			Integer userId=Integer.parseInt(session.getAttribute("userId").toString());
			if(userId>0){
				CourseTrainee  courseTrainee= traineeService.getCourseTrainingByCourseTypeID(userId);
				model.addAttribute("courseTrainee", courseTrainee);
			}
		}catch(Exception e){
			e.printStackTrace();
			new ZLogger("generateAdmitCardtrainee","Exception while generateAdmitCardtrainee "+e.getMessage()   , "TraineeController.java");
		}
		return "generateAdmitCardtrainee";
	}
	
	@RequestMapping(value="/admit-cardtrainee" , method=RequestMethod.GET)
	public String admitcardtrainee(@ModelAttribute("basicTrainee") CourseEnrolledUserForm courseEnrolledUserForm ,
			@ModelAttribute("state") State state , @ModelAttribute("tp") TrainingPartner_old tp,BindingResult result ,HttpSession session, Model model ){
		new ZLogger("admit-cardtrainee","Generate Admit Card .........................."  , "TraineeController.java");
		String imagePath = "";
		String userName = "";
		try{
			userName = (String) session.getAttribute("userName");
			String ss = servletContext.getContextPath().replace("Fssai_E-Learning_System", "Fostac/Trainee");
			imagePath = ss + File.separator + userName+".png";
			if(session.getAttribute("loginIdUnique")!=null){
				String loginid=session.getAttribute("loginIdUnique").toString();
				AdmitCardForm admitCardForm=traineeService.generateAdmitCard(Integer.parseInt(loginid),Profiles.TRAINEE.value());
				session.setAttribute("traineeSteps", 2);
				model.addAttribute("imagePath", imagePath);
				model.addAttribute("admitCardForm", admitCardForm);
			}
		}catch(Exception e){
			e.printStackTrace();
			new ZLogger("admit-cardtrainee","Exception while  = "+e.getMessage()  , "TraineeController.java");
		}
		
		return "admit-cardtrainee";
	}
	
	@RequestMapping(value="/viewTraineeList" , method=RequestMethod.GET)
	public String viewTraineeList(@ModelAttribute("courseEnrolledUserForm") CourseEnrolledUserForm courseEnrolledUserForm ,
			@ModelAttribute("state") State state , @ModelAttribute("loginUser") PersonalInformationTrainee pit ){
		return "viewTraineeList";
	}
	@RequestMapping(value ="/traineeAssessmentOnline", method = RequestMethod.GET)
	public String traineeAssessmentOnline(@ModelAttribute ("courseEnrolledUserForm")CourseEnrolledUserForm courseEnroledUserForm, Model model, HttpSession httpSession){
		String responseText = "";
		int loginId = -1;
		try{
		loginId = (int)httpSession.getAttribute("loginIdUnique");
		if(loginId > 0){
			TraineeAssessment traineeAssessment = new TraineeAssessment();
			int courseType = 1;
			int moduleId = 	traineeService.getCurrentModuleId(loginId);
			List<AssessmentQuestions> assessmentQuestions =  assessmentService.getAssessmentQuestions( moduleId);
			traineeAssessment.setListAssessmentQuestion(assessmentQuestions);
			traineeAssessment.setModuleId(moduleId);
			Gson gson=new Gson();
			String list=gson.toJson(traineeAssessment);
			responseText = "traineeAssessmentOnline";
			model.addAttribute("traineeAssessment",list);
		}
		}catch(Exception e){
			e.printStackTrace();
			responseText = "generic_error";
			new ZLogger("traineeAssessmentOnline","Exception while traineeAssessmentOnline"+e.getMessage()  , "TraineeController.java");
		}
		return responseText;
	}
	
	@RequestMapping(value="/generateCertificatetrainee" , method=RequestMethod.GET)
	public String generateCertificatetrainee(@ModelAttribute("courseEnrolledUserForm") CourseEnrolledUserForm courseEnrolledUserForm ,BindingResult bindingResult, HttpSession session , Model model){
		Integer userId=Integer.parseInt(session.getAttribute("userId").toString());
		try{
			if(userId>0){
				String isEligible = "";
				String isOnline=traineeService.isCourseOnline(userId);
				if(isOnline != null && isOnline.toUpperCase().contains("ONLINE")){
					model.addAttribute("ISONLINE","YES");
				}else{
					model.addAttribute("ISONLINE","NO");
				}
				isEligible = traineeService.isTraineeEligible(userId);
				System.out.println("*****isEligible****"+isEligible);
				if(isEligible != null && isEligible.equals("Y")){
					CourseTrainee  courseTrainee= traineeService.getCourseTrainingByCourseTypeID(userId);
					model.addAttribute("courseTrainee", courseTrainee);
				}
				new ZLogger("generateCertificatetrainee","isEligible ==== "+isEligible  , "TraineeController.java");
				model.addAttribute("Eligible", isEligible);
			}
		}catch(Exception e){
			e.printStackTrace();
			new ZLogger("generateCertificatetrainee","Exception while generateCertificatetrainee"+e.getMessage()  , "TraineeController.java");
		}
		return "generateCertificatetrainee";
	}
	
	@RequestMapping(value="/assessment-instructions-trainee" , method=RequestMethod.GET)
	public String assessmentinstructionstrainee(@ModelAttribute("registrationFormTrainer") RegistrationFormTrainer registrationFormTrainer,BindingResult bindingResult, HttpSession session , Model model )
	{
		Utility utility=new Utility();
		//Need to write service for AsssessorAgency 
		model.addAttribute("utility",utility);
		Integer userId = 0;
		try{
			userId = (Integer) session.getAttribute("userId");
			//OnlineTrainingForm trainingDetails = traineeService.listOnlineTraining(userId);
			
			//model.addAttribute("trainingDetails", trainingDetails);
		
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Exception while course details save : "+ e.getMessage());
			new ZLogger("assessment-instructions-trainee","Exception while assessment-instructions-trainee "+e.getMessage()  , "TraineeController.java");
		}
		return "assessment-instructions-trainee";
	}
	
	@RequestMapping(value="/feedback-form" , method=RequestMethod.GET)
	public String feedbackform(@ModelAttribute("registrationFormTrainer") RegistrationFormTrainer registrationFormTrainer )
	{
		return "feedback-form-trainee";
	}
	@RequestMapping(value="/course-training" , method=RequestMethod.GET)
	public String coursetraining(@ModelAttribute("registrationFormTrainer") RegistrationFormTrainer registrationFormTrainer, HttpSession session, Model model )
	{
		Integer userId = 0;
		try{
			userId = (Integer) session.getAttribute("userId");
			
			String pdf = ".pdf";
			String mp4 = ".mp4";
			String ppt = ".ppt";
			
			if(userId>0){
				CourseTrainee  courseTraineeDisplay= traineeService.getCourseTrainingByCourseTypeID(userId);
				List<CourseTrainee>  ListcourseTrainee= traineeService.getCourseTrainingByCourseTypeIDList(userId);
				System.out.println(" inside list "+ListcourseTrainee.size());
				List<String> listcontentName =  new ArrayList<String>();
				HashMap<String ,String> map = new HashMap<String , String>();
				List<String> listcontentPath =  new ArrayList<String>();
				List<String> listcontentLink =  new ArrayList<String>();
				for(CourseTrainee courseTrainee : ListcourseTrainee ){
					String docPath = "";
					docPath = servletContext.getContextPath().replace("Fssai_E-Learning_System", "Fostac/Course/");
				System.out.println(courseTrainee.getCourseTypeId().toUpperCase());
				
				if( courseTrainee.getCourseTypeId() != null && courseTrainee.getCourseTypeId().toUpperCase().contains("BASIC")){
					new ZLogger("course-training", courseTrainee.getContentLinkInput().toUpperCase() + " "+ courseTrainee.getContentLinkInput().toUpperCase().contains("STUDY")  , "TraineeController.java");
					
					if(courseTrainee.getContentLinkInput() != null && courseTrainee.getContentType().toUpperCase().contains("STUDYMATERIAL")){
						docPath = docPath + "BASIC/PDF/"+courseTrainee.getContentLinkInput()+pdf;
					}else if(courseTrainee.getContentLinkInput() != null && courseTrainee.getContentType().toUpperCase().contains("PPT")){
						docPath = docPath + "BASIC/PPT/"+courseTrainee.getContentLinkInput()+ppt;
					}else if(courseTrainee.getContentLinkInput() != null && courseTrainee.getContentType().toUpperCase().contains("VIDEOS")){
						docPath = docPath + "BASIC/VIDEO/"+courseTrainee.getContentLinkInput()+mp4;
					}
				}else if( courseTrainee.getCourseTypeId() != null && courseTrainee.getCourseTypeId().toUpperCase().contains("ADVANCE")){
					
					if(courseTrainee.getContentLinkInput() != null && courseTrainee.getContentType().toUpperCase().contains("STUDY")){
						docPath = docPath + "ADVANCE/PDF/"+courseTrainee.getContentLinkInput()+pdf;
					}else if(courseTrainee.getContentLinkInput() != null && courseTrainee.getContentType().toUpperCase().contains("PPT")){
						docPath = docPath + "ADVANCE/PPT/"+courseTrainee.getContentLinkInput()+ppt;
					}else if(courseTrainee.getContentLinkInput() != null && courseTrainee.getContentType().toUpperCase().contains("VIDEO")){
						docPath = docPath + "ADVANCE/VIDEO/"+courseTrainee.getContentLinkInput()+mp4;
					}
				}else if( courseTrainee.getCourseTypeId() != null && courseTrainee.getCourseTypeId().toUpperCase().contains("SPECIAL")){
					if(courseTrainee.getContentLinkInput() != null && courseTrainee.getContentType().toUpperCase().contains("STUDY")){
						docPath = docPath + "SPECIAL/PDF/"+courseTrainee.getContentLinkInput()+pdf;
					}else if(courseTrainee.getContentLinkInput() != null && courseTrainee.getContentType().toUpperCase().contains("PPT")){
						docPath = docPath + "SPECIAL/PPT/"+courseTrainee.getContentLinkInput()+mp4;
					}else if(courseTrainee.getContentLinkInput() != null && courseTrainee.getContentType().toUpperCase().contains("VIDEO")){
						docPath = docPath + "SPECIAL/VIDEO/"+courseTrainee.getContentLinkInput();
					}
				}
				System.out.println("courseTrainee.getContentNameInput() "+courseTrainee.getContentNameInput());
				System.out.println("docPath "+docPath);
				listcontentName.add(courseTrainee.getContentNameInput());
				
				map.put(docPath, courseTrainee.getContentNameInput());
				
				listcontentPath.add(docPath);
				listcontentLink.add(courseTrainee.getContentLinkInput());
			
			
				}
	
				model.addAttribute("contentName", listcontentName);
				model.addAttribute("contentPath", listcontentPath);
				model.addAttribute("contentLink", map);
				model.addAttribute("courseTrainee", courseTraineeDisplay);
				
			Utility utility=new Utility();
			//Need to write service for AsssessorAgency 
			model.addAttribute("utility",utility);
			String isOnline=traineeService.isCourseOnline(userId);
			new ZLogger("course-training", "user id = "+userId +" Online == "+isOnline  , "TraineeController.java");
			if(isOnline != null && isOnline.toUpperCase().contains("ONLINE")){
				model.addAttribute("ISONLINE","YES");
			}else{
				model.addAttribute("ISONLINE","NO");
			}
			}
		}catch(Exception e){
			e.printStackTrace();
			new ZLogger("course-training", "Exception while course-training  "+e.getMessage() , "TraineeController.java");
		}
		
		
		return "course-training-trainee";
		
	}
	
	
	
	
	@RequestMapping(value="/getCourseDetailss" , method=RequestMethod.POST)
	@ResponseBody
	public void getCourseDetailss(@RequestParam("data") String data ,@RequestBody GenerateCourseCertificateForm generateCourseCertificateForm,HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException{
		new ZLogger("getCourseDetailss","getCourseDetailss............" + data  , "TrainingPartnerController.java");
		List batchCodeList = traineeService.getCourseDetails(data);
		PrintWriter out = response.getWriter();
		Gson g =new Gson();
		String newList = g.toJson(batchCodeList); 
		System.out.println("newList "+newList);
		out.write(newList);
		out.flush();
		
	}
	
	
	
	/***************************************************** FOSREST*********************************************************************/
	
	
	
	/**
	 * @author Jyoti Mekal
	 */
	@RequestMapping(value = "/PersonalInformationTrainee", method = RequestMethod.GET)
	public String listSubjectMaster(@ModelAttribute("PersonalInformationTrainee") PersonalInformationTrainee personalInformationTrainee ,Model model , HttpServletRequest request,HttpSession session) {
			System.out.println("PersonalInformationTrainee ");
			session.setAttribute("aadhar", personalInformationTrainee == null ? "" : personalInformationTrainee.getAadharNumber());
			session.setAttribute("name",  personalInformationTrainee == null ? "" : personalInformationTrainee.getFirstName());
			session.setAttribute("middleName",  personalInformationTrainee == null ? "" : personalInformationTrainee.getMiddleName());
			session.setAttribute("lastName",  personalInformationTrainee == null ? "" : personalInformationTrainee.getLastName());
			session.setAttribute("dob" ,  personalInformationTrainee == null ? "" : personalInformationTrainee.getDob());
			
			
			System.out.println("profileId"+session.getAttribute("profileId"));
			String userId = request.getParameter("userId");
			model.addAttribute("listStateMaster", this.adminService.listStateMaster());
		   
			Map<String, String> titleMap = lst.titleMap;
			Map<String, String> opt = lst.noOfOptionMap;
			Map<String, String> qual = lst.QualCategoryMap;
			Map<String, String> subqual = lst.SubQualCategoryMap;
			Map<String, String> empcat = lst.employerCategoryMap;
			Map<String, String> des = lst.designationMap;

	        model.addAttribute("titleMap", titleMap);
			model.addAttribute("ExpInYearMap", opt);
			model.addAttribute("ExpInMonthMap", opt);
			model.addAttribute("QualCategoryMap", qual);
			model.addAttribute("SubQualCategoryMap", subqual);
			model.addAttribute("employerCategoryMap", empcat);
			model.addAttribute("designationMap", des);
			
			
			if (userId != null && Integer.parseInt(userId) > 0) {
				personalInformationTrainee = this.traineeService
						.FullDetail(Integer.parseInt(userId));
				model.addAttribute("PersonalInformationTrainee",
						personalInformationTrainee);
				model.addAttribute("isUpdate", "Y");
			}
				else if (session.getAttribute("userId")!=null) {
					personalInformationTrainee = this.traineeService
						.FullDetail((int)session.getAttribute("userId"));
				model.addAttribute("PersonalInformationTrainee",
						personalInformationTrainee);
				model.addAttribute("isUpdate", "Y");
			}
			else {
				model.addAttribute("PersonalInformationTrainee",
						new PersonalInformationTrainee());
			}
			
			/*System.out.println("profileId"+session.getAttribute("profileId"));
			if(session.getAttribute("profileId")==null)
				return "PersonalInformationTrainee";*/
			return "PersonalInformationTrainee";
			}
	
	
	
	@RequestMapping(value = "/PersonalInformationTraineeAdd", method = RequestMethod.POST)
	public String addPersonalInfoTrainee(@RequestParam CommonsMultipartFile file,  
			@Valid @ModelAttribute("PersonalInformationTrainee") PersonalInformationTrainee p, BindingResult result ,Model model , HttpServletRequest request,HttpSession session
) throws Exception {
		System.out.println("Add PersonalInformationTrainee");
	     String personalInformationTrainee = null;

		try{
			
			if(p.getId() == 0){
				personalInformationTrainee = this.traineeService.addPersonalInfoTrainee(p);
			}else{
				personalInformationTrainee = this.traineeService.updatePersonalInfoTrainee(p);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("personalInformationTrainee "+personalInformationTrainee);
		
		//upload image
		try{
			String[] all = personalInformationTrainee.split("&");
			//String ss = session.getServletContext().getRealPath("").replace("Fssai_E-Learning_System", "Fostac/Trainee");
			String ss = session.getServletContext().getRealPath("Trainee");
			File dir = new File(ss);
			if (!dir.exists())
				dir.mkdirs();
		 	  
	    byte[] bytes = file.getBytes();  
	    BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(  
	         new File(ss + File.separator +all[1]+".png")));  
	    stream.write(bytes);  
	    stream.flush();  
	    stream.close();  
		}catch(Exception e){
			e.printStackTrace();
			new ZLogger("saveImage", "Exception while  saveImage "+e.getMessage(), "TraineeController.java");
		}

		//upload image end
		
		
		
		
		if(personalInformationTrainee != null && ! personalInformationTrainee.equalsIgnoreCase("updated")){
			String[] all = personalInformationTrainee.split("&");
			model.addAttribute("id" , all[1]);
			model.addAttribute("pwd" , all[0]);
			new Thread(new Mail("Thanks", p.getEmail(), all[1], all[0], p.getFirstName())).start();
			return "welcome";
		}else if(personalInformationTrainee.equalsIgnoreCase("updated")){
			if((int)session.getAttribute("profileId")==1){
				return "redirect:/traineeUserManagementForm.fssai";
				}
				else{
					return "redirect:/loginProcess.fssai";
				}
		
		
		}else{
			return "PersonalInformationTrainee";
		}
	}
		
		
		
	
	
			
		// for Trainee	
			

		
		
		@RequestMapping(value = "/MyTraining", method = RequestMethod.GET)
		public String MyTraining(@ModelAttribute("MyTrainingForm") MyTrainingForm MyTrainingForm ,Model model){
			
				System.out.println("listMyTraining");
							
				Map<String , String> trainingType = lst.trainingTypeMap;
				model.addAttribute("trainingType",trainingType);
				model.addAttribute("MyTrainingForm", new MyTrainingForm());
			//	model.addAttribute("listTrainingSchedule", this.adminService.listTrainingSchedule());
			
				return "MyTraining";
		
		}

        @RequestMapping(value = "/ListMyTraining", method = RequestMethod.POST)
		public String ListMyTraining(@ModelAttribute("MyTrainingForm") MyTrainingForm MyTrainingForm ,Model model) {
			
				System.out.println("listMyTraining" + MyTrainingForm.getTrainingType());
						
				Map<String , String> trainingType = lst.trainingTypeMap;
				//Map<String , String> trainingCenter = lst.trainingCenterMap;
				model.addAttribute("trainingType",trainingType);
				
				model.addAttribute("MyTrainingForm", new MyTrainingForm());
				model.addAttribute("listMyTraining", this.traineeService.listMyTraining());
			return "MyTraining";
		
	
	
	}
	
	//for get score card
        
        @RequestMapping(value = "/GetScoreCard", method = RequestMethod.GET)
		public String GetScoreCard(@ModelAttribute("GetScoreCardForm") GetScoreCardForm GetScoreCardForm ,Model model,HttpSession session){
        	int userId = (int) session.getAttribute("userId");
				System.out.println("listGetScoreCard");
				int personalTraineeId=(int)session.getAttribute("personalTraineeId");
				
				model.addAttribute("GetScoreCardForm", new GetScoreCardForm());
				//model.addAttribute("listTrainingTopic", this.traineeService.listTrainingTopic(userId));
				//model.addAttribute("listOnlineTraining", this.traineeService.listOnlineTraining(userId));
				//model.addAttribute("listGetScoreCard", this.traineeService.listGetScoreCard(userId));
				
				traineeService.updateSteps(personalTraineeId, 4);
				session.setAttribute("traineeSteps", 4);
			
				return "GetScoreCard";
		
		}

      /*  @RequestMapping(value = "/ListGetScoreCard", method = RequestMethod.POST)
		public String ListGetScoreCard(@ModelAttribute("GetScoreCardForm") GetScoreCardForm GetScoreCardForm ,Model model) {
			
				System.out.println("listGetScoreCard" + GetScoreCardForm.getTrainingType());
						
				Map<String , String> trainingType = lst.trainingTypeMap;
				Map<String , String> trainingPhase = lst.trainingPhaseMap;
				
				model.addAttribute("trainingType",trainingType);
				model.addAttribute("trainingPhase",trainingPhase);
				model.addAttribute("GetScoreCardForm", new GetScoreCardForm());
				//model.addAttribute("listGetScoreCard", this.traineeService.listGetScoreCard());
				
			return "GetScoreCard";
		}*/
        
      //for online Assessment

        @RequestMapping(value = "/OnlineAssessment", method = RequestMethod.GET)
		public String OnlineTraining(@ModelAttribute("OnlineAssessmentForm") OnlineAssessmentForm OnlineAssessmentForm ,Model model, HttpSession session){
			
        	int personalTraineeId = (int)session.getAttribute("personalTraineeId");
         	traineeService.updateSteps(personalTraineeId,3);	
			
         	return "OnlineAssessment";
		
		}
        
        
        
        //for Certificate

        @RequestMapping(value = "/Certificate", method = RequestMethod.GET)
		public String Certificate(@ModelAttribute("CertificateForm") CertificateForm CertificateForm ,Model model , HttpSession session){
			
      	  int loginId = (int) session.getAttribute("userId");
				System.out.println("listCertificate");
				Map<String , String> trainingType = lst.trainingTypeMap;
				
				model.addAttribute("trainingType",trainingType);
				model.addAttribute("CertificateForm", new CertificateForm());
				model.addAttribute("listCertificate", this.traineeService.listCertificate(loginId));
				
				
			
				return "Certificate";
		
		}
	
	//training Institute
	

@RequestMapping(value = "/TrainingRequest", method = RequestMethod.GET)
public String trainingRequest(@ModelAttribute("TrainingRequestForm") TrainingRequestForm trainingRequestForm ,Model model) {
		System.out.println("start get");
			
		Map<String , String> trainingType = lst.trainingTypeMap;
		Map<String , String> userType = lst.userTypeMap;
		Map<String , String> trainingStatus = lst.userStatusMap;
		String startDate="";
		String endDate="";
		
		model.addAttribute("trainingType",trainingType);
		model.addAttribute("userType",userType);
		model.addAttribute("startDate",startDate);
		model.addAttribute("endDate",endDate);
		model.addAttribute("trainingStatus", trainingStatus);
		/*model.addAttribute("listTrainingRequest", this.traineeService.listTrainingRequest());
		model.addAttribute("TrainingRequestForm", new TrainingRequestForm());*/
		
	System.out.println("end get");
	return "TrainingRequest";
}

@RequestMapping(value = "/ListTrainingRequest", method = RequestMethod.POST)
public String ListTrainingRequest(@ModelAttribute("TrainingRequestForm") TrainingRequestForm trainingRequestForm ,Model model) {
	
		
	//model.addAttribute("TrainingRequestForm", new TrainingRequestForm());
		model.addAttribute("listTrainingRequest", this.trainingInstitudeService.listTrainingRequest(trainingRequestForm));
	
		
	
	return "TrainingRequest";
}


@RequestMapping(value = "/MarkAttendance", method = RequestMethod.GET)
public String markAttendance(@ModelAttribute("MarkAttendanceForm") MarkAttendanceForm markAttendanceForm ,Model model) {
		System.out.println("start get");
			
		Map<String , String> trainingType = lst.trainingTypeMap;
		Map<String , String> userType = lst.userTypeMap;
		

		model.addAttribute("trainingType",trainingType);
		model.addAttribute("userType",userType);
			
	System.out.println("end get");
	return "MarkAttendance";
}

	
@RequestMapping(value = "/ListMarkAttendance", method = RequestMethod.POST)
public String ListMarkAttendance(@ModelAttribute("MarkAttendanceForm") MarkAttendanceForm  markAttendanceForm ,Model model) {
	
		//System.out.println("listTrainingInstitute" + trainingInstituteForm.getTrainingType());
				System.out.println("start post");
		

				Map<String , String> attendance1 = lst.instituteAttendanceMap;
				model.addAttribute("attendance1",attendance1);
			
				
				
		model.addAttribute("MarkAttendanceForm", new MarkAttendanceForm());
		model.addAttribute("listMarkAttendance", this.trainingInstitudeService.listMarkAttendance());
	
		
	
	return "MarkAttendance";
}


@RequestMapping(value = "/mycalendar", method = RequestMethod.GET)
public String myCalendar(@ModelAttribute("InstituteMyCalendarForm") InstituteMyCalendarForm myCalendarForm ,Model model) {
		System.out.println("start get");
			
		Map<String , String> trainingType = lst.trainingTypeMap;
		Map<String , String> userType = lst.userTypeMap;
		Map<String , String> status =lst.instituteStatusMap;
		

		model.addAttribute("trainingType",trainingType);
		model.addAttribute("userType",userType);
		model.addAttribute("status",status);
			
	System.out.println("end get");
	return "mycalendar";
}
	
	

@RequestMapping(value = "/listinstitutemycalendar", method = RequestMethod.POST)
public String mmyCalendar(@ModelAttribute("InstituteMyCalendarForm") InstituteMyCalendarForm  myCalendarForm ,Model model) {

	//System.out.println("listTrainingInstitute" + trainingInstituteForm.getTrainingType());
			System.out.println("start post");
	
	model.addAttribute("InstituteMyCalendarForm", new InstituteMyCalendarForm());
	model.addAttribute("listInstituteMyCalendar", this.trainingInstitudeService.listInstituteMyCalendar());

	

return "mycalendar";
}

/*//niranjan
//for onlinelisting

@RequestMapping(value = "/ListOnlineAssessment", method = RequestMethod.POST)
public String onlinelistassessquestion(@ModelAttribute("AssessmentQuestionForm") AssessmentQuestionForm assesQuestionForm ,Model model, HttpSession s) {
		System.out.println("Online Listing get");
	model.addAttribute("listAssessmentQuestion", this.traineeService.listingAssessmentQuestion(assesQuestionForm,(int)s.getAttribute("userId")));
	System.out.println("----------------------------------------------"+s.getAttribute("userId"));
	
	return "listingquestions";
}

*/


/**
 * @author Jyoti Mekal
 */
@RequestMapping(value = "/GetCertificate", method = RequestMethod.GET)
public String GetCertificate(@ModelAttribute("PersonalInformationTrainee") PersonalInformationTrainee personalInformationTrainee ,Model model , HttpServletRequest request, HttpSession session) {
		System.out.println("GetCertificate ");
		String userId = request.getParameter("userId");
		
		traineeService.updateSteps(Integer.parseInt(userId),  0);
		session.setAttribute("traineeSteps", 0);
		CertificateInfo certificateInfo = traineeService.getCertificateID(Integer.parseInt(userId),"");
		if(certificateInfo != null && certificateInfo.getCertificateID() != null && certificateInfo.getCertificateID().length() > 5){
			traineeService.closeCourse(Integer.parseInt(userId), "Y");
		}
		
		model.addAttribute("certificateID", certificateInfo.getCertificateID());
		model.addAttribute("trainingDate", certificateInfo.getTrainingDate());
		model.addAttribute("traineeCertificateName", certificateInfo.getName());
		model.addAttribute("trainingAddress", certificateInfo.getTrainingAddress());
	
		
	return "certificatetraineeGEN";
}

//trainee Feedback
@RequestMapping(value="/traineefeedback" , method = { RequestMethod.POST , RequestMethod.GET })
public String listtraineeFeedback( Model model){
	  model.addAttribute("FeedbackForm",  new FeedbackForm());
  model.addAttribute("listtraineeFeedback", this.traineeService.listFeedback());
  return "traineefeedback";
}
//online training
						
@RequestMapping(value="/online_training" , method = { RequestMethod.POST , RequestMethod.GET })
public String listonlineTraining( Model model){
	  model.addAttribute("OnlineTrainingForm",  new OnlineTrainingForm());
  model.addAttribute("listonlineTraining", this.traineeService.listonlineTraining());

  return "online_training";
} 
  
//fotestcertification


@RequestMapping(value="/certification" , method = RequestMethod.GET )
public String listcertification( Model model){
	  model.addAttribute("certification",  new CertificationForm());
  model.addAttribute("listcertification", this.traineeService.listcertification());
  System.out.println(this.traineeService.listcertification());

  return "certification";
}

//course enrollment-general

@RequestMapping(value = "/GeneralCourseEnrollment", method = RequestMethod.GET)
	public String generalCourseEnrollment(Model model) {
		System.out.println("applyForPost");
		Map<String , String> trainingLabMap = lst.trainingLabMap;
		model.addAttribute("trainingLabMap", trainingLabMap);
		model.addAttribute("listStateMaster", this.adminService.listStateMaster());
		model.addAttribute("generalCourseEnrollmentForm" , new generalCourseEnrollmentForm());

		return "GeneralCourseEnrollment";
	}
	
  @RequestMapping(value="/GeneralCourseEnrollmentlist" , method = RequestMethod.POST)
  public String listtraineeTrainerFeedback(@ModelAttribute("generalCourseEnrollmentForm") generalCourseEnrollmentForm p , Model model){
      model.addAttribute("listgeneralCourseEnrollment", this.traineeService.listgeneralCourseEnrollment(p));
      model.addAttribute("generalCourseEnrollmentForm" , new generalCourseEnrollmentForm());
      List<generalCourseEnrollmentForm> list = this.traineeService.listgeneralCourseEnrollment(p);
      for( generalCourseEnrollmentForm li :   list){
      	System.out.println("li "+li.getTrainingLab());
      }
      return "GeneralCourseEnrollment";
  }
  
//LC - MS/MS Enrollment
  
  @RequestMapping(value = "/lcEnrollment", method = RequestMethod.GET)
	public String lcEnrollment(Model model) {
		System.out.println("lcEnrollment");
		Map<String , String> trainingLabMap = lst.trainingLabMap;
		model.addAttribute("trainingLabMap", trainingLabMap);
		model.addAttribute("listStateMaster", this.adminService.listStateMaster());
		model.addAttribute("lcEnrollmentForm" , new lcEnrollmentForm());

		return "lcEnrollment";
	}
 	
    @RequestMapping(value="/lcEnrollmentlist" , method = RequestMethod.POST)
    public String listlcEnrollment(@ModelAttribute("lcEnrollmentForm") lcEnrollmentForm p , Model model){
        model.addAttribute("listlcEnrollment", this.traineeService.listlcEnrollment(p));
        model.addAttribute("lcEnrollmentForm" , new lcEnrollmentForm());
        List<lcEnrollmentForm> list = this.traineeService.listlcEnrollment(p);
        for( lcEnrollmentForm li :   list){
        	System.out.println("li "+li.getTrainingLab());
        }
        return "lcEnrollment";
    }
    
    //GC - MS/MS Enrollment
    
    @RequestMapping(value = "/gcEnrollment", method = RequestMethod.GET)
  	public String gcEnrollment(Model model) {
  		System.out.println("gcEnrollment");
  		Map<String , String> trainingLabMap = lst.trainingLabMap;
		model.addAttribute("trainingLabMap", trainingLabMap);
		model.addAttribute("listStateMaster", this.adminService.listStateMaster());
  		model.addAttribute("gcEnrollmentForm" , new gcEnrollmentForm());

  		return "gcEnrollment";
  	}
   	
      @RequestMapping(value="/gcEnrollmentlist" , method = RequestMethod.POST)
      public String listgcEnrollment(@ModelAttribute("gcEnrollmentForm") gcEnrollmentForm p , Model model){
          model.addAttribute("listgcEnrollment", this.traineeService.listgcEnrollment(p));
          model.addAttribute("gcEnrollmentForm" , new gcEnrollmentForm());
          
          return "gcEnrollment";
      }
      //IPC - MS/MS Enrollment
      
        @RequestMapping(value = "/icpEnrollment", method = RequestMethod.GET)
      	public String ipcEnrollment(Model model) {
      		System.out.println("icpEnrollment");
      		Map<String , String> trainingLabMap = lst.trainingLabMap;
    		model.addAttribute("trainingLabMap", trainingLabMap);
    		model.addAttribute("listStateMaster", this.adminService.listStateMaster());
    		//model.addAttribute("listDistrictMaster", this.adminService.listDistrictMaster());
      		model.addAttribute("icpEnrollmentForm" , new icpEnrollmentForm());

      		return "icpEnrollment";
      	}
       	
          @RequestMapping(value="/icpEnrollmentlist" , method = RequestMethod.POST)
          public String listipcEnrollment(@ModelAttribute("icpEnrollmentForm") icpEnrollmentForm p , Model model){
              model.addAttribute("listicpEnrollment", this.traineeService.listicpEnrollment(p));
              model.addAttribute("icpEnrollmentForm" , new icpEnrollmentForm());
              return "icpEnrollment";
          }
          
          
        //Before Training
          @RequestMapping(value="/beforeTraining" , method = { RequestMethod.POST , RequestMethod.GET })
          public String listbeforeTraining( Model model){
          	  model.addAttribute("BeforeTraining",  new BeforeTraining());
          model.addAttribute("listBeforeTraining", this.traineeService.listBeforeTraining());
          return "beforeTraining";
          }
          //After Training
          @RequestMapping(value="/afterTraining" , method = { RequestMethod.POST , RequestMethod.GET })
          public String listAfterTraining( Model model){
          	  model.addAttribute("AfterTraining",  new AfterTraining());
          model.addAttribute("listAfterTraining", this.traineeService.listAfterTraining());
          return "afterTraining";
          }
          //printAdmitCard
          @RequestMapping(value="/printAdmitCard" , method = { RequestMethod.POST , RequestMethod.GET })
          public String listPrintAdmitCard( Model model){
          	  model.addAttribute("PrintAdmitCard",  new PrintAdmitCard());
          model.addAttribute("listPrintAdmitCard", this.traineeService.listPrintAdmitCard());
          return "printAdmitCard";
          }

          //mycourses
          @RequestMapping(value="/mycourses" , method = { RequestMethod.POST , RequestMethod.GET })
          public String listMyCourses( Model model){
          	  model.addAttribute("MyCoursesForm",  new MyCoursesForm());
          model.addAttribute("listMyCourses", this.traineeService.listMyCourses());
          return "mycourses";
          }
          //contact us

          @RequestMapping(value = "/traineeContact", method = RequestMethod.GET)
          public String contact(Model model , HttpSession session) {
          	        Map<String , String> subjectMap = lst.subjectMap;
              		model.addAttribute("subjectMap", subjectMap);
              		 model.addAttribute("ContactTrainee",  new ContactTrainee());
              		/*if(checkAccess(session))
            			return "redirect:login.fssai";
            		try{
            			Integer userId = (Integer) session.getAttribute("userId");
            			Integer profileId = (Integer) session.getAttribute("profileId");
            			String defaultMail = traineeService.getDefaultMailID(userId, profileId);
            			model.addAttribute("defaultMail", defaultMail);
            		}catch(Exception e){
            			e.printStackTrace();
            			new ZLogger("contactTrainee", "Exception while  contactTrainee "+e.getMessage(), "TraineeController.java");
            		}
              		*/
          	return "traineeContact";

          }
       
//trainee certificate
                @RequestMapping(value = "/certificatetrainee", method = RequestMethod.GET)
        		public String certificatetrainee(Model model , HttpSession session){
        		 int loginId = (int) session.getAttribute("userId");
        				System.out.println("listCertificate");
                   model.addAttribute("listCertificate", this.traineeService.listCertificate(loginId));
        				return "certificatetrainee";
        		
        		}
     
                //admit card trainee
                
                @RequestMapping(value = "/admitCard", method = RequestMethod.GET)
        		public String admitCard(Model model , HttpSession session){
        				System.out.println("admitCard");
        				return "admitCard";
        		
        		}
                
  
          		
          
    
}
