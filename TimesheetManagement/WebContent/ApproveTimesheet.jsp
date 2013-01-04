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
<body style="height: 100%; border: 1px groove blue;">
<img src="<s:url value="/images/timesheet.png"/>" />
<br/>


	<s:form action="ApproveTimesheet" method="POST" theme="simple">
		<!--  <div align="center">-->
		<div id="wrap" style="float: left;">
			<s:label name="SelectEmp" value="  Select an Employee :"></s:label>
			<s:select label="  Select an Employee" headerKey="-1"
				headerValue="Select Employee"
				list="emp"
				name="employeename" value="-1" />
		</div>
		
		<s:submit name="buttonName" value="Search Timesheet" cssClass="button_example"></s:submit>
		
		<br/><br/>

		<div align="center">

			<!-- list of time sheet goes here -->
			<table class="hovertable">
			<thead>
			<tr>
			<th></th>
			<th>Project Number</th>
			<th>Task</th>
			<th>Date</th>
			<th>hours</th>
			
			</tr>
			</thead>
			<tbody>
			<s:iterator value="timesheets">
				<tr>
					<td><s:checkbox name="time" id="time" fieldValue="%{timesheet_id}"></s:checkbox></td>
					<td><s:property value="project_num" /></td>
					<td><s:property value="task_name" /></td>
					<td><s:property value="work_date" /></td>
					<td><s:property value="no_of_hours" /></td>
					<!-- <td>
					<s:url var="CreateProject" action="Manager">
    				<s:param name="timesheet" value="'timesheet'"></s:param>
					</s:url>
					<s:a href="%{#CreateProject}">Approve/Reject</s:a></td> -->
				</tr>
				<br/>
			</s:iterator>
			</tbody>
			</table>
		</div>
		
		<br />
		<div align="center">
		<s:submit name="buttonName" value=" Approve " cssClass="button_example"></s:submit>
		<s:submit name="buttonName" value="  Reject  " cssClass="button_example"></s:submit>
		</div>
	</s:form>
</body>
</html>