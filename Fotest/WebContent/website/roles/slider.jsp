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
                                <li class="hov"><a href="GeneralCourseEnrollment.fssai" class="clr">General</a></li>
                                <li class="hov"><a href="lcEnrollment.fssai" class="clr">LC-MS/MS</a></li>
                                <li class="hov"><a href="gcEnrollment.fssai" class="clr">GC-MS/MS</a></li>
                                <li class="hov"><a href="icpEnrollment.fssai" class="clr" style="margin-bottom: 1px;">ICP-MS</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="printAdmitCard.fssai">Print Admit Card</a>
                        </li>
                        <li class="dropdown active">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Assessment<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li class="hov"><a href="beforeTraining.fssai" class="clr">Before Training</a></li>
                                <li class="hov"><a href="afterTraining.fssai" class="clr" style="margin-bottom: 1px;">After Training</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="onlineTraining.fssai">Online Training</a>
                        </li>
                        <li>
                          <a href="commonfeedback.fssai">Feedback</a>
                        </li>
                         <li>
                          <a href="feedbackInternalTrainee.fssai">Feedback Internal</a>
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
	<li><a href="applyForPost.fssai">Apply For Post</a></li>
	<li> <a href="commonfeedback.fssai">Feedback</a> </li>
		<li> <a href="internalFeedbackTrainer.fssai">Internal Feedback</a> </li>
	</ul>
</div>

<%
	} else if (session.getAttribute("profileId").equals(5)) {
%>
<div id="sidebar-wrapper">
	<ul class="sidebar-nav">
		<!-- <li class="sidebar-brand">
                        </li> -->
		<li><a href="createCalendar.fssai">Create View Calendar</a></li>
		<li> <a href="updateCalendar.fssai">Update Calendar</a> </li>
		<li><a href="applicationstatus.fssai">Application Status</a></li>
		<li> <a href="markAttendance.fssai">Mark Attendance</a> </li>
	<li> <a href="activateTrainingOfTrainee.fssai">Activate Training</a> </li>
	<li> <a href="activateAssessmentOfTrainee.fssai">Activate Assessment</a> </li>
		<li> <a href="commonfeedback.fssai">Feedback for Trainer</a> </li>
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



