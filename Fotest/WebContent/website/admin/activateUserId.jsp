<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 
<script type="text/javascript"
	src="website/js/jquery-toaster/jquery.toaster.js"></script>

 -->
<script>
	function OnStart() {

		flatpickr("#trainingDate", {

		});
	}
	window.onload = OnStart;
</script>
<%-- <ct:url var="addAction" value="/activateAssessmentOfTraineelist.fssai"></ct:url> --%>
<cf:form action="activateUserIdlist.fssai" name="myForm"
	method="POST" commandName="ActivateUserIdForm">

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
									Activate User Id <label id="created">${created }</label>
								</h1>
								<div class="row">
									<div class="col-xs-12">
										<fieldset>
											<legend>Activate User Id</legend>
											<!-- left side -->
											<div class="col-xs-6">
												<div class="form-group">
													<div>
														<ul class="lab-no">
															<li class="style-li"><strong>User Name: <span
																	style="color: red;">*</span>

															</strong></li>
															<!-- <li id="courseNameErr" style="display: none;"
																class="style-li error-red">Course Name should not
																be blank.</li> -->

														</ul>
													</div>
													<cf:input path="userName" placeholder="userName"
														class="form-control" />
													<%-- <cf:select path="userName" class="form-control">
														<cf:option value="" label="Select Course Name" />
														<cf:options items="${courseNameMap}" />
													</cf:select> --%>
												</div>
											<%-- 	<div class="form-group">
													<div>
														<ul class="lab-no">
															<li class="style-li"><strong>Training Date:</strong></li>
															<li class="style-li error-red"></li>
															<!-- <li id="trainingDateErr" style="display: none;"
																class="style-li error-red">Training Date should not
																be blank.</li> -->
														</ul>
													</div>
													<cf:input path="trainingDate" placeholder="Training Date"
														class="form-control" />
												</div>
 --%>

												<%-- <div class="form-group">
													<div>
														<ul class="lab-no">
															<li class="style-li"><strong>Trainee Name:</strong></li>
															<li class="style-li error-red"></li>
															<!-- <li id="traineeNameErr" style="display: none;"
																class="style-li error-red">Trainee Name should not
																be blank.</li> -->
														</ul>
													</div>
													<cf:input path="traineeName" placeholder="Trainee Name"
														class="form-control" />
												</div> --%>

											</div>
											<!-- right side -->
											<div class="row">

												<!-- left -->
												<div class="col-xs-6">

													<div class="form-group">
														<div>
															<ul class="lab-no">
																<li class="style-li"><strong>Profile Code:
																		<span style="color: red;">*</span>

																</strong></li>
																<!-- <li id="trainingLabErr" style="display: none;"
																	class="style-li error-red">Training Lab should not
																	be blank.</li> -->

															</ul>
														</div>
														<%-- <cf:input path="profileCode" placeholder="Training Lab"
															class="form-control" /> --%>
															 <cf:select path="profileCode" class="form-control">
														<cf:option value="" label="Select Course Name" />
														<cf:options items="${profileCodeMap}" />
													</cf:select> 
													</div>


													<%-- <div class="form-group">
														<div>
															<ul class="lab-no">
																<li class="style-li"><strong> Training
																		Time:</strong></li>
																<li class="style-li error-red"></li>
															</ul>
														</div>
														<cf:input path="trainingTime" placeholder="Training Time"
															class="form-control" />
															<cf:select path="trainingTime" class="form-control">
														<cf:option value="" label="Select Course Name" />
														<cf:options items="${courseNameMap}" />
													</cf:select>
													</div> --%>
													<div class="col-md-06 col-xs-12" style="margin-top: 39px;">
														<input type="submit" id="searchbtn" value="Search"
															style="float: right; padding: 10px 50px 10px 50px"
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
											<legend>Activate Assessment Of Trainee</legend>
											<ct:if test="${!empty listactivateUserId}">
												<table id="datatablesfosrest"
													class="table table-bordered table-responsive">
													<thead>
														<tr class="background-open-vacancies">
															<th>S.No.</th>
															<th>User Name</th>
															<th>User Id</th>
															<th>Profile Code</th>
															<th>View Profile</th>
															<th>Activate</th>
														
														</tr>
													</thead>
													<ct:forEach items="${listactivateUserId}"
														var="listactivateUserId">
														<tr>
															<td>1</td>
															<td>${listactivateUserId.userName}</td>
															<td>${listactivateUserId.userId}</td>
															<td>${listactivateUserId.profileCode}</td>
															<td><a href="">open</a></td>
															<td><input type="checkbox"></td>
															<%-- <td>${listactivateUserId.traineeName}</td>
															<td>${listactivateUserId.attendance}</td> --%>
															<!-- <td><input type="checkbox"></td> -->
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