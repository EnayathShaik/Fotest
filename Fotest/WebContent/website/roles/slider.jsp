<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">
	function preventBack() {
		window.history.forward();
	}
	setTimeout("preventBack()", 10);
	window.onunload = function() {
		null
	};
</script>
<%
	System.out.println("Profile ID : "
			+ session.getAttribute("profileId"));
	if (session.getAttribute("profileId").equals(3)) {
		System.out.println("Profile ID : "
				+ session.getAttribute("profileId"));
%>


  <div id="sidebar-wrapper">
                    <ul class="sidebar-nav">
                        <!-- <li class="sidebar-brand">
                        </li> -->
                        <li class="dropdown active">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Course Enrollment<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li class="hov"><a href="course-enrollment-gen.html" class="clr">General</a></li>
                                <li class="hov"><a href="course-enrollment-lc.html" class="clr">LC-MS/MS</a></li>
                                <li class="hov"><a href="course-enrollment-Gc.html" class="clr">GC-MS/MS</a></li>
                                <li class="hov"><a href="course-enrollment-icp.html" class="clr" style="margin-bottom: 1px;">ICP-MS</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="admit-card.html">Print Admit Card</a>
                        </li>
                        <li class="dropdown active">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Assessment<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li class="hov"><a href="assessment-before-training-instruction.html" class="clr">Before Training</a></li>
                                <li class="hov"><a href="assessment-after-training-instruction.html" class="clr" style="margin-bottom: 1px;">After Training</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="onlineTraining.fssai">Online Training</a>
                        </li>
                        <li>
                          <a href="feedback123.fssai">Feedback</a>
                        </li>
                        <li>
                            <a href="certification.fssai">Certification</a>
                        </li>
                    </ul>
                </div>
<%
	} else if (session.getAttribute("profileId").equals(4)) {
%>
<div id="sidebar-wrapper">
	<ul class="sidebar-nav">
		<!-- <li><a href="search-and-apply.fssai">Search	& Apply Vacancy</a></li> -->
	<li><a href="TrainerRequest.fssai">Training Request</a></li>
	</ul>
</div>

<%
	} else if (session.getAttribute("profileId").equals(5)) {
%>
<div id="sidebar-wrapper">
	<ul class="sidebar-nav">
		<!-- <li class="sidebar-brand">
                        </li> -->
		<li><a href="TrainingRequest.fssai">Training Request</a></li>
		<li> <a href="traineeAttendance.fssai">Mark Attendance</a> </li>
	
	</ul>
</div>

<%
	} else if (session.getAttribute("profileId").equals(6)) {
%>
<div id="sidebar-wrapper">
	<ul class="sidebar-nav">
		<!-- <li class="sidebar-brand">
                    </li> -->
		<li><a href="viewAssessmentAgencyCalendar.fssai">Assessment
				Calendar</a></li>
		<!-- <li> <a href="trainingpartnermarkAttendence.fssai">Mark Attendance</a> </li> -->
		<li><a href="traineeAttendance.fssai">Trainee Attendance</a></li>
		<li><a href="update-result.fssai">Update Result</a></li>
		<li><a href="trainingpartnertrainingcalendar.fssai">Reschedule
				Assessment</a></li>
	</ul>
</div>

<%
	} else if (session.getAttribute("profileId").equals(7)) {
%>
<div id="sidebar-wrapper">
	<ul class="sidebar-nav">
		<!-- <li class="sidebar-brand">
                        </li> -->
		<li><a href="postVacancyTrainingPartner.fssai">Post Vacancy
				for Trainer</a></li>
		<li><a href="trainingpartnerapplicationstatus.fssai">Application
				Status</a></li>
		<li><a href="trainingCalendarForm.fssai">View Training
				Calendar</a></li>
		<li><a href="viewFeedbackDetails.fssai">View Feedback</a></li>
		<li><a href="registrationFormTrainingPartner.fssai">Register
				Training Center</a></li>
	</ul>
</div>

<%
	} else if (session.getAttribute("profileId").equals(8)) {
%>
<div id="sidebar-wrapper">
	<ul class="sidebar-nav">
		<!-- <li class="sidebar-brand"></li> -->
		<!-- TODO -->
		<!--                         <li><a href="viewTrainingCalendar.fssai">View Calendar</a></li> -->
		<li><a href="viewAssessmentAgencyCalendar.fssai">View
				Calendar</a></li>


	</ul>
</div>

<%
	} else if (session.getAttribute("profileId").equals(1)) {
%>
<div id="sidebar-wrapper">
                    <ul class="sidebar-nav">
                       <!--  <li class="sidebar-brand"></li>  -->
                        <li><a href="regionMapping.fssai">Region Mapping</a></li>
                        <li><a href="manageTraining.fssai">Manage Training</a></li>
                        <li> <a href="managecoursecurriculum.fssai">Manage Course Curricullum</a> </li>
                        <li> <a href="assessmentquestions.fssai">Assessment Questions</a> </li>
                        <li> <a href="feedbackMaster.fssai">Feedback Master</a> </li>
                       <li> <a href="verifyTraineeEnrollment.fssai">Verify Trainee Enrollment</a> </li>
                        <li> <a href="managetrainingcalendar.fssai">Manage Training Calendar</a> </li>
                        <li> <a href="activateTrainingOfTrainee.fssai">Activate Training</a> </li>
                      <li> <a href="activateAssessmentOfTrainee.fssai">Activate Assessment</a> </li>
                        <li> <a href="viewtrainingcalendar.fssai"> View Training Calendar</a> </li>
                        <li> <a href="viewEnrolledCourses.fssai"> View Enrolled Courses</a> </li>
                        <li> <a href="generateCertificate.fssai">Generate Certificate</a> </li>
                    </ul>
                </div>

<%
	} else if (session.getAttribute("profileId").equals(2)) {
%>
<div id="sidebar-wrapper">
	<ul class="sidebar-nav">
		<!-- <li class="sidebar-brand"></li> -->
		<li><a href="traineeUserManagementForm.fssai">Trainee User Management Form</a></li>
		<li><a href="NominateTrainee.fssai">Nominate Trainee</a></li>
		<li><a href="TrainingSchedule.fssai">Update Training Schedule</a></li>
</ul>
</div>

<%
	} else if(session.getAttribute("profileId").equals(20)){
%>

<div id="sidebar-wrapper">
	<ul class="sidebar-nav">
		<li> <a href="CustomerMaster.fssai">Customer</a> </li>
        <li> <a href="TaxMaster.fssai">Tax Master</a> </li>
        <li><a href="EmployeeMonthlyCharges.fssai">Employee Monthly Charges</a></li>
        <li><a href="CustomerDetails.fssai">Customer Details</a></li>
        <li><a href="InvoiceMaster.fssai">Invoice Details</a></li>
     <!--    <li><a href="invoicePrint.fssai">Invoice</a></li> -->
</ul>
</div>

<%
	} 
%>



