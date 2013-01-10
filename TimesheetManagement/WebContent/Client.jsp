<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sd" uri="/struts-dojo-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="mystyle.css" rel="stylesheet" type="text/css">
<title>Project Report</title>
</head>
<body style="height: auto;">

	<div id="boundary">
		<br /> <img src="<s:url value="bk_in.jpg"/>" width="930px"
			style="box-shadow: 0px 0px 20px rgba(0, 0, 0, .4);" />



		<div
			style="height: 80px; width: 300px; box-shadow: 0px 0px 20px rgba(0, 0, 0, .4); margin: 30px; padding: 20px; float: left;">

			<s:if test="#session.ClientDetails != null">
				<s:iterator value="#session.ClientDetails">
					<div align="left">

						<b><s:label name="empName" value="Client Name : "></s:label>
						</b>
						<s:property value="client_name" />

					</div>
					<br />
					<div align="left">
						<b><s:label name="role" value="Role : "></s:label> </b>
						<s:property value="%{\"Client\"}" />
					</div>
				</s:iterator>
			</s:if>
			<br />
			<s:if test="#session.todayDate != null">
				<div align="left">
					<b><s:label name="date1" value="Login Date : "></s:label> </b>
					<s:property value="#session.todayDate" />
				</div>
			</s:if>
		</div>

		<div align="right"
			style="margin-bottom: 20px; margin-top: 25px; float: left;">


			<s:form action="home" method="POST">
				<div
					style="overflow: hidden; left; position: relative; vertical-align: middle;">
					<s:submit name="home" value=" Home " cssClass="button_example"></s:submit>
				</div>
			</s:form>



			<s:form action="logout.action" method="POST">
				<%-- <div
					style="overflow: hidden; left; position: relative; vertical-align: middle;">
					<s:submit name="home" value=" Home " cssClass="button_example"></s:submit>
				</div> --%>
				<div
					style="overflow: hidden; right; margin-left: 10px; vertical-align: middle;">
					<s:submit name="logout" value="Logout" cssClass="button_example"></s:submit>
				</div>
			</s:form>
		</div>




		<s:if test="#session.login != 'true'">
			<jsp:forward page="Login.jsp" />
		</s:if>

		<%-- 
	<s:form action="logout.action" method="POST">
	<s:submit name="logout" value="Logout"></s:submit>
	</s:form>
	 --%>



		<div
			style="margin: 170px 30px 30px; box-shadow: 0px 0px 20px rgba(0, 0, 0, .4); padding: 20px; min-height: 400px;">

			<div>
				<b><s:label name="heading" value="Project summary."></s:label>
				</b>
			</div>
			<div>
				<b><s:label name="Date" value="Date : "></s:label> <s:date
						name="currentDate" format="dd/MM/yyyy" />
				</b>
			</div>




			<div align="center">
				<s:form action="exceldemo" method="POST">

					<s:submit name="generate" value="Project Report in Excel"
						cssClass="button_example"></s:submit>

				</s:form>
			</div>
			<div align="center" style="margin-top: 0px;">

				<!-- list of time sheet goes here -->
				<table class="hovertable">
					<thead>
						<tr>
							<th>Project Number</th>
							<th>Project Name</th>
							<th>Description</th>
							<th>Start Date</th>
							<th>End Date</th>
							<th>Employee First Name</th>
							<th>Employee Last Name</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="projectReport">
							<tr>
								<!-- <td><s:checkbox name="time" id="time" fieldValue="%{timesheet_id}"></s:checkbox></td> -->
								<td><s:property value="project_num" />
								</td>
								<td><s:property value="project_name" />
								</td>
								<td><s:property value="description" />
								</td>
								<td><s:property value="startdate" />
								</td>
								<td><s:property value="enddate" />
								</td>
								<td><s:property value="firstname" />
								</td>
								<td><s:property value="lastname" />
								</td>

							</tr>
							<br />
						</s:iterator>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<h4 align="center">Copyright © 2013 TMS@IIITB. All rights
		reserved.</h4>
</body>
</html>