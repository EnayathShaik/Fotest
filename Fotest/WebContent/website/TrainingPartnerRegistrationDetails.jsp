<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core"%>


<script src="website/js/jquery-2.1.0.min.js"></script>


<script src="website/js/commonController.js"></script>

<script>

/* function OnStart() {

	flatpickr("#dob", {
		enableTime : true
	});
	
	DrawCaptcha();
}
window.onload = OnStart; */


	function DrawCaptcha() {
		var a = Math.ceil(Math.random() * 7) + '';
		var b = Math.ceil(Math.random() * 7) + '';
		var c = Math.ceil(Math.random() * 7) + '';
		var d = Math.ceil(Math.random() * 7) + '';
		var e = Math.ceil(Math.random() * 7) + '';
		var f = Math.ceil(Math.random() * 7) + '';
		var code = a + ' ' + b + ' ' + ' ' + c + ' ' + d + ' ' + e + ' ' + f;
		document.getElementById("txtCaptcha").value = code
	}

	  function OnStart(){
	
	 var isUpdate = '${isUpdate}';
	 var profileId = '${profileId}';
	 if(profileId ==2 || profileId == 1 ){ 
	
	 $("#statusDIV").css("display" , "block");
	
	
	 }
	 if(isUpdate !=null && isUpdate== "Y"){
	 alert("Update Your Details");
	
	 $("#id").val('${PersonalInformationTrainingPartner.loginDetails.id}'); 
	 $("#state").val('${PersonalInformationTrainingPartner.state}');
	 $("#state").trigger("change");
	 window.setTimeout(function() {
	 $("#district").val('${PersonalInformationTrainingPartner.district}');
	 $("#district").trigger("change");
	 window.setTimeout(function() {
	 $("#closestCity").val('${PersonalInformationTrainingPartner.closestCity}');
	 }, 1000);
	 }, 1000);
	
	 $("#createUpdateBtn").val("Update");
	 $("#captcha").css("display" , "none");
	 $("#chkunit").css("display" , "none");
	 $("#check").attr("checked","checked");
	 
	 var name = '${PersonalInformationTrainingPartner.testingFacilities}';
	
	 alert(name);
	 $("#testingFacilities").attr("checked","checked");
	 
	 }

	
	 DrawCaptcha(); 
	
	 flatpickr("#dob" ,{});	
	
	/* 
	 $('#sameAddr').change(function(){
	
	 if(this.checked){
	 $("#resState").val($("#correspondenceState").val());
	 $("#resState").trigger("change");
	 window.setTimeout(function() {
	 $("#residentialDistrict").val($("#correspondenceDistrict").val());
	 $("#residentialDistrict").trigger("change");
	 window.setTimeout(function() {
	 $("#resCity").val($("#correspondenceCity").val());
	 }, 1000);
	 }, 1000);
	
	
	 $("#resPincode").val($("#correspondencePincode").val());
	 $("#ResidentialLine1").val($("#correspondenceAddress1").val());
	 $("#ResidentialLine2").val($("#correspondenceAddress2").val())
	 //
	 }else{
	 $("#resState").val('');
	 $("#residentialDistrict").val('');
	 $("#resCity").val('');
	 $("#resPincode").val('');
	 $("#ResidentialLine1").val('');
	 $("#ResidentialLine2").val('');
	
	
	 }
	
	 }); 	 */	  
	
	
	
	 }
	
	 window.onload = OnStart;
	 
</script>


<cf:form action="registerpersonalinformationtrainingpartnerAdd.fssai"
	name="myForm" method="POST"
	commandName="PersonalInformationTrainingPartner"
	onsubmit="return validateFields();">

	<section>
		<div class="container">
			<div class="row mar-top-aadhar">
				<div class="col-md-1 col-xs-12"></div>

				<div class="col-md-10  col-xs-12">
					<h3 class="text-capitalize heading-3-padding">Training Partner
						Registration Form</h3>
					<!-- personal information -->
					<fieldset>
						<legend>Personal Information</legend>

						<!-- form field starts here -->



						<!-- left side -->
						<div class="col-md-6 col-xs-12">


							<%-- <cf:input type="hidden" path="id"/> --%>

							<div class="form-group">
								<div>
									<ul class="lab-no">
										<li class="style-li"><strong>User Id:</strong></li>
										<li class="style-li error-red">*</li>
										<!--  valid -->
										<li id="userIdErr" style="display: none;"
											class="style-li error-red">User Id can not be blank.</li>

									</ul>
								</div>
								<cf:input type="text" path="userId" class="form-control" />

							</div>

							<div class="form-group">
								<div>
									<ul class="lab-no">
										<li class="style-li"><strong>Date of Birth:</strong></li>
										<li class="style-li error-red">*</li>
										<!--  valid -->
										<li id="dobErr" style="display: none;"
											class="style-li error-red">Date of Birth can not be
											blank.</li>

									</ul>
								</div>
								<cf:input type="text" path="dob" id="dob" name="dob"
									class="form-control" />
							</div>

							<div class="form-group">
								<div>
									<ul class="lab-no">
										<li class="style-li"><strong>Gender:</strong></li>

										<li class="style-li error-red">*</li>
									</ul>
								</div>
								<cf:radiobutton path="gender" value="M" checked="true" />
								Male&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<cf:radiobutton path="gender" value="F" />
								Female
							</div>

							<div class="form-group">
								<div>
									<ul class="lab-no">
										<li class="style-li"><strong>Designation:</strong></li>
										<li class="style-li error-red">*</li>
										<!--  valid -->
										<li id="DesignationErr" style="display: none;"
											class="style-li error-red">Aadhar Number can not be
											blank.</li>
										<li class="style-li error-red">
									</ul>
								</div>
								<cf:input type="text" path="designation" class="form-control"
									placeholder="Designation" />
							</div>


						</div>
						<!-- left side ends -->

						<!-- right side -->
						<div class="col-md-6 col-xs-12">

							<div class="form-group">
								<div>
									<ul class="lab-no">
										<li class="style-li"><strong>Title:</strong></li>
										<!--  valid -->
										<li id="titleErr" style="display: none;"
											class="style-li error-red">Title can not be blank.</li>
										<li class="style-li error-red">*</li>
									</ul>
								</div>
								<cf:select path="title" class="form-control">
									<cf:option value="" label="Select Title" />
									<cf:options items="${titleMap}" />
								</cf:select>
							</div>

							<div class="form-group">
								<div>
									<ul class="lab-no">
										<li class="style-li"><strong>First
												Name(Authorized Person):</strong></li>
										<li class="style-li error-red">*</li>
										<!--  valid -->
										<li id="firstNameErr" style="display: none;"
											class="style-li error-red">First Name can not be blank.</li>

									</ul>
								</div>
								<cf:input type="text" path="firstName" class="form-control"
									placeholder="First Name"
									onkeyup="if (/\d/g.test(this.value)) this.value = this.value.replace(/\d/g,'')" />
							</div>

							<div class="form-group">
								<div>
									<ul class="lab-no">
										<li class="style-li"><strong>Middle
												Name(Authorized Person):</strong></li>
										<li class="style-li error-red"></li>
										<!--  valid -->
										<li id="MiddleNameErr" style="display: none;"
											class="style-li error-red">Middle Name can not be blank.</li>

									</ul>
								</div>
								<cf:input type="text" path="middleName" class="form-control"
									placeholder="Middle Name"
									onkeyup="if (/\d/g.test(this.value)) this.value = this.value.replace(/\d/g,'')" />
							</div>

							<div class="form-group">
								<div>
									<ul class="lab-no">
										<li class="style-li"><strong>Last
												Name(Authorized Person):</strong></li>
										<li class="style-li error-red"></li>
										<!--  valid -->
										<li id="LastNameErr" style="display: none;"
											class="style-li error-red">Last Name can not be blank.</li>

									</ul>
								</div>
								<cf:input type="text" path="lastName" class="form-control"
									placeholder="Last Name"
									onkeyup="if (/\d/g.test(this.value)) this.value = this.value.replace(/\d/g,'')" />
							</div>


						</div>
						<!-- right side ends -->
					</fieldset>




					<!-- Correspondence Address -->
					<fieldset>
						<legend>Lab Contact Details</legend>

						<!-- form field starts here -->

						<!-- left side -->
						<div class="col-md-6 col-xs-12">

							<div class="form-group">
								<div>
									<ul class="lab-no">
										<li class="style-li"><strong>LAB Name:</strong></li>
										<li class="style-li error-red">*</li>
										<!--  valid -->
										<li id="labNameErr" style="display: none;"
											class="style-li error-red">correspondence Address can
											not be blank.</li>

									</ul>
								</div>
								<cf:input type="text" path="labName" class="form-control"
									placeholder="LabName" required="" />
							</div>

							<div class="form-group">
								<div>
									<ul class="lab-no">
										<li class="style-li"><strong>LAB Address Line 1:</strong></li>
										<li class="style-li error-red">*</li>
										<!--  valid -->
										<li id="labAddressLine1Err" style="display: none;"
											class="style-li error-red">LAB Address can not be blank.</li>

									</ul>
								</div>
								<cf:input type="text" path="labAddressLine1"
									class="form-control" placeholder="Address" required="" />
							</div>

							<div class="form-group">
								<div>
									<ul class="lab-no">
										<li class="style-li"><strong>LAB Address Line 2:</strong></li>
										<li class="style-li error-red">*</li>
										<!--  valid -->
										<li id="labAddressLine2Err" style="display: none;"
											class="style-li error-red">LAB Address can not be blank.</li>

									</ul>
								</div>
								<cf:input type="text" path="labAddressLine2"
									class="form-control" placeholder="Address" required="" />
							</div>




							<div class="form-group">
								<div>
									<ul class="lab-no">
										<li class="style-li"><strong>State:</strong></li>
										<li class="style-li error-red">*</li>
										<!--  valid -->
										<li id="stateErr" style="display: none;"
											class="style-li error-red">correspondence State can not
											be blank.</li>

									</ul>
								</div>
								<cf:select path="state" class="form-control"
									onchange="getDistrict(this.value , 'district')">
									<cf:option value="0" label="Select state Name" />
									<cf:options items="${listStateMaster}" itemValue="stateId"
										itemLabel="stateName" />
								</cf:select>
							</div>

							<div class="form-group">
								<div>
									<ul class="lab-no">
										<li class="style-li"><strong>District:</strong></li>
										<li class="style-li error-red">*</li>
										<!--  valid -->
										<li id="districtErr" style="display: none;"
											class="style-li error-red">District can not be blank.</li>

									</ul>
								</div>
								<cf:select id="district" path="district" class="form-control"
									onchange="getCity(this.value , 'closestCity')">
									<cf:option value="0" label="select District"></cf:option>

								</cf:select>
							</div>



						</div>
						<!-- left side ends -->

						<!-- right side -->
						<div class="col-md-6 col-xs-12">


							<div class="form-group">
								<div>
									<ul class="lab-no">
										<li class="style-li"><strong>Closest City:</strong></li>
										<li class="style-li error-red">*</li>
										<!--  valid -->
										<li id="closestCityErr" style="display: none;"
											class="style-li error-red">City can not be blank.</li>

									</ul>
								</div>
								<cf:select path="closestCity" class="form-control">

								</cf:select>
							</div>



							<div class="form-group">
								<div>
									<ul class="lab-no">
										<li class="style-li"><strong>Pin Code:</strong></li>
										<li class="style-li error-red">*</li>
										<!--  valid -->
										<li id="pincodeErr" style="display: none;"
											class="style-li error-red">Pin code can not be blank.</li>

									</ul>
								</div>
								<cf:input type="text" path="pincode" class="form-control"
									minlength="6" maxlength="6" placeholder="Pin Code" required=""
									onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')" />
							</div>

							<div class="form-group">
								<div>
									<ul class="lab-no">
										<li class="style-li"><strong>Contact Number:</strong></li>
										<li class="style-li error-red">*</li>
										<!--  valid -->
										<li id="contactNumberErr" style="display: none;"
											class="style-li error-red">Mobile can not be blank.</li>

									</ul>
								</div>

								<cf:input type="text" path="contactNumber" class="form-control"
									minlength="10" maxlength="10" placeholder="Contact Number"
									required=""
									onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')" />

							</div>
							<div class="form-group">
								<div>
									<ul class="lab-no">
										<li class="style-li"><strong>Email:</strong></li>
										<li class="style-li error-red">*</li>
										<!--  valid -->
										<li id="EmailErr" style="display: none;"
											class="style-li error-red">Email can not be blank.</li>

									</ul>
								</div>

								<cf:input type="text" path="emailId" class="form-control"
									placeholder="EmailId" onblur="emailVal(this.id,this.value)"
									required="" />
							</div>

						</div>
						<!-- right side ends -->
					</fieldset>
					<!-- Correspondence address ends -->


					<!-- permanent Address -->
					<fieldset>
						<legend>LAB Details</legend>

						<!-- form field starts here -->

						<!-- left side -->
						<div class="col-md-6 col-xs-12">

							<div class="form-group">
								<div>
									<ul class="lab-no">
										<li class="style-li"><strong>NABL Accredited
												Status :</strong></li>

										<li class="style-li error-red">*</li>
									</ul>
								</div>
								<cf:radiobutton path="NABLStatus" value="Yes" checked="true" />
								Yes&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<cf:radiobutton path="NABLStatus" value="No" />
								No
							</div>

							<div class="form-group">
								<div>
									<ul class="lab-no">
										<li class="style-li"><strong>If yes chemical
												field validity:</strong></li>
										<li id="chemicalFieldValidityErr" style="display: none;"
											class="style-li error-red">Correspondence Address can
											not be blank.</li>
									</ul>
								</div>
								<cf:input type="text" path="chemicalFieldValidity"
									class="form-control" placeholder="Address" required="" />
							</div>

							<div class="form-group">
								<div>
									<ul class="lab-no">
										<li class="style-li"><strong>If yes Biological
												field validity:</strong></li>
										<li id="biologicalFieldValidityErr" style="display: none;"
											class="style-li error-red">Correspondence Address can
											not be blank.</li>
									</ul>
								</div>
								<cf:input type="text" path="biologicalFieldValidity"
									class="form-control" placeholder="Address" required="" />
							</div>

						</div>
						<!-- left side ends -->

						<!-- right side -->
						<div class="col-md-6 col-xs-12">


							<div class="form-group">
								<div>
									<ul class="lab-no">
										<li class="style-li"><strong>Wheather lab is
												notified by Fssai :</strong></li>

										<li class="style-li error-red">*</li>
									</ul>
								</div>
								<cf:radiobutton path="labNotified" value="Yes" checked="true" />
								Yes&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<cf:radiobutton path="labNotified" value="No" />
								No
							</div>

							<div class="form-group">
								<div>
									<ul class="lab-no">
										<li class="style-li"><strong>If yes registration
												Number:</strong></li>
										<li id="registrationNumberErr" style="display: none;"
											class="style-li error-red">Correspondence Address can
											not be blank.</li>
									</ul>
								</div>
								<cf:input type="text" path="registrationNumber"
									class="form-control" placeholder="Registration Number"
									required="" />
							</div>

						</div>
						<!-- right side ends -->
					</fieldset>
					<!-- Permanent address ends -->


					<fieldset>
						<legend>Training Facility Details</legend>

						<!-- form field starts here -->

						<!-- left side -->
						<div class="col-md-6 col-xs-12">

							<div class="form-group">
								<div>
									<ul class="lab-no">
										<li class="style-li"><strong>Training room with
												seating capacity:</strong></li>
										<li id="seatingCapacityErr" style="display: none;"
											class="style-li error-red">Correspondence Address can
											not be blank.</li>
									</ul>
								</div>
								<cf:input type="text" path="seatingCapacity"
									class="form-control" placeholder="No. of seats" required="" />
							</div>


							<div class="form-group">
								<div>
									<ul class="lab-no">
										<li class="style-li"><strong>Facility of
												LCD/Projector:</strong></li>

										<li class="style-li error-red">*</li>
									</ul>
								</div>
								<cf:radiobutton path="availabiltyOfTVProjector" value="Yes"
									checked="true" />
								Yes&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<cf:radiobutton path="availabiltyOfTVProjector" value="No" />
								No
							</div>

							<div class="form-group">
								<div>
									<ul class="lab-no">
										<li class="style-li"><strong>Facility for
												Audio/Video recording :</strong></li>

										<li class="style-li error-red">*</li>
									</ul>
								</div>
								<cf:radiobutton path="availabiltyAudioVideoRecording"
									value="Yes" checked="true" />
								Yes&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<cf:radiobutton path="availabiltyAudioVideoRecording" value="No" />
								No
							</div>

						</div>
						<!-- left side ends -->

						<!-- right side -->
						<div class="col-md-6 col-xs-12">
							<%--                           <table>
<ct:forEach var="itr" items="${courseNameMap}">
<td>
<cf:checkbox path="availabiltyAudioVideoRecording"  id="check" value="${itr}" /> 
<ct:out value=" ${itr}" />
</td>
</ct:forEach>
    	</table> --%>
							<div class="form-group">
								<div>
									<ul class="lab-no">
										<li class="style-li"><strong>Testing Facilities
												available in LAB :</strong></li>
										<li id="testingFacilitiesErr" style="display: none;"
											class="style-li error-red">Correspondence Address can
											not be blank.</li>
									</ul>
								</div>
								<ct:forEach items="${courseNameMap}" var="map">
									<cf:checkbox path="testingFacilities" id="testingFacilities"
										value="${map.value}" label=" ${map.value}" />
									<br>
								</ct:forEach>
							</div>






						</div>
						<!-- right side ends -->
					</fieldset>

			<fieldset>
						<legend>Previous Training Experience</legend>
						<div class="col-md-6 col-xs-12">
<br />
<div class="form-group">
<h4>Details of previous trainings conducted by Lab in the area of food testing:</h4>
						<table  id="datatablesfosrest" class="table table-bordered table-responsive">
	<tr>
		<th> Sr. No.</th>
		<th>Subject</th>
		<th >From Date</th>
		<th >To date</th>
		<th >No. of participants</th>
		<th >Trainer's Name</th>
	</tr>
	<ct:forEach var="i" begin="0" end="4" varStatus="loop">
	
	
	
		<tr>
			<td>${loop.count}</td>
			<td><input type="text"></td>
			<td><input type="text" id="fromD"></td>
			<td><input type="text" id="toD"></td>
			<td><input type="text"></td>
			<td><input type="text"></td>
		
			
		</tr>
	</ct:forEach>
	</table>
	<br />
	<br />
	</div>
	<div class="form-group">
	<h4>Details of ISO 17025 Trained Staff Available in Lab:</h4>
		<table  id="datatablesfosrest" class="table table-bordered table-responsive">
	<tr>
		<th> Sr. No.</th>
		<th>Name</th>
		<th >Details of Training</th>
		<th >Relevant experience in Audit and Training</th>
		
	</tr>
	<ct:forEach var="i" begin="0" end="4" varStatus="loop">
	
	
	
		<tr>
			<td>${loop.count}</td>
			<td><input type="text"></td>
			<td><input type="text"></td>
			<td><input type="text"></td>
		
			
		</tr>
	</ct:forEach>
	</table>
	Qualified Food analyst Available in lab: <input type="radio" value="yes" /> Yes <input type="radio" value="No" /> No
	
	</div>
	<br /><br />
	<div class="form-group">
		<h4>Details of ISO 17025 Trained Staff Available in Lab:</h4>
			<table  id="datatablesfosrest" class="table table-bordered table-responsive">
	<tr>
		<th> Sr. No.</th>
		<th>Name</th>
		<th >Qualifying Year</th>

		
	</tr>
	<ct:forEach var="i" begin="0" end="4" varStatus="loop">
	
	
	
		<tr>
			<td>${loop.count}</td>
			<td><input type="text"></td>
			<td><input type="text"></td>
		
		
			
		</tr>
	</ct:forEach>
	</table>
				</div>
					</fieldset>


					<!-- captcha -->
					<fieldset id="captcha">
						<div class="col-md-2 col-xs-12"></div>
						<div
							style="width: 95%; margin-left: 32px; float: left; height: 100px; border: 1px solid #cecece;"
							class="form-group">
							<div style="float: left">
								<div style="float: left; width: 98%;">

									<label id="captchaError"
										style="float: left; width: 99%; font-family: Calibri; margin-left: 0px;">Please
										enter captcha in below textbox !!!</label>
								</div>

								<div style="float: left; width: 99%;">

									<input type="text" id="txtCaptcha"
										style="background-image: url(1.jpg); text-align: center; border: none; width: 140px; margin-left: 8px; font-weight: bold; font-family: Modern"
										disabled="disabled" /> <input type="button" id="btnrefresh"
										value="Refresh" onclick="DrawCaptcha();" />
									<div id="txtInputErr" style="display: none;"
										class="style-li error-red">Captcha is required.</div>
									<input type="text" id="txtInput" placeholder="Captcha"
										style="width: 140px;" />

								</div>
							</div>
							<div id="chkunit" style="float: left; width: 99%;">
								<p><input type="checkbox" id="check" style="margin-left: 1%;">
								 I have read and understood the Terms & Conditions and the Privacy
									Policy of FSSAI. </p>
							</div>
						</div>
					</fieldset>
					<!-- button -->

					<div class="row">
						<div class="col-md-4 col-xs-12"></div>
						<div class="col-md-4 col-xs-12">
							  <cf:input path="id"  type="hidden"/> 
							<input type="submit" style="width: 100%;" class="btn login-btn"
								id="createUpdateBtn" value="Register" />

						</div>
						<div class="col-md-4 col-xs-12"></div>
					</div>






					<div class="col-md-1 col-xs-12"></div>
				</div>
			</div>
		</div>
	</section>


	<div class="col-md-2 hidden-xs"></div>
</cf:form>


<!--   validation function -->
<!--  <script>
   
   
   function validateFields(){
	   var isUpdate = '${isUpdate}';

   	 //alert($("#userType").val());
   	// alert($("#holidayReason").val());
   		 $("#userTypeErr").css("display" , "none");
			$("#titleErr").css("display" , "none");
		$("#correspondencePincodeErr").css("display", "none");
		$("#correspondencePincodeErr1").css("display", "none");
		$("#mobileErr").css("display" , "none");
		$("#AadharNumberErr").css("display" , "none");
		$("#firstNameErr").css("display" , "none");
		$("#MiddleNameErr").css("display" , "none");
		$("#LastNameErr").css("display" , "none");
		$("#FatherNameErr").css("display" , "none");
		$("#empIDErr").css("display" , "none");
		$("#dobErr").css("display" , "none");
		$("#correspondenceAddress1Err").css("display" , "none");
		$("#correspondenceStateErr").css("display" , "none");
		$("#EmailErr").css("display" , "none");
		 $("#correspondenceDistrictErr").css("display" , "none");
		 $("#correspondenceCityErr").css("display" , "none");
		 $("#txtInputErr").css("display" , "none");
		 $("#ResidentialLine1Err").css("display" , "none");
		 $("#resStateErr").css("display" , "none");
		 $("#residentialDistrictErr").css("display" , "none");
		 $("#resCityErr").css("display" , "none");
		 
		 
   	    if($("#userType").val() == ''){
   		 
   		$("#userTypeErr").css("display" , "block");
   		return false;
   	 } else if($("#AadharNumber").val().match(/^[0-9]{12}$/) == null){
 		/* alert("Please Enter 12 digit Adhar number"); */
 		 $("#AadharNumberErr").css("display" , "block");
 	     return false;
   	 }else if($("#empID").val() == ''){
   		 $("#empIDErr").css("display" , "block");
 		return false; 
   	 }else if($("#dob").val() == ''){
   		 $("#dobErr").css("display" , "block");
  		return false;
   	 }else if($("#title").val() == ''){
   		 $("#titleErr").css("display" , "block");
    		return false; 
   	 }else if($("#firstName").val() == ''){
   		 $("#firstNameErr").css("display" , "block");
 		return false; 
	 }else if($("#MiddleName").val() == ''){
   		 $("#MiddleNameErr").css("display" , "block");
 		return false; 
	 } else if($("#LastName").val() == ''){
   		 $("#LastNameErr").css("display" , "block");
  		return false; 
 	 }else if($("#FatherName").val() == ''){
   		 $("#FatherNameErr").css("display" , "block");
   		return false; 
  	 }else if($("#correspondenceAddress1").val() == ''){
   		 $("#correspondenceAddress1Err").css("display" , "block");
    		return false; 
  	 }
  	 else if($("#correspondenceState").val() == 0){
   		 $("#correspondenceStateErr").css("display" , "block");
  		return false; 
 	 }else if($("#Email").val() == ''){
   		 $("#EmailErr").css("display" , "block");
   		return false; 
  	 }else if($("#correspondenceDistrict").val() == 0){
   		 $("#correspondenceDistrictErr").css("display" , "block");
    		return false;
  	 }else if($("#correspondenceCity").val() == 0){
   		 $("#correspondenceCityErr").css("display" , "block");
    		return false;
  	 }else if($("#correspondencePincode").val().match(/^[0-9]{6}$/) == null){
  		 alert("invalid pin");
  		 $("#correspondencePincodeErr").css("display" , "block");
  		return false;
  	 }else if($("#mobile").val().match(/^[0-9]{10}$/) == null){
    	
      		 $("#mobileErr").css("display" , "block");
      		return false;
  	 }
   	   
   	
   	else  if($("#ResidentialLine1").val() == ''){
  		 $("#ResidentialLine1Err").css("display" , "block");
   		return false;
	 }
   	   
  
	else if($("#resState").val() == 0){
		 $("#resStateErr").css("display" , "block");
 		return false;
	 }
	else if($("#residentialDistrict").val() == 0){
		 $("#residentialDistrictErr").css("display" , "block");
		return false;
	 }
	
	else if($("#resCity").val() == 0){
		 $("#resCityErr").css("display" , "block");
		return false;
	 }
	else if($("#resPincode").val().match(/^[0-9]{6}$/) == null){
		 $("#resPincodeErr").css("display" , "block");
		return false;
	} 
		else if(!(isUpdate !=null && isUpdate== "Y")){
			if($("#txtInput").val() == ''){
			 $("#txtInputErr").css("display" , "block");
			return false;
		
	 }
   	 var str1 = removeSpaces(document.getElementById('txtCaptcha').value);
     var str2 = removeSpaces(document.getElementById('txtInput').value);
     if (!(str1 == str2)) {
    	 alert("Please Enter correct captcha");
         document.getElementById('txtInput').value = "";
         return false;
     }
		}
   	 if($("#check").is(":checked")== false){
   		 alert("click on check box");
   		 return false;
  	 } 
    }
   

 

   // Remove the spaces from the entered and generated code
   function removeSpaces(string) {
       return string.split(' ').join('');
   }

 


   
   </script>
	 -->