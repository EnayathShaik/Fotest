<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript"
	src="website/js/jquery-toaster/jquery.toaster.js"></script>
	<script src="website/js/commonController.js"></script>



<%-- <ct:url var="addAction" value="/lcEnrollmentlist.fssai"></ct:url> --%>
<cf:form action="commonContact" name="myForm" method="POST"
	commandName="ContactTrainee" onsubmit="return validateFields();">

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
									Let Us Help You.<label id="created">${created }</label>
								</h1>
								<div class="row">
									<div class="col-xs-12">
										
											
										

											<!-- left side -->
						<!--  <div class="col-xs-6">  -->
												
						        <div class="form-group">
									<div>
										<ul class="lab-no">
											<li class="style-li"><strong>Email:</strong></li>
											<li class="style-li error-red">*</li>
											<li id="qsubCategoryErr" style="display: none;"
												class="style-li error-red">Please Training Lab</li>
										</ul>
									</div>
									<cf:input path="emailAddress" placeholder="Enter email"
															class="form-control" /> 
								</div>
												
								   <div class="form-group">
                                    <div>
                                        <ul class="lab-no">
                                            <li class="style-li"><strong>Query Catagory:</strong></li><li class="style-li error-red"> * </li>
                                            <!--  valid -->
                                            <!--  <li id="correspondenceStateErr" style="display:none;" class="style-li error-red" >correspondence State can not be blank.</li> -->
                                            
                                        </ul>
                                    </div>
                                    <cf:select path="queryCatagory" class="form-control">
                                	<cf:option value="0" label="Select subject Name" />
									<cf:options items="${subjectMap}"/>
                                    </cf:select> 
                                   
                                </div>
                                
                                 <div class="form-group">
                                    <div>
                                        <ul class="lab-no">
                                            <li class="style-li"><strong>Query Sub Catagory:</strong></li><li class="style-li error-red"> * </li>
                                            <!--  valid -->
                                            <!--  <li id="correspondenceStateErr" style="display:none;" class="style-li error-red" >correspondence State can not be blank.</li> -->
                                            
                                        </ul>
                                    </div>
                                    <cf:select path="querySubCatagory" class="form-control">
                                	<cf:option value="0" label="Select subject Name" />
									<cf:options items="${subjectMap}"/>
                                    </cf:select> 
                                   
                                </div>
                             
                                  <div class="form-group">
                                    <div>
                                        <ul class="lab-no">
                                            <li class="style-li"><strong>Message:</strong></li>  <li class="style-li error-red"> * </li>
                                             <!--  valid -->
                                            <!-- <li id="correspondenceDistrictErr" style="display:none;" class="style-li error-red" >District can not be blank.</li> -->
                                          
                                        </ul>
                                    </div>
                                     <cf:textarea path="messageDetails" placeholder="Enter your message(250 words)"
															class="form-control" /> 
                            
                                </div>
                                 
                                 
                                    <!-- right side ends -->
											
									             <!-- <div class="col-md-4 col-xs-12">  
                                                      <input type="submit" class="form-control login-btn" value="Show Details"> </a>
                                                 </div> -->
                                                 <div class="col-md-4 hidden-xs"></div>
                                                        <div class="col-md-4 col-xs-12">
                                                                <input type="button" class="form-control login-btn" value="Submit">
                                                        </div>
                                                        <div class="col-md-4 hidden-xs"></div>

													<!-- <input type="submit" id="updatebtn"
														style="display: none; float: right; margin-right: 122px;"
														value="Update" class="btn login-btn" /> <input
														type="submit" id="createbtn" value="Create"
														class="btn login-btn" /> -->
												</div>
											</div>

										
									</div>
								</div>
							</div>
</div></div></div></section></cf:form>