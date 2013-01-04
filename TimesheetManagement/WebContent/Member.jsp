<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sd" uri="/struts-dojo-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manager</title>
</head>
<body>
	<s:label value="Timesheet"></s:label>
	<s:div>
		<s:url var="SubmitTimesheet" action="member">
			<s:param name="function" value="'SubmitTimsheet'"></s:param>
		</s:url>
		<s:a href="%{#SubmitTimesheet}">Submit Timesheet</s:a>
	</s:div>

	<s:label value="Project"></s:label>
	<s:div>
		<s:url var="MyProject" action="member">
			<s:param name="function" value="'MyProject'"></s:param>
		</s:url>
		<s:a href="%{#MyProject}">My Project</s:a>
	</s:div>

	<s:label value="MyAccount"></s:label>
	<s:div>
		<s:url var="PasswordManagement" action="member">
			<s:param name="function" value="'PasswordManagement'"></s:param>
		</s:url>
		<s:a href="%{#PasswordManagement}">Password Management</s:a>
	</s:div>
</body>
</html>