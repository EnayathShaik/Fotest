<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core"%>
<link class="jsbin"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1/themes/base/jquery-ui.css"
	rel="stylesheet" type="text/css" />
<script class="jsbin"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script class="jsbin"
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.0/jquery-ui.min.js"></script>
<meta charset=utf-8 />

<style>
article, aside, figure, footer, header, hgroup, menu, nav, section {
	display: block;
}
</style>

<script src="website/js/commonController.js"></script>
<script>
	function DrawCaptcha() {
		var a = Math.ceil(Math.random() * 7) + '';
		var b = Math.ceil(Math.random() * 7) + '';
		var c = Math.ceil(Math.random() * 7) + '';
		var d = Math.ceil(Math.random() * 7) + '';
		var e = Math.ceil(Math.random() * 7) + '';
		var f = Math.ceil(Math.random() * 7) + '';
		var code = a + ' ' + b + ' ' + c + ' ' + d + ' ' + e + ' ' + f;
		document.getElementById("txtCaptcha").value = code
	}

	function OnStart() {

		var isUpdate = '${isUpdate}';
		if (isUpdate != null && isUpdate == "Y") {
			$("#firstName").val('${PersonalInformationTrainer.firstName}');
			$("#mn").val('${PersonalInformationTrainer.middleName}');
			$("#ln").val('${PersonalInformationTrainer.lastName}');
			$("#dateP").val('${PersonalInformationTrainer.dob}');
			$("#AadharNumberShow").val(
					'${PersonalInformationTrainer.aadharNumber}');
			$("#AadharNumber")
					.val('${PersonalInformationTrainer.aadharNumber}');

			$("#correspondenceState").val(
					'${PersonalInformationTrainer.correspondenceState}');
			$("#correspondenceState").trigger("change");
			window
					.setTimeout(
							function() {
								$("#correspondenceDistrict")
										.val(
												'${PersonalInformationTrainer.correspondenceDistrict}');
								$("#correspondenceDistrict").trigger("change");
								window
										.setTimeout(
												function() {
													$("#correspondenceCity")
															.val(
																	'${PersonalInformationTrainer.correspondenceCity}');
												}, 1000);
							}, 1000);

			$("#createUpdateBtn").val("Update");
			$("#captcha").css("display", "none");
			$("#chkunit").css("display", "none");
			$("#check").attr("checked", "checked");

			var fields = '${PersonalInformationTrainer.modules}'.split(',');
			//alert("lenght "+fields.length); 
			for (i = 0; i < fields.length; i++) {
				//alert("fileds "+fields[i]);
				document.getElementById('modules_' + fields[i]).checked = true;
				/* 		  $("#GC-MS/MS").attr("checked","checked"); */
			}

		}
		DrawCaptcha();

		flatpickr("#dob", {});

	}
	window.onload = OnStart;
	// Remove the spaces from the entered and generated code
	function removeSpaces(string) {
		return string.split(' ').join('');
	}
</script>


<cf:form action="PersonalInformationTrainerAdd.fssai" name="myForm"
	method="POST" commandName="PersonalInformationTrainer"
	onsubmit="return validateFields();"  enctype="multipart/form-data">
	<section>
		<div class="container">
			<div class="row mar-top-aadhar">
				<div class="col-md-1 col-xs-12"></div>

				<div class="col-md-10  col-xs-12">
					<h3 class="text-capitalize heading-3-padding">Trainer
						Registration Form</h3>
					<form>
						<!-- personal information -->
						<fieldset>
							<legend>Personal Information</legend>

							<!-- form field starts here -->
							<!-- left side -->
							<div class="col-md-6 col-xs-12" style="margin-top: 223px;">
								<cf:input type="hidden" path="id" />
								<div class="form-group">
									<div>
										<ul class="lab-no">
											<li class="style-li"><strong>User Id:</strong></li>
											<li class="style-li error-red">*</li>
											<li id="userIdErr" style="display: none;"
												class="style-li error-red">User Id can not be blank.</li>
										</ul>
									</div>
									<cf:input type="text" path="userId" class="form-control"
										placeholder="userId" />
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
											<li class="style-li"><strong>Aadhar Number:</strong></li>
											<li class="style-li error-red">*</li>
											<!--  valid -->
											<li id="AadharNumberErr" style="display: none;"
												class="style-li error-red">Aadhar Number can not be
												blank.</li>
											<li class="style-li error-red"><span id="aadhar_status"></span>
										</ul>
									</div>
									<input type="text" id="AadharNumberShow" class="form-control"
										placeholder="Aadhar Number" value="" disabled="true" />
									<cf:input type="hidden" path="AadharNumber"
										class="form-control" maxlength="12"
										placeholder="Aadhar Number"
										onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')"
										onblur="ck_aadhar('personalinformationtrainer');" />
								</div>
								<div class="form-group">
									<div>
										<ul class="lab-no">
											<li class="style-li"><strong>Mobile:</strong></li>
											<li class="style-li error-red">*</li>
											<li id="mobile1Err" style="display: none;"
												class="style-li error-red">Mobile cannot be blank</li>
										</ul>
									</div>
									<cf:input type="text" path="mobile1" class="form-control"
										placeholder="Mobile Number" minlength="10" maxlength="10"
										required=""
										onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')" />
								</div>
							</div>
							<!-- left side ends -->

							<!-- right side -->
							<div class="col-md-6 col-xs-12" >
							
								<div class="col-md-12 col-xs-12">
									<span id="preview"> <img id="myimg" src="website/images/DummyProfile.png" width="200" height="190" /></span>
									<input class="btn login-btn" type="file" id="file" name="file" />
								</div>

								<div class="form-group">
									<div>
										<ul class="lab-no">
											<li class="style-li"><strong>Title:</strong></li>
											<li class="style-li error-red">*</li>
											<li id="titleErr" style="display: none;"
												class="style-li error-red">Please Select Title.</li>
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
											<li class="style-li"><strong>First Name:</strong></li>
											<li class="style-li error-red">*</li>
											<li id="firstNameErr" style="display: none;"
												class="style-li error-red">Please Enter First Name.</li>

										</ul>
									</div>
									<cf:input type="text" path="firstName" class="form-control"
										id="firstName" placeholder="First Name"
										onkeyup="if (/\d/g.test(this.value)) this.value = this.value.replace(/\d/g,'')" />
								</div>
								<div class="form-group">
									<div>
										<ul class="lab-no">
											<li class="style-li"><strong>Middle Name:</strong></li>
											<li class="style-li error-red"></li>
											<li id="MiddleNameErr" style="display: none;"
												class="style-li error-red">Please Enter Middle Name.</li>

										</ul>
									</div>
									<cf:input type="text" path="MiddleName" class="form-control"
										placeholder="Middle Name" id="mn"
										onkeyup="if (/\d/g.test(this.value)) this.value = this.value.replace(/\d/g,'')" />
								</div>
								<div class="form-group">
									<div>
										<ul class="lab-no">
											<li class="style-li"><strong>Last Name:</strong></li>
											<li class="style-li error-red"></li>
											<li id="LastNameErr" style="display: none;"
												class="style-li error-red">Please Enter Last Name.</li>

										</ul>
									</div>
									<cf:input type="text" path="LastName" class="form-control"
										placeholder="Last Name" id="ln"
										onkeyup="if (/\d/g.test(this.value)) this.value = this.value.replace(/\d/g,'')" />
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
							
							</div>
							<!-- right side ends -->
						</fieldset>

						<fieldset>
							<legend>Contact Details</legend>

							<!-- form field starts here -->

							<!-- left side -->
							<div class="col-md-6 col-xs-12">

								<div class="form-group">
									<div>
										<ul class="lab-no">
											<li class="style-li"><strong>Residence Address
													Line 1:</strong></li>
											<li class="style-li error-red">*</li>
											<li id="residenceAddress1Err" style="display: none;"
												class="style-li error-red">Address can not be blank.</li>
										</ul>
									</div>
									<cf:input type="text" path="residenceAddress1"
										class="form-control" placeholder="Address" required="" />
								</div>

								<div class="form-group">
									<div>
										<ul class="lab-no">
											<li class="style-li"><strong>Residence Address
													Line 2:</strong></li>
											<li class="style-li error-red"></li>
										</ul>
									</div>
									<cf:input type="text" path="residenceAddress2"
										class="form-control" placeholder="Address" required="" />
								</div>
								<div class="form-group">
									<div>
										<ul class="lab-no">
											<li class="style-li"><strong>State:</strong></li>
											<li class="style-li error-red">*</li>
											<li id="correspondenceStateErr" style="display: none;"
												class="style-li error-red">Please Select State.</li>

										</ul>
									</div>
									<cf:select path="correspondenceState" class="form-control"
										onchange="getDistrict(this.value , 'correspondenceDistrict')">
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
											<li id="correspondenceDistrictErr" style="display: none;"
												class="style-li error-red">District can not be blank.</li>

										</ul>
									</div>
									<cf:select path="correspondenceDistrict" class="form-control"
										onchange="getCity(this.value , 'correspondenceCity')">

									</cf:select>
								</div>
							</div>
							<!-- left side ends -->

							<!-- right side -->
							<div class="col-md-6 col-xs-12">

								<div class="form-group">
									<div>
										<ul class="lab-no">
											<li class="style-li"><strong>City:</strong></li>
											<li class="style-li error-red">*</li>
											<li id="correspondenceCityErr" style="display: none;"
												class="style-li error-red">City can not be blank.</li>

										</ul>
									</div>
									<cf:select path="correspondenceCity" class="form-control">

									</cf:select>
								</div>
								<div class="form-group">
									<div>
										<ul class="lab-no">
											<li class="style-li"><strong>Email:</strong></li>
											<li class="style-li error-red">*</li>
											<li id="EmailErr" style="display: none;"
												class="style-li error-red">Please Enter Valid Email ID.</li>

										</ul>
									</div>
									<cf:input type="text" path="Email" class="form-control"
										placeholder="Email" onblur="emailVal(this.id,this.value)"
										required="" />

								</div>
								<div class="form-group">
									<div>
										<ul class="lab-no">
											<li class="style-li"><strong>Mobile:</strong></li>
											<li class="style-li error-red">*</li>
											<li id="mobile2Err" style="display: none;"
												class="style-li error-red">Mobile cannot be blank</li>
										</ul>
									</div>
									<cf:input type="text" path="mobile2" class="form-control"
										placeholder="Mobile Number" minlength="10" maxlength="10"
										required=""
										onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')" />
								</div>


							</div>
							<!-- right side ends -->
						</fieldset>
						<fieldset>
							<legend>Qualification Details</legend>

							<!-- form field starts here -->
							<!-- left side -->
							<div class="col-md-6 col-xs-12">

								<div class="form-group">
									<div>
										<ul class="lab-no">
											<li class="style-li"><strong>Qualification
													Category:</strong></li>
											<li class="style-li error-red"></li>
											<li id="qualCategoryErr" style="display: none;"
												class="style-li error-red">Please select Qualification
												Category.</li>

										</ul>
									</div>

									<cf:select path="qualCategory" class="form-control">
										<cf:option value="0" label="Select Qualification Category" />
										<cf:options items="${QualCategoryMap}" />
									</cf:select>
								</div>

								<div class="form-group">
									<div>
										<ul class="lab-no">
											<li class="style-li"><strong>Others:</strong></li>
										</ul>
									</div>
									<cf:input type="text" path="others1" class="form-control"
										placeholder="Address" required="" />
								</div>

							</div>
							<!-- left side ends -->

							<!-- right side -->
							<div class="col-md-6 col-xs-12">

								<div class="form-group">
									<div>
										<ul class="lab-no">
											<li class="style-li"><strong>Qualification Sub
													Category:</strong></li>
											<li class="style-li error-red"></li>
											<li id="qualSubCategoryErr" style="display: none;"
												class="style-li error-red">Please select Qualification
												Sub Category.</li>
										</ul>
									</div>

									<cf:select path="qualSubCategory" class="form-control">
										<cf:option value="0" label="Select Qualification SubCategory" />
										<cf:options items="${SubQualCategoryMap}" />
									</cf:select>
								</div>

								<div class="form-group">
									<div>
										<ul class="lab-no">
											<li class="style-li"><strong>Others:</strong></li>
											<li class="style-li error-red"></li>
											<li id="resCityErr" style="display: none;"
												class="style-li error-red">City can not be blank.</li>
										</ul>
									</div>
									<cf:input type="text" path="others2" class="form-control"
										placeholder="Address" required="" />
								</div>
							</div>
							<!-- right side ends -->
						</fieldset>
						<!-- Permanent address ends -->

						<!-- Experience starts -->

						<fieldset>
							<legend>Experience Details </legend>
							<!-- left side -->
							<div class="col-md-6 col-xs-12">
								<div class="form-group">
									<label>Are you NABL/ ISO 17025 certified lead assessor
										? ?</label> <br> <label class="radio-inline"> <input
										type="radio" name="optradio" checked="checked" /> Yes
									</label> <label class="radio-inline"> <input type="radio"
										name="optradio" /> No
									</label>
								</div>

								<div class="form-group">
									<div>
										<ul class="lab-no">
											<li id="assExpInYearErr" style="display: none;"
												class="style-li error-red">Exp. in YEAR can not be
												blank.</li>
											<li id="assExpInMonthErr" style="display: none;"
												class="style-li error-red">Exp. in MONTH can not be
												blank.</li>
											<li class="style-li"><strong>If Yes Relevant
													Experience as Assessor:</strong></li>
											<li class="style-li error-red"></li>
										</ul>
									</div>
									<div class="row">
										<div class="col-xs-6">
											<cf:select path="assExpInYear" class="form-control">
												<cf:option value="0" label="Select Exp in Year" />
												<cf:options items="${ExpInYearMap}" />
											</cf:select>
										</div>
										<div class="col-xs-6">

											<cf:select path="assExpInMonth" class="form-control">
												<cf:option value="0" label="Select Exp in Month" />
												<cf:options items="${ExpInMonthMap}" />
											</cf:select>
										</div>
									</div>
								</div>
								<div class="form-group">
									<div>
										<ul class="lab-no">
											<li class="style-li"><strong>Modules wish to
													conduct training on it ?</strong></li>
											<li id="testingFacilitiesErr" style="display: none;"
												class="style-li error-red">Correspondence Address can
												not be blank.</li>
										</ul>
									</div>
									<ct:forEach items="${courseNameMap}" var="map">
										<%-- <cf:checkbox path="modules" id="testingFacilities"
											value="${map.value}" label=" ${map.value}" /> --%>

										<cf:checkbox path="modules" id="modules_${map.value}"
											value="${map.value}" label=" ${map.value}" />
										<br>
									</ct:forEach>
								</div>
							</div>
							<!-- left side ends -->
							<!-- right side -->
							<div class="col-md-6 col-xs-12">

								<div class="form-group">
									<div>
										<ul class="lab-no">

											<li class="style-li"><strong>Training
													experience related to food sector:</strong></li>
											<li class="style-li error-red"></li>
											<li id="trExpInYearErr" style="display: none;"
												class="style-li error-red">Exp. in YEAR can not be
												blank.</li>
											<li id="trExpInMonthErr" style="display: none;"
												class="style-li error-red">Exp. in MONTH can not be
												blank.</li>


										</ul>
									</div>
									<div class="row">
										<div class="col-xs-6">
											<cf:select path="trExpInYear" class="form-control">
												<cf:option value="0" label="Select Exp in Year" />
												<cf:options items="${ExpInYearMap}" />
											</cf:select>
										</div>
										<div class="col-xs-6">

											<cf:select path="trExpInMonth" class="form-control">
												<cf:option value="0" label="Select Exp in Month" />
												<cf:options items="${ExpInMonthMap}" />
											</cf:select>
										</div>
									</div>
								</div>
								<div class="form-group">
									<ul class="lab-no">
										<li class="style-li"><strong>Area Specialization</strong></li>
										<li id="areaSpecializationErr" style="display: none;"
											class="style-li error-red">Area Specialization cannot be
											blank.</li>
										<cf:textarea class="form-control" path="areaSpecialization"
											placeholder="Enter Your Message (250 Words)" />
									</ul>
								</div>

							</div>
							<!-- right side ends -->
						</fieldset>
						<!-- Experience end -->

						<!-- captcha -->
						<fieldset id="captcha">
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
								<div id=chkunit style="float: left; width: 99%;">
									<input type="checkbox" id="check" style="margin-left: 1%;">
									<!-- <a href="#" target="_blank" class="terms-font-size">  -->
									I have read and understood the Terms & Conditions and the
									Privacy Policy of FSSAI.
									<!-- </a> -->
								</div>
							</div>
						</fieldset>
						<!-- button -->

						<div class="row">
							<div class="col-md-4 col-xs-12"></div>
							<div class="col-md-4 col-xs-12">
								<input type="submit" style="width: 100%;" class="btn login-btn"
									id="createUpdateBtn" value="Register" />
							</div>
							<div class="col-md-4 col-xs-12"></div>
						</div>



					</form>
					<!-- form ends -->




					<div class="col-md-1 col-xs-12"></div>
				</div>
			</div>
		</div>
	</section>
	<div class="col-md-2 hidden-xs"></div>
</cf:form>


<script>
	function validateFields() {
		var isUpdate = '${isUpdate}';

		$("#userIdErr").css("display", "none");
		$("#titleErr").css("display", "none");
		$("#dobErr").css("display", "none");
		$("#firstNameErr").css("display", "none");
		$("#MiddleNameErr").css("display", "none");
		$("#LastNameErr").css("display", "none");
		$("#AadharNumberErr").css("display", "none");
		$("#mobile1Err").css("display", "none");

		$("#residenceAddress1Err").css("display", "none");
		$("#correspondenceStateErr").css("display", "none");
		$("#correspondenceDistrictErr").css("display", "none");
		$("#correspondenceCityErr").css("display", "none");
		$("#EmailErr").css("display", "none");
		$("#mobile2Err").css("display", "none");
		$("#qualCategoryErr").css("display", "none");
		$("#qualSubCategoryErr").css("display", "none");
		$("#trExpInYearErr").css("display", "none");
		$("#trExpInMonthErr").css("display", "none");
		$("#assExpInYearErr").css("display", "none");
		$("#assExpInMonthErr").css("display", "none");
		$("#areaSpecializationErr").css("display", "none");
		if ($("#userId").val() == '') {
			$("#userIdErr").css("display", "block");

			return false;
		}
		if ($("#title").val() == 0) {

			$("#titleErr").css("display", "block");
			return false;
		}
		if ($("#dob").val() == 0) {

			$("#dobErr").css("display", "block");
			return false;
		}
		if ($("#firstName").val() == 0) {

			$("#firstNameErr").css("display", "block");
			return false;
		}
		if ($("#MiddleName").val() == 0) {

			$("#MiddleNameErr").css("display", "block");
			return false;
		}
		if ($("#LastName").val() == 0) {

			$("#LastNameErr").css("display", "block");
			return false;
		}
		/* if ($("#AadharNumber").val() == 0) {

			$("#AadharNumberErr").css("display", "block");
			return false;
		} */

		if ($("#mobile1").val().match(/^[0-9]{10}$/) == null) {

			$("#mobile1Err").css("display", "block");
			return false;
		}
		if ($("#mobile1").val() == 0) {

			$("#mobileErr").css("display", "block");
			return false;
		}
		if ($("#residenceAddress1").val() == 0) {

			$("#residenceAddress1Err").css("display", "block");
			return false;
		}
		if ($("#correspondenceState").val() == 0) {
			$("#correspondenceStateErr").css("display", "block");
			return false;
		}
		if ($("#correspondenceDistrict").val() == 0) {

			$("#correspondenceDistrictErr").css("display", "block");
			return false;
		}
		if ($("#correspondenceCity").val() == 0) {

			$("#correspondenceCityErr").css("display", "block");
			return false;
		}
		if ($("#Email").val() == '') {

			$("#EmailErr").css("display", "block");
			return false;
		}
		if ($("#mobile2").val() == 0) {

			$("#mobile2Err").css("display", "block");
			return false;
		}
		if ($("#mobile2").val().match(/^[0-9]{10}$/) == null) {

			$("#mobile2Err").css("display", "block");
			return false;
		}

		if ($("#qualCategory").val() == 0) {
			$("#qualCategoryErr").css("display", "block");
			return false;
		}
		if ($("#qualSubCategory").val() == 0) {

			$("#qualSubCategoryErr").css("display", "block");
			return false;
		}

		if ($("#assExpInYear").val() == 0) {
			$("#assExpInYearErr").css("display", "block");
			return false;
		}
		if ($("#assExpInMonth").val() == 0) {
			$("#assExpInMonthErr").css("display", "block");
			return false;
		}

		if ($("#trExpInYear").val() == 0) {

			$("#trExpInYearErr").css("display", "block");
			return false;
		}
		if ($("#trExpInMonth").val() == 0) {

			$("#trExpInMonthErr").css("display", "block");
			return false;
		}
		if ($("#areaSpecialization").val() == 0) {
			$("#areaSpecializationErr").css("display", "block");
			return false;
		}

		/* if ($("#correspondencePincode").val() == '') {

		$("#correspondencePincodeErr").css("display", "block");
		return false;

		}
		if (($("#correspondencePincode").val()).match(/^[0-9]{6}$/) == null) {

		$("#correspondencePincodeErr1").css("display", "block");
		return false;
		}  */

		if (!(isUpdate != null && isUpdate == "Y")) {

			if ($("#txtInput").val() == '') {
				$("#txtInputErr").css("display", "block");
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
		if ($("#check").is(":checked") == false) {
			alert("check the checkbox to agree to term and conditions");
			return false;
		}

	}
</script>

<script type="text/javascript">
	var aadhar = localStorage.getItem('aadhar');
	document.getElementById("AadharNumber").value = aadhar;

	document.getElementById("AadharNumberShow").value = aadhar;
	localStorage.removeItem('aadhar');

	var DOB = localStorage.getItem('DOB');
	document.getElementById("dateP").value = DOB;
	localStorage.removeItem('DOB');

	var firstname = localStorage.getItem('name');
	document.getElementById("firstName").value = firstname;
	localStorage.removeItem('name');

	var middleName = localStorage.getItem('middleName');
	document.getElementById("mn").value = middleName;
	localStorage.removeItem('middleName');

	var lastName = localStorage.getItem('lastName');
	document.getElementById("ln").value = lastName;
	localStorage.removeItem('lastName');
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