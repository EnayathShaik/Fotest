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
<cf:form action="applyForPostlist.fssai" name="myForm" method="POST"
	commandName="ApplyForPostForm" onsubmit="return validateFields();">

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
									class="orange-font">Welcome ${userName }</span>
								</a>
							</div>
						</div>
						<!-- add the content here for main body -->
						<!-- timeline  -->
						<div class="row">

							<div class="col-xs-12">
								<h1>
									Apply For Post <label id="created">${created }</label>
								</h1>
								<div class="row">
									<div class="col-xs-12">
										<fieldset>
											<legend>Apply For Post</legend>
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
                                                         <li class="style-li"><strong>District:</strong></li>  <li class="style-li error-red"> * </li>
                                                         <!--  valid -->
                                                         <!-- <li id="correspondenceDistrictErr" style="display:none;" class="style-li error-red" >District can not be blank.</li> -->
                                          
                                                         </ul>
                                                     </div>
                                                       <cf:select path="district" class="form-control">
                                                       <cf:option value="0" label="select District"></cf:option>
                                                       <cf:options items="${listDistrictMaster}" itemValue="districtId" itemLabel="districtName"/>
                                                       </cf:select>
                                                </div>
												
												    


											</div>
											<!-- right side -->
											<div class="row">

												<!-- left -->
												<div class="col-xs-6">
												
												<div class="form-group">
														<div>
															<ul class="lab-no">
																<li class="style-li"><strong>Training Center:</strong></li>
																<li class="style-li error-red"></li>
																<li id="trainingCenterErr" style="display:none;" class="style-li error-red" > training Center should not be blank.</li>
															</ul>
														</div>

														<cf:select path="trainingCenter" class="form-control">
															<cf:option value="" label="Select training Center" />
															<cf:options items="${trainingCenterMap}" />
														</cf:select>
													</div>

													<div class="form-group">
												          <div>
													<ul class="lab-no">
														<li class="style-li"><strong>Training Date:</strong></li>
														
														<li id="trainingDateErr" style="display: none;"
															class="style-li error-red">Please Select Training Date.</li>
															 	<li class="style-li error-red"><label
															class="error visibility" id="courseError">*</label></li>
													</ul>
												          </div>
												<cf:input class="form-control" path="trainingDate"
													type="text" placeholder="Training Date" />
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
											<ct:if test="${!empty listapplyForPost}">
												<table id="datatablesfosrest" class="table table-bordered table-responsive">
														<thead>
														<tr class="background-open-vacancies">
															<th>S.No.</th>
															<th>Course Name</th>
															<th>Training Center Name</th>
															<th>Contact Person Name, Address, Phone</th>
															<th>Vacancy</th>
														</tr>
													</thead>

													<ct:forEach items="${listapplyForPost}" var="applyForPost"
														varStatus="loop">

														<tr>
															<td>${loop.count}<input type="checkbox"></td>
															<td>${applyForPost.courseName}</td>
															<td>${applyForPost.trainingCenter}</td>
															<td>${applyForPost.contactPerson}</td>
															<td>${applyForPost.vacancy}</td>
														</tr>
													</ct:forEach>
												</table>
												<div class="col-md-12 col-xs-12 text-right" >
                                                          <input type="button" style="float: right; width:20%;margin-top:-75px;" class="form-control login-btn" value="Apply">
                                                </div>
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
 
  