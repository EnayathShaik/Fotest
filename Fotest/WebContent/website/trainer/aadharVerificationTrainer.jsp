<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="website/js/commonController.js"></script>

  <script>
                function OnStart() {
                
                	flatpickr("#dob" , {
                		
                	});	
                }
                window.onload = OnStart;
            </script>
<script> 
    function AvoidSpace(event) {
        var k = event ? event.which : window.event.keyCode;
        alert(k);
        if (k == 32) return false;
    }
    
    function isAadharCorrect(){
    
    	var aadhar=document.getElementById( "AadharNumber" ).value;
    	//dateP,name
    	var DOB = $("#dateP").val();
    	localStorage.setItem("DOB", DOB);
    	
    	var name = $("#name").val();
    	localStorage.setItem("name", name);
    	var middleName = $("#middleName").val();
    	localStorage.setItem("middleName", middleName);
    	var lastName = $("#lastName").val();
    	localStorage.setItem("lastName", lastName);
    	if(document.getElementById('123').checked)
    		var gender = $("#123").val();
    	else
    		var gender = $("#456").val();
    
    	localStorage.setItem("gender", gender);
    	var i=0;
    	if(aadhar != ''){
    		if(aadhar.length == 12){
    			localStorage.setItem("aadhar", aadhar);
    		}
    		else{
    			i=1;
    		 alert('Aadhar Number Must be 12 Digit.');
    		}
    	}
    	else{
    		i=2;
    		 alert('Please enter Aadhar Number');
    		 
    	}
 	 if(i==0){
    		//$('#verifyBtn').on('click',function(ev) {
		        $('#myModal').modal({
		            show: 'true'
		        });
		   // });
    		return true;
    	} 
    }

</script>
  <cf:form action="verifyRegistrationForm.fssai"  name="myForm" method="POST" commandName="aadharDetails" >
<%-- <ct:url var="addAction" value="/manageTraining/add.fssai"></ct:url>
<cf:form action="${addAction}" name="myForm" method="POST"
	commandName="aadharDetails"> --%>

<!-- main section -->
<section class="section-form-margin-top">
  <div class="container"> 
    <!-- login form -->
    <div class="row">
      <div class="col-md-2 hidden-xs"></div>
      <div class="col-md-8  col-xs-12">
        <h3 class="text-capitalize heading-3-padding" style="font-size: 24px; text-align: left;">Trainer Registration Form</h3>
        <!-- personel info Start -->
        <div class="personel-info" style="margin-bottom: 40px;">
          <fieldset>
            <legend>
            <h3 style="font-size: 20px; font-weight: normal;">Personal Information</h3>
            </legend>
            <!-- left side -->
            <div class="col-md-6 col-xs-12">
              <div class="form-group">
								<div>
									<ul class="lab-no">
										<li class="style-li"><strong><cs:message
													code="lbl.Trainee.AadharNumber" /></strong></li>
										<li class="style-li error-red"><span id="aadhar_status"></span><label
												id=AadharNumberError class="error visibility">*
													Enter your aadharNumber </label> <cf:errors path="AadharNumber"
													cssClass="error" /></li>
									</ul>
								</div>
								<cf:input path="AadharNumber" class="form-control"
									maxlength="12" placeholder="Aadhar Number"
									onblur="ck_aadhar('personalinformationtrainer');" value=""
									onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')" />
							</div>
              <div class="form-group">
                <div>
                  <ul class="lab-no">
                    <li class="style-li"><strong>Date Of Birth:</strong></li>
                    <li class="style-li error-red"> </li>
                  </ul>
                </div>
                <cf:input path="dob" type="text" id="dateP" class="form-control" placeholder="Date of birth" />
              </div>
              
              <div class="form-group">
<div>
<ul class="lab-no">
<li class="style-li"><strong><cs:message code="lbl.Trainee.Gender" /></strong></li>
<li class="style-li error-red">
<label id="errorgender" class="error visibility">* error</label>
<cf:errors path="gender" cssClass="error" /></li>
</ul>
</div>
<label class="radio-inline">
<cf:radiobutton path="gender" value="M" checked="true" id="123" />Male&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 <cf:radiobutton path="gender" value="F" id="456"/>Female
</label>
</div>

            </div>
            <!-- right side -->
            <div class="col-md-6 col-xs-12">
              <div class="form-group">
                <div>
                  <ul class="lab-no">
                    <li class="style-li"><strong>First Name:</strong></li>
                    <li class="style-li error-red"></li>
                  </ul>
                </div>
                <cf:input path="name" class="form-control" placeholder="first Name" />
              </div>

            </div>
            
             <div class="col-md-6 col-xs-12">
              <div class="form-group">
                <div>
                  <ul class="lab-no">
                    <li class="style-li"><strong>Middle Name:</strong></li>
                    <li class="style-li error-red"></li>
                  </ul>
                </div>
                <cf:input path="middleName" class="form-control" placeholder="Middle Name" />
              </div>

            </div>
            
            <div class="col-md-6 col-xs-12">
              <div class="form-group">
                <div>
                  <ul class="lab-no">
                    <li class="style-li"><strong>Last Name:</strong></li>
                    <li class="style-li error-red"></li>
                  </ul>
                </div>
                <cf:input path="lastName" class="form-control" placeholder="Last Name" />
              </div>
</div>
           <button type="button" class="btn login-btn" id="verifyBtn"
												data-toggle="modal"  style="margin-left: 300px;" onclick="return isAadharCorrect();">Verify</button>
												</fieldset>
												<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
								aria-labelledby="myModalLabel">
								<div class="modal-dialog" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
											 <p class="text-center" style="color: green;">Aadhar Verified!</p>
                                        <p class="text-center">Your Linked Bank Account : State Bank of India</p>
										<div class="col-xs-12" style="margin-top: 20px; text-align: -webkit-center;"> <a href="PersonalInformationTrainer.fssai" class="btn login-btn" style="width: 40%;">Register</a> 
             
            </div> 
										</div>
									
										</div>

									</div>
								</div>
							</div>
        </div>
      </div>
      <div class="col-md-2 hidden-xs"></div>
    </div>
</section>
</cf:form>