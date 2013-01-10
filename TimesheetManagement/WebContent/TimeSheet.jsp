<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sd" uri="/struts-dojo-tags"%>
<s:set name="theme" value="'simple'" scope="page" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>Time Sheet</title>
<sd:head />
<%-- <style type="text/css">
<!--
.timesheetheader {
	font-family: "Palatino Linotype", "Book Antiqua", Palatino, serif;
	font-size: 16px;
	font-style: italic;
	line-height: normal;
	font-weight: bold;
	font-variant: small-caps;
	text-transform: capitalize;
	background-color: #DDD;
	text-align: left;
	white-space: normal;
	display: table;
}
-->
</style>
 --%>
<link href="mystyle.css" rel="stylesheet" type="text/css"></link>
</head>

<body style="height: auto;">

	<div id="boundary">
		<br /> <img src="<s:url value="bk_in.jpg"/>" width="930px"
			style="box-shadow: 0px 0px 20px rgba(0, 0, 0, .4);" />

		<div
			style="height: 80px; width: 300px; box-shadow: 0px 0px 20px rgba(0, 0, 0, .4); margin: 30px; padding: 20px; float: left;">

			<s:if test="#session.EmployeeDetails != null">
				<s:iterator value="#session.EmployeeDetails">
					<div align="left">

						<b><s:label name="empName" value="Employee Name : "></s:label>
						</b>
						<s:property value="firstname" />
						&nbsp;
						<s:property value="lastname" />
					</div>
					<br />
					<div align="left">
						<b><s:label name="role" value="Role : "></s:label>
						</b>
						<s:property value="role_name" />
					</div>
				</s:iterator>
			</s:if>
			<br />
			<s:if test="#session.todayDate != null">
				<div align="left">
					<b><s:label name="date1" value="Login Date : "></s:label>
					</b>
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


		<%-- <s:form action="logout.action" method="POST">
			<s:submit name="logout" value="Logout" cssClass="button_example"></s:submit>
		</s:form> --%>



		<div
			style="margin: 170px 30px 30px; box-shadow: 0px 0px 20px rgba(0, 0, 0, .4); padding: 20px; min-height: 400px;">


			<div style="margin-bottom: 50px;">
				<s:form action="timesheet.action" method="post"
					style="margin-left:40px;margin-right:40px">
					<center>
						<table class="hovertable">
							<tr align="center">
								<th scope="col">Project Number</th>
								<th scope="col">Project Name</th>
								<th scope="col">Task Name</th>
								<th scope="col" width="100px">Date</th>
								<th scope="col">No. Of Hours</th>
								<th scope="col">Timesheet Status</th>
							</tr>

							<tr>
								<td align="center">
									<%-- <s:textfield size="10" name="won" id="won" value="won" /> --%>
									<s:property value="won" /></td>
								<td align="center">
									<%-- <s:textfield disabled="true" size="20"
							id="projectname" name="projectname" /> --%> <s:property
										default="Project Name" value="projectname" /></td>
								<td align="center">
									<%-- <s:textfield size="10" name="taskname"
							id="taskname" disabled="true" /> --%> <s:property
										default="Task Name" value="taskname" /></td>
								<td align="center" width="100px"><sd:datetimepicker
										id="date" name="date" displayFormat="dd-MM-yyyy"
										value="%{'today'}" /></td>
								<td align="center"><s:textfield size="10" name="hrs"
										id="hrs" /></td>
								<td align="center">
									<%-- <s:textfield size="15" name="status"
							id="status" disabled="true" /> --%> <s:property default="Pending"
										value="status" /></td>
							</tr>

						</table>

					</center>
					<br />
					<%-- <s:submit name="commandButton" id="refresh" value="Refresh" cssClass="button_example"/> --%>
					<s:submit name="commandButton" id="submit" value="Submit"
						cssClass="button_example" />

					<s:if test="hasActionMessages()">
						<div class="success">
							<s:actionmessage />
						</div>
					</s:if>

					<s:if test="hasActionErrors()">
						<div class="error">
							<s:actionerror />
						</div>
					</s:if>

					<br />
					<br />
					<s:label name="details" value="Timesheet details."></s:label>
					<br />
					<br />
					<table class="hovertable" style="margin-left: 60px;">
						<tr align="center">
							<th scope="col">Project Number</th>
							<th scope="col">Project Name</th>
							<th scope="col">Task Name</th>
							<th scope="col">Date</th>
							<th scope="col">No. Of Hours</th>
							<th scope="col">Status</th>
						</tr>

						<s:iterator value="viewtimesheet">
							<tr>
								<td width="100px"><s:property value="project_num" />
								</td>
								<td width="100px"><s:property value="project_name" />
								</td>
								<td width="100px"><s:property value="task_name" />
								</td>
								<td width="100px"><s:property value="work_date" />
								</td>
								<td width="100px"><s:property value="no_of_hours" />
								</td>
								<td width="100px"><s:property value="status" />
								</td>
							</tr>
						</s:iterator>
					</table>

				</s:form>
			</div>
		</div>

	</div>
	<h4 align="center">Copyright © 2013 TMS@IIITB. All rights
		reserved.</h4>
</body>
</html>
