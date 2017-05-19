<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %>
        <%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>
            <script type="text/javascript">
                function OnStart() {
                    alert('vvvvvvvvvvvvvv');
                    showDetail();
              
                }
                window.onload = OnStart;

            </script>
           <script type="text/javascript">
               /*  function searchAssessmentAgencyList() {
                    document.getElementById("detailListOfAssessor").style.display = 'none';
                	var name1=JSON.stringify({
                		courseName:0
                  })
                    var result = "";
                    $.ajax({
                        type: 'post',
                        url: 'searchAssessmentAgencyList.fssai?data=',
                        contentType : "application/json",
              		  	data:name1,
                        async: false,
                        success: function(data) {
                            $('#newTable').show();
                            //var mainData = JSON.stringify(data);
                            var mainData1 = jQuery.parseJSON(data);
                            var j = 1;
                            $('#newTable tr').remove();
                            $('#newTable').append('<tr  class="background-open-vacancies"><th>S.No.</th><th>Assessment Agency Name</th><th>Number of Assessor IDs</th></tr>')
                            $.each(mainData1, function(i, obj) {
                                $('#newTable').append('<tr id="tableRow"><td>' + j++ + '</td><td>' + obj[1] + '</td><td><input type="hidden" id="assessmentAgencyId" value="' + obj[0] + '" /><a href="#" onclick="showDetail();">' + obj[2] + '</a></td></tr>');

                            });
                        }
                    });
                    return result;
                }
 */

                function showDetail() {
alert('fffffffffff');
               /*      document.getElementById("detailListOfAssessor").style.display = 'block';
                    var result = "";
                    var id = document.getElementById("assessmentAgencyId").value;
                 	var name1=JSON.stringify({
                		courseName:0 
                  }) */
                    $.ajax({
                        type: 'get',
                        url: 'adminHomepage.fssai',
                        contentType : "application/json",
              		  	data:name1,
                        async: false,
                       success: function(data) {
                    	   alert('11111111111111');
                    	 var mainData = JSON.stringify(data);
                           var mainData1 = jQuery.parseJSON(data);
                           alert('33333333344444444444444');
                        /*   $('#newTable1').show();
                            
                            //alert(mainData1);
                            var j = 1;
                            $('#newTable1 tr').remove();
                            $('#newTable1').append('<tr  class="background-open-vacancies"><th>S.No.</th><th>Assessment Agency Name</th><th>Assessor Name</th><th>Assessor Id</th><th>Activate</th></tr>')
                            $.each(mainData1, function(i, obj) {
                                $('#newTable1').append('<tr id="tableRow"><td>' + j++ + '</td><td>' + obj[0] + '</td><td>' + obj[1] + '</td><td>' + obj[2] + '</td><td><input type="hidden" id="statusHidden' + obj[4] + '" value="' + obj[3] + '"/><input type="hidden" id="assessorId' + obj[4] + '" value="' + obj[4] + '" /><button onclick="statusChange(' + obj[4] + ');return false;"> Activate</button></td></tr>');
                                console.log(obj[0] + " -" + obj[1] + " -" + obj[2] + " -" + obj[3] + " -" + obj[4]);

                            }); */
                      
                       } 
                       
                    });
                 	alert('22222222222222');
	                    //return result;
                }

                </script> 

<!-- <script >
                function statusChange(elementId) {
                
                	var result = "";
                    var id = document.getElementById("assessorId" + elementId).value;
                    var status = document.getElementById("statusHidden" + elementId).value;
                    var total = "id=" + id + "@status=" + status;
                	var name1=JSON.stringify({
                		courseName:0
                  })
                    $.ajax({
                        type: 'post',
                        url: 'changeAssessor.fssai?data=' + total,
                        contentType : "application/json",
              		  	data:name1,
                        async: false,
                        success: function(data) {
                            $('#name_status').html(response);
                            $('#newTable1').hide();
                        }
                    });
                    showDetail();
                    return result;
                }

                </script> -->
            



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
