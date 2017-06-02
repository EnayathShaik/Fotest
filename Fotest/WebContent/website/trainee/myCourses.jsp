<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>


 <cf:form action="mycourses.fssai" name="myForm" method="POST"
	commandName="MyCoursesForm" onsubmit="return validateFields();">
    <section>
         <%@include file="../roles/top-menu.jsp"%>
    </section>
    <!-- main body -->
    <section class="main-section-margin-top">
        <div class="container-fluid">
            <div id="wrapper">
                <!-- Sidebar -->
                <div > <%@include file="../roles/slider.jsp" %>
                </div>
                <!-- /#sidebar-wrapper -->
                <!-- Page Content -->
                <div id="page-content-wrapper">
                    <div class="container-fluid">
                        <!-- vertical button -->
                        <div class="row">
                            <div class="col-lg-12">
                                <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle"> <i class="fa fa-bars"></i> <span class="orange-font">Welcome ${userName}</span> </a>
                            </div>
                        </div>
                        <!-- add the content here for main body -->
                        <!-- timeline  -->
                        <div class="row">

                                <div class="col-xs-12">
                                    <h1></h1>
                                                            <!-- search Results -->
                                            <div class="col-xs-12 " id="testt">

                                                <!-- table -->
                                                <div class="row">
                                                    <div class="col-xs-12">
                                                            <fieldset>
                                           <legend>My Courses</legend>
                                         <ct:if test="${!empty listMyCourses}">
                                            <table id="datatablesfosrest" class="table table-bordered table-responsive">
                                               <thead>
                                                    <tr class="background-open-vacancies">
                                                        <th>S.No.</th>
                                                        <th>Course Name</th>
                                                         <th>Training Date & Time</th>
                                                          <th>Training LAB Name</th>
                                                          <th>Contact Person Name</th>
                                                            <th>Contact Person Email</th>
                                                           <th>Status</th>
            
                                                    </tr>
                                                </thead>
                                                
                                                <ct:forEach items="${listMyCourses}" var="listMyCourses" varStatus="loop">
                                                <tr>
												<td>1</td>
												<td>${listMyCourses.courseName}</td>
												<td>${listMyCourses.trainingDate} &nbsp;&nbsp;&nbsp;&nbsp;  ${listMyCourses.trainingTime}  </td>
												<td>${listMyCourses.trainingLab}</td>
												<td>${listMyCourses.name}</td>
												<td>${listMyCourses.email}</td>
												<td>${listMyCourses.status}</td>
							
											</tr>
												</ct:forEach>
                                            </table>
                                           </ct:if> 
                                        </fieldset>
											  </div>
                                                </div>
                                            </div>
                             <!-- search div ends -->
                        </div><!-- row ends -->
                    </div>
                </div>
            </div>
        </div>
      </div>
    </section>
 
 <input type="hidden" id="idHidden" value="" />
 <input type="hidden" id="hiddenCourseType" value="" />                                             
   </cf:form></html>