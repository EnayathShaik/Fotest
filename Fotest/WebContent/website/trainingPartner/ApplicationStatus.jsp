<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core"%>

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
											<h3>Trainer Application Status</h3>
										</legend>
										<!--   <script type="text/javascript">
                                        var formObj = '${trainingpartnerapplicationstatus}';
                                        var formData = JSON.parse(formObj);
                                        var courseTypes = formData.courseTypes;
                                        </script> -->

										<div class="row">
											<div class="col-xs-12">

												<!-- left side -->
												<div class="col-md-6 col-xs-12">

													<div class="form-group">
														<div>
															<ul class="lab-no">
																<li class="style-li"><strong>Training
																		Name:</strong></li>

															</ul>
														</div>
														<cf:select path="trainingName" class="form-control"
															id="trainingName">
													
														<cf:option value="" label="Select Training Name" />
														<%-- <cf:options items="${trainingName}" /> --%>
															</cf:select>
													</div>
												</div>

												<!-- right side -->
												<div class="col-md-6 col-xs-12">
													<div class="form-group">
														<div>
															<ul class="lab-no">
																<li class="style-li"><strong>Training
																		Date:</strong></li>
																<li id="dobErr" style="display: none;"
																	class="style-li error-red">Select Date.</li>

															</ul>
														</div>
														<cf:input type="text" path="trainingDate" id="trainingDate"
															class="form-control" />
													</div>

													<!-- <button
														class="btn login-btn pull-right show-details-vacancy collapsed"
														data-toggle="collapse" data-target="#show-result"
														aria-expanded="false" onclick="showDetails();">Show
														Details</button> -->
														<input type="submit" 
														class="btn login-btn pull-right" value="Show Details" />
													<!-- <input type="submit" id="btnExport"
														style="margin-right: 20px;"
														class="btn login-btn pull-right" value="Download" /> -->
														
												</div>

											</div>

											<div class="col-md-3 hidden-xs"></div>
										</div>
									</fieldset>


								</div>

								<!--                                     search Results -->
								<!--                         search Results -->
									<div class="col-xs-12 " id="testt">

								<!-- table -->
								<div class="row">
									<div class="col-xs-12">
										<fieldset>
											<legend>Current Application Status</legend>
											<ct:if test="${!empty listDetails}">
												<table border="1" id="datatablesfosrest" class="table table-bordered table-responsive">
													<thead>
														<tr class="background-open-vacancies">
															<th>S.No.</th>
															<th>Training Name</th>
															<th>Training Date</th>
															<th>Number of Vacancies</th>
															<th>Number of Applicants</th>
														</tr>
													</thead>
													<ct:forEach items="${listDetails}" var="listDetails" varStatus="loop">
														<tr>
															<td>${loop.count}</td>
															<td>${listDetails.trainingName}</td>
															<td>${listDetails.trainingDate}</td>
															<td>${listDetails.numberOfVacancies}</td>
															<td>${listDetails.noOfApplicants}</td>
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
				</div>
			</div>
		</div>
	</section>
</cf:form>
