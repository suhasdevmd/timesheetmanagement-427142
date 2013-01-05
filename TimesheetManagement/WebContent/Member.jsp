<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sd" uri="/struts-dojo-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="mystyle.css">
<title>Manager</title>
</head>
<body style="height: auto; border: 1px groove black;" marginheight="5px">
<img src="<s:url value="/images/timesheet.png"/>" />

	<div id="wrappermenu">
	<s:label value="Timesheet"></s:label></div>
	
	<s:div cssClass="divalign">
	<img src="<s:url value="/images/arrow.png"/>" />
		<s:url var="SubmitTimesheet" action="member">
			<s:param name="function" value="'SubmitTimsheet'"></s:param>
		</s:url>
		<s:a href="%{#SubmitTimesheet}">Submit Timesheet</s:a>
	</s:div>

	<div id="wrappermenu">
	<s:label value="Project"></s:label></div>
	<s:div cssClass="divalign">
	<img src="<s:url value="/images/arrow.png"/>" />
		<s:url var="MyProject" action="member">
			<s:param name="function" value="'MyProject'"></s:param>
		</s:url>
		<s:a href="%{#MyProject}">My Project</s:a>
	</s:div>


	<div id="wrappermenu">
	<s:label value="MyAccount"></s:label></div>
	<s:div cssClass="divalign">
	<img src="<s:url value="/images/arrow.png"/>" />
		<s:url var="PasswordManagement" action="member">
			<s:param name="function" value="'PasswordManagement'"></s:param>
		</s:url>
		<s:a href="%{#PasswordManagement}">Password Management</s:a>
	</s:div>
	
	<br/>
	<br/><br/><br/>
</body>
</html>