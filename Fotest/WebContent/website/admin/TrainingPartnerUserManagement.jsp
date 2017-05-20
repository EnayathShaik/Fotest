<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core"%>

<cf:form action="trainingpartnerusermanagementsearch.fssai" name="myForm"
	method="POST" commandName="trainingPartnerUserManagementForm">

	<section>
                    <%@include file="../roles/top-menu.jsp"%>
                </section>
                <!-- main body -->
                <section >
                    <div class="container-fluid">
                        <div id="wrapper" >
                            <!-- Sidebar -->
                            
                                <%@include file="../roles/slider.jsp" %>
                            
                            <!-- /#sidebar-wrapper -->
                            <!-- Page Content -->
                            <div id="page-content-wrapper">
                                <div class="container-fluid">
                                    <!-- vertical button -->
                                    <!-- vertical button -->
                            <div class="row">
                                <div class="col-lg-12">
                                    <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle">
                                        <i class="fa fa-bars"></i> <span class="orange-font">Welcome : ${loginId}</span>
                                    </a>
                                </div>
                            </div>

                                    
	<!-- main body -->
	<section class="main-section-margin-top">
	<div class="col-xs-12">
									<h3 class="text-capitalize heading-3-padding">Training
										Partner User Management</h3>
									<form>
										<!-- personal information -->
										<div class="personel-info">
											<fieldset>
												<!-- left side -->
												<div class="col-md-6 col-xs-12">
													<div class="form-group">
														<div>
															<ul class="lab-no">
																<li class="style-li"><strong>First Name:</strong></li>
																<li class="style-li error-red"><cf:errors
																		path="firstName" cssClass="error" /></li>
															</ul>
														</div>
														<cf:input path="firstName" placeholder="First Name"
															class="form-control" />
													</div>
													<div class="form-group">
														<div>
															<ul class="lab-no">
																<li class="style-li"><strong>Middle Name:</strong></li>
																<li class="style-li error-red"><cf:errors
																		path="middleName" cssClass="error" /></li>
															</ul>
														</div>
														<cf:input path="middleName" placeholder="Middle Name"
															class="form-control" />
													</div>
													<div class="form-group">
														<div>
															<ul class="lab-no">
																<li class="style-li"><strong>Last Name:</strong></li>
																<li class="style-li error-red"><cf:errors
																		path="lastName" cssClass="error" /></li>
															</ul>
														</div>
														<cf:input path="lastName" placeholder="Last Name"
															class="form-control" />
													</div>
												</div>
												<!-- right side -->
												<div class="col-md-6 col-xs-12">
													<div class="form-group">
														<div>
															<ul class="lab-no">
																<li class="style-li"><strong>User ID:</strong></li>
																<li class="style-li error-red"><cf:errors
																		path="userId" cssClass="error" /></li>
															</ul>
														</div>
														<cf:input path="userId" placeholder="UserId"
															class="form-control" />
													</div>


													<div class="form-group">
														<div>
															<ul class="lab-no">
																<li class="style-li"><strong>Status:</strong></li>
																<li class="style-li error-red"></li>
															</ul>
														</div>
														<cf:select path="status" class="form-control">
															<cf:option value="A" label="Active" />
															<cf:option value="i" label="In-Active" />
														</cf:select>

													</div>
												</div>
												<!-- personal information ends -->
											</fieldset>
										</div>
										<!-- personal information ends -->
										<!-- Training center Details  -->
										<div class="row" style="height: 20px;"></div>
										<!-- captcha -->
										<!-- buttons -->
										<div class="col-md-4 hidden-xs"></div>
										<div class="col-md-4 col-xs-12">
											<a href="login.html"> <input type="submit"
												class="form-control login-btn" value="Search">
											</a>
										</div>
										<div class="col-md-4 hidden-xs"></div>
										<!-- training center details ends -->
									</form>
									<br>
									<br>
									<br>
								</div>
								<div class="col-md-2 hidden-xs"></div>

							</section>
							
							  <section class="section-form-margin-top">
                                <!-- fostac logo -->
                                <!-- login form -->
                                <div class="row" style="height:20px;"></div>
                                <div class="row">
                                    <div class="col-xs-12">
                                        <table class="table table-hover table-bordered table-responsive">
                                            <thead>
                                                <th>User ID</th>
                                                <th>First Name</th>
                                                <th>Middle Name</th>
                                                <th>Last Name</th>
                                                <th>UserId</th>
                                            </thead>
  <tbody>
                                            
<ct:forEach var="listValue" items="${searchList}" varStatus="loop"><tr>
<td><label><a href="registerpersonalinformationtrainingpartner.fssai?userId=${listValue[6]}" value="${listValue[0] }">${listValue[1] }</a></label></td>
<td><label>${listValue[2] }</label></td>
<td><label>${listValue[3] }</label></td>	
<td><label>${listValue[4] }</label></td>
<td><label>${listValue[5] }</label></td>


</tr>
 </ct:forEach>
  
  
  
  </tbody>              
                                        </table>
                                    </div>
                                    <div class="col-md-2 hidden-xs"></div>
                                </div>
                            </section> 
						</div>
						<!-- row -->
					</div>
				</div>
			</div>
	
	</section>

</cf:form>
