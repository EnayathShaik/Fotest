<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core"%>



<script>
	function OnStart() {

		flatpickr("#sessionDate", {
			enableTime : true
		});

	}
	window.onload = OnStart;
</script>


<cf:form action="viewfeedbacksearch.fssai" name="myForm"
	method="POST" commandName="viewFeedbackForm">

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
									class="orange-font"> Welcome ${userName }</span>
								</a>
							</div>
						</div>
						<!-- add the content here for main body -->
						<!-- timeline  -->
						<div class="row">
							<section class="section-form-margin-top">
								<!-- fostac logo -->
								<!-- login form -->

								<div class="col-xs-12">
									<fieldset><legend class="text-capitalize heading-3-padding">Trainee and Trainer Feedback</legend>


									<div class="personel-info">
										
											<!-- left side -->
											<div class="col-md-6 col-xs-12">

												<div class="form-group">
													<div>
														<ul class="lab-no">
															<li class="style-li"><strong>Course Name:</strong></li>
															<li class="style-li error-red"></li>
														</ul>
													</div>
													<cf:select path="courseName" id="courseName"
														class="form-control">
														<cf:option value="0">Select Course Name</cf:option>
														<cf:options items="${courseNameMap}" />

													</cf:select>
												</div>
										
												<div class="form-group">
													<div>
														<ul class="lab-no">
															<li class="style-li"><strong>Type of User:</strong></li>
															<li class="style-li error-red"><cf:errors
																	path="userType" cssClass="error" /></li>
														</ul>
													</div>
													<cf:input path="userType" placeholder="User Type"
														class="form-control" />
												</div>

											</div>
											<!-- right side -->
											<div class="col-md-6 col-xs-12">


														<div class="form-group">
													<div>
														<ul class="lab-no">
															<li class="style-li"><strong>Session Date:</strong></li>
															<li class="style-li error-red"><cf:errors
																	path="sessionDate" cssClass="error" /></li>
														</ul>
													</div>
													<cf:input path="sessionDate" placeholder="sessionDate"
														class="form-control" />
												</div>
											</div>
											<div class="col-md-12 col-xs-12">

												<div class="col-md-12 col-xs-12">
													<input type="submit" style="float: right; margin-right: 20px;" value="Search" class="btn login-btn" />

												</div>
											</div>

									</div>

									<div class="row" style="height: 20px;"></div>
									<!-- captcha -->
									<!-- buttons -->
									<div class="col-md-4 hidden-xs"></div>
									<!-- 	<div class="col-md-4 col-xs-12">
											 <input type="submit"
												class="form-control login-btn" value="Search">
												<br />
											 <input type="button"
												class="form-control login-btn" value="Download">
														<br> <br> <br>
													
										</div> -->

									<div class="col-md-4 hidden-xs"></div>


									</fieldset>
								</div>
								<div class="col-md-2 hidden-xs"></div>

							</section>
							<section class="section-form-margin-top">
								<!-- fostac logo -->
								<!-- login form -->
								<div class="row" style="height: 20px;"></div>
								<div class="col-xs-12 " id="testt">

								<!-- table -->
								<div class="row">
									<div class="col-xs-12">
										<fieldset>
											<legend>List</legend>
											<ct:if test="${!empty listDetails}">
												<table border="1" id="datatablesfosrest" class="table table-bordered table-responsive">
													<thead>
														<tr class="background-open-vacancies">
															<th>S.No.</th>
															<th>Course Name</th>
															<th>Session Date</th>
															<th>User Type</th>
														
														</tr>
													</thead>
													<ct:forEach items="${listDetails}" var="listDetails" varStatus="loop">
														<tr>
															<td>${loop.count}</td>
															<td>${listDetails.courseName}</td>
															<td>${listDetails.sessionDate}</td>
															<td>${listDetails.userType}</td>
															
															</tr>
													</ct:forEach>
												</table>
											</ct:if>
										</fieldset>
									</div>
								</div>
							</div>
							</section>
						</div>
						<!-- row -->
					</div>
				</div>
			</div>
		</div>
	</section>
			<br />
									<h3 style="float: right; margin-right: 200px;">Overall Rating:</h3>
										<br />
												<br />
														<br />
																<br />
</cf:form>

