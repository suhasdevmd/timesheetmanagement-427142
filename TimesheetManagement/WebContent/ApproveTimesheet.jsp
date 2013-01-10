<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sd" uri="/struts-dojo-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="mystyle.css" rel="stylesheet" type="text/css">
<title>Approve Timesheet</title>
</head>
<body style="height: auto;">

	<div id="boundary">
		<br /> <img src="<s:url value="bk_in.jpg"/>" width="930px"
			style="box-shadow: 0px 0px 20px rgba(0, 0, 0, .4);" /> <br />



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
						<b><s:label name="role" value="Role : "></s:label> </b>
						<s:property value="role_name" />
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
		</s:form> --%>



		<div
			style="margin: 170px 30px 30px; box-shadow: 0px 0px 20px rgba(0, 0, 0, .4); padding: 20px; min-height: 400px;">



			<s:form action="ApproveTimesheet" method="POST" theme="simple">
				<!--  <div align="center">-->
				<div id="wrap" style="float: left;">
					<s:label name="SelectEmp" value="  Select an Employee :"></s:label>
					<s:select label="  Select an Employee" headerKey="-1"
						headerValue="Select Employee" list="emp" name="employeename"
						value="-1" />
				</div>
				<div id="wrap1">
					<s:submit name="buttonName" value="Search Timesheet"
						cssClass="button_example"></s:submit>
				</div>


				<br />
				<br />

				<div align="left" style="margin-left: 40px">

					<!-- list of time sheet goes here -->
					<table class="hovertable">
						<thead>
							<tr>
								<th></th>
								<th>Employee Name</th>
								<th width="150px" colspan="1">Project Number</th>
								<th width="100px" colspan="1">Task</th>
								<th width="100px" colspan="1">Date</th>
								<th width="100px" colspan="1">hours</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="timesheets">
								<tr>
									<td><s:checkbox name="time" id="time"
											fieldValue="%{timesheet_id}"></s:checkbox></td>
									<td width="0px" align="center"><s:property
											value="emp_name" />
									</td>
									<td width="0px" align="center"><s:property
											value="project_num" /></td>
									<td width="0px" align="center"><s:property
											value="task_name" /></td>
									<td width="0px" align="center"><s:property
											value="work_date" /></td>
									<td width="0px" align="center"><s:property
											value="no_of_hours" /></td>
									<!-- <td>
					<s:url var="CreateProject" action="Manager">
    				<s:param name="timesheet" value="'timesheet'"></s:param>
					</s:url>
					<s:a href="%{#CreateProject}">Approve/Reject</s:a></td> -->
								</tr>
								<br />
							</s:iterator>
						</tbody>
					</table>
				</div>

				<br />
				<div align="left" style="margin-left: 40px">
					<s:submit name="buttonName" value=" Approve "
						cssClass="button_example"></s:submit>
					<s:submit name="buttonName" value="  Reject  "
						cssClass="button_example"></s:submit>
				</div>
			</s:form>
			<br /> <br /> <br /> <br />
		</div>
	</div>

	<h4 align="center">Copyright © 2013 TMS@IIITB. All rights
		reserved.</h4>
</body>
</html>