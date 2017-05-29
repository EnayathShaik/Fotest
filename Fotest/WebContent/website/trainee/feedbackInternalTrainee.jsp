<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>

               
<!--

//-->
<style>
li.inline-text {
  display: inline-block;
  margin: 0 10px;
}
 
</style>

</script>

 <%-- <ct:url var="addAction" value="/TrainingSchedule/add.fssai" ></ct:url> --%>
<%-- <cf:form action="feedbackInternal.fssai" name="myForm" method="POST" commandName="OnlineTrainingForm" onsubmit="return validateFields();">  --%>

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
                        <div class="row">

                                <div class="col-xs-12">
                                
                                 <!-- search Results -->
                                            <div class="col-xs-12 " id="testt">

                                                <!-- table -->
                                                <div class="row">
                                                    <div class="col-xs-12">
                                                            <fieldset>
                                           <legend>Feedback</legend>
                                        
                                            <table id="datatablesfosrest" class="table table-bordered table-responsive">
                                               <thead>
                                                    <tr class="background-open-vacancies">
                                                        <th>Feedback Point</th>
                                                        <th>1</th>
                                                         <th>2</th>
                                                          <th>3</th>
                                                           <th>4</th>
                                                            <th>5</th>
                                                    </tr>
                                                </thead>
												<tr>
                                                <td>Trainer's Knowledge</td>
                                                <td class="text-center"><input type="radio" name="tk"></td>
                                                <td class="text-center"><input type="radio" name="tk"></td>
                                                <td class="text-center"><input type="radio" name="tk"></td>
                                                <td class="text-center"><input type="radio" name="tk"></td>
                                                <td class="text-center"><input type="radio" name="tk"></td>                                                
                                                
                                            </tr>
                                            
                                            <tr>
                                                <td>Trainer's Motivation</td>
                                                <td class="text-center"><input type="radio" name="tm"></td>
                                                <td class="text-center"><input type="radio" name="tm"></td>
                                                <td class="text-center"><input type="radio" name="tm"></td>
                                                <td class="text-center"><input type="radio" name="tm"></td>
                                                <td class="text-center"><input type="radio" name="tm"></td>
                                                
                                            </tr>
                                            
                                            <tr>
                                                <td>Course Content</td>
                                                <td class="text-center"><input type="radio" name="cc"></td>
                                                <td class="text-center"><input type="radio" name="cc"></td>
                                                <td class="text-center"><input type="radio" name="cc"></td>
                                                <td class="text-center"><input type="radio" name="cc"></td>
                                                <td class="text-center"><input type="radio" name="cc"></td>
                                                
                                            </tr>
                                            
                                            <tr>
                                                <td>Course Helpfull in Job</td>
                                                <td class="text-center"><input type="radio" name="chj"></td>
                                                <td class="text-center"><input type="radio" name="chj"></td>
                                                <td class="text-center"><input type="radio" name="chj"></td>
                                                <td class="text-center"><input type="radio" name="chj"></td>
                                                <td class="text-center"><input type="radio" name="chj"></td>
                                            </tr>
                                            
                                            <tr>
                                                <td>Insitute's Ambience</td>
                                                <td class="text-center"><input type="radio" name="ia"></td>
                                                <td class="text-center"><input type="radio" name="ia"></td>
                                                <td class="text-center"><input type="radio" name="ia"></td>
                                                <td class="text-center"><input type="radio" name="ia"></td>
                                                <td class="text-center"><input type="radio" name="ia"></td>
                                            </tr>
                                            
                                            <tr>                                                
                                                <td>Infrastructure Provided</td>
                                                <td class="text-center"><input type="radio" name="ip"></td>
                                                <td class="text-center"><input type="radio" name="ip"></td>
                                                <td class="text-center"><input type="radio" name="ip"></td>
                                                <td class="text-center"><input type="radio" name="ip"></td>
                                                <td class="text-center"><input type="radio" name="ip"></td>
                                            </tr>                     
												
                                            </table>
                                             <div class="col-md-06 col-xs-12" style="margin-top:39px;">
												    
										          <input type="submit" id="searchbtn" value="Submit"
										                 style=" float: right; padding:10px  50px 10px 50px"
													     class="btn login-btn" /> 
												
                                           
                                            <ul class="feed-no">
                                                <li class="inline-text"><span><strong>1</strong></span>&nbsp;<span>Poor</span></li>
                                                <li class="inline-text"><span><strong>2</strong></span>&nbsp;<span>Good</span></li>
                                                <li class="inline-text"><span><strong>3</strong></span>&nbsp;<span>Better</span></li>
                                                <li class="inline-text"><span><strong>4</strong></span>&nbsp;<span>Best</span></li>
                                                <li class="inline-text"><span><strong>5</strong></span>&nbsp;<span>Excellent</span></li>
                                            </ul>
                                                 
                                           </div>
                                        
                                          
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
    </section>                                     
											
		<input type="hidden" id="idHidden" value="" />
 <input type="hidden" id="hiddenCourseType" value="" />                                             
