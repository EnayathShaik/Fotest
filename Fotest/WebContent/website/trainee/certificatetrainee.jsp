<%@page import="java.text.SimpleDateFormat"%>
    <%@page import="java.util.Date"%>
    <%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core"%>

    
        <html xmlns="http://www.w3.org/1999/xhtml">
        <%
String strNewDate = null;
try{

	strNewDate=new SimpleDateFormat("dd/MM/yyyy").format(new Date());
}catch(Exception e){
}
%>

            <head>
                <title></title>
                <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
                <script type="text/javascript">
                    $("#btnPrint").live("click", function () {
                        var divContents = $("#dvContainer").html();
                        var printWindow = window.open('', '', 'height=400,width=800');
                        /* printWindow.document.write('<html><head><title>DIV Contents</title>'); */
                        printWindow.document.write('</head><body >');
                        printWindow.document.write(divContents);
                        printWindow.document.write('</body></html>');
                        printWindow.document.close();
                        printWindow.print();
                    });
                </script>
            </head>

            <body>
                <form>
                    <!-- horizontal navigation -->
                    <section>
                        <%@include file="../roles/top-menu.jsp"%>
                    </section>
                    <!-- main body -->
                    <section class="main-section-margin-top">
                        <div class="container-fluid">
                            <div id="wrapper">
                                <!-- Sidebar menu -->
                                <%@include file="../roles/slider.jsp" %>
                                    <!-- Sidebar menu -->
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
                                            <div id="dvContainer">
                                                <div class="container-fluid">
                                                    <div class="row">
                                                        <!-- html code to add from here -->
                                                        <div class="col-xs-12 certi-width">
						                                    <div class="col-xs-12"><img src="website/img/hra-wigeneral.jpg" class="img-responsive"></div>
						            							
                                         <div class="col-xs-12 this-certify">
                                        <h3 class="text-center th-pos">This is to certify that</h3>
                                        	<ct:forEach items="${listCertificate}" var="listCertificate" varStatus="loop">
										
                                        <p class="text-center for-p"><span><strong>${listCertificate[0]}&nbsp;&nbsp;${listCertificate[1]}&nbsp;&nbsp;${listCertificate[2]} </strong></span></p>
                                       
                                      	</ct:forEach>
                                          <hr class="nam-hr">
                                        <div class="di-msg">
                                            <p>has received necessary training required to be a trainer for Project Clean Streat Food . The Training</p>
                                            <p> was help on
                                                <span class="on-dat-general"></span>
                                                <span class="at-general">at</span>
                                                <span><hr class="on-hr-general" /></span>

                                                <span>
                                                    
                                                <span class="add-pos-general"></span><span><hr class="at-hr-general"></span><span class="full-stop-general">.</span>
                                                </span>

                                            </p>

                                        </div>
                                    </div>

                                    <div class="col-xs-12 sign-pos-general">
                                        <div class="col-md-6 col-xs-6">
                                            <hr class="left-sign">
                                            <p class="left-p">Training Partner</p>
                                        </div>
                                        <div class="col-md-6 col-xs-6">
                                            <hr class="right-sign">
                                            <p class="right-p text-center">Training Coordinator
                                                <br><span>FSSAI</span></p>
                                        </div>
                                    </div>

                                    <div class="col-xs-12 cert-btm-general">
                                        <p class="btm-p">Certificate Number : ${certificateID}</p>
                                        <p class="btm-p">Date Issued : <%=strNewDate%></p>
                                        <p class="btm-p">Refresher Due : 2 years from date of issue.</p>
                                    </div>                     
						                                     
						                                     
						                                     
						                                     

                                    
						
						                                    <div class="row">
						                                        <div class="col-md-4 col-xs-12"></div>
						                                        <div class="col-md-4 col-xs-12" style="position: absolute;top: 54em;left: 12px;">
						                                            <a href="#" onclick="window.print()" class="btn login-btn" style="width: 100%;">Print</a>
						                                        </div>
						                                        <div class="col-md-4 col-xs-12"></div>
						                                    </div>
						
						                                </div>
                                                        <!-- html code ends here -->
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                    </section>
                    <!-- scripts -->
                </form>
            </body>

        </html>