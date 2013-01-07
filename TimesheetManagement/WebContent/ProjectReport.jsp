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
<body style="height: auto; border: 1px groove black;" marginheight="5px">
	<img src="<s:url value="/images/timesheet.png"/>" />
	<div>
		<s:label name="heading" value="Project Allocation summary."></s:label>
	</div>
	<div>
		<s:label name="Date" value="Date : "></s:label>
		<s:date name="currentDate" format="dd/MM/yyyy" />
	</div>

	<div>
		<s:label name="Employee" value="Reported generated by : "></s:label>
		<s:property value="employee_name" />
	</div>


	<div align="center">
		<s:form action="exceldemo" method="POST">

			<s:submit name="generate" value="Project Report in Excel"></s:submit>

		</s:form>
	</div><div align="center" style="margin-top:0px;">

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

</body>
</html>