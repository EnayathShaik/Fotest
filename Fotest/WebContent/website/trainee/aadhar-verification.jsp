<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="website/js/commonController.js"></script>
<script src="website/js/jquery-2.1.0.min.js"></script>
<script> 
function OnStart() {
    
	flatpickr("#dob", {});
}
window.onload = OnStart;

    function AvoidSpace(event) {
        var k = event ? event.which : window.event.keyCode;
        if (k == 32) return false;
    }
    
    function isAadharCorrect(){
    	var aadhar=document.getElementById( "AadharNumber" ).value;
    	//dateP,name
    	var DOB = $("#dateP").val();
    	localStorage.setItem("DOB", DOB);
    	
    	var name = $("#name").val();
    	localStorage.setItem("name", name);
    	
    	var name = $("#middleName").val();
    	localStorage.setItem("middleName", name);
    	
    	var name = $("#lastName").val();
    	localStorage.setItem("lastName", name);
    	
    	if(aadhar != ''){
    		if(aadhar.length == 12){
    			localStorage.setItem("aadhar", aadhar);
    		}else{
    			alert('Aadhar Number Must be 12 Digit.');
        		return false;
    		}
    	}else{
    		alert('Please enter Aadhar Number');
    		return false;
    	}
    	
    }

</script>
<cf:form action="registrationForm.fssai"  name="myForm" method="POST" commandName="aadharDetails">
 


<!-- main section -->
<section class="section-form-margin-top">
  <div class="container"> 
    <!-- login form -->
    <div class="row">
      <div class="col-md-2 hidden-xs"></div>
      <div class="col-md-8  col-xs-12">
        <h3 class="text-capitalize heading-3-padding" style="font-size: 24px; text-align: left;">Trainee Registration Form</h3>
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
										<li class="style-li error-red"><span id="aadhar_status"><label
												id=AadharNumberError class="error visibility">*
													Enter your aadharNumber </label> <cf:errors path="AadharNumber"
													cssClass="error" /></li>
									</ul>
								</div>
								<cf:input path="AadharNumber" class="form-control"
									maxlength="12" placeholder="Aadhar Number"
									onblur="ck_aadhar('personalinformationtrainee');" value=""
									onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')" />
							</div>
              
              <div class="form-group">
									<div>
										<ul class="lab-no">
											<li class="style-li"><strong>Date of Birth:</strong></li>
											<li id="dobErr" style="display: none;"
												class="style-li error-red">Please Select Date Of Birth.</li>
											<li class="style-li error-red">*</li>
										</ul>
									</div>
									<cf:input type="text" path="dob" id="dateP" name="dob"
										class="form-control" />
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
				<cf:radiobutton path="gender" value="M" checked="true" />Male&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				 <cf:radiobutton path="gender" value="F" />Female
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
            
               <button type="button" class="btn login-btn" data-toggle="modal" data-target="#myModal" style="margin-left: 300px;">Verify</button>
	</fieldset>
	
	<!-- modal -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
								<div class="modal-dialog" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
											 <p class="text-center" style="color: green;">Aadhar Verified!</p>
                                             <p class="text-center">Your Linked Bank Account : State Bank of India</p>
										    <div class="col-xs-12" style="margin-top: 20px; text-align: -webkit-center;"> <a href="PersonalInformationTrainee.fssai" onclick="return isAadharCorrect();"class="btn login-btn" style="width: 40%; margin-left: 155px;">Register</a> 
             
                                            </div> 
										</div>
									
									</div>

								</div>
			</div>
            
            
          </fieldset>
        </div>
      </div>
      <div class="col-md-2 hidden-xs"></div>
    </div>
  </div>
</section>
</cf:form>