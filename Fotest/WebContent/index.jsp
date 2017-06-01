<%@page import="com.ir.form.common.EventsCreater"%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html lang="en">
<script type="text/javascript">
	function preventBack() {
		window.history.forward();
	}
	setTimeout("preventBack()", 10);
	window.onunload = function() {
		null
	};
</script>

<head>

<base href="<%=basePath%>">

<title>FOTEST</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>FOTEST - Food Testing Staff Training </title>
<!-- core CSS -->
<link href="website/css/bootstrap.min.css" rel="stylesheet">
<link href="website/css/font-awesome.min.css" rel="stylesheet">
<link href="website/css/animate.min.css" rel="stylesheet">
<link href="website/css/main.css" rel="stylesheet">
<link href="website/css/responsive.css" rel="stylesheet">
<link href="website/css/monthly.css" rel="stylesheet" />
<link href="website/css/custom.css" rel="stylesheet" />
<link href="css/swipebox.css" rel="stylesheet" />


</head>
<!--/head-->

<body class="homepage">

	<header id="header">
		<div class="top-bar">
			<div class="container">
				<div class="row">
					<div class="col-sm-6 col-xs-4">
						<div class="top-logo">
							<a href="loginProcess.fssai"><img class="img-responsive"
								src="website/images/fostac-logo.png"
								alt="Food Safety Training and Certification"
								title="Food Safety Training and Certification"></a>
						</div>
					</div>
					<div class="col-sm-6 col-xs-8">
						<div class="social">
							<div class="social-share">
								<a href="http://www.fssai.gov.in/" target="_blank"><img
									class="img-responsive" src="website/images/fosrest-logo.png"></a>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!--/.container-->
		</div>
		<!--/.top-bar-->

		<nav class="navbar navbar-inverse" role="banner">
			<div class="container">
				<div class="navbar-header">
					<button style="background: #000070;" type="button"
						class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
				</div>
				<div class="collapse navbar-collapse navbar-left text-center">
					<ul class="nav navbar-nav">
						<li id="homepagefssai"><a onclick="setID('homepagefssai')"
							href="fostac.fssai">HOME</a></li>
						<li id="aboutpagefssai"><a onclick="setID('aboutpagefssai')"
							href="about.fssai">ABOUT</a></li>
						<li id="coursespagefssai" class="dropdown"><a
							onclick="setID('coursespagefssai')" href="courses.html"
							class="dropdown-toggle" data-toggle="dropdown">COURSES <i
								class="fa fa-angle-down"></i></a>
							<ul class="dropdown-menu">
								<li><a href="#">Induction Training</a></li>
             					 <li><a href="#">Refresher Training</a></li>
             					 <li><a href="#">Training of Trainers</a></li>
              					<li><a href="#">Specific Training</a></li>
							</ul></li>
							<li><a href="#">Useful Links</a></li>
						<li id="faqpagefssai"><a onclick="setID('faqpagefssai')"
							href="faq.fssai">FAQ</a></li>
						<li id="contactpagefssai"><a
							onclick="setID('contactpagefssai')" href="contact.fssai">CONTACT</a></li>
						<li id="loginpagefssai"><a onclick="setID('loginpagefssai')"
							href="login.fssai">LOGIN</a></li>
					</ul>
					<div class="search">
						<form role="form" class="searchbar">
							<input type="text" class="search-form" autocomplete="off"
								placeholder="Search..."> <i
								style="color: #71b44b; margin-right: 10px;" class="fa fa-search"></i>
						</form>
					</div>
				</div>
			</div>
			<!--/.container-->
		</nav>
		<!--/nav-->

	</header>
	<!--/header-->

	<section id="main-slider" class="no-margin">
		<div class="carousel slide">
			<div class="carousel-inner">
				<div class="item active header-bg"
					style="background-image: url(website/images/slider/banner.jpg)">
					<div class="container">
						<div class="row slide-margin">
							<div class="col-sm-12">
								<div class="carousel-content">
									<h1 class="animation animated-item-1">Food Testing Staff Training
										</h1>
									<!-- <h3 class="animation animated-item-3">WE ARE LOOKING FOR
										YOU!</h3> -->
									<h2 class="animation animated-item-2">REGISTER HERE</h2>
								</div>
							</div>
							<div class="col-sm-6 hidden-xs animation animated-item-4">
								<div class="slider-img"></div>
							</div>
							<!-- re update the index design -->
							<div class="col-xs-12">
								<div class="col-md-3 xs-hidden"></div>
								<div class="col-md-6 col-xs-12">
									<div class="col-md-4 col-xs-12" align="center">
										<a href="aadhar-verification.fssai"><img
											src="website/images/trainee.png"></a>
									</div>
									<div class="col-md-4 col-xs-12" align="center">
										<a href="aadharVerificationTrainer.fssai"><img
											src="website/images/trainer.png"></a>
									</div>
									<div class="col-md-4 col-xs-12" align="center">
										<a href="registerpersonalinformationtrainingpartner.fssai"><img
											src="website/images/trainingpartner.png"></a>
								</div>
								<div class="col-md-3 xs-hidden"></div>

							</div>
						</div>
					</div>
				</div>
				
			</div>
			<!--/.carousel-inner-->
		</div>
		<!--/.carousel-->
		</div>
	</section>
	<!--/#main-slider-->

	<!--/#feature-->
	<section id="feature">
		<div class="container">
			<div class="row">
				<div class="course-heading">Training</div>
				<div class="course-arrow">
					<img src="website/images/course-down-arroe.png" width="8"
						height="25">
				</div>
			</div>
			<div class="row">
				<div class="features">
					  <div class="col-md-3 col-sm-4 wow fadeInDown"
						data-wow-duration="1000ms" data-wow-delay="600ms">
						<div class="feature-wrap ">
						<div class="left-training-box" style="color:#fff !important;">
						<a href="" ><img src="website/images/general-training.png" class="img-responsive general-image-train" alt="image" /></a>
								   <div><a href="" > <h3 class="text-center text-capitalize padding-17 fon-dis-siz" style="color:#fff !important;">General Training</h3> </a>
								   </div>
						</div>
						</div>
					</div>
					    <div class="col-md-3 col-xs-12">
                    <div class="center-training-box sop-tra">
                        <a href="" ><img src="website/images/back.jpg" class="img-responsive general-image-train" alt="image" /></a>

                        <a href="" > <h3 class="text-center text-capitalize sop-head-three fon-siz-22" style="color:#fff !important;margin:0px;    background-color: #d9041d !important;">Sophisticated Instruments Training</h3> </a>
</div>
                </div>
					 <div class="col-md-3 col-xs-12 news-blog-background">
                    <div class="cust-pad-blog img-center-blog">
                        <a href="#" ><img src="website/images/blog.png" class="img-responsive" alt="blog image" /></a>
                    </div>
                </div>
                 <div class="col-md-3 col-xs-12">
                    <div class="custm-news">
                        <h2 class="text-capitalize text-center news-font">News & Updates</h2>
                    </div>
                    <div id="news" class="owl-carousel">
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner">
    <div class="item active">
      <p class="txt-ellip">FSSAI vide Gazette notification number S.O 2428 (E) dated the 13th July, 2016 notified 112 NABL accredited food testing laboratories for the purpose of carrying out Analysis of samples taken under Section 47 of the Food Safety and Standard Act, 2006.</p>
                            <div class="text-center"><a href="#" class="btn btn-default" >Read More</a></div>
    </div>

    <div class="item">
       <p class="txt-ellip">Foods & Examinations proposed to be held in December 2016.</p>
                            <div class="text-center"><a href="#" class="btn btn-default" >Read More</a></div>
    </div>

    <div class="item">
       <p class="txt-ellip">More Intimation Coming Soon.</p>
                            <div class="text-center"><a href="#" class="btn btn-default" >Read More</a></div>
    </div>
  </div>

  <!-- Left and right controls -->
 
</div>

				</div>
				<!--/.services-->
			</div>
			<!--/.row-->
		</div>
		<!--/.container-->
		</div>
	</section>

<header class="header-spacing">
<h2 class="text-capitalization">Photo Gallery</h2></header>
	<section id="feature" style="margin:0px; padding:0px;" >
  <div class="container">
    <div class="row">
      <div class="features">
        <div class="col-md-5 col-xs-12 wow fadeInDown btm-space" data-wow-duration="1000ms" data-wow-delay="600ms">
         
          <div id="myCarousel1" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators hidden">
    <li data-target="#myCarousel1" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel1" data-slide-to="1"></li>
    <li data-target="#myCarousel1" data-slide-to="2"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner">
    <div class="item active">
     <div class="item"> <a href="website/images/photo-gallery.jpg" class="swipebox" title="Event Name"> <img src="website/images/photo-gallery.jpg" alt="image"> </a> </div>
      </div>

    <div class="item">
        <a href="website/images/photo-gallery.jpg" class="swipebox" title="Event Name"> <img src="website/images/photo-gallery.jpg" alt="image"> </a> </div>
   

   <div class="item"> <a href="website/images/photo-gallery.jpg" class="swipebox" title="Event Name"> <img src="website/images/photo-gallery.jpg" alt="image"> </a> 
   </div>
   
   
  </div>

  <!-- Left and right controls -->
 
</div>
      
        </div>
          <div class="col-md-3 col-xs-12 learning-resources-background">
                    <div class="text-center"> <a href=""><img src="website/images/icon workshop image.png" alt="Learning Resources" /></a> </div>
                    <h3 class="text-center"><a href="" class="white" >Learning Resources</a></h3>
                </div>
        <!--/.col-md-4-->
       
					 <div class="col-md-4 col-xs-12 wow fadeInDown"
						data-wow-duration="1000ms" data-wow-delay="600ms">
						
					
						<div class="page">
							<div
								style="width: 100%; max-width: 600px; display: inline-block;">
								<div class="monthly" id="mycalendar"></div>
							</div>
						</div>


					</div> 
					<div class="col-md-3 col-xs-12 wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="600ms">
        
        </div>
        <!--/.col-md-4--> 
        
      </div>
      <!--/.services--> 
    </div>
    <!--/.row--> 
  </div>
  <!--/.container--> 
</section>
 <section id="feature" style="display:none;">
		<div class="container">
			<div class="row">
				<div class="features">

					<div class="col-md-3 col-sm-4 wow fadeInDown"
						data-wow-duration="1000ms" data-wow-delay="600ms">
						<a href="certificationProcess.fssai">
							<div class="feature-wrap assessor-box center-block">
								<h3 class="box-heading">Certification Process</h3>
								<p>Fostac has FSSAI recognized assessor's to access &
									provide FSSAI validated certificate.</p>
							</div>
						</a>
					</div>


					<!--/.col-md-4-->

					<div class="col-md-3 col-sm-4 wow fadeInDown"
						data-wow-duration="1000ms" data-wow-delay="600ms">
						<a href="knowYourTrainingPartner.fssai">
							<div class="feature-wrap partner-box center-block">
								<h3 class="box-heading">TRAINING PARTNER & ASSESSMENT
									AGENCY</h3>
								<p>On the basis of your training need you can choose your
									training provider.</p>
							</div>
						</a>
					</div>
					<!--/.col-md-4-->
					<!-- calendar -->

					<!--/.col-md-4-->

					 <div class="col-md-3 col-sm-4 wow fadeInDown"
						data-wow-duration="1000ms" data-wow-delay="600ms">
						<div class="feature-wrap training-box center-block">
							<h3 class="box-heading">Find your Nearest Training Centre</h3>
							<div style="margin: 10px 0px 0px 0px;">
								<jsp:include page="website/website/index.html" />
							</div>
						</div>
					</div> 
					<!--/.col-md-4-->

				</div>
				<!--/.services-->
			</div>
			<!--/.row-->
		</div>
		<!--/.container-->
	</section> 

	<section>
		<div class="container">
			<div class="row">
				<div class="col-xs-12">
					<div id="map-container">
						<div class="row">
							<div class="col-md-4 col-xs-12">
								<div id="loc-list">
									<ul id="list"></ul>
								</div>
							</div>

							<div class="col-md-8 col-xs-12">
								<div id="map" style="height: 200px; width: 100%;"></div>
							</div>
						</div>


					</div>
				</div>


			</div>
		</div>
	</section>


	<section id="bottom">
		<div class="container wow fadeInDown" data-wow-duration="1000ms"
			data-wow-delay="600ms">
			<div class="row">
				<div class="col-md-3 col-sm-6">
					<div class="widget center-block">
						<ul>
							<li><a href="fostac.fssai">Home</a></li>
							<li><a href="about.fssai">About</a></li>
							<li class="dropdown"><a href="courses.html"
								class="dropdown-toggle" data-toggle="dropdown">Courses<i
									class="fa fa-angle-down"></i></a>
								<ul class="dropdown-menu">
									<li><a href="basic-level.fssai">Basic Level</a></li>
									<li><a href="advance-level.fssai">Advance Level</a></li>
									<li><a href="special-level.fssai">Special Level</a></li>
								</ul></li>
							<li><a href="#">Risk & Solutions</a></li>
							<li><a href="#">Help</a></li>
							<li><a href="contact.fssai">Contact</a></li>
						</ul>
					</div>
				</div>
				<!--/.col-md-3-->
				<div class="col-md-3 col-sm-6">
					<div class="widget center-block">
						<ul>
							<li><a href="disclaimer.fssai">Disclaimer</a></li>
							<li><a href="#">Archives</a></li>
							<li><a href="#">Useful Links</a></li>
							<li><a href="#">Faqs</a></li>
							<li><a href="feedback.fssai">Feedback</a></li>
						</ul>
					</div>
				</div>
				<!--/.col-md-3-->
				<div class="col-md-3 col-sm-6">
					<div class="widget center-block text-center"
						style="border-right: none;">
						<ul>
							<!--  <li class="subscribe">Sign up for our mailing list to get latest updates and offers.
              <form action="#" id="form-subscribe">
                <div class="form-field">
                  <input type="email" placeholder="Email Address" id="email">
                  <input class="btn" type="submit" id="submit" value="Subscribe">
                </div>
             
            </li> -->
							
							<li class="pd-top"><a href="website/android/app-release.apk"
								target="_blank"><img src="website/images/android.png"
									width="30" height="30"></a>&nbsp; <a href="#" target="_blank"><img
									src="website/images/facebook.png" width="30" height="30"></a>&nbsp;
								<a href="#" target="_blank"><img
									src="website/images/twitter.png" width="30" height="30"></a>&nbsp;
								<a href="#" target="_blank"><img
									src="website/images/linkedin.png" width="30" height="30"></a>
								&nbsp; <a href="#" target="_blank"><img
									src="website/images/google-plus.png" width="32" height="32"></a>
							</li>
						</ul>
					</div>
				</div>
				<!--/.col-md-3-->
				<div class="col-md-3 col-sm-6">
					<div class="widget center-block text-center"
						style="border-right: none;">
						<ul>
							<li><a href="http://www.fssai.gov.in/" target="_blank"><img
									src="website/images/fssai.png" alt="FSSAI" width="151"
									height="86"></a></li>
						</ul>
					</div>
				</div>
				<!--/.col-md-3-->
			</div>
		</div>
	</section>
	<!--/#bottom-->
	<footer id="footer" class="midnight-blue">
		<div class="container">
			<div class="row">
				<div class="col-sm-12 text-center">
					Design and Developed by &nbsp;<a href="http://www.zentechinfo.com/"
						target="_blank"
						style="color: #1c1b1b; text-decoration: underline;">Zentech
						Info Solutions Pvt. Ltd.</a> &copy; FSSAI 2016- All Right Reserved.
				</div>
			</div>
		</div>
	</footer>
	<!--/#footer-->
	<!-- <script src="website/js/jquery.js"></script>  -->
	<script src="website/js/bootstrap.min.js"></script>
	<script src="website/js/jquery.isotope.min.js"></script>
	<script src="website/js/wow.min.js"></script>
	<script src="website/js/monthly.js"></script>
	<%
		EventsCreater creater = new EventsCreater();
		creater.createEvents(request);
	%>
	<script type="text/javascript">
		$(window)
				.load(
						function() {

							$('#mycalendar').monthly({
								mode : 'event',
								//jsonUrl: 'events.json',
								//dataType: 'json'
								xmlUrl : 'website/js/events.xml'
							});

							 $('#mycalendar2').monthly({
						            mode: 'picker',
						            target: '#mytarget',
						            setWidth: '250px',
						            startHidden: true,
						            showTrigger: '#mytarget',
						            stylePast: true,
						            disablePast: true
						        });


							switch (window.location.protocol) {
							case 'http:':
							case 'https:':
								// running on a server, should be good.
								break;
							case 'file:':
								alert('Just a heads-up, events will not work when run locally.');
							}

						});
	</script>
	<div id="google_translate_element"></div>
	<script type="text/javascript">
		function googleTranslateElementInit() {
			new google.translate.TranslateElement({
				pageLanguage : 'en',
				layout : google.translate.TranslateElement.InlineLayout.SIMPLE
			}, 'google_translate_element');
		}
	</script>
	<script type="text/javascript"
		src="//translate.google.com/translate_a/element.js?cb=googleTranslateElementInit"></script>



</body>


</html>
   <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="js/aos.js"></script>
    <script>
        AOS.init();
    </script>
    <!-- carousel -->
    <script src="js/owl.carousel.js"></script>

    <!-- gallery -->
    <script src="js/jquery.swipebox.js"></script>
    <script type="text/javascript">
    ; (function ($) {

        $('.swipebox').swipebox();

    })(jQuery);
    </script>
