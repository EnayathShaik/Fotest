<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript"
	src="website/js/jquery-toaster/jquery.toaster.js"></script>

<script>
                function OnStart() {
                   
                	flatpickr("#trainingDate" , {
                		
                	});	
                }
                window.onload = OnStart;

            </script>

 <%-- <ct:url var="addAction" value="/verifyTraineeEnrollment/list.fssai"></ct:url> --%> 
<cf:form action="markAttendancelist.fssai" name="myForm" method="POST"
	commandName="MarkAttendanceForm" onsubmit="return validateFields();">

	<section>
		<%@include file="/website/roles/top-menu.jsp"%>
	</section>
	<!-- main body -->
	<section class="main-section-margin-top">
		<div class="container-fluid">
			<div id="wrapper">
				<!-- Sidebar -->
				<%@include file="/website/roles/slider.jsp"%>
				<!-- /#sidebar-wrapper -->
				<!-- Page Content -->
				<div id="page-content-wrapper">
					<div class="container-fluid">
						<!-- vertical button -->
						<div class="row">
							<div class="col-lg-12">
								<a href="#menu-toggle" class="vertical-menu-position-btn"
									id="menu-toggle"> <i class="fa fa-bars"></i> <span
									class="orange-font">Welcome Fotest</span>
								</a>
							</div>
						</div>
						<!-- add the content here for main body -->
						<!-- timeline  -->
						<div class="row">

							<div class="col-xs-12">
								<h1>
									Mark Attendance <label id="created">${created }</label>
								</h1>
								<div class="row">
									<div class="col-xs-12">
										<fieldset>
											<legend>Mark Attendance</legend>
										<cf:input path="id" type="hidden" /> 

											<!-- left side -->
											<div class="col-xs-6">
												
												<div class="form-group">
														<div>
															<ul class="lab-no">
																<li class="style-li"><strong>Course Name:</strong></li>
																<li class="style-li error-red"></li>
																<li id="courseNameErr" style="display:none;" class="style-li error-red" > Course Name should not be blank.</li>
															</ul>
														</div>

														<cf:select path="courseName" class="form-control">
															<cf:option value="" label="Select course Name" />
															<cf:options items="${courseNameMap}" />
														</cf:select>
													</div>
												
										       <div class="form-group">
												          <div>
													<ul class="lab-no">
														<li class="style-li"><strong>Course Date:</strong></li>
														
														<li id="trainingDateErr" style="display: none;"
															class="style-li error-red">Please Select Course Date.</li>
															 	<li class="style-li error-red"><label
															class="error visibility" id="courseError">*</label></li>
													</ul>
												          </div>
												<cf:input class="form-control" path="trainingDate" type="text" placeholder="Course Date" />
											       </div>
												
												    


											</div>
											<!-- right side -->
											<div class="row">

												<!-- left -->
												<div class="col-xs-6">
												
												 <div class="form-group">
												          <div>
													<ul class="lab-no">
														<li class="style-li"><strong>Training Time:</strong></li>
														
														<li id="trainingDateErr" style="display: none;"
															class="style-li error-red">Please Select Training Date.</li>
															 	<li class="style-li error-red"><label
															class="error visibility" id="courseError">*</label></li>
													</ul>
												          </div>
												<cf:input class="form-control" path="trainingTime" type="text" placeholder="Training Time" />
											       </div>

													
											
													
                                                           <div class="col-md-4 hidden-xs"></div>
                                                        <div class="col-md-4 col-xs-12">
                                                            <a href="login.html">
                                                            
                                                                <input type="submit" class="form-control login-btn" value="Show Details"> </a>
                                                        </div>
                                                        <div class="col-md-4 hidden-xs"></div>

													<!-- <input type="submit" id="updatebtn"
														style="display: none; float: right; margin-right: 122px;"
														value="Update" class="btn login-btn" /> <input
														type="submit" id="createbtn" value="Create"
														class="btn login-btn" /> -->
												</div>
											</div>

										</fieldset>
									</div>
								</div>
							</div>

							<!-- search Results -->
							<div class="col-xs-12 " id="testt">

								<!-- table -->
								<div class="row">
									<div class="col-xs-12">
										<fieldset>
											<legend>Search Results</legend>
											<ct:if test="${!empty listmarkAttendance}">
												<table id="datatablesfosrest" class="table table-bordered table-responsive">
														<thead>
														<tr class="background-open-vacancies">
															<th>S.No.</th>
															<th>Course Name</th>
															<th>Training Date</th>
															<th>Training Time</th>
															<th>Participant Name</th>
															<th>Add Participant's Photo</th>
															<th>Aadhar No.</th>
															<th>Attendance</th>
															
														</tr>
													</thead>

													<ct:forEach items="${listmarkAttendance}" var="markAttendance"
														varStatus="loop">

														<tr>
															<td>${loop.count}</td>
															<td>${markAttendance.courseName}</td>
															<td>${markAttendance.trainingDate}</td>
															<td>${markAttendance.trainingTime}</td>
															<td>${markAttendance.participantName}</td>
															<td><input type="button" value="Open"></td>
															<td><input type="text" value=""></td>
															<td><select><option>Present</option><option>Absent</option></select></td>	
															
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
						<!-- row ends -->

					</div>
				</div>
			</div>
		</div>
	</section>
	<input type="hidden" id="idH" value="" />
</cf:form>
 
  