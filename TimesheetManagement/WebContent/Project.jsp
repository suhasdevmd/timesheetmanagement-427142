<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sd" uri="/struts-dojo-tags"%>
<html>
<head>
<sd:head />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="mystyle.css" rel="stylesheet" type="text/css">
<title>Project</title>
</head>
<body style="height: 100%; border: 1px groove black;">
	<img src="<s:url value="/images/timesheet.png"/>" />
	<s:if test="hasActionErrors()">
		<div class="errors">
			<s:actionerror />
		</div>
	</s:if>

	<s:form action="CreateProject" method="POST" theme="simple">

		<div id="CrtProj" align="left">

			<table>
				<tr>
					<td><s:label name="ProjectNumber" value="  Project Number "></s:label>
					</td>
					<td><s:textfield name="ProjectNumber" label="Project Number"
							id="ProjectNumber">
						</s:textfield></td>
				</tr>


				<tr>
					<td><s:label name="ProjectName" value="  Project Name "></s:label>
					</td>
					<td><s:textfield name="ProjectName" label="Project Name"
							id="ProjectName">
						</s:textfield></td>
				</tr>

				<tr>
					<td><s:label name="ProjectDescription"
							value="  Project Description "></s:label>
					</td>
					<td><s:textfield name="ProjectDesc"
							label="Project Description" id="ProjectDesc">
						</s:textfield></td>
				</tr>


				<tr>
					<td><s:label name="startDate" value="Start Date"></s:label>
					</td>
					<td><sd:datetimepicker name="StartDate"
							displayFormat="dd-MM-yyyy" value="%{'today'}" /></td>
				</tr>


				<tr>
					<td><s:label name="endDate" value="End Date"></s:label>
					</td>
					<td><sd:datetimepicker name="EndDate"
							displayFormat="dd-MM-yyyy" value="%{'today'}" /></td>
				</tr>


				<tr>
					<td><s:label name="CostPerHour" value="  Cost Per Hour "></s:label>
					</td>
					<td><s:textfield name="Cost" label="Cost Per Hour" id="Cost">
						</s:textfield></td>
				</tr>

				<tr>
					<td><s:label name="Client" value="  Client "></s:label>
					</td>
					<td><s:select label="Client" headerKey="-1"
							headerValue="Select Client" list="clients" name="client"
							value="-1" /></td>
				</tr>
				<tr><td></td></tr>
				<tr><td></td></tr>
				<tr><td></td></tr><tr><td></td></tr><tr><td></td></tr><tr><td></td></tr>
			</table>
		</div>
		<div id="wrapper2" align="right">
			<s:submit name="CreateProj" id="CreateProj" value="Create Project"
				cssClass="button_example" style="margin-right:40px">
			</s:submit>
		</div>
	</s:form>
	<br />
	<br />
</body>
</html>