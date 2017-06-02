<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %>
        <%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>
            <script type="text/javascript">
                </script>



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
                         	<!-- vertical button -->
						<div class="row">
							<div class="col-lg-12">
								<a href="#menu-toggle" class="vertical-menu-position-btn"
									id="menu-toggle"> <i class="fa fa-bars"></i> <span
									class="orange-font">Welcome ${userName} </span>
								</a>
							</div>
						</div>
                    
                    <div class="col-xs-12 " id="testt">
								<!-- table -->
								<div class="row">
									<div class="col-xs-12">
										<fieldset>
											<legend>Pending trainee course enrollment verification list</legend>
											<ct:if test="${!empty listPendingTraineeEnrollment}">
												<table id="datatablesfosrest"
													class="table table-bordered table-responsive">
													<thead>
														<tr class="background-open-vacancies">
															<!-- <th>S.No.</th> -->
															<th>Course Name</th>
															<th>No.Of Enrollment</th>
															<th>Training Date</th>
															
														</tr>
													</thead>
													<ct:forEach items="${listPendingTraineeEnrollment}"
														var="listPendingTraineeEnrollment">
														<tr>
															<!-- <td>1</td> -->
															<td>${listPendingTraineeEnrollment.courseName}</td>
															<td><a href="verifyTraineeEnrollment.fssai">${listPendingTraineeEnrollment.noOfEnroll}</a></td>
															<td>${listPendingTraineeEnrollment.trainingDate}</td>
														</tr>
													</ct:forEach>
												</table>
											</ct:if>
										</fieldset>
									</div>
								</div>
							</div>
                    
                    
                    
                    
                    
                    
                    
                    
                     <div class="col-xs-12 " id="testt">
								<!-- table -->
								<div class="row">
									<div class="col-xs-12">
										<fieldset>
											<legend>Pending user-id Activation</legend>
											<ct:if test="${!empty listuserIdActivation}">
												<table id="datatablesfosrest"
													class="table table-bordered table-responsive">
													<thead>
														<tr class="background-open-vacancies">
															<!-- <th>S.No.</th> -->
															<th>User Type</th>
															<th>No.Of Users</th>
															<!-- <th>Training Date</th> -->
															
														</tr>
													</thead>
													<ct:forEach items="${listuserIdActivation}"
														var="listuserIdActivation">
														<tr>
															<!-- <td>1</td> -->
															<td>${listuserIdActivation.userType}</td>
															<td><a href="activateUserId.fssai">${listuserIdActivation.noOfUsers}</a></td>
														
														</tr>
													</ct:forEach>
												</table>
											</ct:if>
										</fieldset>
									</div>
								</div>
							</div>
                    
                    
                    
                    
                    
                    
                     <div class="col-xs-12 " id="testt">
								<!-- table -->
								<div class="row">
									<div class="col-xs-12">
										<fieldset>
											<legend>Pending request for calendar update</legend>
											<ct:if test="${!empty listpendingRequestForCalendar}">
												<table id="datatablesfosrest"
													class="table table-bordered table-responsive">
													<thead>
														<tr class="background-open-vacancies">
															<!-- <th>S.No.</th> -->
															<th>Course Name</th>
															<th>Training Date</th>
															<th>Request Type</th>
															<th>No. Of Requests</th>
														</tr>
													</thead>
													<ct:forEach items="${listpendingRequestForCalendar}"
														var="listpendingRequestForCalendar">
														<tr>
															<!-- <td>1</td> -->
															<td>${listpendingRequestForCalendar.courseName}</td>
																<td>${listpendingRequestForCalendar.trainingDate}</td>
																	<td>${listpendingRequestForCalendar.requestType}</td>
															<td><a href="managetrainingcalendar.fssai">${listpendingRequestForCalendar.noOfRequest}</a></td>
														
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
    </section>
