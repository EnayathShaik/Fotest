
<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="cs" uri="http://www.springframework.org/tags"%>
        <%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core"%>
        <!-- @author Jyoti Mekal -->

   			  
            <cf:form commandName="certification">

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
                                                <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle"> <i class="fa fa-bars"></i> <span class="orange-font">Welcome ${userName}</span>
                                                </a>
                                            </div>
                                        </div>
            
<fieldset><legend>Certification</legend>
<ct:if test="${!empty listcertification}">
	  <table id="datatablesfosrest" class="table table-bordered table-responsive">
	<thead>
	<tr>
	<th >Sr. No</th>
		<th >Course Name</th>
		<th >Training Date and Time</th>
		<th >Training LAB Name</th>
		<th >Certification</th>

	
	</tr>
	</thead>
	<ct:forEach items="${listcertification}" var="listcertification">
	
	
		<tr>
			<td>1</td>
			<td>${listcertification.courseName}</td>
			<td>${listcertification.trainingDate} &nbsp;&nbsp;&nbsp;&nbsp;  ${listcertification.trainingTime}  </td>
			<td>${listcertification.trainingLab}</td>
			<td><a href="certificatetrainee.fssai"><input type="button" value="Get Certificate"  class="form-control login-btn"></a></td>
		</tr>
	</ct:forEach>
	</table>
</ct:if>
</fieldset>
</div>
</div>
</div>
</div>
</section>
<input type="hidden" id="idHidden" value="" />
            </cf:form>