<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sd" uri="/struts-dojo-tags"%>
<html>
<s:set name="theme" value="'simple'" scope="page" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="mystyle.css">
<title>Link</title>
</head>
<body style="height: auto; border: 1px groove black;" marginheight="5px">
	<img src="<s:url value="/images/timesheet.png"/>" />


	<div id="wrappermenu">
		<s:label value="Timesheet"></s:label>
	</div>
	<s:div cssClass="divalign">
		<img src="<s:url value="/images/arrow.png"/>" />
		<s:url var="SubmitTimesheet" action="admin_home">
			<s:param name="function" value="'SubmitTimesheet'"></s:param>
		</s:url>
		<s:a href="%{#SubmitTimesheet}">Submit Timesheet</s:a>
	</s:div>

	<div id="wrappermenu">
		<s:label value="Administrator"></s:label>
	</div>
	<s:div cssClass="divalign">
		<img src="<s:url value="/images/arrow.png"/>" />
		<s:url var="AddUpdateEmployee" action="admin_home">
			<s:param name="function" value="'AddUpdateEmployee'"></s:param>
		</s:url>
		<s:a href="%{#AddUpdateEmployee}">Add/Update Employee</s:a>
	</s:div>


<br><br><br><br><br><br><br><br><br><br>
</body>
</html>