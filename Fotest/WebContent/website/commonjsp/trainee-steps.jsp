<script type="text/javascript">
	var traineeSteps =
<%=(Integer) session.getAttribute("traineeSteps")%>
	
</script>

<div class="container-fluid">
	<div class="row">
		<div class="col-xs-12">
			<div class="page-header">
				<h1 id="timeline">Training Process</h1>
			</div>
			<ul class="timeline">
				<li><ct:choose>
						<ct:when
							test="${traineeSteps < 1}">
							<div id="t_step1" class="timeline-badge primary">1</div>
						</ct:when>
						<ct:otherwise>
							<div id="t_step1" class="timeline-badge success">1</div>
						</ct:otherwise>
					</ct:choose>
					<div class="timeline-panel">
						<div class="timeline-heading">
							<h4 class="timeline-title">Step 1</h4>
						</div>
						<div class="timeline-body">
							<p>Course Enrollment</p>
							<p>
		
							</p>
						</div>
					</div></li>
				<li class="timeline-inverted"><ct:choose>
						<ct:when test="${traineeSteps < 2}">
							<ct:set value="timeline-badge primary" var="cssClass"></ct:set>
							<div class="${cssClass}">2</div>
						</ct:when>
						<ct:otherwise>
							<ct:set value="timeline-badge success" var="cssClass"></ct:set>
							<div class="${cssClass}">2</div>
						</ct:otherwise>
					</ct:choose> <!-- <div class="timeline-badge success">2</div> -->
					<div class="timeline-panel">
						<div class="timeline-heading">
							<h4 class="timeline-title">Step-2</h4>
						</div>
						<div class="timeline-body">
							<p>
								<ct:choose>
									<ct:when test="${traineeSteps < 2}">
										<a href="OnlineTraining.fssai">Print Admit Card</a>
									</ct:when>
									<ct:otherwise>
                  Get Online Training Content
                      </ct:otherwise>
								</ct:choose>
							</p>
						</div>
					</div></li>




				<li><ct:choose>
						<ct:when test="${traineeSteps < 3}">
							<ct:set value="timeline-badge primary" var="cssClass"></ct:set>
							<div class="${cssClass}">3</div>
						</ct:when>
						<ct:otherwise>
							<ct:set value="timeline-badge success" var="cssClass"></ct:set>
							<div class="${cssClass}">3</div>
						</ct:otherwise>
					</ct:choose> <!-- <div class="timeline-badge success">5</div> -->
					<div class="timeline-panel">
						<div class="timeline-heading">
							<h4 class="timeline-title">Step-3</h4>
						</div>
						<div class="timeline-body">
							<p>
								<ct:choose>
									<ct:when test="${traineeSteps < 3}">
										<a href="OnlineAssessment.fssai">Assessment Before Training</a>
									</ct:when>
									<ct:otherwise>
										Online Assessment
										</ct:otherwise>
								</ct:choose>
							</p>
						</div>
					</div></li>



				<li class="timeline-inverted"><ct:choose>
						<ct:when test="${traineeSteps < 4}">
							<ct:set value="timeline-badge primary" var="cssClass"></ct:set>
							<div class="${cssClass}">4</div>
						</ct:when>
						<ct:otherwise>
							<ct:set value="timeline-badge success" var="cssClass"></ct:set>
							<div class="${cssClass}">4</div>
						</ct:otherwise>
					</ct:choose> <!-- <div class="timeline-badge success">2</div> -->
					<div class="timeline-panel">
						<div class="timeline-heading">
							<h4 class="timeline-title">Step-4</h4>
						</div>
						<div class="timeline-body">
							<p>
								<ct:choose>
									<ct:when test="${traineeSteps < 4}">
										<a href="GetScoreCard.fssai">Attend Online Training / Provided By Training Partner/ LAB</a>
									</ct:when>
									<ct:otherwise>
										Get Your Score Card
										</ct:otherwise>
								</ct:choose>
							</p>
						</div>
					</div></li>




				<%-- 	
				<li class="timeline-inverted"><ct:choose>
						<ct:when
							test="${traineeSteps < 4}">
							<ct:set value="timeline-badge primary" var="cssClass"></ct:set>
							<div class="${cssClass}">4</div>
						</ct:when>
						<ct:otherwise>
							<ct:set value="timeline-badge success" var="cssClass"></ct:set>
							<div class="${cssClass}">4</div>
						</ct:otherwise>
					</ct:choose> <!-- <div class="timeline-badge success">4</div> -->
					<div class="timeline-panel">
						<div class="timeline-heading">
							<h4 class="timeline-title">Step-4</h4>
						</div>
						<div class="timeline-body">
							<p>Get Your Score Card</p>
							<p>
								<ct:choose>
									<ct:when
										test="${traineeSteps < 4}">
										<a href="GetScoreCard.fssai">Get Your Score Card</a>
										 <!-- | <a href="#">In Physical Center</a> -->
									</ct:when>
									<ct:otherwise>
Get Your Score Card
</ct:otherwise>
								</ct:choose>
							</p>
						</div>
					</div></li>
					 --%>

				<li><ct:choose>
						<ct:when test="${traineeSteps < 5}">
							<ct:set value="timeline-badge primary" var="cssClass"></ct:set>
							<div class="${cssClass}">5</div>
						</ct:when>
						<ct:otherwise>
							<ct:set value="timeline-badge success" var="cssClass"></ct:set>
							<div class="${cssClass}">5</div>
						</ct:otherwise>
					</ct:choose> <!-- <div class="timeline-badge success">5</div> -->
					<div class="timeline-panel">
						<div class="timeline-heading">
							<h4 class="timeline-title">Step-5</h4>
						</div>
						<div class="timeline-body">
							<p>
								<ct:choose>
									<ct:when test="${traineeSteps < 5}">
										<a href="Certificate.fssai"> Print Your Admit Card</a>
									</ct:when>
									<ct:otherwise>
										 Certificate
										</ct:otherwise>
								</ct:choose>
							</p>
						</div>
					</div></li>
					
					
					<li class="timeline-inverted"><ct:choose>
						<ct:when test="${traineeSteps < 6}">
							<ct:set value="timeline-badge primary" var="cssClass"></ct:set>
							<div class="${cssClass}">6</div>
						</ct:when>
						<ct:otherwise>
							<ct:set value="timeline-badge success" var="cssClass"></ct:set>
							<div class="${cssClass}">6</div>
						</ct:otherwise>
					</ct:choose> <!-- <div class="timeline-badge success">2</div> -->
					<div class="timeline-panel">
						<div class="timeline-heading">
							<h4 class="timeline-title">Step-6</h4>
						</div>
						<div class="timeline-body">
							<p>
								<ct:choose>
									<ct:when test="${traineeSteps < 6}">
										<a href="GetScoreCard.fssai">Get Assessed By FSSAI Accredited Assessment Agency</a>
									</ct:when>
									<ct:otherwise>
											Get Assessed By FSSAI Accredited Assessment Agency
											</ct:otherwise>
								</ct:choose>
							</p>
						</div>
					</div></li>
					
					<li><ct:choose>
						<ct:when test="${traineeSteps < 7}">
							<ct:set value="timeline-badge primary" var="cssClass"></ct:set>
							<div class="${cssClass}">7</div>
						</ct:when>
						<ct:otherwise>
							<ct:set value="timeline-badge success" var="cssClass"></ct:set>
							<div class="${cssClass}">7</div>
						</ct:otherwise>
					</ct:choose> <!-- <div class="timeline-badge success">5</div> -->
					<div class="timeline-panel">
						<div class="timeline-heading">
							<h4 class="timeline-title">Step-7</h4>
						</div>
						<div class="timeline-body">
							<p>
								<ct:choose>
									<ct:when test="${traineeSteps < 6}">
										<a href="Certificate.fssai">Give Your Feedback</a>
									</ct:when>
									<ct:otherwise>
										 Certificate
										</ct:otherwise>
								</ct:choose>
							</p>
						</div>
					</div></li>
					
					
				
				<li class="timeline-inverted"><ct:choose>
						<ct:when test="${traineeSteps < 8}">
							<ct:set value="timeline-badge primary" var="cssClass"></ct:set>
							<div class="${cssClass}">8</div>
						</ct:when>
						<ct:otherwise>
							<ct:set value="timeline-badge success" var="cssClass"></ct:set>
							<div class="${cssClass}">8</div>
						</ct:otherwise>
					</ct:choose> <!-- <div class="timeline-badge success">2</div> -->
					<div class="timeline-panel">
						<div class="timeline-heading">
							<h4 class="timeline-title">Step-8</h4>
						</div>
						<div class="timeline-body">
							<p>
								<ct:choose>
									<ct:when test="${traineeSteps < 8}">
										<a href="GetScoreCard.fssai"> Get Your Certificate Validated By FSSAI</a>
									</ct:when>
									<ct:otherwise>
										 Get Your Certificate Validated By FSSAI
										</ct:otherwise>
								</ct:choose>
							</p>
						</div>
					</div></li>
				
				<%-- <li class="timeline-inverted"><ct:choose>
						<ct:when
							test="${traineeSteps < 6}">
							<ct:set value="timeline-badge primary" var="cssClass"></ct:set>
							<div class="${cssClass}">6</div>
						</ct:when>
						<ct:otherwise>
							<ct:set value="timeline-badge success" var="cssClass"></ct:set>
							<div class="${cssClass}">6</div>
						</ct:otherwise>
					</ct:choose> <!-- <div class="timeline-badge success">6</div> -->
					<div class="timeline-panel">
						<div class="timeline-heading">
							<h4 class="timeline-title">Step-6</h4>
						</div>
						<div class="timeline-body">
							<p>
								<ct:choose>
									<ct:when
										test="${traineeSteps < 6}">
										<a href="#"> Get Your Certificate</a>
									</ct:when>
									<ct:otherwise>
Get Your Certificate
</ct:otherwise>
								</ct:choose>
							</p>
						</div>
					</div></li> --%>
			</ul>
		</div>
	</div>
</div>
<script type="text/javascript">
	var traineeSteps =
<%=session.getAttribute("traineeSteps")%>
	
</script>