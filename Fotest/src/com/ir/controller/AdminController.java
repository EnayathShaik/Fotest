package com.ir.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.google.gson.Gson;

import com.ir.form.ChangePasswordForm;
import com.ir.form.CityMasterForm;
import com.ir.form.DistrictMasterForm;
import com.ir.form.GenerateCertificateForm;
import com.ir.form.GenerateCourseCertificateForm;
import com.ir.form.RegionMasterForm;
import com.ir.form.manageTrainingForm;
import com.ir.form.verifyTraineeEnrollmentForm;
import com.ir.form.viewEnrolledCoursesForm;
import com.ir.model.CityMaster;
import com.ir.model.DistrictMaster;
import com.ir.model.ManageTraining;
import com.ir.model.RegionMaster;
import com.ir.model.StateMaster;
import com.ir.service.AdminService;
import com.ir.service.PageLoadService;
import com.zentech.logger.ZLogger;
import com.zentect.list.constant.ListConstant;


@Controller
public class AdminController {

	@Autowired
	@Qualifier("adminService")
	AdminService adminService;
	
	@Autowired
	@Qualifier("pageLoadService")
	PageLoadService pageLoadService;

	ListConstant lst = new ListConstant();

	
/**
	 * @author Jyoti Mekal
	 *
	 *         All Add Edit delete for State Master
	 */

	@RequestMapping(value = "/StateMaster", method = RequestMethod.GET)
	public String listStateMaster(
			@ModelAttribute("StateMaster") StateMaster StateMaster, Model model) {
		System.out.println("listStateMaster");
		model.addAttribute("StateMaster", new StateMaster());
		model.addAttribute("listStateMaster",
				this.adminService.listStateMaster());
		return "StateMaster";
	}

	@RequestMapping(value = "/StateMaster/add", method = RequestMethod.POST)
	public String addStateMaster(
			@Valid @ModelAttribute("StateMaster") StateMaster p,
			BindingResult result) {
		System.out.println(result.hasErrors());

		if (result.hasErrors()) {

			new ZLogger("StateMaster", "bindingResult.hasErrors  "
					+ result.hasErrors(), "AdminController.java");
			new ZLogger("StateMaster", "bindingResult.hasErrors  "
					+ result.getErrorCount() + " All Errors "
					+ result.getAllErrors(), "AdminController.java");
			return "redirect:/StateMaster.fssai";
		}

		System.out.println("p.getId() " + p.getStateId());
		if (p.getStateId() == 0) {
			// new person, add it
			this.adminService.addStateMaster(p);
		} else {
			// existing person, call update
			this.adminService.updateStateMaster(p);
		}
		System.out.println("after insert");
		return "redirect:/StateMaster.fssai";
	}

	@RequestMapping("/StateMaster/remove/{id}")
	public String removeStateMaster(@PathVariable("id") int id) {

		this.adminService.removeStateMaster(id);
		return "redirect:/StateMaster.fssai";
	}

	@RequestMapping(value = "/StateMaster/edit/{id}", method = RequestMethod.POST)
	@ResponseBody
	public void editStateMaster(
			@PathVariable("id") int id,
			@RequestBody GenerateCourseCertificateForm generateCourseCertificateForm,
			HttpServletRequest httpServletRequest, HttpServletResponse response)
			throws IOException {
		new ZLogger("StateMaster/edit", "StateMaster/edit............" + id,
				"AdminController.java");

		StateMaster hm = this.adminService.getStateMasterById(id);
		// List courseList = adminService.searchFeedbackMaster(data);
		PrintWriter out = response.getWriter();
		Gson g = new Gson();
		String newList = g.toJson(hm);
		System.out.println("newList " + newList);
		out.write(newList);
		out.flush();

	}

	/**
	 * @author Jyoti Mekal
	 *
	 *         All Add Edit delete for District Master
	 */

	@RequestMapping(value = "/DistrictMaster", method = RequestMethod.GET)
	public String listDistrictMaster(
			@ModelAttribute("DistrictMasterForm") DistrictMaster DistrictMaster,
			Model model) {
		System.out.println("listDistrictMaster");
		model.addAttribute("DistrictMasterForm", new DistrictMasterForm());
		model.addAttribute("listStateMaster",
				this.adminService.listStateMaster());
		model.addAttribute("listDistrictMaster",
				this.adminService.listDistrictMaster());
		return "DistrictMaster";
	}

	@RequestMapping(value = "/DistrictMaster/add", method = RequestMethod.POST)
	public String addDistrictMaster(
			@Valid @ModelAttribute("DistrictMasterForm") DistrictMasterForm p,
			BindingResult result) {
		System.out.println(result.hasErrors());

		if (result.hasErrors()) {

			new ZLogger("DistrictMaster", "bindingResult.hasErrors  "
					+ result.hasErrors(), "AdminController.java");
			new ZLogger("DistrictMaster", "bindingResult.hasErrors  "
					+ result.getErrorCount() + " All Errors "
					+ result.getAllErrors(), "AdminController.java");
			return "redirect:/DistrictMaster.fssai";
		}

		DistrictMaster districtMaster = new DistrictMaster();
		districtMaster.setDistrictId(p.getDistrictId());
		districtMaster.setDistrictName(p.getDistrictName());
		districtMaster.setStateMaster(this.adminService.getStateMasterById(p
				.getStateId()));
		districtMaster.setStatus(p.getStatus());
		if (p.getDistrictId() == 0) {
			// new person, add it
			this.adminService.addDistrictMaster(districtMaster);
		} else {
			// existing person, call update
			this.adminService.updateDistrictMaster(districtMaster);
		}
		System.out.println("after insert");
		return "redirect:/DistrictMaster.fssai";
	}

	@RequestMapping("/DistrictMaster/remove/{id}")
	public String removeDistrictMaster(@PathVariable("id") int id) {

		this.adminService.removeDistrictMaster(id);
		return "redirect:/DistrictMaster.fssai";
	}

	@RequestMapping(value = "/DistrictMaster/edit/{id}", method = RequestMethod.POST)
	@ResponseBody
	public void editDistrictMaster(
			@PathVariable("id") int id,
			@RequestBody GenerateCourseCertificateForm generateCourseCertificateForm,
			HttpServletRequest httpServletRequest, HttpServletResponse response)
			throws IOException {
		new ZLogger("DistrictMaster/edit", "DistrictMaster/edit............"
				+ id, "AdminController.java");

		DistrictMaster hm = this.adminService.getDistrictMasterById(id);
		// List courseList = adminService.searchFeedbackMaster(data);
		PrintWriter out = response.getWriter();
		Gson g = new Gson();
		String newList = g.toJson(hm);
		System.out.println("newList " + newList);
		out.write(newList);
		out.flush();

	}

	/**
	 * @author Jyoti Mekal
	 *
	 *         All Add Edit delete for City Master
	 */

	@RequestMapping(value = "/CityMaster", method = RequestMethod.GET)
	public String listCityMaster(
			@ModelAttribute("CityMasterForm") CityMaster CityMaster, Model model) {
		System.out.println("listCityMaster");
		model.addAttribute("CityMasterForm", new CityMasterForm());
		model.addAttribute("listStateMaster",
				this.adminService.listStateMaster());
		model.addAttribute("listDistrictMaster",
				this.adminService.listDistrictMaster());
		model.addAttribute("listCityMaster", this.adminService.listCityMaster());
		return "CityMaster";
	}

	@RequestMapping(value = "/CityMaster/add", method = RequestMethod.POST)
	public String addCityMaster(
			@Valid @ModelAttribute("CityMasterForm") CityMasterForm p,
			BindingResult result) {
		System.out.println(result.hasErrors());

		if (result.hasErrors()) {

			new ZLogger("CityMaster", "bindingResult.hasErrors  "
					+ result.hasErrors(), "AdminController.java");
			new ZLogger("CityMaster", "bindingResult.hasErrors  "
					+ result.getErrorCount() + " All Errors "
					+ result.getAllErrors(), "AdminController.java");
			return "redirect:/CityMaster.fssai";
		}

		CityMaster CityMaster = new CityMaster();
		CityMaster.setCityId(p.getCityId());
		CityMaster.setCityName(p.getCityName());
		CityMaster.setDistrictMaster(this.adminService.getDistrictMasterById(p
				.getDistrictId()));
		CityMaster.setStatus(p.getStatus());
		if (p.getCityId() == 0) {
			// new person, add it
			this.adminService.addCityMaster(CityMaster);
		} else {
			// existing person, call update
			this.adminService.updateCityMaster(CityMaster);
		}
		System.out.println("after insert");
		return "redirect:/CityMaster.fssai";
	}

	@RequestMapping("/CityMaster/remove/{id}")
	public String removeCityMaster(@PathVariable("id") int id) {

		this.adminService.removeCityMaster(id);
		return "redirect:/CityMaster.fssai";
	}

	@RequestMapping(value = "/CityMaster/edit/{id}", method = RequestMethod.POST)
	@ResponseBody
	public void editCityMaster(
			@PathVariable("id") int id,
			@RequestBody GenerateCourseCertificateForm generateCourseCertificateForm,
			HttpServletRequest httpServletRequest, HttpServletResponse response)
			throws IOException {
		new ZLogger("CityMaster/edit", "CityMaster/edit............" + id,
				"AdminController.java");

		CityMaster hm = this.adminService.getCityMasterById(id);
		// List courseList = adminService.searchFeedbackMaster(data);
		PrintWriter out = response.getWriter();
		Gson g = new Gson();
		String newList = g.toJson(hm);
		System.out.println("newList " + newList);
		out.write(newList);
		out.flush();

	}

	/**
	 * @author Jyoti Mekal
	 *
	 *         All Add Edit delete for Region Master
	 */

	@RequestMapping(value = "/RegionMaster", method = RequestMethod.GET)
	public String listRegionMaster(
			@ModelAttribute("RegionMasterForm") RegionMaster RegionMaster,
			Model model) {
		System.out.println("listRegionMaster");
		model.addAttribute("RegionMasterForm", new RegionMasterForm());
		model.addAttribute("listStateMaster",
				this.adminService.listStateMaster());
		model.addAttribute("listDistrictMaster",
				this.adminService.listDistrictMaster());
		model.addAttribute("listCityMaster", this.adminService.listCityMaster());
		model.addAttribute("listRegionMaster",
				this.adminService.listRegionMaster());
		return "RegionMaster";
	}

	@RequestMapping(value = "/RegionMaster/add", method = RequestMethod.POST)
	public String addRegionMaster(
			@Valid @ModelAttribute("RegionMasterForm") RegionMasterForm p,
			BindingResult result) {
		System.out.println(result.hasErrors());

		if (result.hasErrors()) {

			new ZLogger("RegionMaster", "bindingResult.hasErrors  "
					+ result.hasErrors(), "AdminController.java");
			new ZLogger("RegionMaster", "bindingResult.hasErrors  "
					+ result.getErrorCount() + " All Errors "
					+ result.getAllErrors(), "AdminController.java");
			return "redirect:/RegionMaster.fssai";
		}

		RegionMaster RegionMaster = new RegionMaster();
		RegionMaster.setId(p.getRegionId());
		RegionMaster.setRegionName(p.getRegionName());
		RegionMaster.setCityMaster(this.adminService.getCityMasterById(p
				.getCityId()));
		RegionMaster.setStatus(p.getStatus());
		if (p.getRegionId() == 0) {
			// new person, add it
			this.adminService.addRegionMaster(RegionMaster);
		} else {
			// existing person, call update
			this.adminService.updateRegionMaster(RegionMaster);
		}
		System.out.println("after insert");
		return "redirect:/RegionMaster.fssai";
	}

	@RequestMapping("/RegionMaster/remove/{id}")
	public String removeRegionMaster(@PathVariable("id") int id) {

		this.adminService.removeRegionMaster(id);
		return "redirect:/RegionMaster.fssai";
	}

	@RequestMapping(value = "/RegionMaster/edit/{id}", method = RequestMethod.POST)
	@ResponseBody
	public void editRegionMaster(
			@PathVariable("id") int id,
			@RequestBody GenerateCourseCertificateForm generateCourseCertificateForm,
			HttpServletRequest httpServletRequest, HttpServletResponse response)
			throws IOException {
		new ZLogger("RegionMaster/edit", "RegionMaster/edit............" + id,
				"AdminController.java");

		RegionMaster hm = this.adminService.getRegionMasterById(id);
		// List courseList = adminService.searchFeedbackMaster(data);
		PrintWriter out = response.getWriter();
		Gson g = new Gson();
		String newList = g.toJson(hm);
		System.out.println("newList " + newList);
		out.write(newList);
		out.flush();

	}

	@RequestMapping(value = "/changePasswordAdminPage", method = RequestMethod.GET)
	public String changePasswordAdminPage(
			@ModelAttribute("changePasswordForm") ChangePasswordForm changePasswordForm) {
		return "changePasswordAdminPage";
	}

	@RequestMapping(value = "/changePasswordAdminSave", method = RequestMethod.POST)
	public String changePasswordAdminSave(
			@ModelAttribute("changePasswordForm") ChangePasswordForm changePasswordForm,
			HttpSession session, BindingResult result, Model model) {
		if (result.hasErrors()) {
			new ZLogger("changePasswordAdminSave", "bindingResult.hasErrors  "
					+ result.hasErrors(), "AdminController.java");
			new ZLogger("changePasswordAdminSave", "bindingResult.hasErrors  "
					+ result.getErrorCount() + " All Errors "
					+ result.getAllErrors(), "AdminController.java");

			return "changePasswordAdminPage";
		}
		try {
			String id = (String) session.getAttribute("logId");
			boolean changePasswordTraineeSave = adminService
					.changePasswordadminSave(changePasswordForm, id);
			if (changePasswordTraineeSave) {
				model.addAttribute("created", "Your password has changed !!!");
			} else {
				model.addAttribute("created", "Oops, something went wrong !!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			new ZLogger("changePasswordAdminSave",
					"changePasswordAdminSave Loading Exception "
							+ e.getMessage(),
					"RegistrationControllerAssessor.java");
		}
		return "changePasswordAdminPage";
	}

	@RequestMapping(value = "/changePasswordTp", method = RequestMethod.GET)
	public String changePasswordTp(
			@ModelAttribute("changePasswordForm") ChangePasswordForm changePasswordForm) {
		return "changePasswordTp";
	}

	@RequestMapping(value = "/changePasswordTPSave", method = RequestMethod.POST)
	public String changePasswordTPSave(
			@ModelAttribute("changePasswordForm") ChangePasswordForm changePasswordForm,
			HttpSession session, BindingResult result, Model model) {
		if (result.hasErrors()) {
			new ZLogger("changePasswordTPSave", "bindingResult.hasErrors  "
					+ result.hasErrors(), "AdminController.java");
			new ZLogger("changePasswordTPSave", "bindingResult.hasErrors  "
					+ result.getErrorCount() + " All Errors "
					+ result.getAllErrors(), "AdminController.java");
			return "changePasswordTp";
		}
		try {
			String id = (String) session.getAttribute("logId");
			boolean changePasswordTraineeSave = adminService
					.changePasswordTPSave(changePasswordForm, id);
			if (changePasswordTraineeSave) {
				model.addAttribute("created", "Your password has changed !!!");
			} else {
				model.addAttribute("created", "Oops, something went wrong !!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			new ZLogger("changePasswordTPSave",
					"changePasswordTPSave exception  " + e.getMessage(),
					"AdminController.java");
		}
		return "changePasswordTp";
	}
	
	// Manage Training

		@RequestMapping(value = "/manageTraining", method = RequestMethod.GET)
		public String listmanageTraining(Model model) {
			System.out.println("listmanageTraining");

			model.addAttribute("manageTrainingForm", new manageTrainingForm());
			model.addAttribute("listmanageTraining", this.adminService.listManageTraining());
			return "manageTraining";
		}

		// For add and update state both
		@RequestMapping(value = "/manageTraining/add", method = RequestMethod.POST)
		public String addmanageTraining(@ModelAttribute("manageTrainingForm") ManageTraining p) {
			System.out.println("id1" + p.getId());
			if (p.getId() == 0) {
				// new person, add it
				this.adminService.addManageTraining(p);
			} else {
				// existing person, call update
				this.adminService.updateManageTraining(p);
			}
			return "redirect:/manageTraining.fssai";
		}

		@RequestMapping("/manageTraining/remove/{id}")
		public String removeManageTraining(@PathVariable("id") int id) {

			this.adminService.removeManageTraining(id);
			return "redirect:/manageTraining.fssai";
		}

		@RequestMapping("/manageTraining/edit/{id}")
		public void editManageTraining(@PathVariable("id") int id, Model model, HttpServletRequest httpServletRequest,
				HttpServletResponse response) throws IOException {
			System.out.println("id2" + id);
			ManageTraining mt = this.adminService.getManageTrainingById(id);
			PrintWriter out = response.getWriter();
			Gson g = new Gson();
			String newList = g.toJson(mt);
			System.out.println("newList " + newList);
			out.write(newList);
			out.flush();
		}

		// Verify Trainee Enrollment

				@RequestMapping(value = "/verifyTraineeEnrollment", method = RequestMethod.GET)
				public String verifyTraineeEnrollment(Model model) {
					System.out.println("verifyTraineeEnrollment");
					Map<String, String> courseNameMap = lst.courseNameMap;
					model.addAttribute("verifyTraineeEnrollmentForm", new verifyTraineeEnrollmentForm());
					model.addAttribute("courseNameMap", courseNameMap);
					return "verifyTraineeEnrollment";
				}

				@RequestMapping(value = "/verifyTraineeEnrollmentlist", method = RequestMethod.POST)
				public String listVerifyTraineeEnrollment(
						@ModelAttribute("verifyTraineeEnrollmentForm") verifyTraineeEnrollmentForm p, Model model) {
					model.addAttribute("listVerifyTraineeEnrollment", this.adminService.listVerifyTraineeEnrollment(p));
					List<verifyTraineeEnrollmentForm> list = this.adminService.listVerifyTraineeEnrollment(p);
					return "verifyTraineeEnrollment";
				}
				
				// View Enrolled Courses

				@RequestMapping(value = "/viewEnrolledCourses", method = RequestMethod.GET)
				public String viewEnrolledCourses(Model model) {
					System.out.println("viewEnrolledCourses");
					Map<String, String> courseNameMap = lst.courseNameMap;
					model.addAttribute("viewEnrolledCoursesForm", new viewEnrolledCoursesForm());
					model.addAttribute("courseNameMap", courseNameMap);
					return "viewEnrolledCourses";
				}

				@RequestMapping(value = "/viewEnrolledCourseslist", method = RequestMethod.POST)
				public String listviewEnrolledCourses(@ModelAttribute("viewEnrolledCoursesForm") viewEnrolledCoursesForm p,
						Model model) {
					model.addAttribute("listviewEnrolledCourses", this.adminService.listviewEnrolledCourses(p));
					return "viewEnrolledCourses";
				}
				
				 //Generate Certificate
			    
			    @RequestMapping(value = "/generateCertificate", method = RequestMethod.GET)
			 	public String generateCertificate(Model model) {
			 		System.out.println("GenerateCertificate");
			 		Map<String , String> courseNameMap = lst.courseNameMap;
			 		
			 		model.addAttribute("GenerateCertificateForm" , new GenerateCertificateForm());
			 		model.addAttribute("courseNameMap", courseNameMap);
			 		
			 		return "generateCertificate";
			 	}
			  	
			   
			    
				 @RequestMapping(value="/generateCertificatelist" , method = RequestMethod.POST)
			    public String listgenerateCertificate(@ModelAttribute("GenerateCertificateForm") GenerateCertificateForm p , Model model){
			  	  model.addAttribute("GenerateCertificateForm" , new GenerateCertificateForm());
			        model.addAttribute("listgenerateCertificate", this.adminService.listgenerateCertificate(p));
			        return "generateCertificate";
			    } 

	
}
