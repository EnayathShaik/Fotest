<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core"%>


		<script src="website/js/jquery-2.1.0.min.js"></script>
		<script src="website/js/commonController.js"></script>
		
<script>
	/* var result="";
	 var response="";

	 function showDetail(){
	
	
	 $('#tblAssessorCourses tr').remove();
	 $('#tblAssessorCourses').append('<thead>'+
	 '<tr class="background-open-vacancies">'+
	 '<th>S.No.</th>'+
	 '<th>Course Type</th>'+
	 '<th>Course Name</th>'+
	 '<th>Training Date</th>'+
	 '<th>Training Time</th>'+
	 '<th>Trainer Name</th>'+
	 '<th>&nbsp;&nbsp;</th>'+
	 '</tr>'+
	 '</thead>');
	 //var id = document.getElementById("assessmentAgencyId").value;
	 var data=JSON.stringify({
	 courseType:$('#selCourseType').val()==null?0:$('#selCourseType').val(),
	 courseName:$('#selCourseName').val()==null?0:$('#selCourseName').val(),
	 trainingDate:$('#trainingdate').val(),
	 trainingCenter:0
	 });
	 $.ajax({
	 type: 'post',
	 url: 'getApplicationStatusDetails.fssai',
	 contentType : "application/json",
	 data: data,
	 success: function (response) {
	 response=JSON.parse(response);
	 for(index=0;index<response.length;index++){
	 console.log(response[index]);
	 $('#applicaionStatus').append('<tr>'+
	 '<td>'+(index+1)+'</td><td>'+response[index].courseTypeName+'</td>'+
	 '<td>'+response[index].courseName+'</td>'+
	 '<td>'+response[index].trainingDate.replace("-","/").replace("-","/")+'</td>'+
	 '<td>'+response[index].noOfVacancy+'</td>'+
	 '<td><a href="editApplicationStatusDetails.fssai?courseType='+response[index].courseTypeId+'&&courseName='+response[index].courseNameId+'">'+response[index].noOfApplications+'</td> '+
	 '</tr>');
	 }
	 }
	 });

	 }
	 */
</script>

<script type="text/javascript">
 function OnStart() {

flatpickr("#trainingDate", {
	enableTime : true
});

DrawCaptcha();
}
window.onload = OnStart; 
</script>

<cf:form action="applicationstatusshowdetails.fssai" method="POST"
	commandName="applicationStatusForm">
	<section>
		<%@include file="../roles/top-menu.jsp"%>
	</section>
	<!-- main body -->
	<section class="main-section-margin-top">
		<div class="container-fluid">
			<div id="wrapper">

				<!-- Sidebar -->
				<%@include file="../roles/slider.jsp"%>
				<!-- /#sidebar-wrapper -->
				<!-- Page Content -->
				<div id="page-content-wrapper">
					<div class="container-fluid">

						<!-- vertical button -->
						<div class="row">
							<div class="col-lg-12">
								<a href="#menu-toggle" class="vertical-menu-position-btn"
									id="menu-toggle"> <i class="fa fa-bars"></i> <span
									class="orange-font">Welcome :
										${loginUser.loginDetails.loginId}</span>
								</a>
							</div>
						</div>

						<!-- add the content here for main body -->
						<!-- timeline  -->
						<div class="container-fluid">
							<div class="row">

								<!-- search and apply vacancies -->
								<div class="col-xs-12">
									<fieldset>
										<legend>
											<h3>Current Application Status</h3>
										</legend>
										
										<div class="col-xs-12 table-overflow-responsive">
                                    <div class="row">
                                        <div class="col-xs-12">
                                            
                                            <!-- left side -->
                                            <div class="col-md-6 col-xs-12">
                                                <h4><strong>Training Name :</strong> ICP-MS </h4>
                                                <h4><strong>Training Date :</strong> 12/05/2016 </h4>
                                                <h4><strong>Number of Vacancies :</strong> 20 </h4> </div>
                                            <!-- left side ends -->
                                            <!-- right side -->
                                            <div class="col-md-6 col-xs-12"> </div>
                                            <!-- rigth side ends -->
                                            <!-- button -->
                                            <!-- button row ends -->
                                           
                                        </div>
                                    </div>
                                </div>
                                <!-- search Results -->
                               
									<div class="col-xs-12 " id="testt">

								<!-- table -->
								<div class="row">
									<div class="col-xs-12">
										<fieldset>
											<legend>Current Application Status</legend>
											<ct:if test="${!empty currentStatus}">
												<table border="1" id="datatablesfosrest" class="table table-bordered table-responsive">
													<thead>
														<tr class="background-open-vacancies">
															<th>S.No.</th>
															<th>TrainerName</th>
															<th>View Profile</th>
															<th>Status</th>
														</tr>
													</thead>
													<ct:forEach items="${currentStatus}" var="listDetails" varStatus="loop">
														<tr>
															<td>${loop.count}</td>
															 <td>${listDetails[0]}</td>
															<td><input type="button" value="View Profile"></td>
															
																														<td><select>
  <option value="Pending">Pending</option>
  <option value="Selected">Selected</option>
</select></td>
															  	</tr>
													</ct:forEach>
												</table>
											</ct:if>
										</fieldset>
									</div>
								</div>
							</div>
</fieldset>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		</div>
		
	</section>
</cf:form>

