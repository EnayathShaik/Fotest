<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript"
	src="website/js/jquery-toaster/jquery.toaster.js"></script>

<script>
                function OnStart() {
                   
                	flatpickr("#trainingDate" , {
                		enableTime: true
                	});	
                	
                 
                }
                window.onload = OnStart;

            </script>

<ct:url var="addAction" value="updateCalendarlist.fssai"></ct:url>
<cf:form action="${addAction}" name="myForm" method="POST"
	commandName="createCalendarForm" onsubmit="return validateFields();">

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
									class="orange-font">Welcome Admin</span>
								</a>
							</div>
						</div>
						<!-- add the content here for main body -->
						<!-- timeline  -->
						<div class="row">

							<div class="col-xs-12">
								<h1>
									Create Calendar <label id="created">${created }</label>
								</h1>
								<div class="row">
									<div class="col-xs-12">
										<fieldset>
											<legend>Create Calendar</legend>
										<%-- 	<cf:input path="id" type="hidden" /> --%>

											<!-- left side -->
											<div class="col-xs-6">
												<div class="form-group">
													<div>
														<ul class="lab-no">
															<li class="style-li"><strong>Course Name: <span
																	style="color: red;">*</span>

															</strong></li>
															<li id="courseNameErr" style="display: none;"
																class="style-li error-red">Course Name should not be
																blank.</li>

														</ul>
													</div>

													<cf:select path="courseName" class="form-control">
														<cf:option value="" label="Select userType" />
														<cf:options items="${courseNameMap}" />
													</cf:select>
												</div>
													<div class="form-group">
														<div>
															<ul class="lab-no">
																<li class="style-li"><strong>Training
																		Date:</strong></li>
																<li class="style-li error-red"></li>
																<li id="trainingDateErr" style="display: none;"
																	class="style-li error-red">Training Date should not be
																	blank.</li>
															</ul>
														</div>
														<cf:input path="trainingDate"
															placeholder="Training Date" class="form-control" />
													</div>
												
											</div>
											<!-- right side -->
											<div class="row">

												<!-- left -->
												<div class="col-xs-6">
										
													<div class="form-group">
														<div>
															<ul class="lab-no">
																<li class="style-li"><strong> No. Of Seats:</strong></li>
																<li class="style-li error-red"></li>
																<li id="trainingTimeErr" style="display: none;"
																	class="style-li error-red">Training Time should not be
																	blank.</li>
															</ul>
														</div>
														<cf:input path="noOfSeats"
															placeholder="noOfSeats" class="form-control" />
													</div>
													<div class="col-md-06 col-xs-12" style="margin-top:39px;">
												<input type="submit" id="searchbtn" value="Search"
													style=" float: right; padding:10px  50px 10px 50px"
													 class="btn login-btn" /> 
													</div>
													
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
											<legend>Create Calendar</legend>
											<ct:if test="${!empty listupdateCalendar}">
												<table id="datatablesfosrest" class="table table-bordered table-responsive">
														<thead>
														<tr class="background-open-vacancies">
															<th>S.No.</th>
															<th>Course Name</th>
															<th>Training Date</th>
															<th>Request Type</th>
															<th>Comments</th>
														</tr>
													</thead>

													<ct:forEach items="${listupdateCalendar}" var="listupdateCalendar"
														varStatus="loop">

														<tr>
															<td>${loop.count}<input type="checkbox"></td>
															<td>${listupdateCalendar.courseName}</td>
															<td>${listupdateCalendar.trainingDate}</td>
															<%-- <td>${listupdateCalendar.requestType}</td>
															<td>${listupdateCalendar.comments}</td> --%>
															
															<td><select><option>Cancel</option><option>Update</option></select></td>	
														 <td><cf:textarea class="form-control" path="comments"
										placeholder="Enter Your Message (250 Words)" /></td>
										               <!--  <td><input type="text" value=""></td>  -->
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
</body>
</html>