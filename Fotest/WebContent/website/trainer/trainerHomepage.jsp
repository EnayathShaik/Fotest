<%-- \<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core"%>
<%System.out.print("trainee home page jsp"); %>

<!-- horizontal navigation -->


<section>
<%@include file="../roles/top-menu.jsp"%>
</section>
<!-- main body -->
<section class="main-section-margin-top">
  <div class="container-fluid">
    <div id="wrapper"> 
      
      <!-- Sidebar -->
    <%@include file="../roles/slider.jsp" %>
      <!-- /#sidebar-wrapper --> 
      <!-- Page Content -->
      <div id="page-content-wrapper">
        <div class="container-fluid"> 
          
            <div class="row">
                                            <div class="col-xs-12">
                                           <fieldset>
                                           <legend>Training Requests for Trainer</legend>
                                            <ct:if test="${!empty listTrainingSchedule}">
                                            <table id="datatablesfosrest" class="table table-bordered table-responsive">
                                               <thead>
                                                    <tr class="background-open-vacancies">
                                                        <th>S.No.</th>
                                                        <th>Training Type</th>
                                                        <th>User Type</th>
                                                        <th>Training Phase</th>
                                                        <th>Training Start Date</th>
                                                        <th>Training End Date</th>
                                                        <th>No. Of Enrollments</th>
                                                        <th>Status</th>
                                                        <th>Accept</th>
                                                        <th>Reject</th>
                                                        
                                                    </tr>
                                                </thead>
                                                
                                                <ct:forEach items="${listTrainingSchedule}" var="TrainingSchedule" varStatus="loop">
                                                <tr>
												<td>${loop.count}</td>
												<td>${TrainingSchedule.trainingType}</td>
												<td>${TrainingSchedule.userType}</td>
												<td>${TrainingSchedule.trainingPhase}</td>
												<td>${TrainingSchedule.trainingStartDate}</td>
												<td>${TrainingSchedule.trainingEndDate}</td>
												<td>20</td>
												<td>${TrainingSchedule.trainingInstitudeStatus}</td>
												<td><button  class="btn login-btn" onclick='acceptTrainingRequest(${TrainingSchedule.trainingScheduleId} , ${profileId },${loginUser2 },"accept");return false;' >Accept</button></td>
												<td><button  class="btn login-btn" onclick='acceptTrainingRequest(${TrainingSchedule.trainingScheduleId} , ${profileId },${loginUser2 },"reject");return false;' >Reject</button></td>
												
											</tr>
										</ct:forEach>
                                            </table>
                                           </ct:if>
                                        </fieldset>
                                                    </div>
                                                </div>
                 
        </div>
      </div>
    </div>
  </div>
</section>
<!-- scripts --> 

<script>

function acceptTrainingRequest(id , profileId,loginUser2,operation){
	//alert(" id "+id + "profileId  "+profileId+" userID:"+loginUser2+" OPer="+operation);
	if( confirm("Are you sure you want to "+operation + " ? ")){
	   var name1=JSON.stringify({
  		courseName:0
    })
  	$.ajax({
  	      type: 'post',
  	    url: 'TrainingSchedule/accept/'+id+'.fssai?profileId='+profileId+'&loginUser2='+loginUser2+'&operation='+operation,
  	      contentType : "application/json",
  		  data:name1,
  	      success: function (response) {  
  	    	location.reload();  
  	      }
  	});
	   
}
}

</script>
 --%>
 <%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>


 <cf:form action="trainerHomepage.fssai" name="myForm" method="POST"
	commandName="TrainerHomePageForm" onsubmit="return validateFields();">
    <section>
         <%@include file="../roles/top-menu.jsp"%>
    </section>
    <!-- main body -->
    <section class="main-section-margin-top">
        <div class="container-fluid">
            <div id="wrapper">
                <!-- Sidebar -->
                <div > <%@include file="../roles/slider.jsp" %>
                </div>
                <!-- /#sidebar-wrapper -->
                <!-- Page Content -->
                <div id="page-content-wrapper">
                    <div class="container-fluid">
                        <!-- vertical button -->
                        <div class="row">
                            <div class="col-lg-12">
                                <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle"> <i class="fa fa-bars"></i> <span class="orange-font">Welcome ${userName}</span> </a>
                            </div>
                        </div>
                        <!-- add the content here for main body -->
                        <!-- timeline  -->
                        

                              
                                   
                                                            <!-- search Results -->
                                            <div class="col-xs-12 " id="testt">

                                                <!-- table -->
                                                <div class="row">
                                                    <div class="col-xs-12">
                                                            <fieldset>
                                           <legend>View Confirmed Trainings</legend>
                                         <ct:if test="${!empty listtrainerHomepage}">
                                            <table id="datatablesfosrest" class="table table-bordered table-responsive">
                                               <thead>
                                                    <tr class="background-open-vacancies">
                                                        <th>S.No.</th>
                                                        <th>Course Name</th>
                                                         <th>Training Date & Time</th>
                                                          <th>Training LAB Name</th>
                                                           <th>Contact Person Name</th>
                                                             <th>Contact Person's EmailId</th>
            
                                                    </tr>
                                                </thead>
                                                
                                                <ct:forEach items="${listtrainerHomepage}" var="trainerHomepage" varStatus="loop">
                                                <tr>
												<td>${loop.count}</td>
												<td>${trainerHomepage.courseName}</td>
												<td>${trainerHomepage.trainingDate} &nbsp;&nbsp;&nbsp;&nbsp;  ${trainerHomepage.trainingTime}  </td>
												<td>${trainerHomepage.trainingLab}</td>
												<td>${trainerHomepage.contactPersonName}</td>
												<td>${trainerHomepage.email}</td>
											</tr>
												</ct:forEach>
                                            </table>
                                           </ct:if> 
                                        </fieldset>
											  </div>
                                                </div>
                                            </div>
                                           
                                            <!-- open vacancy -->
                                            <div class="col-xs-12 " id="testt">
                                             <div class="row">
                                                    <div class="col-xs-12">
                                                            <fieldset>
                                           <legend>Open vacancies</legend>
                                         <ct:if test="${!empty listopenVacancies}">
                                            <table id="datatablesfosrest" class="table table-bordered table-responsive">
                                               <thead>
                                                    <tr class="background-open-vacancies">
                                                        <th>S.No.</th>
                                                        <th>Course Name</th>
                                                         <th>Trainer Program</th>
                                                          <th>Trainer Course</th>
                                                           <th>Training Slot</th>
                                                           <th></th>
                                                    </tr>
                                                </thead>
                                                
                                                <ct:forEach items="${listopenVacancies}" var="openVacancies" varStatus="loop">
                                                <tr>
												<td>${loop.count}</td>
												<td>${openVacancies.courseName}</td>
												<td>${openVacancies.trainerProgram}</td>
												<td>${openVacancies.trainerCourse}</td>
												<td>${openVacancies.trainingSlot}</td>
												<td><input type="button" value="Apply"></td>
											    </tr>
												</ct:forEach>
                                            </table>
                                           </ct:if> 
                                        </fieldset>
											  </div>
                                                </div>
                                                </div>
                                                <!-- open vacancy end-->
                                                <div class="col-xs-12 " id="testt">
                                                <div class="row">
                                                    <div class="col-xs-12">
                                                            <fieldset>
                                           <legend>Job Application</legend>
                                         <ct:if test="${!empty listjobApplication}">
                                            <table id="datatablesfosrest" class="table table-bordered table-responsive">
                                               <thead>
                                                    <tr class="background-open-vacancies">
                                                        <th>S.No.</th>
                                                        <th>Course Name</th>
                                                         <th>Trainer Program</th>
                                                          <th>Trainer Course</th>
                                                           <th>Training Slot</th>
                                                           <th>Training Status</th>
                                                    </tr>
                                                </thead>
                                                
                                                <ct:forEach items="${listjobApplication}" var="jobApplication" varStatus="loop">
                                                <tr>
												<td>${loop.count}</td>
												<td>${jobApplication.courseName}</td>
												<td>${jobApplication.trainerProgram}</td>
												<td>${jobApplication.trainerCourse}</td>
												<td>${jobApplication.trainingSlot}</td>
												<td>${jobApplication.status}</td>
											</tr>
												</ct:forEach>
                                            </table>
                                           </ct:if> 
                                        </fieldset>
											  </div>
                                                </div>
                                                </div>
                             <!-- search div ends -->
                       
                    </div>
                </div>
            </div>
        </div>
     
    </section>
 
 <input type="hidden" id="idHidden" value="" />
 <input type="hidden" id="hiddenCourseType" value="" />                                             
   </cf:form></html>