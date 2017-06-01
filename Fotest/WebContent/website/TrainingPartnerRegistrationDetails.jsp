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
	 alert("Update Your Details "+'${userName}');
	
	
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
	 var a='${PersonalInformationTrainingPartner.NABLStatus}';
	 //alert(a);
	 if(a!='Yes'){	 
		// alert("if loop "+a);
		 $("#chemicalField").css("display" , "none");
		 $("#biologyField").css("display" , "none");
		
	 }
	 
	 if('${PersonalInformationTrainingPartner.labNotified}'!='Yes')
		 $("#regNum").css("display" , "none");
	 $("#state").val('${PersonalInformationTrainingPartner.state}');
	 $("#state").val('${PersonalInformationTrainingPartner.state}');

 	 var fields = '${PersonalInformationTrainingPartner.testingFacilities}'.split(',');
	for(i=0;i<fields.length;i++){
		 document.getElementById('testingFacilities_'+fields[i]).checked = true;
/* 		  $("#GC-MS/MS").attr("checked","checked"); */
	 }
	 
	 
	//for tables in jsp
	
   	 for(i=0;i<=4;i++){
   		var table=document.getElementById('prevtrainingExp_'+i).value.split('|');
   		 $("#pteSubject_"+i).val(table[0]);
   		 $("#pteFromD_"+i).val(table[1]);
   		 $("#pteToD_"+i).val(table[2]);
   		 $("#pteNoOfParticipants_"+i).val(table[3]);
   		 $("#pteTrainerName_"+i).val(table[4]);
   	
   		table=document.getElementById('trainedStaff_'+i).value.split('|');
      	 $("#tsName_"+i).val(table[0]);
      	 $("#tsDetails_"+i).val(table[1]);
      	 $("#tsRevExp_"+i).val(table[2]);
      	 
      	 if(i<2){
      	table=document.getElementById('foodAnalyst_'+i).value.split('|');
     	 $("#faName_"+i).val(table[0]);
     	 $("#faQualYear_"+i).val(table[1]);
      	 }
      	 
   		   	 }

	 
 } 
 
	 DrawCaptcha(); 
	
	 flatpickr("#dob" ,{});	

   	 for(i=0;i<=4;i++){

	 flatpickr("#pteFromD_"+i, {});
	 flatpickr("#pteToD_"+i, {});
   	 }
	 }
		
	 window.onload = OnStart;
	 
</script>


<cf:form action="registerpersonalinformationtrainingpartnerAdd.fssai"
	name="myForm" method="POST"
	commandName="PersonalInformationTrainingPartner"
	onsubmit="return validateFields();" enctype="multipart/form-data">

	<section>
		<div class="container">
			<div class="row mar-top-aadhar">
				<div class="col-md-1 col-xs-12"></div>

				<div class="col-md-10  col-xs-12" >
					<h3 class="text-capitalize heading-3-padding">Training Partner
						Registration Form</h3>
					<!-- personal information -->
					<fieldset>
						<legend>Personal Information</legend>

						<!-- form field starts here -->



						<!-- left side -->
						<div class="col-md-6 col-xs-12" style="margin-top: 223px;">


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
											class="style-li error-red">Select Date of birth.</li>

									</ul>
								</div>
								<cf:input type="text" path="dob" id="dob" name="dob"
									class="form-control" />
							</div>

							   <div class="form-group">
                                    <div>
                                        <ul class="lab-no">
                                            <li class="style-li"><strong>Gender:</strong></li>
                                            
                                            <li class="style-li error-red"> * </li>
                                        </ul>
                                    </div>
                                   <cf:radiobutton
										path="gender" value="M" checked="true" />Male&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<cf:radiobutton path="gender" value="F" />Female
                                </div>
							
							<%-- <div class="form-group">
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
							</div> --%>

							<div class="form-group">
								<div>
									<ul class="lab-no">
										<li class="style-li"><strong>Designation:</strong></li>
										<li class="style-li error-red">*</li>
										<!--  valid -->
										<li id="designationErr" style="display: none;"
											class="style-li error-red">Designation can not be
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
		<div class="col-md-12 col-xs-12">
									<span id="preview"> 	
									<ct:choose>
									    <ct:when test="${!empty userName}">
									   <img id="myimg" src='D:/newfosrest/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Fotest/TrainingPartner/${userName}.png' width="200" height="190" />
									   </ct:when>
									    <ct:otherwise>
									<img id="myimg" src="website/images/DummyProfile.png" width="200" height="190" />
									</ct:otherwise>
									</ct:choose>
									</span>
									<input class="btn login-btn" type="file" id="file" name="file" />
								</div>
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
													<li class="style-li error-red">*</li>
										<li class="style-li error-red"></li>
										<!--  valid -->
										<li id="middleNameErr" style="display: none;"
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
													<li class="style-li error-red">*</li>
										<li class="style-li error-red"></li>
										<!--  valid -->
										<li id="lastNameErr" style="display: none;"
											class="style-li error-red">Last Name can not be blank.</li>

									</ul>
								</div>
								<cf:input type="text" path="lastName" class="form-control"
									placeholder="last Name"
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
											class="style-li error-red">LAB Name can
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
									
										<!--  valid -->
										<!-- <li id="labAddressLine2Err" style="display: none;"
											class="style-li error-red">LAB Address can not be blank.</li> -->

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
											class="style-li error-red">Select the State.</li>

									</ul>
								</div>
								<cf:select path="state" class="form-control"
									onchange="getDistrict(this.value , 'district')">
									<cf:option value="0" label="Select  Name" />
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
											class="style-li error-red">Select the District.</li>

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
											class="style-li error-red">Select the City..</li>

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
										<li class="style-li"><strong>Email ID:</strong></li>
										<li class="style-li error-red">*</li>
										<!--  valid -->
										<li id="emailIdErr" style="display: none;"
											class="style-li error-red">Email Id can not be blank.</li>

									</ul>
								</div>

								<cf:input type="text" path="emailId" class="form-control"
									placeholder="Email Id" onblur="emailVal(this.id,this.value)"
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

							<div  onchange="radioState();"  class="form-group" >
								<div>
									<ul class="lab-no">
										<li class="style-li" ><strong>NABL Accredited
												Status :</strong></li>

										<li class="style-li error-red">*</li>
									</ul>
								</div>
								<cf:radiobutton path="NABLStatus" id="YesNABL" value="Yes" checked="true" />
								Yes&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<cf:radiobutton path="NABLStatus" value="No"   />
								No
							</div>

							<div id="chemicalField" class="form-group" >
								<div>
									<ul class="lab-no">
										<li class="style-li" ><strong>If yes chemical
												field validity:</strong></li>
													<li class="style-li error-red">*</li>
										<li id="chemicalFieldValidityErr" style="display: none;"
											class="style-li error-red">Chemical Field Validity can
											not be blank.</li>
									</ul>
								</div>
								<cf:input type="text" path="chemicalFieldValidity" 
									class="form-control" placeholder="Chemical Field Validity" required="" />
							</div>
 
							<div class="form-group" id="biologyField" >
								<div>
									<ul class="lab-no">
										<li class="style-li"><strong>If yes Biological
												field validity:</strong></li> 
													<li class="style-li error-red">*</li>
										<li id="biologicalFieldValidityErr" style="display: none;"
											class="style-li error-red">Biological Field Validity Address can
											not be blank.</li>
									</ul>
								</div>
								<cf:input type="text" path="biologicalFieldValidity"
									class="form-control" placeholder="Biological Field Validity" required="" />
							</div>

						</div>
						<!-- left side ends -->

						<!-- right side -->
						<div class="col-md-6 col-xs-12">


							<div class="form-group" onchange="radioState();">
								<div>
									<ul class="lab-no">
										<li class="style-li"><strong>Wheather lab is
												notified by Fssai :</strong></li>

										<li class="style-li error-red">*</li>
									</ul>
								</div>
								<cf:radiobutton path="labNotified" id="YesLabNotified" value="Yes" checked="true"  />
								Yes&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<cf:radiobutton path="labNotified" value="No" />
								No
							</div>

							<div class="form-group" id="regNum"  >
								<div>
									<ul class="lab-no">
										<li class="style-li"><strong>If yes registration
												Number:</strong></li>
													<li class="style-li error-red">*</li>
										<li id="registrationNumberErr" style="display: none;"
											class="style-li error-red">Registration Number can
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
													<li class="style-li error-red">*</li>
										<li id="seatingCapacityErr" style="display: none;"
											class="style-li error-red">No. of seats can
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
													<li class="style-li error-red">*</li>
										<li id="testingFacilitiesErr" style="display: none;"
											class="style-li error-red">Select Testing Facilities</li>
									</ul> 
								</div> 
								<div id="chkdiv">
							
									<%-- <cf:checkboxes element="li" id="testingFacilities'+${courseNameMap.value}+'12" items="${courseNameMap}" path="testingFacilities" 
									
										/> --%>
								
										<ct:forEach items="${courseNameMap}" var="map">
									<cf:checkbox  path="testingFacilities" id="testingFacilities_${map.value}"
										value="${map.value}" label=" ${map.value}" />
									<br>
								</ct:forEach>
									
									<br>
								
								</div>
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
	<cf:input type="hidden" path="prevtrainingExp_${loop.index}" class="form-control"  />
	
		
	<tr> 
		<td>${loop.count}</td>
			<td><input type="text" id="pteSubject_${loop.index}"></td>
			<td><input type="text" id="pteFromD_${loop.index}"></td>
			<td><input type="text" id="pteToD_${loop.index}"></td>
			<td><input type="text" id="pteNoOfParticipants_${loop.index}"></td>
			<td><input type="text" id="pteTrainerName_${loop.index}"></td> 
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
	<cf:input type="hidden"  path="trainedStaff_${loop.index}" class="form-control"  />
	
	
		<tr>
		<td>${loop.count}</td>
			<td><input type="text" id="tsName_${loop.index}"></td>
			<td><input type="text" id="tsDetails_${loop.index}"></td>
			<td><input type="text" id="tsRevExp_${loop.index}"></td>
		</tr>
	</ct:forEach>
	</table>
	<br /><br />
	Qualified Food analyst Available in lab:  <cf:radiobutton
										path="foodAnalystAvail" value="Yes" checked="true" />Yes&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<cf:radiobutton path="foodAnalystAvail" value="No" />No</div>
	
	<div class="form-group">
		<h4>Details of ISO 17025 Trained Staff Available in Lab:</h4>
			<table  id="datatablesfosrest" class="table table-bordered table-responsive">
	<tr>
		<th> Sr. No.</th>
		<th>Name</th>
		<th >Qualifying Year</th>

		
	</tr>
	<ct:forEach var="i" begin="0" end="1" varStatus="loop">
	
	<cf:input type="hidden" path="foodAnalyst_${loop.index}" class="form-control"  />
	
	
		<tr>
		<td>${loop.count}</td>
			<td><input type="text" id="faName_${loop.index}"></td>
			<td><input type="text" id="faQualYear_${loop.index}"></td>
		
		</tr>

	</ct:forEach>
	</table>
				</div>
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
  <script>
   
   
   function validateFields(){
	   var isUpdate = '${isUpdate}';

   	 //alert($("#userType").val());
   	// alert($("#holidayReason").val());
   	   	
   	
   //alert("as");
   		
   	
   		 $("#userIdErr").css("display" , "none");
			$("#titleErr").css("display" , "none");
		$("#dobErr").css("display", "none");
		$("#designationErr").css("display", "none");
		$("#firstNameErr").css("display" , "none");
		$("#middleNameErr").css("display" , "none");
		$("#lastNameErr").css("display" , "none");

		$("#labNameErr").css("display" , "none");
		$("#labAddressLine1Err").css("display" , "none");
		$("#closestCityErr").css("display" , "none");
		$("#stateErr").css("display" , "none");
		$("#pincodeErr").css("display" , "none");
		$("#districtErr").css("display" , "none");
		 $("#contactNumberErr").css("display" , "none");
		 $("#emailIdErr").css("display" , "none");
	
		 $("#chemicalFieldValidityErr").css("display" , "none");
		 $("#biologicalFieldValidityErr").css("display" , "none");
		 $("#residentialDistrictErr").css("display" , "none");
		 $("#registrationNumberErr").css("display" , "none");
		 $("#seatingCapacityErr").css("display" , "none");
		 $("#testingFacilitiesErrs").css("display" , "none");
		 $("#txtInputErr").css("display" , "none");
		
		
	 	   	
   	    if($("#userId").val() == ''){
   		 
   		$("#userIdErr").css("display" , "block");
   		return false;
   	 } else if($("#dob").val()== ''){
	
 		 $("#dobErr").css("display" , "block");
 	     return false;
   	 }else if($("#designation").val() == ''){
   		 $("#designationErr").css("display" , "block");
 		return false; 
   	 }else if($("#title").val() == ''){
   		 $("#titleErr").css("display" , "block");
  		return false;
   	 }	
   	 	else if($("#firstName").val() == ''){
   		 $("#firstNameErr").css("display" , "block");
 		return false; 
	 }else if($("#middleName").val() == ''){
   		 $("#middleNameErr").css("display" , "block");
 		return false; 
	 } else if($("#lastName").val() == ''){
   		 $("#lastNameErr").css("display" , "block");
  		return false; 
 	 }else if($("#labName").val() == ''){
   		 $("#labNameErr").css("display" , "block");
    		return false; 
  	 }
  	 else if($("#labAddressLine1").val() == ''){
   		 $("#labAddressLine1Err").css("display" , "block");
  		return false; 
 	 }else if($("#state").val() == 0){ 
			$("#stateErr").css("display" , "block");
   		return false; 
  	 }else if($("#district").val() == 0){
   		 $("#districtErr").css("display" , "block");
    		return false;
  	 }else if($("#closestCity").val() == 0){
   		 $("#closestCityErr").css("display" , "block");
    		return false;
  	 }else if($("#pincode").val().match(/^[0-9]{6}$/) == null){
  		 alert("invalid pin");
  		 $("#pincodeErr").css("display" , "block");
  		return false;
  	 }else if($("#contactNumber").val().match(/^[0-9]{10}$/) == null){
    	
      		 $("#contactNumberErr").css("display" , "block");
      		return false;
  	 }
	   	
   	
   	else   if($("#emailId").val() == ''){
  		 $("#emailIdErr").css("display" , "block");
   		return false;
	 }
	else if($("#chemicalFieldValidity").val()=='' && $('#YesNABL').is(':checked')){
		 $("#chemicalFieldValidityErr").css("display" , "block");
		return false;
	} 
  
	else if($("#biologicalFieldValidity").val() == '' && $('#YesNABL').is(':checked')){
		 $("#biologicalFieldValidityErr").css("display" , "block");
 		return false;
	 }
	else if($("#registrationNumber").val() == '' && $('#YesLabNotified').is(':checked')){
		 $("#registrationNumberErr").css("display" , "block");
		return false;
	 }
	
	else if($("#seatingCapacity").val() == ''){
		 $("#seatingCapacityErr").css("display" , "block");
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
   		 alert("Click on check-box to Agree to Terms and Conditions");
   		 return false;
  	 } 
		

   	//tables
   	 for(i=0;i<=4;i++){
   		 
   	   		//1st table
   	   var joined=document.getElementById('pteSubject_'+i).value.concat('|'.concat(document.getElementById('pteFromD_'+i).value.concat('|'.concat(document.getElementById('pteToD_'+i).value.concat('|'.concat(document.getElementById('pteNoOfParticipants_'+i).value.concat('|'.concat(document.getElementById('pteTrainerName_'+i).value))))))));
   		
   		document.getElementById('prevtrainingExp_'+i).value=joined;
   	 
   	//2nd table
  	joined=document.getElementById('tsName_'+i).value.concat('|'.concat(document.getElementById('tsDetails_'+i).value.concat('|'.concat(document.getElementById('tsRevExp_'+i).value))));
	
	document.getElementById('trainedStaff_'+i).value=joined;

	//3rd table
if(i<2){
joined=document.getElementById('faName_'+i).value.concat('|'.concat(document.getElementById('faQualYear_'+i).value));

document.getElementById('foodAnalyst_'+i).value=joined;
}
   	   	 }
 }
   

   // Remove the spaces from the entered and generated code
   function removeSpaces(string) {
       return string.split(' ').join('');
   } 

 function radioState(){
	   		
	  // alert("as"); 
	   //alert($('#YesNABL').is(':checked')); 
		 	 if($('#YesNABL').is(':checked')) { 
		 		 //alert("in");
				 $("#chemicalField").css("display" , "block");
				 $("#biologyField").css("display" , "block");
		 	 }
		 	 else{
		 		$("#chemicalField").css("display" , "none");
		 	   	$("#biologyField").css("display" , "none");
		 	 } 
		 	 
	   	
			 if($('#YesLabNotified').is(':checked')) { 
		 		 //alert("in");
				 $("#regNum").css("display" , "block");
				
		 	 }
		 	 else{
		 		$("#regNum").css("display" , "none");
		 	
		 	 } 
		 	 
   }

   
   </script>
<script>
		function dispPrev(files) {

			var reader = new FileReader();
			var img = new Image();

			reader.onload = function(e) {
				img.src = e.target.result;
				fileSize = Math.round(files.size / 1024);
				// alert("File size is " + fileSize + " kb");
				///alert("width=" + this.width + " height=" + this.height);
				img.onload = function() {

					$('#preview')
							.append(
									'<img src="' + e.target.result + '" height="190px" width="200px" />');
				};

			};
			reader.readAsDataURL(files);

		}

		$(document).ready(function() {

			$("#file").change(function() {
				$("span").html("");
				var file = this.files[0];
				dispPrev(file);
			});

		});
	</script>