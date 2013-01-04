<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sd" uri="/struts-dojo-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test 2 </title>
</head>
<body>

<s:label value="Timesheet"></s:label>
<s:div>
<s:url var="SubmitTimesheet" action="Manager">
    <s:param name="function" value="'SubmitTimsheet'"></s:param>
</s:url>
<s:a href="%{#SubmitTimesheet}">Submit Timesheet</s:a>
</s:div>

<s:div>
<s:url var="ApproveTimesheet" action="Manager">
    <s:param name="function" value="'ApproveTimesheet'"></s:param>
</s:url>
<s:a href="%{#ApproveTimesheet}">Approve Timesheet</s:a>
</s:div>


<s:label value="Project"></s:label>
<s:div>
<s:url var="CreateProject" action="Manager">
    <s:param name="function" value="'CreateProject'"></s:param>
</s:url>
<s:a href="%{#CreateProject}">CreateProject</s:a>
</s:div>

<s:div>
<s:url var="AssignEmp" action="Manager">
    <s:param name="function" value="'AssignEmp'"></s:param>
</s:url>
<s:a href="%{#AssignEmp}">Assign Employees</s:a>
</s:div>



<s:label value="Report"></s:label>
<s:div>
<s:url var="ViewReport" action="Manager">
    <s:param name="function" value="'ViewReport'"></s:param>
</s:url>
<s:a href="%{#ViewReport}">View Report</s:a>
</s:div>










</body>
</html>