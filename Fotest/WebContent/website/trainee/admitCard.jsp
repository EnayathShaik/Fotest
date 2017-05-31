<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>

               
<!--

//-->
</script>

 <%-- <ct:url var="addAction" value="/TrainingSchedule/add.fssai" ></ct:url> --%>
<%-- <cf:form action="onlineTraining.fssai" name="myForm" method="POST" commandName="OnlineTrainingForm" onsubmit="return validateFields();">  --%>

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
                                <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle"> <i class="fa fa-bars"></i> <span class="orange-font">Welcome FotestTrainee</span> </a>
                            </div>
                        </div>
                        <!-- add the content here for main body -->
                        <!-- timeline  -->
                      
                         <div class="container-fluid">
                                <h2 class="text-center course-heading-color">Admit Card</h2>
                                <hr class="course-heading-underline">

                                <div class="col-md-2 hidden-xs"> </div>
                                <div class="col-md-8 col-xs-12 contact-margin-top">
                                    <img src="website/img/admit-card.jpg" class="img-responsive" />
                                
                                <div class="col-md-2 hidden-xs"> </div>
                            </div>
                        </div>

                             <!-- search div ends -->
                        <!-- row ends -->
                    </div>
                </div>
            </div>
        </div>
    </section>
 
 <input type="hidden" id="idHidden" value="" />
 <input type="hidden" id="hiddenCourseType" value="" />                                             
  