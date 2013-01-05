<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sd" uri="/struts-dojo-tags"%>

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="mystyle.css" rel="stylesheet" type="text/css">
<title>Assign Employees to project</title>

</head>

<body style="height: auto; border: 1px groove blue;" marginheight="5px">

<img src="<s:url value="/images/timesheet.png"/>" />

	<s:form action="AssignEmp" method="POST" theme="simple">
		<!-- drop down menu for project selection 

		<s:select label="Select a Project" headerKey="-1"
			headerValue="Select Project"
			list="#{'1':'Proj1', '2':'Proj2', '3':'Proj3', '4':'Proj4'}"
			name="project" value="-1" />-->



		<div align="left" id="wrapper">
			<s:label name="SelectProj" value="  Select a project :"></s:label>
			<s:select label="  Select a Project" headerKey="-1"
				headerValue="Select Project" list="project" name="project"
				value="-1" cssClass="select"/>
		</div>


		<!-- drop down menu for task name selection 
		<s:select label="Select a Task" headerKey="-1"
			headerValue="Select Task"
			list="#{'1':'Requirement', '2':'Development', '3':'Testing'}"
			name="task" value="-1" />-->

		<br />

		<div align="left" id="wrapper">
			<s:label name="SelectTask" value="  Select a task :"></s:label>
			<s:select label="  Select a Task" headerKey="-1"
				headerValue="Select Task" list="task" name="task" value="-1" cssClass="select"/>
		</div>
		<!-- 
		<s:checkboxlist label="Select Employees" labelposition="top"
			list="#{'1':'Suhas', '2':'Dev', '3':'Bond'}" name="employees"
			value="1" />
		 -->
		<br />
		<br />


		<div align="left" id="wrapper1">
			<s:label name="SelectEmp" value="  Select Employees :"></s:label>
			<br />
			<hr>
			<s:checkboxlist label="  Select Employees" labelposition="top"
				list="emp" name="employees" value="1" theme="vertical-checkbox"/>
		</div>
		<br />
		<div align="left" id="wrapper2">
			<s:submit name="Assign Employees" value="Assign Employees" cssClass="button_example"></s:submit>
		</div>
	</s:form>
</body>
</html>