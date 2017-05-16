package com.ir.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ir.form.LoginForm;
import com.ir.model.LoginDetails;
import com.ir.model.ManageAssessmentAgency;
import com.ir.model.ManageTrainingPartner;
import com.ir.model.PersonalInformationAssessor;
import com.ir.model.PersonalInformationTrainee;
import com.ir.model.PersonalInformationTrainer;
import com.ir.model.PersonalInformationTrainingInstitute;
import com.ir.model.PersonalInformationTrainingPartner;
import com.ir.model.TrainingPartner_old;
import com.ir.service.AdminService;
import com.ir.service.LoginService;
import com.ir.service.TrainingPartnerService;
import com.ir.service.UpdateService;
import com.zentech.logger.ZLogger;
//import org.apache.tomcat.util.net.jsse.openssl.Authentication;

/**
 * Controller to handle login process
 * 
 */
@Controller
@SessionAttributes
public class LoginController {
	
	
	@Autowired
	@Qualifier("loginService")
	LoginService loginService; 
	
	@Autowired
	@Qualifier("adminService")
	AdminService adminService;
	
	@Autowired
	@Qualifier("updateServiceImpl")
	UpdateService updateServiceImpl; 
	
	@Autowired
	@Qualifier("personalInformationTrainee")
	PersonalInformationTrainee personalInformationTrainee; 
	@Autowired
	@Qualifier("personalInformationTrainer")
	PersonalInformationTrainer personalInformationTrainer; 
	@Autowired
	@Qualifier("personalInformationTrainingPartner")
	PersonalInformationTrainingPartner personalInformationTrainingPartner; 
	@Autowired
	@Qualifier("personalInformationAssessor")
	PersonalInformationAssessor personalInformationAssessor; 
	@Autowired
	@Qualifier("trainingPartnerService")
	TrainingPartnerService trainingPartnerService; 
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm(@ModelAttribute("login") LoginForm loginForm , HttpSession session) {
		Integer profileID = (Integer) session.getAttribute("profileId");
		if(profileID != null && profileID > 0){
			return "redirect:loginProcess.fssai";
		}
		new ZLogger("login", "LoginController loginForm begin .", "LoginController.java");
		return "login";
	}

	/**
	 * @param loginForm
	 * @param result
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/traineeHome", method = RequestMethod.GET)
	public String traineeHome(@ModelAttribute("login") LoginForm loginForm ,BindingResult result, Model model, HttpSession session) {
		String userid=(String)session.getAttribute("loginId");
		if(userid!=null){
			return "traineeHomepage";
		}else{
			return "login";
		}
		
	}

	/**
	 * @param loginForm
	 * @param result
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/trainerHome", method = RequestMethod.GET)
	public String trainerHome(@ModelAttribute("login") LoginForm loginForm ,BindingResult result, Model model, HttpSession session) {
		String userid=(String)session.getAttribute("loginId");
		if(userid!=null){
			return "trainerHomepage";
		}else{
			return "login";
		}
		
	}
	
	/**
	 * @param loginForm
	 * @param result
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public String login(@Valid @ModelAttribute("login") LoginForm loginForm,BindingResult result, Model model, HttpSession session) {
		if(result.hasErrors()){
			new ZLogger("loginProcess", "bindingResult.hasErrors  "+result.hasErrors() , "LoginController.java");
			new ZLogger("loginProcess", "bindingResult.hasErrors  "+result.getErrorCount() +" All Errors "+result.getAllErrors(), "LoginController.java");
			session.invalidate();
			return "login";
		}
		LoginDetails loginDetails = null;
		try{
			loginDetails = loginService.login(loginForm);
		}catch(Exception e){
			e.printStackTrace();
			new ZLogger("loginProcess", "Exception while  loginProcess  "+e.getMessage() , "LoginController.java");
		}
		if(loginDetails == null){
			model.addAttribute("error" , "Oops , You are not authorized !!!");
			return "login";
		}
		session.setAttribute("loginIdUnique", loginDetails.getId());
		if(loginDetails!=null && loginDetails.getProfileId()==1 && loginDetails.getStatus().equalsIgnoreCase("A")){
			model.addAttribute("loginDetails", loginDetails);
			session.setAttribute("loginUser", loginDetails);  
			session.setAttribute("logId",loginDetails.getLoginId());
			session.setAttribute("profileId", loginDetails.getProfileId());
			session.setAttribute("userId", loginDetails.getId());
			session.setAttribute("userName", loginDetails.getLoginId());
			new ZLogger("loginProcess","in super admin admin login" , "LoginController.java");
			return "adminHomepage";
		}else if(loginDetails!=null && loginDetails.getProfileId() == 2 && loginDetails.getStatus().equalsIgnoreCase("A")){
			new ZLogger("loginProcess","in admin login" , "LoginController.java");
			session.setAttribute("loginUser", loginDetails);
			session.setAttribute("logId",loginDetails.getLoginId());
			session.setAttribute("profileId", loginDetails.getProfileId());
			session.setAttribute("userId", loginDetails.getId());
			session.setAttribute("userName", loginDetails.getLoginId());
			return "stateAdminHomepage";
		}else if(loginDetails !=null && loginDetails.getProfileId() == 3 && loginDetails.getStatus().equalsIgnoreCase("A"))
		{
			
			session.setAttribute("profileId", loginDetails.getProfileId());
			session.setAttribute("userId", loginDetails.getId());
			session.setAttribute("userName", loginDetails.getLoginId());			
			return "traineeHomepage";
		}else if(loginDetails!=null && loginDetails.getProfileId() == 4 && loginDetails.getStatus().equalsIgnoreCase("A")){
		
			session.setAttribute("profileId", loginDetails.getProfileId());
			session.setAttribute("userId", loginDetails.getId());
			session.setAttribute("userName", loginDetails.getLoginId());
			session.setAttribute("loginUser2", personalInformationTrainer.getId());
			//session.setAttribute("logId", personalInformationTrainer.getLoginDetails().getLoginId());

		
			return "trainerHomepage";
		}else if(loginDetails!=null && loginDetails.getProfileId() == 5){
			if(loginDetails.getStatus().equalsIgnoreCase("A")){
				
				session.setAttribute("profileId", loginDetails.getProfileId());
				session.setAttribute("userId", loginDetails.getId());
				session.setAttribute("userName", loginDetails.getLoginId());	
				return "trainingInstitudeHomepage";
			}else{
				model.addAttribute("error" , "Oops , you are not authorized !!!");
				return "login";
			}
				
		}
		else if(loginDetails != null && loginDetails.getProfileId() == 6 ){
			new ZLogger("loginProcess","in login when assessor", "LoginController.java");
			if(loginDetails.getStatus().equalsIgnoreCase("A")){

				session.setAttribute("profileId", loginDetails.getProfileId());
				session.setAttribute("userId", loginDetails.getId());
				session.setAttribute("userName", loginDetails.getLoginId());
				return "AssessorPage";
			}else{
				model.addAttribute("error" , "Oops , you are not authorized !!!");
				return "login";
			}
			
		}
		else if(loginDetails!=null && loginDetails.getProfileId() == 7 && loginDetails.getStatus().equalsIgnoreCase("A")){
			session.setAttribute("profileId", loginDetails.getProfileId());
			session.setAttribute("userId", loginDetails.getId());
			session.setAttribute("userName", loginDetails.getLoginId());
			return "trainingPartnerDashboard";
		}else if(loginDetails!=null && loginDetails.getProfileId() == 8 && loginDetails.getStatus().equalsIgnoreCase("A")){
			new ZLogger("loginProcess","in assessment agency", "LoginController.java");
			session.setAttribute("logerClass","ManageAssessmentAgency");
			session.setAttribute("loginIdUnique", loginDetails.getId());
			session.setAttribute("profileId", loginDetails.getProfileId());
			session.setAttribute("userId", loginDetails.getId());
			session.setAttribute("userName", loginDetails.getLoginId());
			return "assessmentAgencyHomepage";
		}else if(loginDetails!=null && loginDetails.getProfileId() == 10 && loginDetails.getStatus().equalsIgnoreCase("A")){
			
			new ZLogger("loginProcess","in admin login" , "LoginController.java");
			session.setAttribute("loginUser", loginDetails);
			session.setAttribute("logId",loginDetails.getLoginId());
			session.setAttribute("profileId", loginDetails.getProfileId());
			session.setAttribute("userId", loginDetails.getId());
			session.setAttribute("userName", loginDetails.getLoginId());
			return "stateAdminHomepage";
		}else if(loginDetails!=null && loginDetails.getProfileId() == 20 && loginDetails.getStatus().equalsIgnoreCase("A")){
			
			new ZLogger("loginProcess","in admin login" , "LoginController.java");
			session.setAttribute("loginUser", loginDetails);
			session.setAttribute("logId",loginDetails.getLoginId());
			session.setAttribute("profileId", loginDetails.getProfileId());
			session.setAttribute("userId", loginDetails.getId());
			session.setAttribute("userName", loginDetails.getLoginId());
			return "AssessorPage";
		}
		
		else{
			model.addAttribute("error" , "Oops , wrong Id and password !!!");
			return "login";
		}

	}
	
	/**
	 * @param loginForm
	 * @param result
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/loadData", method = RequestMethod.GET)
	public String loadData(@Valid @ModelAttribute("login") LoginForm loginForm,BindingResult result, Model model, HttpSession session) {
		Integer profileID = (Integer) session.getAttribute("profileId");
		
		if(profileID != null && profileID > 0){
			if(profileID == 1){
				return "adminHomepage";
			}else if(profileID == 2){
				return "adminHomepage";
			}else if(profileID == 3){
				return "traineeHomepage";
			}else if(profileID == 4){
				return "trainerHomepage";
			}else if(profileID == 5){
				return "trainingInstitudeHomepage";
			}else if(profileID == 6){
				return "AssessorPage";
			}else if(profileID == 7){
				return "trainingPartnerDashboard";
			}else if(profileID == 8){
				return "assessmentAgencyHomepage";
			}
		}
		return "login";
	}
	
	/**
	 * @param loginForm
	 * @param result
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/loginProcess", method = RequestMethod.GET)
	public String loginAuto(@Valid @ModelAttribute("login") LoginForm loginForm,BindingResult result, Model model, HttpSession session) {
		Integer profileID = (Integer) session.getAttribute("profileId");
		
		
		if(profileID != null && profileID > 0){
			if(profileID == 1){
				return "adminHomepage";
			}else if(profileID == 2){
				return "adminHomepage";
			}else if(profileID == 3){
				return "traineeHomepage";
			}else if(profileID == 4){
				
				return "trainerHomepage";
			}else if(profileID == 5){
				
				return "trainingInstitudeHomepage";
			}else if(profileID == 6){
				return "AssessorPage";
			}else if(profileID == 7){
				return "trainingPartnerDashboard";
			}else if(profileID == 8){
				return "assessmentAgencyHomepage";
			}
		}
		return "login";
	}
	
	
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(@Validated @ModelAttribute("login") LoginForm loginForm, HttpSession session,  BindingResult result,Model model) {
		model.addAttribute("error"," You have successfully logout");
		session.invalidate();
		return "login";
	}
	
	//@ModelAttribute("trainingPartnerCountList")
	public List<TrainingPartner_old> trainingPartnerList(){
		List<TrainingPartner_old> trainingPartnerList = null;
		try{
			trainingPartnerList = loginService.trainingPartnerCountList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return trainingPartnerList;
	}
	
}